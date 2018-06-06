/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import JPA.Campanha;
import JPA.CampanhaCreate;
import JPA.Utilizador;
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
 * @author root
 */
@Stateless
public class CampanhaFacade extends AbstractFacade<Campanha> {

    @PersistenceContext(unitName = "PERSISTENCE_UNIT_NAME")
    private EntityManager em;

    public CampanhaFacade() {
        super(Campanha.class);
    }

    public Long create2(CampanhaCreate campanha) {
        Utilizador u = em.find(Utilizador.class, campanha.user_id);
        Campanha c = new Campanha(campanha.title, campanha.description, campanha.goal, u,campanha.image);
        super.create(c);
        return c.getId();
    }

    public void edit(@PathParam("id") Long id, Campanha entity) {
        super.edit(entity);
    }

    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    public Campanha find(@PathParam("id") Long id) {
        return super.find(id);
    }

    public List<Campanha> findAll() {
        TypedQuery query = em.createQuery("SELECT p FROM Campanha p", Campanha.class);
        return query.getResultList();
    }

    public List<Campanha> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
return em;
    }
}
