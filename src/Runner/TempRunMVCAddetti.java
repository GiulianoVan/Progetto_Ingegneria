/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;

import Controller.Controller;
import Model.Addetto.AddettiModel;
import Model.EventModel;
import View.AddettiPanel;
import View.EventPanel;

/**
 *
 * @author giuli
 */
public class TempRunMVCAddetti {
   
    private AddettiModel addMod;
    private AddettiPanel addView;
    private Controller evtControl;
    
    
    
    public TempRunMVCAddetti()
    {
       
        addMod = new AddettiModel();
        //EventView evtView = new EventView();
        addView = new AddettiPanel();
        //GeneralView genView = new GeneralView(evtView);
        addMod.addObserver(addView);
        //SearchEventController evtControl = new SearchEventController();
        evtControl = new Controller();
        evtControl.setModel(addMod);
        evtControl.setView(addView);
        //evtView.setControllerButtonOkSearchEvent(evtControl);
        addView.setControllerGeneral(evtControl);
        //genView.add(evtView)     
    }

    public AddettiModel getAddMod() {
        return addMod;
    }

    public void setAddMod(AddettiModel addMod) {
        this.addMod = addMod;
    }

    public AddettiPanel getAddView() {
        return addView;
    }

    public void setAddView(AddettiPanel addView) {
        this.addView = addView;
    }

    public Controller getEvtControl() {
        return evtControl;
    }

    public void setEvtControl(Controller evtControl) {
        this.evtControl = evtControl;
    }
    
    
}
