/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;

import ControllerGeneral.ControllerGeneralButton;
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
    private ControllerGeneralButton evtControl;
    
    
    
    public TempRunMVCAddetti()
    {
       
        addMod = new AddettiModel();
        //EventView evtView = new EventView();
        addView = new AddettiPanel();
        //GeneralView genView = new GeneralView(evtView);
        addMod.addObserver(addView);
        //SearchEventController evtControl = new SearchEventController();
        evtControl = new ControllerGeneralButton();
        evtControl.setModel(addMod);
        evtControl.setView(addView);
        //evtView.setControllerButtonOkSearchEvent(evtControl);
        addView.setControllerGeneralButton(evtControl);
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

    public ControllerGeneralButton getEvtControl() {
        return evtControl;
    }

    public void setEvtControl(ControllerGeneralButton evtControl) {
        this.evtControl = evtControl;
    }
    
    
}
