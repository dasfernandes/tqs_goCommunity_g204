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
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
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

/**
 *
 * @author Dimitri
 */
@RunWith(Arquillian.class)
public class CampanhaRESTIT {
    
    private WebTarget target;

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(
                        AbstractFacade.class, UtilizadorREST.class, UtilizadorFacade.class,  CampanhaREST.class, CampanhaFacade.class, Campanha.class, Donation.class, Utilizador.class, ApplicationConfig.class, CampanhaCreate.class)
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
        Response response = target.path("/campaign/count").request().get();
        assertEquals(200, response.getStatus());
        assertEquals(response.readEntity(String.class), "0");
    }

    @Test
    @InSequence(2)
    public void testGetAll() throws Exception {
        Response response = target.path("/campaign").request().get();
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
        c.user_id = 1L;
        response = target.path("/campaign").request().post(Entity.entity(c, MediaType.APPLICATION_JSON));
        assertEquals(200, response.getStatus());
        assertEquals(2L, (long)response.readEntity(Long.class));
    }
    
    @Test
    @InSequence(4)
    public void getSingleCampanha() throws Exception {
        Response response = target.path("campaign/2").request().get();
        assertEquals(200, response.getStatus());
        Campanha c = response.readEntity(Campanha.class);
        assertEquals("testTitle", c.getTitle());
    }
    
    @Test
    @InSequence(5)
    public void getCampanhaFail() throws Exception {
        Response response = target.path("campaign/3").request().get();
        assertEquals(204, response.getStatus());
    }
    
    @Test
    @InSequence(6)
    public void getCountNotEmpty() throws Exception {
        Response response = target.path("campaign/count").request().get();
        assertEquals(200, response.getStatus());
        assertEquals("1", response.readEntity(String.class));
    }
    
    @Test
    @InSequence(7)
    public void testGetAllNotEmpty() throws Exception {
        Response response = target.path("/campaign").request().get();
        assertEquals(200, response.getStatus());
    }
    
    @Test
    @InSequence(8)
    public void removeCampanha() throws Exception {
        Response response = target.path("campaign/2").request().delete();
        assertEquals(204, response.getStatus());
        Response response2 = target.path("campaign/count").request().get();
        assertEquals(200, response2.getStatus());
        assertEquals("0", response2.readEntity(String.class));
    }

    
}
