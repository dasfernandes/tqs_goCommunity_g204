/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import JPA.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Artur
 */
@RunWith(Arquillian.class)
public class CampanhaFacadeRESTIT {

    private WebTarget target;

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(
                        AbstractFacade.class, CampanhaFacadeREST.class, UtilizadorFacadeREST.class, Campanha.class, Donation.class, Utilizador.class);
    }

    @ArquillianResource
    private URL base;

    @Before
    public void setUp() throws MalformedURLException {
        Client client = ClientBuilder.newClient();
        target = client.target(URI.create(new URL(base, "registry/campaign").toExternalForm()));
        target.register(Campanha.class);
    }

    @Test
    @InSequence(1)
    public void testPostAndGet() {
        MultivaluedHashMap<String, String> map = new MultivaluedHashMap<>();
        map.add("title", "Flu fundraiser");
        map.add("description", "Is a fundraiser for flu");
        map.add("goal", "25000");
        map.add("current", "13000");
        target.request().post(Entity.form(map));

        map.clear();
        map.add("title", "Cancer fundraiser");
        map.add("description", "Is a fundraiser for cancer");
        map.add("goal", "30000");
        map.add("current", "10000");
        target.request().post(Entity.form(map));
        
        Campanha[] campaignList = target.request().get(Campanha[].class);
        
        assertEquals(2, campaignList.length);
        
        assertEquals("Flu fundraiser", campaignList[0].getTitle());
        assertEquals(13000, campaignList[0].getCurrent());

        assertEquals("Cancer fundraiser", campaignList[1].getTitle());
        assertEquals(30000, campaignList[1].getCurrent());
    }
}

