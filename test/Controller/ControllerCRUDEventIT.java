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
    
    private void testCaseSearch(String title, Date from, Date to) throws Exception
    {
        System.out.println(from);
        Set<Event> event = searchAdvEvent(title, from, to);
        try {
            for(Event tmp : event)
            {
                assertEquals(tmp.getTitle(), title);
                assertEquals((tmp.getDataEvent().after(from)), true);
                assertEquals((tmp.getDataEvent().before(to)), true);
            }             
        }
        catch(Exception e) {throw new Exception();}
    }

    /**
     * Test of actionPerformed method, of class ControllerCRUDEvent.
     */
    @Test
    public void testActionPerformed() throws Exception {
        System.out.println("actionPerformed");
        testCaseSearch("", new Date("2018-lug-10"), new Date(2018,07,12));
        /*view = new EventPanel();
        dao = new ImplEventDao();
        //ControllerCRUDEvent controllerEvt = new ControllerCRUDEvent(dao, view);
        ActionEvent e = new ActionEvent(view.getButtonOkAdvSearchGeneral(), 0, "SEARCH_ADVANCED");
        //controllerEvt.actionPerformed(e);*/
        
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

public Set<Event> searchAdvEvent(String title, Date from, Date to)
{
    Set<Event> event = new HashSet<>();
    String type = "Select Type Event...";
    String kind = "genere";
    
    if(title.trim().length()!=0)
    {
        try
        {
             if(event.isEmpty())
               event.addAll(dao.searchByTitle(title));
             else
                event.retainAll(dao.searchByTitle(title));
        }
        catch(SQLException err)
        {
             JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    if(!type.equalsIgnoreCase("Select Type Event..."))
     {
            try{
               if(event.isEmpty()) 
                 event.addAll(dao.searchByTypeEvent(type.toUpperCase()));
               else
                 event.retainAll(dao.searchByTypeEvent(type.toUpperCase()));
            }
            catch(SQLException err)
            {
                  JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
            }
     }
    if(from != null && to != null)
    {
        try{
           if(event.isEmpty())  
              event.addAll(dao.searchByDate(from,to));
           else
             event.retainAll(dao.searchByDate(from,to));
        }
        catch(SQLException err)
        {
           JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    else
    {
            if((from == null &&  to!= null) || (from!= null &&  to== null))       
                 JOptionPane.showMessageDialog(view,"Error : Riempire entrambi i campi della data o lasciarli entrambi vuoti. ","ERROR", JOptionPane.ERROR_MESSAGE);

    }

    if(!kind.equalsIgnoreCase("Genere"))
     {
            try{
                    if(event.isEmpty()) 
                       event.addAll(dao.searchByKindEvent(kind));
                    else
                       event.retainAll(dao.searchByKindEvent(kind));
               }
            catch(SQLException err)
            {
                 JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
            }
     }
        return event;
    }
}