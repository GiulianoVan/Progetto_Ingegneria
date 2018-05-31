/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;

import Controller.ControllerEvent;
import Controller.ControllerGeneral;
import DB.DAO.EventDao;
import DB.DAO.ImplEventDao;
import GestioneTabella.ControllerTableEvent;
import Model.MODELDACANCELARE.EventModel;
import View.EventPanel;


/**
 *
 * @author giuli
 */
public class RunECBEvents {
    
    private EventDao dao;
    private EventPanel evtView;
    private ControllerEvent controller;
    private ControllerTableEvent controllerTable;

    
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
        dao = new ImplEventDao();
        evtView = new EventPanel();
        controller = new ControllerEvent(dao,evtView);
        controllerTable = new ControllerTableEvent(dao,evtView);
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
