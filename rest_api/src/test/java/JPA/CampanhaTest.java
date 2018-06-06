/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dimitri
 */
public class CampanhaTest {

    private Campanha campanha;
    private Utilizador user;

    public CampanhaTest() {
    }
    
    @Before
    public void setUp() {
        user = new Utilizador("testName", "testEmail", "testPw");
        campanha = new Campanha("testTitle", "testDescription", 0, user,"");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getUser method, of class Campanha.
     */
    @Test
    public void testGetUser() {
        assertEquals(campanha.getUser().getName(), "testName");
    }

    /**
     * Test of setUser method, of class Campanha.
     */
    @Test
    public void testSetUser() {
        campanha.setUser(null);
        assertEquals(campanha.getUser(), null);
        campanha.setUser(user);
        assertEquals(campanha.getUser().getName(), "testName");
    }

    /**
     * Test of getTitle method, of class Campanha.
     */
    @Test
    public void testGetTitle() {
        assertEquals(campanha.getDescription(), "testDescription");
    }

    /**
     * Test of setTitle method, of class Campanha.
     */
    @Test
    public void testSetTitle() {
        campanha.setTitle("abc");
        assertEquals("abc", campanha.getTitle());
    }

    /**
     * Test of getDescription method, of class Campanha.
     */
    @Test
    public void testGetDescription() {
        assertEquals(campanha.getDescription(), "testDescription");
    }

    /**
     * Test of setDescription method, of class Campanha.
     */
    @Test
    public void testSetDescription() {
        campanha.setDescription("abc");
        assertEquals("abc", campanha.getDescription());
        
    }

    /**
     * Test of getGoal method, of class Campanha.
     */
    @Test
    public void testGetGoal() {
        assertEquals(campanha.getGoal(), (double) 0, 0.01);
    }

    /**
     * Test of setGoal method, of class Campanha.
     */
    @Test
    public void testSetGoal() {
        campanha.setGoal(2);
        double d = 2;
        assertEquals(d, (double)campanha.getGoal(), 0.01);
    }

    /**
     * Test of getCurrent method, of class Campanha.
     */
    @Test
    public void testGetCurrent() {
        assertEquals(campanha.getCurrent(), (double) 0, 0.01);
        
    }

    /**
     * Test of setCurrent method, of class Campanha.
     */
    @Test
    public void testSetCurrent() {
        campanha.setCurrent(2);
        double d = 2;
        assertEquals(d, (double)campanha.getCurrent(), 0.01);
    }

    /**
     * Test of getDonations method, of class Campanha.
     */
    @Test
    public void testGetDonations() {
        assertEquals(campanha.getDonations().size(), 0);
    }

    /**
     * Test of setDonations method, of class Campanha.
     */
    @Test
    public void testSetDonations() {
        Donation d = new Donation();
        List<Donation> l = new ArrayList<>();
        l.add(d);
        campanha.setDonations(l);
        assertEquals(d, campanha.getDonations().get(0));
    }

    /**
     * Test of addDonation method, of class Campanha.
     */
    @Test
    public void testAddDonation() {
        Donation d = new Donation();
        campanha.addDonation(d);
        assertEquals(d, campanha.getDonations().get(0));
    }

    /**
     * Test of hashCode method, of class Campanha.
     */
    @Test
    public void testHashCode() {
        Campanha copy = new Campanha("testTitle", "testDescription", 0, user,"");
        assertEquals(copy.hashCode(), copy.hashCode());
    }

    /**
     * Test of equals method, of class Campanha.
     */
    @Test
    public void testEquals() {
        Campanha copy = new Campanha("testTitle3", "testDescription", 0, user,"");
        copy.setId(4L);
        assertFalse(campanha.equals(copy));
        assertTrue(campanha.equals(campanha));
    }

    /**
     * Test of toString method, of class Campanha.
     */
    @Test
    public void testToString() {
        Campanha copy = new Campanha("testTitle", "testDescription", 0, user,"");
        assertEquals(copy.toString(), campanha.toString());
    }

}
