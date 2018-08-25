/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Runner;

import BusinessComponent.Boundary.BoundaryViewEvent;
import ControllerCopiaOLDVERSIONE.ControllerCRDEventCOPIA;
import BusinessComponent.Controller.ControllerCRUDEvent;
import BusinessComponent.Boundary.BoundaryGeneralPanel;
import DataStorage.DB.DAO.EventDao;
import DataStorage.DB.DAO.ImplMySqlEventDao;
import ControllerCopiaOLDVERSIONE.ControllerUpdateEvent;
import Presentazione.EventPanel;
import BusinessComponent.Boundary.BoundaryTableEvent;


/**
 *
 * @author giuli
 */
public class RunECBEvents {
    
    private EventDao dao;
    private EventPanel evtView;
    private ControllerCRUDEvent controller;
    private ControllerUpdateEvent controllerTable;
    private BoundaryViewEvent boundary;
    private BoundaryTableEvent boundaryTab;
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
        controller = new ControllerCRUDEvent(dao);
        //controllerTable = new ControllerUpdateEvent(dao,evtView);
        boundary = new BoundaryViewEvent(evtView,controller);
        boundaryTab = new BoundaryTableEvent(evtView, controller);
        /*
        dao = new ImplMySqlAddettoDao();
         addettiView = new AddettiPanel();
         controller = new ControllerCRUDAddetto(dao);
         controllerTable = new ControllerUpdateAddetto(dao,addettiView);
         boundary = new BoundaryViewSecurity(addettiView,controller);
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
