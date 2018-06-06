/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dimitri
 */
public class UtilizadorTest {
    private Campanha campanha;
    private Utilizador user;
    private Donation donation;
    
    public UtilizadorTest() {
    }
    
    @Before
    public void setUp() {
        user = new Utilizador("testName", 0, "testEmail", "testPw");
        campanha = new Campanha("testTitle", "testDescription", 0, user);
        donation = new Donation(user, campanha, 0, new Date());
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Utilizador.
     */
    @Test
    public void testGetId() {
    }

    /**
     * Test of setId method, of class Utilizador.
     */
    @Test
    public void testSetId() {
    }

    /**
     * Test of getName method, of class Utilizador.
     */
    @Test
    public void testGetName() {
        assertEquals(user.getName(), "testName");
    }

    /**
     * Test of setName method, of class Utilizador.
     */
    @Test
    public void testSetName() {
        user.setName("abc");
        assertEquals(user.getName(), "abc");
    }

    /**
     * Test of getSumdonated method, of class Utilizador.
     */
    @Test
    public void testGetSumdonated() {
        assertEquals(user.getSumdonated(), 0.0, 0.01);
    }

    /**
     * Test of setSumdonated method, of class Utilizador.
     */
    @Test
    public void testSetSumdonated() {
        user.setSumdonated(1.0);
        assertEquals(user.getSumdonated(), 1.0, 0.01);
        user.setSumdonated(2.0);
        assertEquals(user.getSumdonated(), 2.0, 0.01);
    }

    /**
     * Test of getEmail method, of class Utilizador.
     */
    @Test
    public void testGetEmail() {
        assertEquals(user.getEmail(), "testEmail");
    }

    /**
     * Test of setEmail method, of class Utilizador.
     */
    @Test
    public void testSetEmail() {
        user.setEmail("abc");
        assertEquals(user.getEmail(), "abc");
        user.setEmail("abc1");
        assertEquals(user.getEmail(), "abc1");
    }

    /**
     * Test of getPwhash method, of class Utilizador.
     */
    @Test
    public void testGetPwhash() {
        assertEquals(user.getPwhash(), "testPw");
    }

    /**
     * Test of setPwhash method, of class Utilizador.
     */
    @Test
    public void testSetPwhash() {
        user.setPwhash("abc");
        assertEquals(user.getPwhash(), "abc");
        user.setPwhash("abc1");
        assertEquals(user.getPwhash(), "abc1");
    }

    /**
     * Test of setDonations method, of class Campanha.
     */
    @Test
    public void testSetDonations() {
        Donation d = new Donation();
        List<Donation> l = new ArrayList<>();
        l.add(d);
        user.setDonations(l);
        assertEquals(d, user.getDonations().get(0));
    }

    /**
     * Test of addDonation method, of class Campanha.
     */
    @Test
    public void testAddDonation() {
        Donation d = new Donation();
        user.addDonation(d);
        assertEquals(d, user.getDonations().get(0));
    }
    /**
     * Test of hashCode method, of class Campanha.
     */
    @Test
    public void testHashCode() {
        Utilizador copy = new Utilizador("testName2", 0, "testEmail2", "testPw2");
        copy.setId(4L);
        assertNotEquals(user.hashCode(), copy.hashCode());
        assertEquals(user.hashCode(), user.hashCode());
    }

    /**
     * Test of equals method, of class Campanha.
     */
    @Test
    public void testEquals() {
        Utilizador copy = new Utilizador("testName2", 0, "testEmail2", "testPw2");
        copy.setId(4L);
        assertFalse(user.equals(copy));
        assertTrue(user.equals(user));
    }

    /**
     * Test of toString method, of class Campanha.
     */
    @Test
    public void testToString() {
        Utilizador copy = new Utilizador("testName2", 0, "testEmail2", "testPw2");
        assertNotEquals(copy.toString(), user.toString());
    }

}
