/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;

import Controller.ControllerAddetto.AddettoTableController.ControllerFocusTableAddetto;
import Controller.ControllerAddetto.AddettoTableController.ControllerKeyTable;
import Controller.ControllerAddetto.AddettoTableController.ControllerMouseTableAddetto;
import Controller.ControllerGeneral.ControllerGeneralButton;
import ControllerAddetto.ControllerButtonAddetto;
import ControllerAddetto.ControllerKeyAddetto;
import GestioneTabella.ControllerTable;
import Model.Addetto.AddettiModel;
import View.AddettiPanel;


/**
 *
 * @author Pirozzi
 */
public class RunMVCAddetti {
    
    AddettiModel addettiModel;
    AddettiPanel addettiView;
    ControllerButtonAddetto controllerButton;
    //ControllerKeyTable controllerTab;
   // ControllerMouseTableAddetto controllerMouse;
    ControllerKeyAddetto controllerText;
    ControllerGeneralButton x;
    //ControllerFocusTableAddetto controllerFocus;
    ControllerTable controllerTab ;
    
    public AddettiModel getModel() {
        return addettiModel;
    }

    public void setModel(AddettiModel model) {
        this.addettiModel = model;
    }

    public AddettiPanel getView() {
        return addettiView;
    }

    public void setView(AddettiPanel view) {
        this.addettiView = view;
    }
    
    
   public void startMVCAddetti()
   {
    
         addettiModel = new AddettiModel();
        // creo le addettiView passando il addettiModel
         addettiView = new AddettiPanel();
        //model registra un osservatore
        addettiModel.addObserver(addettiView);
        controllerButton = new ControllerButtonAddetto();
        controllerButton.setModel(addettiModel);
        controllerButton.setView(addettiView);
        addettiView.SetControllerButton(controllerButton);
        //creo controllerButton per la tabella e lo registro alla addettiView
        /*
        controllerTab = new ControllerKeyTable();
        controllerTab.setModel(addettiModel);
        controllerTab.setView(addettiView);
        addettiView.SetControllerKeyTable(controllerTab);
        
        controllerFocus = new ControllerFocusTableAddetto();
        controllerFocus.setModel(addettiModel);
        controllerFocus.setView(addettiView);
        addettiView.setControllerFocusTable(controllerFocus);
        controllerMouse = new ControllerMouseTableAddetto();
        controllerMouse.setModel(addettiModel);
        controllerMouse.setView(addettiView);
        addettiView.setControllerMouseTable(controllerMouse); 
        */
        //creo controllerButton per la Jtext e le registro ai addettiModel ed al controllerButton
        controllerTab = new ControllerTable(addettiModel,addettiView);
        
        controllerText = new ControllerKeyAddetto();
        controllerText.setModel(addettiModel);
        controllerText.setView(addettiView);
        addettiView.SetControllerKeyText(controllerText);
        x = new ControllerGeneralButton();
        x.setView(addettiView);
        x.setModel(addettiModel);
        addettiView.setControllerGeneralButton(x);
        
        
        //visualizzo addettiView
      }
   }

