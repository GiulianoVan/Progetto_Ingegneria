/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;

import Controller.Controller;
import Controller.SearchEventController;
import Model.EventModel;
import View.EventView;

/**
 *
 * @author giuli
 */
public class RunMVCEvents {
    
    public RunMVCEvents()
    {
       
        EventModel evtModel = new EventModel();
        EventView evtView = new EventView();
        evtModel.addObserver(evtView);
        //SearchEventController evtControl = new SearchEventController();
        Controller evtControl = new Controller();
        evtControl.setModel(evtModel);
        evtControl.setView(evtView);
        //evtView.setControllerButtonOkSearchEvent(evtControl);
        evtView.setControllerEvent(evtControl);
        evtView.setVisible(true);
    }
    
}
