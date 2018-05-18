/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;


import Controller.ControllerAddetto;
import GestioneTabella.ControllerTableAddetto;
import Model.Addetto.AddettiModel;
import View.AddettiPanel;


/**
 *
 * @author Pirozzi
 */
public class RunMVCAddetti {
    
    AddettiModel addettiModel;
    AddettiPanel addettiView;
    ControllerAddetto controller;
    ControllerTableAddetto controllerTable;
   
    
   public void startMVCAddetti()
   {
    
         addettiModel = new AddettiModel();
        // creo le addettiView passando il addettiModel
         addettiView = new AddettiPanel();
        //model registra un osservatore
        addettiModel.addObserver(addettiView);
        controller = new ControllerAddetto(addettiModel,addettiView);
        controllerTable = new ControllerTableAddetto(addettiModel,addettiView);
        
        
        
        
        //visualizzo addettiView
      }

    public AddettiPanel getAddettiView() {
        return addettiView;
    }

    public void setAddettiView(AddettiPanel addettiView) {
        this.addettiView = addettiView;
    }
   }

