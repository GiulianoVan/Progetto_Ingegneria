/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Runner;

import BusinessComponent.Boundary.BoundaryViewEvent;
import BusinessComponent.Controller.ControllerCRUDEvent;
import AccessDataStorage.DB.DAO.EventDao;
import AccessDataStorage.DB.DAO.ImplMySqlEventDao;
import Presentation.EventPanel;
import BusinessComponent.Boundary.BoundaryTableEvent;


/**
 *
 * @author INGSW2017_22
 */
public class RunECBEvents {
    
    private EventDao dao;
    private EventPanel evtView;
    private ControllerCRUDEvent controller;
    private BoundaryViewEvent boundary;
    private BoundaryTableEvent boundaryTab;
    public EventPanel getEvtView() {
        return evtView;
    }

    public void setEvtView(EventPanel evtView) {
        this.evtView = evtView;
    }
    
    public void startRunECBEvents()
    {
        dao = new ImplMySqlEventDao();
        evtView = new EventPanel();
        controller = new ControllerCRUDEvent(dao);
        boundary = new BoundaryViewEvent(evtView,controller);
        boundaryTab = new BoundaryTableEvent(evtView, controller);
        
    }
}
