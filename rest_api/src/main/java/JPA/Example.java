/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package JPA;

import javax.persistence.*;
import java.util.*;

/**
 *
 * @author root
 */
public class Example {
    /*
    public static void main(String[] args){
        String example="ONE";
        // Get the EntityManager by creating an EntityManagerFactory via the persistence-unit name we provided.
        
        EntityManager entityManager = Persistence.createEntityManagerFactory("PERSISTENCE_UNIT_NAME").createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction(); // Not useful here, but useful to see
        List<ExampleEntity> list  = null;
        try {
        transaction.begin();
        // Add an entity
        ExampleEntity entity = new ExampleEntity();
        entity.setTalky(example);
        entityManager.persist(entity);
        // List entities, via the named query we defined in mapping.xml
        TypedQuery<ExampleEntity> nq = entityManager.createNamedQuery("list", ExampleEntity.class);
        list = nq.getResultList();
        // Commit the transaction
        transaction.commit();
        } catch (Exception e) {
        transaction.rollback();
        throw e; // Ergo showing a 500 error. You may want to throw an exception that is not detailing stuff about your JPA connection
        } finally {
        entityManager.clear(); // Clears all the entities from the EntityManager
        entityManager.close();
        }
        
        EntityManager em = Persistence.createEntityManagerFactory("PERSISTENCE_UNIT_NAME").createEntityManager();
        
        em.getTransaction().begin();
        for (int i = 0; i < 100; i++) {
            Campanha p = new Campanha(i+"", i+"", i);
            
            Utilizador u= new Utilizador(i+"", i, i+"",i+"");
            
            Donation d1= new Donation(u,p,i,new Date());
            Donation d2= new Donation(u,p,i*2,new Date());
            
            em.persist(p);
            em.persist(u);
            em.persist(d1);
            em.persist(d2);
        }
        
        em.getTransaction().commit();
        
        // Find the number of Campanha objects in the database:
        Query q1 = em.createQuery("SELECT COUNT(p) FROM Campanha p");
        System.out.println("Total Campanhas: " + q1.getSingleResult());
        q1 = em.createQuery("SELECT COUNT(p) FROM Donation p");
        System.out.println("Total Donations: " + q1.getSingleResult());
        q1 = em.createQuery("SELECT COUNT(p) FROM Utilizador p");
        System.out.println("Total Utilizadores: " + q1.getSingleResult());
        
        
        TypedQuery<Utilizador> query =
                em.createQuery("SELECT p FROM Utilizador p", Utilizador.class);
        List<Utilizador> results = query.getResultList();
        for (Utilizador p : results) {
            System.out.println(p);
        }
        
        // Retrieve all the Campanha objects from the database:
        
        TypedQuery<Campanha> query2 =
                em.createQuery("SELECT p FROM Campanha p", Campanha.class);
        List<Campanha> results2 = query2.getResultList();
        for (Campanha p : results2) {
            System.out.println(p);
        }
        
        TypedQuery<Donation> query3 =
                em.createQuery("SELECT p FROM Donation p", Donation.class);
        List<Donation> results3 = query3.getResultList();
        for (Donation p : results3) {
            System.out.println(p);
        }
        
        // Close the database connection:
        em.close();
        
    }*/
}
