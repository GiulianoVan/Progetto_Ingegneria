/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;

import Controller.Controller;
import Controller.ControllerMouseGeneral;
import Controller.SearchEventController;
import Model.EventModel;
import View.EventPanel;
import View.EventView;
import View.GeneralPanel;
import View.GeneralView;

/**
 *
 * @author giuli
 */
public class RunMVCEvents {
    
    private EventModel evtModel;
    private EventPanel evtView;
    private Controller evtControl;
    private ControllerMouseGeneral mouseController;
    
    public RunMVCEvents()
    {
       
        evtModel = new EventModel();
        //EventView evtView = new EventView();
        evtView = new EventPanel();
        //GeneralView genView = new GeneralView(evtView);
        evtModel.addObserver(evtView);
        //SearchEventController evtControl = new SearchEventController();
        evtControl = new Controller();
        mouseController = new ControllerMouseGeneral();
        evtControl.setModel(evtModel);
        evtControl.setView(evtView);
        mouseController.setView(evtView);
        mouseController.setModel(evtModel);
        //evtView.setControllerButtonOkSearchEvent(evtControl);
        evtView.setMouseListener(mouseController);
        evtView.setControllerGeneral(evtControl);
        
        //genView.add(evtView);
        
    }

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

    public Controller getEvtControl() {
        return evtControl;
    }

    public void setEvtControl(Controller evtControl) {
        this.evtControl = evtControl;
    }
    
    
    
}
