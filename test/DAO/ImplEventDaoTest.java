/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DAO.ImplEventDao;
import Model.JavaBean.Event;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pirozzi
 */
public class ImplEventDaoTest {
    
    public ImplEventDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of advancedSearchEvent method, of class ImplEventDao.
     */
    @Test
    public void testAdvancedSearchEvent() throws Exception {
        System.out.println("advancedSearchEvent");
        String evtName = "";
        String codEvt = "";
        String dateEvt = "";
        String typeEvt = "";
        ImplEventDao instance = new ImplEventDao();
        Event expResult = null;
        Event result = instance.advancedSearchEvent(evtName, codEvt, dateEvt, typeEvt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createEvent method, of class ImplEventDao.
     */
    @Test
    public void testCreateEvent() throws Exception {
        System.out.println("createEvent");
        Event event = null;
        ImplEventDao instance = new ImplEventDao();
        instance.createEvent(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateEvent method, of class ImplEventDao.
     */
    @Test
    public void testUpdateEvent() throws Exception {
        System.out.println("updateEvent");
        String new_value = "";
        String attribute_to_change = "";
        String id = "";
        ImplEventDao instance = new ImplEventDao();
        int expResult = 0;
        int result = instance.updateEvent(new_value, attribute_to_change, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteEvent method, of class ImplEventDao.
     */
    @Test
    public void testDeleteEvent_String() throws Exception {
        System.out.println("deleteEvent");
        String idEvent = "";
        ImplEventDao instance = new ImplEventDao();
        int expResult = 0;
        int result = instance.deleteEvent(idEvent);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    

    /**
     * Test of deleteEvent method, of class ImplEventDao.
     */
    
    /**
     * Test of searchByTypeEvent method, of class ImplEventDao.
     */
    @Test
    public void testSearchByTypeEvent() throws Exception {
        System.out.println("searchByTypeEvent");
        String type_event = "";
        ImplEventDao instance = new ImplEventDao();
        Set<Event> expResult = null;
        Set<Event> result = instance.searchByTypeEvent(type_event);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByKindEvent method, of class ImplEventDao.
     */
    @Test
    public void testSearchByKindEvent() throws Exception {
        System.out.println("searchByKindEvent");
        String kind_event = "";
        ImplEventDao instance = new ImplEventDao();
        Set<Event> expResult = null;
        Set<Event> result = instance.searchByKindEvent(kind_event);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByTitle method, of class ImplEventDao.
     */
    @Test
    public void testSearchByTitle() throws Exception {
        System.out.println("searchByTitle");
        String title = "";
        ImplEventDao instance = new ImplEventDao();
        Set<Event> expResult = null;
        Set<Event> result = instance.searchByTitle(title);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByPlace method, of class ImplEventDao.
     */
    @Test
    public void testSearchByPlace() throws Exception {
        System.out.println("searchByPlace");
        String place = "";
        ImplEventDao instance = new ImplEventDao();
        Set<Event> expResult = null;
        Set<Event> result = instance.searchByPlace(place);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByProvince method, of class ImplEventDao.
     */
    @Test
    public void testSearchByProvince() throws Exception {
        System.out.println("searchByProvince");
        String province = "";
        ImplEventDao instance = new ImplEventDao();
        Set<Event> expResult = null;
        Set<Event> result = instance.searchByProvince(province);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByDate method, of class ImplEventDao.
     */
    @Test
    public void testSearchByDate() throws Exception {
        System.out.println("searchByDate");
        Date from = null;
        Date to = null;
        ImplEventDao instance = new ImplEventDao();
        Set<Event> expResult = null;
        Set<Event> result = instance.searchByDate(from, to);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
