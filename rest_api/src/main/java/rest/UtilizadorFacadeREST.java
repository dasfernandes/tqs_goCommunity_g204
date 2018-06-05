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

/**
 *
 * @author Dimitri
 */
@Stateless
@Path("user")
public class UtilizadorFacadeREST extends AbstractFacade<Utilizador> {

    Utilizador u = new Utilizador("Artue2", 1, "artue@ua.pt", "password");
    Utilizador u1 = new Utilizador("Manel2", 2, "manel@ua.pt", "password");
    List<Utilizador> l = new ArrayList<>();

    @PersistenceContext(unitName = "PERSISTENCE_UNIT_NAME")
    private EntityManager em;

    public UtilizadorFacadeREST() {
        super(Utilizador.class);
        l.add(u);
        l.add(u1);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Utilizador entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Utilizador entity) {
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
    public Utilizador find(@PathParam("id") Long id) {
        //return l.get(id.intValue());
        System.out.println(123);
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Utilizador> findAll() {
        
        //return l;
        System.out.println(3231312);
        TypedQuery<Utilizador> query = em.createQuery("SELECT p.id, p.name, p.email, p.sumdonated FROM Utilizador p", Utilizador.class);
        return query.getResultList();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Utilizador> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        TypedQuery<Utilizador> query = em.createQuery("SELECT p.id, p.name, p.email, p.sumdonated FROM Utilizador p", Utilizador.class);
        query.setMaxResults(to - from + 1);
        query.setFirstResult(from);
        return query.getResultList();
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
