/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;


import Controller.ControllerCRUDAddetto;
import DB.DAO.ImplAddettoDao;
import Controller.ControllerTableAddetto;
import View.AddettiPanel;


/**
 *
 * @author Pirozzi
 */
public class RunECBAddetti {
    
    AddettiPanel addettiView;
    ControllerCRUDAddetto controller;
    ControllerTableAddetto controllerTable;
    ImplAddettoDao dao;
    
   public void startMVCAddetti()
   {
    
        dao = new ImplAddettoDao();
        // creo le addettiView passando il addettiModel
         addettiView = new AddettiPanel();
        //model registra un osservatore
        controller = new ControllerCRUDAddetto(dao,addettiView);
        controllerTable = new ControllerTableAddetto(dao,addettiView);
        
        
        
        
        //visualizzo addettiView
      }

    public AddettiPanel getAddettiView() {
        return addettiView;
    }

    public void setAddettiView(AddettiPanel addettiView) {
        this.addettiView = addettiView;
    }
   }

