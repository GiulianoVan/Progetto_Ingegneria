/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataStorage.DB.DAO.ImplMySqlEventDao;
import DataStorage.DB.Database.DBConnect;
import BusinessComponent.Entity.Event;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
            DBConnect.setUser("cognomen");
            DBConnect.setPassword("progettoing");
           
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
    /*
    @Test
    public void testAdvancedSearchEvent() throws Exception {
        System.out.println("advancedSearchEvent");
        String evtName = "";
        String codEvt = "";
        String dateEvt = "";
        String typeEvt = "";
        ImplMySqlEventDao instance = new ImplMySqlEventDao();
        Event expResult = null;
        Event result = instance.advancedSearchEvent(evtName, codEvt, dateEvt, typeEvt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
*/
    /**
     * Test of createEvent method, of class ImplMySqlEventDao.
     */
    
    
    @Test
    public void testCreateEvent() throws Exception {
      
        System.out.println("createEvent");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        //WECT1 Event e = new Event("Prova1","test", "Cinema", "Comedy",sdf.parse("5/06/1990"),"test"); //sql exception on date,ok
        //WECT2 Event e = new Event("","test", "Cinema", "Comedy",sdf.parse("5/06/2020"),"test"); //sql exception on title,ok
        //WECT3 Event e = new Event("******","test", "Cinema", "Comedy",sdf.parse("5/06/2020"),"test"); //sql exception on title,ok
        //WECT4 Event e = new Event("Harry Potter","test","Ciao","",sdf.parse("16/07/2018"),"test"); //sql exception on type_event,ok
      /*WECT5*/ Event e = new Event("Harry Potter 3","test","Cinema","Other",sdf.parse("7/06/2020"),"test"); //insert ok,ok
        //WECT6 Event e = new Event("Napoli-Juve","test","Sport","Football",sdf.parse("06/03/2019"),"test"); //insert ok,ok
        //WECT7 Event e = new Event("Napoli-Juve","test","Sport","Comedy",sdf.parse("16/07/2018"),"test"); //sql exception kind,ok
        //WECT8 Event e = new Event("Pino Daniele","test","Concert","",sdf.parse("16/07/2018"),"test"); //sql exception kind,ok
        //WECT9 Event e = new Event("Ingegneria*_*","test","","",sdf.parse("20/07/2018"),"test"); //SQL exception on type Event  enumeration,ok
       //WECT11 Event e = new Event("Jovanotti","test","","Concert","PopAndRock","test"); //sqlException on date.
       //WECT10 Event e = new Event("Jovanotti","test","Concert","xxxxx",sdf.parse("25/07/2022"),"test"); //SqlException on KindEvent
        ImplMySqlEventDao instance = new ImplMySqlEventDao();
        int res = instance.createEvent(e);
        
        assertEquals(1,res);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    
    /**
     * Test of updateEvent method, of class ImplEventDao.
     */
   
    /*
    @Test
    public void testUpdateEvent() throws Exception {
        System.out.println("updateEvent");
        String new_value = "PROVAXXX";
        String attribute_to_change = "TITLE";
        String id = "5";
        ImplMySqlEventDao instance = new ImplMySqlEventDao();
        int expResult = 1;
        int result = instance.updateEvent(new_value, attribute_to_change, id);
        System.out.println(result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    */
    
    /**
     * Test of deleteEvent method, of class ImplMySqlEventDao.
     */
    
    
    @Test
    public void testDeleteEvent_String() throws Exception {
        System.out.println("deleteEvent");
        //SECT1 String idEvent = "Aaaaaaabbbccc";
        //SECT2 String idEvent = "";
        String idEvent= "24";
        ImplMySqlEventDao instance = new ImplMySqlEventDao();
        
        int result = instance.deleteEvent(idEvent);
        //SECT1-SECT2 assertEquals(0,result);
        /*SECT3*/ assertEquals(1,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    
    
    /**
     * Test of deleteEvent method, of class ImplEventDao.
     */
    
    /**
     * Test of searchByTypeEvent method, of class ImplEventDao.
     */
    
    /*
    @Test
    public void testSearchByTypeEvent() throws Exception {
        System.out.println("searchByTypeEvent");
        String type_event = "";
        ImplMySqlEventDao instance = new ImplMySqlEventDao();
        Set<Event> expResult = null;
        Set<Event> result = instance.searchByTypeEvent(type_event);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    
    /**
     * Test of searchByKindEvent method, of class ImplEventDao.
     */
    
    /*
    @Test
    public void testSearchByKindEvent() throws Exception {
        System.out.println("searchByKindEvent");
        String kind_event = "";
        ImplMySqlEventDao instance = new ImplMySqlEventDao();
        Set<Event> expResult = null;
        Set<Event> result = instance.searchByKindEvent(kind_event);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    
    
    /**
     * Test of searchByTitle method, of class ImplMySqlEventDao.
     */
    @Test
    public void testSearchByTitle() throws Exception {
        System.out.println("searchByTitle");
        //String title = "Harry Potter";
        //String title = "XXX";
        //String title = "";
        //String title = "*****";
        String title = "Da paura";
        ImplMySqlEventDao instance = new ImplMySqlEventDao();
        Set<Event> result = instance.searchByTitle(title);
         
        for(Event e : result)
        {
            assertEquals(title.toUpperCase(),e.getTitle().toUpperCase());
        }
        
            
        
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of searchByPlace method, of class ImplEventDao.
     */
    
    /*
    @Test
    public void testSearchByPlace() throws Exception {
        System.out.println("searchByPlace");
       
        String place = "Napoli";
                
        ImplMySqlEventDao instance = new ImplMySqlEventDao();
        //Set<Event> expResult = null;
        Set<Event> result = instance.searchByPlace(place);
        for(Event e : result)
        {
          assertEquals(place.toUpperCase(),e.getPlaceName().toUpperCase());
        }
// TODO review the generated test code and remove the default call to fail.
    }

     */
    
    /**
     * Test of searchByProvince method, of class ImplEventDao.
     */
    

    /**
     * Test of searchByDate method, of class ImplEventDao.
     */
    
    /*
    @Test
    public void testSearchByDate() throws Exception {
        System.out.println("searchByDate");
        Date from = null;
        Date to = null;
        ImplMySqlEventDao instance = new ImplMySqlEventDao();
        Set<Event> expResult = null;
        Set<Event> result = instance.searchByDate(from, to);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    */
    
}
