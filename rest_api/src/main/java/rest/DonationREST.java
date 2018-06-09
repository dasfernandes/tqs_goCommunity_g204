/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import JPA.Campanha;
import JPA.Donation;
import JPA.Donation.DonationSerial;
import JPA.Utilizador;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Stateless
@Path("donation")
public class DonationREST {

    @EJB
    DonationFacade facade;

    public DonationREST() {

    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Long create(DonateXml entity) {
        return facade.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Donation entity) {
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
    public DonationSerial find(@PathParam("id") Long id) {
        try {
            return facade.find(id);
        } catch (Exception e) {
            return null;
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<DonationSerial> findAll() {
        return facade.findAllFiltered();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<DonationSerial> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return facade.findRangeFiltered(from, to);
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(facade.count());
    }

    @XmlRootElement
    public static class DonateXml {

        @XmlElement
        public double ammount;
        @XmlElement
        public Long user_id;
        @XmlElement
        public Long campanha_id;

        public DonateXml() {
        }

        ;
        
        public DonateXml(Long campanha_id, Long user_id, double amount) {
            this.ammount = amount;
            this.campanha_id = campanha_id;
            this.user_id = user_id;
        }
    }

}
