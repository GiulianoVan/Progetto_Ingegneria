/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;

import Controller.ControllerXXXX;
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
        ControllerXXXX evtControl = new ControllerXXXX();
        evtControl.setModel(evtModel);
        evtControl.setView(evtView);
        //evtView.setControllerButtonOkSearchEvent(evtControl);
        evtView.setController(evtControl);
        evtView.setVisible(true);
    }
    
}
