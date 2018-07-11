/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.DAO.EventDao;
import DB.DAO.ImplEventDao;
import View.EventPanel;
import View.GeneralPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import static java.lang.Compiler.command;
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

    /**
     * Test of actionPerformed method, of class ControllerCRUDEvent.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        GeneralPanel view = new EventPanel();
        EventDao dao = new ImplEventDao();
        ControllerCRUDEvent controllerEvt = new ControllerCRUDEvent(dao, view);
        ActionEvent e = new ActionEvent(view.getButtonOkAdvSearchGeneral(), 0, "SEARCH_ADVANCED");
        controllerEvt.actionPerformed(e);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
