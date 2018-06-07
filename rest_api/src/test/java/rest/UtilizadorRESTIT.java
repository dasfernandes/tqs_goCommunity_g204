/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import JPA.Campanha;
import JPA.CampanhaCreate;
import JPA.Donation;
import JPA.Utilizador;
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
public class UtilizadorRESTIT {
    private WebTarget target;

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(
                        AbstractFacade.class, UtilizadorREST.class, UtilizadorFacade.class, Campanha.class, Donation.class, Utilizador.class, ApplicationConfig.class, CampanhaCreate.class)
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml");
    }

    @ArquillianResource
    private URL deploymentURL;

    @Before
    public void setUp() throws MalformedURLException {
        Client client = ClientBuilder.newClient();
        target = client.target(URI.create(new URL(deploymentURL, "rest/user").toExternalForm()));
        target.register(Utilizador.class);
    }

    @Test
    @InSequence(1)
    public void testCount() {
        Response response = target.path("/count").request().get();
        assertEquals(200, response.getStatus());
        assertEquals(response.readEntity(String.class), "0");
    }

    @Test
    @InSequence(2)
    public void testGetAll() throws Exception {
        Response response = target.request().get();
        assertEquals(200, response.getStatus());
    }
    
    @Test
    @InSequence(3)
    public void testCreate() throws Exception {
        Utilizador user = new Utilizador("testName", "testEmail", "testPw");
        Response response = target.request().post(Entity.entity(user, MediaType.APPLICATION_JSON));
        assertEquals(200, response.getStatus());
        assertEquals(1L, (long)response.readEntity(Long.class));
    }
    
    @Test
    @InSequence(4)
    public void getSingleCampanha() throws Exception {
        Response response = target.path("/1").request().get();
        assertEquals(200, response.getStatus());
        Utilizador u = response.readEntity(Utilizador.class);
        assertEquals("testName", u.getName());
    }
    
    @Test
    @InSequence(5)
    public void getCampanhaFail() throws Exception {
        Response response = target.path("/2").request().get();
        assertEquals(204, response.getStatus());
    }
    
    @Test
    @InSequence(6)
    public void getCountNotEmpty() throws Exception {
        Response response = target.path("/count").request().get();
        assertEquals(200, response.getStatus());
        assertEquals(response.readEntity(String.class), "1");
    }
    
    @Test
    @InSequence(7)
    public void editCampanha() throws Exception {
        Response response = target.path("/1").request().get();
        assertEquals(200, response.getStatus());
        Utilizador u = response.readEntity(Utilizador.class);
        assertEquals("testName", u.getName());
        u.setName("testName2");
        target.path("/1").request().put(Entity.entity(u, MediaType.APPLICATION_JSON));
        Response response2 = target.path("/1").request().get();
        assertEquals(200, response2.getStatus());
        Utilizador u2 = response2.readEntity(Utilizador.class);
        assertEquals("testName2", u2.getName());
        
        
    }
    
    @Test
    @InSequence(8)
    public void removeCampanha() throws Exception {
        Response response = target.path("/1").request().delete();
        assertEquals(204, response.getStatus());
        Response response2 = target.path("/count").request().get();
        assertEquals(200, response2.getStatus());
        assertEquals(response2.readEntity(String.class), "0");
    }

    
}
