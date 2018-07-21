/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;

import Controller.ControllerCRDEvent;
import Controller.ListenerPanell;
import DB.DAO.EventDao;
import DB.DAO.ImplMySqlEventDao;
import Controller.ControllerUpdateEvent;
import View.EventPanel;


/**
 *
 * @author giuli
 */
public class RunECBEvents {
    
    private EventDao dao;
    private EventPanel evtView;
    private ControllerCRDEvent controller;
    private ControllerUpdateEvent controllerTable;

    
    public EventPanel getEvtView() {
        return evtView;
    }

    public void setEvtView(EventPanel evtView) {
        this.evtView = evtView;
    }
    
    //private ControllerGeneralButton evtControl;
   // private ControllerMouseGeneral mouseController;
    //private ControllerGeneralFocus focusController;
    
    public void startRunMVCEvents()
    {
        dao = new ImplMySqlEventDao();
        evtView = new EventPanel();
        controller = new ControllerCRDEvent(dao,evtView);
        controllerTable = new ControllerUpdateEvent(dao,evtView);
        /*evtControl = new ControllerGeneralButton();
        evtControl.setModel(evtModel);
        evtControl.setView(evtView);
        evtView.setControllerGeneralButton(evtControl);
        mouseController = new ControllerMouseGeneral();
        mouseController.setModel(evtModel);
        mouseController.setView(evtView);
        evtView.setMouseListener(mouseController);
        focusController = new ControllerGeneralFocus();
        focusController.setView(evtView);
        focusController.setModel(evtModel);
        evtView.setFocusController(focusController);
        */

        
    }
/*
    public EventModel getEvtModel() {
        return evtModel;
    }

    public void setEvtModel(EventModel evtModel) {
        this.evtModel = evtModel;
    }

    public GeneralPanel getEvtView() {
        return evtView;
    }

    public void setEvtView(EventPanel evtView) {
        this.evtView = evtView;
    }

  */  
    
}
