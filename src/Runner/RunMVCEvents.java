/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;

import Controller.ControllerGeneral.ControllerGeneralButton;
import Controller.ControllerGeneral.ControllerGeneralFocus;
import Controller.ControllerGeneral.ControllerMouseGeneral;
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
    private ControllerGeneralButton evtControl;
    private ControllerMouseGeneral mouseController;
    private ControllerGeneralFocus focusController;
    
    public void startRunMVCEvents()
    {
       
        evtModel = new EventModel();
        evtView = new EventPanel();
        evtModel.addObserver(evtView);
        evtControl = new ControllerGeneralButton();
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

    public ControllerGeneralButton getEvtControl() {
        return evtControl;
    }

    public void setEvtControl(ControllerGeneralButton evtControl) {
        this.evtControl = evtControl;
    }
    
    
    
}
