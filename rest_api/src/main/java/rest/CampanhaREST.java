/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import JPA.Campanha;
import JPA.Campanha.CampanhaSerial;
import JPA.CampanhaCreate;
import JPA.Utilizador;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Dimitri
 */
@Stateless
@Path("campaign")
public class CampanhaREST{

    @EJB
    CampanhaFacade facade;
    

    public CampanhaREST() {
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Long create(CampanhaCreate campanha) {
        return facade.create(campanha);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Campanha entity) {
        facade.edit(id, entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        facade.remove(id);
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public CampanhaSerial find(@PathParam("id") Long id) {
        try {
            return facade.find(id);
        } catch (Exception e) {
            return null;
        }
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON})
    public List<CampanhaSerial> findAll() {
        return facade.findAllFiltered();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<CampanhaSerial> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return facade.findRange(from, to);
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return facade.countREST();
    }

}