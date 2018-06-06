/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dimitri
 */
public class DonationTest {
    private Campanha campanha;
    private Utilizador user;
    private Donation donation;
    
    public DonationTest() {
    }
    
    @Before
    public void setUp() {
        user = new Utilizador("testName", "testEmail", "testPw");
        campanha = new Campanha("testTitle", "testDescription", 0, user,"");
        donation = new Donation(user, campanha, 0, new Date());
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of getUtilizador method, of class Donation.
     */
    @Test
    public void testGetUtilizador() {
        assertEquals(donation.getUtilizador(), user);
    }

    /**
     * Test of setUser method, of class Donation.
     */
    @Test
    public void testSetUser() {
        Utilizador u = new Utilizador("testName1", "testEmail1", "testPw1");
        assertEquals(u, donation.getUtilizador());
    }

    /**
     * Test of getCampanha method, of class Donation.
     */
    @Test
    public void testGetCampanha() {
        assertEquals(campanha, donation.getCampanha());
    }

    /**
     * Test of setCampanha method, of class Donation.
     */
    @Test
    public void testSetCampanha() {
        donation.setCampanha(null);
        assertEquals(donation.getCampanha(), null);
        donation.setCampanha(campanha);
        assertEquals(campanha, donation.getCampanha());
    }

    /**
     * Test of getAmmount method, of class Donation.
     */
    @Test
    public void testGetAmmount() {
        assertEquals(donation.getAmmount(), 0, 0.01);
    }

    /**
     * Test of setAmmount method, of class Donation.
     */
    @Test
    public void testSetAmmount() {
        donation.setAmmount(1);
        assertEquals(donation.getAmmount(), 1, 0.01);
        donation.setAmmount(2);
        assertEquals(donation.getAmmount(), 2, 0.01);
    }

    /**
     * Test of getDate method, of class Donation.
     */
    @Test
    public void testGetDate() {
        assertEquals(donation.getDate(), new Date());
    }

    /**
     * Test of setDate method, of class Donation.
     */
    @Test
    public void testSetDate() {
        donation.setDate(null);
        assertEquals(donation.getDate(), null);
        Date d = new Date();
        donation.setDate(d);
        assertEquals(donation.getDate(), d);
    }

    /**
     * Test of hashCode method, of class Donation.
     */
    @Test
    public void testHashCode() {
        assertEquals(donation.hashCode(), donation.hashCode());
    }

    /**
     * Test of equals method, of class Donation.
     */
    @Test
    public void testEquals() {
        Donation d = new Donation(user, campanha, 1, new Date());
        donation.setId(4L);
        assertFalse(donation.equals(d));
        assertTrue(donation.equals(donation));
    }

    /**
     * Test of toString method, of class Donation.
     */
    @Test
    public void testToString() {
        Donation d = new Donation(user, campanha, 1, new Date());
        assertNotEquals(donation.toString(), d);
        assertEquals(donation.toString(), donation.toString());
    }
    
}
