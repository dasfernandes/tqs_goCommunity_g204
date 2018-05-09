/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import JPA.Campanha;
import JPA.Utilizador;
import java.util.ArrayList;
import java.util.List;
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
public class CampanhaFacadeREST extends AbstractFacade<Campanha> {
    Utilizador u = new Utilizador("Artue", 0, "artue@ua.pt", "password");
    Campanha c = new Campanha("Doações para o Canil", "Sample description", 10, u);
    Campanha c1 = new Campanha("Angariação de fundos para festa", "Sample description", 1000, u);
    List<Campanha> l = new ArrayList<>();

    @PersistenceContext(unitName = "PERSISTENCE_UNIT_NAME")
    private EntityManager em;

    public CampanhaFacadeREST() {
        super(Campanha.class);
        l.add (c);
        l.add (c1);
    }

    @POST
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public void create(@FormParam("user_id") Integer id, @FormParam("title") String title, @FormParam("description") String description, @FormParam("goal") Double goal) {
        Utilizador u = em.find(Utilizador.class, id);
        Campanha c = new Campanha(title, description, goal, u);
        em.persist(title);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Campanha entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Campanha find(@PathParam("id") Long id) {
        return l.get(id.intValue());
        //return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Campanha> findAll() {
        return l;
        //TypedQuery query = em.createQuery("SELECT p FROM Campanha p", Campanha.class);
        //return query.getResultList();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Campanha> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
