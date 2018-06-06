/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import JPA.Donation;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
public class DonationFacade extends AbstractFacade<Donation> {

    @PersistenceContext(unitName = "PERSISTENCE_UNIT_NAME")
    private EntityManager em;

    public DonationFacade() {
        super(Donation.class);
    }

    public Long create2(Donation entity) {
        super.create(entity);
        return entity.getId();
    }

    public void edit(@PathParam("id") Long id, Donation entity) {
        super.edit(entity);
    }

    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    public Donation find(@PathParam("id") Long id) {
        return super.find(id);
    }

    public List<Donation> findAll() {
        return super.findAll();
    }

    public List<Donation> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    public String countREST() {
        return String.valueOf(super.count());
    }

    protected EntityManager getEntityManager() {
        return em;
    }
    
}

