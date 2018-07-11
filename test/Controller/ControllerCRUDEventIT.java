/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.DAO.EventDao;
import DB.DAO.ImplEventDao;
import Model.JavaBean.Event;
import View.EventPanel;
import View.GeneralPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import static java.lang.Compiler.command;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author giuli
 */
public class ControllerCRUDEventIT {
    
    GeneralPanel view = null;
    EventDao dao = null;
    
    public ControllerCRUDEventIT() {
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
    
    private void testAdvancedSearch(String title,String type, Date from, Date to,String kind,ControllerCRUDEvent evt) 
    {
        
        
                Set<Event> event = evt.advancedSearch(title, type, from, to, kind);
                
                
                for(Event tmp : event)
                {
                    assertEquals(tmp.getTitle().toUpperCase(), title.toUpperCase());
                    
                  if(from != null && to != null)
                  {
                    if(!(tmp.getDataEvent().equals(from) || tmp.getDataEvent().equals(to)))
                    {
                        assertEquals((tmp.getDataEvent().after(from)), true);
                        assertEquals((tmp.getDataEvent().before(to)), true);
                    }
                  }
                 
                }       
                
                
    }

    /**
     * Test of actionPerformed method, of class ControllerCRUDEvent.
     */
    @Test
    public void testActionPerformed() throws Exception {
        System.out.println("actionPerformed");
        view = new EventPanel();
        dao = new ImplEventDao();
        ControllerCRUDEvent controllerEvt = new ControllerCRUDEvent(dao, view);
        //controllerEvt.advancedSearch("Harry","Select Type Event...",new Date(2018,8,20),new Date(2018,10,15),"genere");
        testAdvancedSearch("Prova1","Select Type Event...",new Date(2018,0,10),new Date(2018,11,15),"genere",controllerEvt);
        testAdvancedSearch("Prova1","Select Type Event...",new Date(2018,0,10),null,"genere",controllerEvt);//JOPTION
        testAdvancedSearch("Prova1","Select Type Event...",null,null,"genere",controllerEvt);
        testAdvancedSearch("Prova1","Select Type Event...",null,new Date(2018,0,10),"genere",controllerEvt);//JOPTION
        

        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of keyReleased method, of class ControllerCRUDEvent.
     */
    /*@Test
    public void testKeyReleased() {
        System.out.println("keyReleased");
        KeyEvent e = null;
        ControllerCRUDEvent instance = null;
        instance.keyReleased(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of itemStateChanged method, of class ControllerCRUDEvent.
     */
    /*@Test
    public void testItemStateChanged() {
        System.out.println("itemStateChanged");
        ItemEvent e = null;
        ControllerCRUDEvent instance = null;
        instance.itemStateChanged(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

}