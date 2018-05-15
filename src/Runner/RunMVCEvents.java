/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;

import Controller.Controller;
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
    
    public RunMVCEvents()
    {
       
        EventModel evtModel = new EventModel();
        //EventView evtView = new EventView();
        GeneralPanel evtView = new GeneralPanel();
        GeneralView genView = new GeneralView();
        evtModel.addObserver(evtView);
        //SearchEventController evtControl = new SearchEventController();
        Controller evtControl = new Controller();
        evtControl.setModel(evtModel);
        evtControl.setView(evtView);
        //evtView.setControllerButtonOkSearchEvent(evtControl);
        evtView.setControllerGeneral(evtControl);
        //genView.add(evtView);
        genView.setVisible(true);
    }
    
}
