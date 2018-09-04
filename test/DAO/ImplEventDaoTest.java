/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import AccessDataStorage.DB.DAO.ImplMySqlEventDao;
import AccessDataStorage.DB.Database.DBConnect;
import BusinessComponent.Entity.Event;
import java.lang.reflect.Executable;
import java.text.SimpleDateFormat;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author INGSW2017_22
 */
public class ImplEventDaoTest {
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    
    public ImplEventDaoTest() {
            DBConnect.setUser("Admin_1");
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
     * Test of createEvent method, of class ImplMySqlEventDao.
     */
    
    
    @Test
    public void testCreateEvent() throws Exception {
      
        System.out.println("createEvent");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        // WECT TEST
        Event e1 = new Event("Prova1","test", "Cinema", "Comedy",sdf.parse("5/06/1990"),"test"); //sql exception on date,ok
        Event e2 = new Event("","test", "Cinema", "Comedy",sdf.parse("5/06/2020"),"test"); //sql exception on title,ok
        Event e3 = new Event("******","test", "Cinema", "Comedy",sdf.parse("5/06/2020"),"test"); //sql exception on title,ok
        Event e4 = new Event("Harry Potter","test","Ciao","",sdf.parse("16/07/2018"),"test"); //sql exception on type_event,ok
        Event e5 = new Event("Harry Potter 3","test","Cinema","Other",sdf.parse("7/06/2020"),"test"); //insert ok,ok
        Event e6 = new Event("Napoli-Juve","test","Sport","Football",sdf.parse("06/03/2019"),"test"); //insert ok,ok
        Event e7 = new Event("Napoli-Juve","test","Sport","Comedy",sdf.parse("16/07/2018"),"test"); //sql exception kind,ok
        Event e8 = new Event("Pino Daniele","test","Concert","",sdf.parse("16/07/2018"),"test"); //sql exception kind,ok
        Event e9 = new Event("Ingegneria*_*","test","","",sdf.parse("20/07/2018"),"test"); //SQL exception on type Event  enumeration,ok
        Event e10 = new Event("Jovanotti","test","","Concert","PopAndRock",null,"test"); //sqlException on date.
        Event e11 = new Event("Jovanotti","test","Concert","xxxxx",sdf.parse("25/07/2022"),"test"); //SqlException on KindEvent
        
        ImplMySqlEventDao instance = new ImplMySqlEventDao();
        
        
        /*int res = instance.createEvent(e5);
        assertEquals(1,res); 
        res = instance.createEvent(e6);
        assertEquals(1,res);
        */
        
        
        int res = instance.createEvent(e1);
        assertEquals(1,res); 
        res = instance.createEvent(e2);
        assertEquals(1,res);
        res = instance.createEvent(e3);
        assertEquals(1,res);
        res = instance.createEvent(e4);
        assertEquals(1,res);
        res = instance.createEvent(e5);
        assertEquals(1,res);
        res = instance.createEvent(e6);
        assertEquals(1,res);
        res = instance.createEvent(e7);
        assertEquals(1,res);
        res = instance.createEvent(e8);
        assertEquals(1,res);
        res = instance.createEvent(e9);
        assertEquals(1,res);
        res = instance.createEvent(e10);
        assertEquals(1,res);
        res = instance.createEvent(e11);
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
}
