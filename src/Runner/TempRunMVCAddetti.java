/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;


import Controller.ControllerGeneral.ControllerGeneralButton;
import Model.Addetto.AddettiModel;
import Model.EventModel;
import View.AddettiPanel;
import View.EventPanel;

/**
 *
 * @author giuli
 */
public class TempRunMVCAddetti {
   
    private AddettiModel addettoModel;
    private AddettiPanel addettoView;
    private ControllerGeneralButton addettoControl;
    
    
    
    public TempRunMVCAddetti()
    {
       
        addettoModel = new AddettiModel();
        //EventView evtView = new EventView();
        addettoView = new AddettiPanel();
        //GeneralView genView = new GeneralView(evtView);
        addettoModel.addObserver(addettoView);
        //SearchEventController evtControl = new SearchEventController();
        addettoControl = new ControllerGeneralButton();
        addettoControl.setModel(addettoModel);
        addettoControl.setView(addettoView);
        //evtView.setControllerButtonOkSearchEvent(evtControl);
        addettoView.setControllerGeneralButton(addettoControl);
        //genView.add(evtView)     
    }

    public AddettiModel getAddMod() {
        return addettoModel;
    }

    public void setAddMod(AddettiModel addMod) {
        this.addettoModel = addMod;
    }

    public AddettiPanel getAddView() {
        return addettoView;
    }

    public void setAddView(AddettiPanel addView) {
        this.addettoView = addView;
    }

    public ControllerGeneralButton getAddControl() {
        return addettoControl;
    }

    public void setAddControl(ControllerGeneralButton evtControl) {
        this.addettoControl = evtControl;
    }
    
    
}
