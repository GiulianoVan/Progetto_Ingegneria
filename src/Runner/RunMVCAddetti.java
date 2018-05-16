/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;

import Controller.ControllerAddetto.AddettoTableController.ControllerFocusTableAddetto;
import Controller.ControllerAddetto.AddettoTableController.ControllerKeyTable;
import ControllerGeneral.ControllerGeneralButton;
import Controller.ControllerAddetto.AddettoTableController.ControllerMouseTableAddetto;
import ControllerAddetto.ControllerButtonAddetto;
import ControllerAddetto.ControllerKeyAddetto;
import Model.Addetto.AddettiModel;
import View.AddettiPanel;


/**
 *
 * @author Pirozzi
 */
public class RunMVCAddetti {
    
    AddettiModel model;
    AddettiPanel view;
    ControllerButtonAddetto controllerButton;
    ControllerKeyTable controllerTab;
    ControllerMouseTableAddetto controllerMouse;
    ControllerKeyAddetto controllerText;
    ControllerGeneralButton x;
    ControllerFocusTableAddetto controllerFocus;
    
    public AddettiModel getModel() {
        return model;
    }

    public void setModel(AddettiModel model) {
        this.model = model;
    }

    public AddettiPanel getView() {
        return view;
    }

    public void setView(AddettiPanel view) {
        this.view = view;
    }
    
    
   public void startMVCAddetti()
   {
    
         model = new AddettiModel();
        // creo le view passando il model
         view = new AddettiPanel();
        //model registra un osservatore
        model.addObserver(view);
        controllerButton = new ControllerButtonAddetto();
        controllerButton.setModel(model);
        controllerButton.setView(view);
        view.SetControllerButton(controllerButton);
        //creo controllerButton per la tabella e lo registro alla view
        
        controllerTab = new ControllerKeyTable();
        controllerTab.setModel(model);
        controllerTab.setView(view);
        view.SetControllerKeyTable(controllerTab);
        
        controllerFocus = new ControllerFocusTableAddetto();
        controllerFocus.setModel(model);
        controllerFocus.setView(view);
        view.setControllerFocusTable(controllerFocus);
        controllerMouse = new ControllerMouseTableAddetto();
        controllerMouse.setModel(model);
        controllerMouse.setView(view);
        view.setControllerMouseTable(controllerMouse); 
        //creo controllerButton per la Jtext e le registro ai model ed al controllerButton
        controllerText = new ControllerKeyAddetto();
        controllerText.setModel(model);
        controllerText.setView(view);
        view.SetControllerKeyText(controllerText);
        x = new ControllerGeneralButton();
        x.setView(view);
        x.setModel(model);
        view.setControllerGeneralButton(x);
        
        
        //visualizzo view
      }
   }

