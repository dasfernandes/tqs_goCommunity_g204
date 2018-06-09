/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import JPA.Campanha;
import JPA.Utilizador;
import JPA.Utilizador.UtilizadorSerialized;
import JPA.UtilizadorCreate;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dimitri
 */
@Stateless
@Path("user")
public class UtilizadorREST {
    @EJB
    UtilizadorFacade facade;

    public UtilizadorREST() {
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Long createUser(UtilizadorCreate entity) {       
        return facade.create2(entity);
    }
    
    @GET
    @Path("/test")
    public Long createUserTest() {       
        return facade.create2(new UtilizadorCreate("nome", "pass", "crl"));
    }
    
    @POST
    @Path("login")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Utilizador login(LoginXml login) {
        Utilizador user = facade.login(login);
        return user;
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Utilizador entity) {
        facade.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        facade.remove(id);
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public UtilizadorSerialized find(@PathParam("id") Long id) {
        return facade.find(id).getSerialized();
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON})
    public List<UtilizadorSerialized> findAll() { 
        System.out.println("oi");
        return facade.findAllFiltered();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<UtilizadorSerialized> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return facade.findRange(from, to);
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(facade.count());
    }
    
    @XmlRootElement
    public static class LoginXml {
        @XmlElement public String email;
        @XmlElement public String pwhash;
    }

}
