/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import AccessDataStorage.DB.DAO.ImplMySqlEventDao;
import AccessDataStorage.DB.Database.DBConnect;
import BusinessComponent.Entity.Event;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        //BISOGNA INSERIRE UN EVENTO CON CHIAVE PRIMARIA 24 AL FINE DI VERIFICARE IL TEST DEL METODO DELETE
        Connection con;
        PreparedStatement ps;
        try
        {
        String sql = "INSERT INTO EVENTO(IDEVENTO,TITLE,EVENT_TYPE,KIND_TYPE,DATE,PLACE_NAME,DESCRIPTION) VALUES ('24','test','SPORT','FOOTBALL','2018-12-07','NAPOLI','RIGA TEST');";
        con = DBConnect.getConnection();
        ps=con.prepareStatement(sql);
        int res = ps.executeUpdate();
        con.close();
        ps.close();
        }
        catch(SQLException e)
        {
            
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createEvent method, of class ImplMySqlEventDao.
     */
    
    
    @Test
    public void testCreateEvent()  {
      
        System.out.println("createEvent");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        // WECT TEST
        try{
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
           
            //NEL TRY CATCH QUELLE CHE DEVONO ANDARE IN ECCEZIONE.
            
            try
            {
                instance.createEvent(e1);
                fail();
            }
            catch(SQLException ex)
            {
                assertTrue(true);
            }
            try
            {
                instance.createEvent(e2);
                fail();
            }
            catch(SQLException ex)
            {
                assertTrue(true);
            }
            try
            {
                instance.createEvent(e3);
                fail();
            }
            catch(SQLException ex)
            {
                assertTrue(true);
            }
            try
            {
                instance.createEvent(e4);
                fail();
            }
            catch(SQLException ex)
            {
                assertTrue(true);
            }
            
            try
            {
                instance.createEvent(e5);
                assertTrue(true);
            }
            catch(SQLException ex)
            {
                fail();
            }
            
            try
            {
                instance.createEvent(e6);
                assertTrue(true);
            }
            catch(SQLException ex)
            {
                fail();
            }
            try
            {
                instance.createEvent(e7);
                fail();
            }
            catch(SQLException ex)
            {
                assertTrue(true);
            }
            try
            {
                instance.createEvent(e8);
                fail();
            }
            catch(SQLException ex)
            {
                assertTrue(true);
            }
            try
            {
                instance.createEvent(e9);
                fail();

            }
            catch(SQLException ex)
            {
                assertTrue(true);
            }
            try
            {
                instance.createEvent(e10);
                fail();
            }
            catch(SQLException ex)
            {
                assertTrue(true);
            }
            try
            {
                instance.createEvent(e11);
                fail();
            }
            catch(SQLException ex)
            {
                assertTrue(true);
            }
        
        
        }
        catch(Exception e)
        {
            System.out.println("Errore conversione data.Verificare di aver inserito una data nel formato valido e riprovare");
        }
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    /**
     * Test of deleteEvent method, of class ImplMySqlEventDao.
     */
    @Test
    public void testDeleteEvent() throws Exception {
        System.out.println("deleteEvent");
        
         String idEvent1 = "Aaaaaaabbbccc";
         String idEvent2 = "";
         String idEvent3 = "24";
         //nota deve essere presente la chiave primaria dell'evento 24 per funzionare.
         
        ImplMySqlEventDao instance = new ImplMySqlEventDao();
        
        int result = instance.deleteEvent(idEvent1);
        assertEquals(0,result);
        
        result = instance.deleteEvent(idEvent2);
        assertEquals(0,result);
        
        
        result = instance.deleteEvent(idEvent3);
        assertEquals(1,result);


        
    }
    
    
    
    
    /**
     * Test of searchByTitle method, of class ImplMySqlEventDao.
     */
    @Test
    public void testSearchByTitle() throws Exception {
        System.out.println("searchByTitle");
        String title1 = "Harry Potter";
        String title2 = "XXX";
        String title3 = "";
        String title4 = "*****";
        String title5 = "Da paura";
        
        
        ImplMySqlEventDao instance = new ImplMySqlEventDao();
        Set<Event> result = instance.searchByTitle(title1);
        
        for(Event e : result)
        {
            assertEquals(title1.toUpperCase(),e.getTitle().toUpperCase());
        }      
        
        result = instance.searchByTitle(title2);
        
        for(Event e : result)
        {
            assertEquals(title2.toUpperCase(),e.getTitle().toUpperCase());
        }      
        
        result = instance.searchByTitle(title3);
         
        for(Event e : result)
        {
            assertEquals(title3.toUpperCase(),e.getTitle().toUpperCase());
        }      
         
        result = instance.searchByTitle(title4);
        
        for(Event e : result)
        {
            assertEquals(title4.toUpperCase(),e.getTitle().toUpperCase());
        }      
          
        result = instance.searchByTitle(title5);
        
        for(Event e : result)
        {
            assertEquals(title5.toUpperCase(),e.getTitle().toUpperCase());
        }      
        
        // TODO review the generated test code and remove the default call to fail.
    }
}
