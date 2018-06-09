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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.PathParam;
import rest.DonationREST.DonateXml;

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

    public Long create(DonateXml d) {
        Utilizador u = em.find(Utilizador.class, d.user_id);
        Campanha c = em.find(Campanha.class, d.campanha_id);

        Donation don = new Donation(u, c, d.ammount, new Date());
        super.create(don);
        return don.getId();

    }

    public void edit(@PathParam("id") Long id, Donation entity) {
        super.edit(entity);
    }

    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    public DonationSerial find(@PathParam("id") Long id) {
        return super.find(id).getSerialized();
    }

    public List<DonationSerial> findAllFiltered() {
        List<Donation> lista = super.findAll();
        List<DonationSerial> out = new ArrayList<>();
        for (Donation c : lista) {
            out.add(c.getSerialized());
        }
        return out;
    }

    public List<DonationSerial> findRangeFiltered(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        List<Donation> lista = super.findRange(new int[]{from, to});
        List<DonationSerial> out = new ArrayList<>();
        for (Donation c : lista) {
            out.add(c.getSerialized());
        }
        return out;
    }

    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
