/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import JPA.Campanha;
import JPA.Campanha.CampanhaSerial;
import JPA.CampanhaCreate;
import JPA.Donation;
import JPA.Utilizador;
import JPA.UtilizadorCreate;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Date;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.netbeans.rest.application.config.ApplicationConfig;
import rest.DonationREST.DonateXml;

/**
 *
 * @author Dimitri
 */
@RunWith(Arquillian.class)
public class DonationRESTIT {
    
    private WebTarget target;

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(
                        AbstractFacade.class, CampanhaREST.class, DonationREST.class, UtilizadorREST.class, DonationFacade.class, UtilizadorFacade.class, CampanhaFacade.class, Campanha.class, Donation.class, Utilizador.class, ApplicationConfig.class, CampanhaCreate.class)
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml");
    }

    @ArquillianResource
    private URL deploymentURL;

    @Before
    public void setUp() throws MalformedURLException {
        Client client = ClientBuilder.newClient();
        target = client.target(URI.create(new URL(deploymentURL, "rest").toExternalForm()));
        target.register(Campanha.class);
    }

    @Test
    @InSequence(1)
    public void testCount() {
        Response response = target.path("/donation/count").request().get();
        assertEquals(200, response.getStatus());
        assertEquals(response.readEntity(String.class), "0");
    }

    @Test
    @InSequence(2)
    public void testGetAll() throws Exception {
        Response response = target.path("/donation").request().get();
        assertEquals(200, response.getStatus());
    }
    
    @Test
    @InSequence(3)
    public void testCreate() throws Exception {
        UtilizadorCreate user = new UtilizadorCreate("testName", "testEmail", "testPw");
        Response response = target.path("/user").request().post(Entity.entity(user, MediaType.APPLICATION_JSON));
        assertEquals(200, response.getStatus());
        CampanhaCreate c = new CampanhaCreate();
        c.description = "testDescription";
        c.title = "testTitle";
        c.image = "testImage";
        c.user_id = Long.parseLong(response.readEntity(String.class));
        response = target.path("/campaign").request().post(Entity.entity(c, MediaType.APPLICATION_JSON));
        assertEquals(200, response.getStatus());
        
        response = target.path("/campaign/2").request().get();
        assertEquals(200, response.getStatus());
        //System.out.println("\n\n"+ (response.getEntity()).toString()+"\n\n");
        //System.out.println("\n\n"+ response.toString()+"\n\n");
        //System.out.println(response.readEntity(String.class));
        JsonObject json = (new JsonParser()).parse(response.readEntity(String.class)).getAsJsonObject();
        assertEquals(200, response.getStatus());
        assertEquals(0.0, json.get("current").getAsDouble(), 0.01);
        DonateXml d = new DonateXml(json.get("id").getAsLong(), c.user_id, 10);
        response = target.path("/donation").request().post(Entity.entity(d, MediaType.APPLICATION_JSON));
        assertEquals(200, response.getStatus());
        assertNotEquals(-1L, (long)response.readEntity(Long.class));
        
        response = target.path("/campaign/" + json.get("id").getAsLong()).request().get();
        assertEquals(200, response.getStatus());
        json = (new JsonParser()).parse(response.readEntity(String.class)).getAsJsonObject();
        assertEquals(200, response.getStatus());
        assertEquals(10.0, json.get("current").getAsDouble(), 0.01);
    }
    
    @Test
    @InSequence(4)
    public void getSingleDonation() throws Exception {
        Response response = target.path("/donation/3").request().get();
        assertEquals(200, response.getStatus());
        JsonObject json = (new JsonParser()).parse(response.readEntity(String.class)).getAsJsonObject();
        assertEquals(1L, json.get("userId").getAsLong());
    }
    
    @Test
    @InSequence(5)
    public void getDonationFail() throws Exception {
        Response response = target.path("/donation/80").request().get();
        assertEquals(204, response.getStatus());
    }
    
    @Test
    @InSequence(6)
    public void getCountNotEmpty() throws Exception {
        Response response = target.path("/donation/count").request().get();
        assertEquals(200, response.getStatus());
        assertEquals(response.readEntity(String.class), "1");
    }
           
    
    @Test
    @InSequence(7)
    public void testGetAllNotEmpty() throws Exception {
        Response response = target.path("/donation").request().get();
        assertEquals(200, response.getStatus());
    }
    
    @Test
    @InSequence(8)
    public void testGetAllCampaigns() throws Exception {
        Response response = target.path("/campaign").request().get();
        assertEquals(200, response.getStatus());
    }
    /*
    @Test
    @InSequence(10)
    public void removeCampanha() throws Exception {
        Response response = target.path("/donation/1").request().delete();
        assertEquals(204, response.getStatus());
        Response response2 = target.path("/donation/count").request().get();
        assertEquals(200, response2.getStatus());
        assertEquals(response2.readEntity(String.class), "0");
    }*/

    
}
