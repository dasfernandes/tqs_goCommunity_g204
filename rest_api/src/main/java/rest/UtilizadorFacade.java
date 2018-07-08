/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import JPA.Utilizador;
import JPA.Utilizador.UtilizadorSerialized;
import JPA.UtilizadorCreate;
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
 * @author root
 */
@Stateless
public class UtilizadorFacade extends AbstractFacade<Utilizador> {

    @PersistenceContext(unitName = "PERSISTENCE_UNIT_NAME")
    private EntityManager em;

    public UtilizadorFacade() {
        super(Utilizador.class);
    }
    
    public Long create2(UtilizadorCreate u) {
        Utilizador user = new Utilizador(u.name, u.email, u.pwHash);
        super.create(user);
        System.out.println("\nCreated User: " + user.toString());
        return user.getId();
    }
    
    public Utilizador login(UtilizadorREST.LoginXml login) {
        TypedQuery<Utilizador> query = em.createQuery("SELECT u FROM Utilizador u where u.email=\'"+login.email+"\'", Utilizador.class);
        List<Utilizador> lista=query.getResultList();
        if (lista.size()>0 ){
            if (lista.get(0).getPwhash().equals(login.pwhash)){
                return lista.get(0);
            }
        }
        return null;
    }

    public void edit(@PathParam("id") Long id, Utilizador entity) {
        super.edit(entity);
    }

    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    public Utilizador find(@PathParam("id") Long id) {
        System.out.println("\n\n\n" + id);
        List<Utilizador> lista = super.findAll();
        Utilizador u = super.find(id);
        System.out.println("User found" +u.toString());
        return u;

    }
    
    public List<UtilizadorSerialized> findAllFiltered() {
        List<Utilizador> lista = super.findAll();
        List<UtilizadorSerialized> out = new ArrayList<>();
        for (Utilizador u: lista) 
            out.add(u.getSerialized());
        return out;
    }

    public List<UtilizadorSerialized> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        List<Utilizador> lista = super.findRange(new int[]{from, to});;
        List<UtilizadorSerialized> out = new ArrayList<>();
        for (Utilizador u: lista)  {
            System.out.println("\n\n\n"+ u.toString() +"\n\n");
            out.add(u.getSerialized());}
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
