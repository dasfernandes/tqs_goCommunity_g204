/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest_api;

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
import rest.AbstractFacade;
import rest.CampanhaFacadeREST;
import rest.UtilizadorFacadeREST;

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
        map.add("user", "Manuel o Roxo");
        target.request().post(Entity.form(map));

        map.clear();
        map.add("title", "Cancer fundraiser");
        map.add("description", "Is a fundraiser for cancer");
        map.add("goal", "30000");
        map.add("current", "10000");
        map.add("user", "Dimitri nas Silvas");
        target.request().post(Entity.form(map));

        Campanha[] campaignList = target.request().get(Campanha[].class);

        assertEquals(2, campaignList.length);

        assertEquals("Flu fundraiser", campaignList[0].getTitle());
        assertEquals(25000, campaignList[0].getGoal());

        assertEquals("Cancer fundraiser", campaignList[1].getTitle());
        assertEquals(30000, campaignList[1].getGoal());
    }

    @Test
    @InSequence(2)
    public void testGetSingle() {
        Campanha c = target
                .path("{id}")
                .resolveTemplate("user", "Dimitri nas Silvas")
                .request(MediaType.APPLICATION_XML)
                .get(Campanha.class);
        assertEquals("Cancer fundraiser", c.getTitle());
        assertEquals(30000, c.getGoal());
    }

//    @Test
//    @InSequence(3)
//    public void testPut() {
//        MultivaluedHashMap<String, String> map = new MultivaluedHashMap<>();
//        map.add("title", "TQS project fundraiser");
//        map.add("description", "Is a fundraiser to help us fisish de project");
//        map.add("goal", "40000");
//        map.add("current", "2");
//        map.add("user", "Artue");
//        target.request().post(Entity.form(map));
//
//        Employee[] list = target.request().get(Employee[].class);
//        assertEquals(4, list.length);
//
//        assertEquals("Howard", list[3].getName());
//        assertEquals(4, list[3].getAge());
//    }
//}
}