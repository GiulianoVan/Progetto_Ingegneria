/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;


import Controller.ControllerCRDAddetto;
import DB.DAO.ImplMySqlAddettoDao;
import Controller.ControllerUpdateAddetto;
import View.AddettiPanel;


/**
 *
 * @author Pirozzi
 */
public class RunECBAddetti {
    
    AddettiPanel addettiView;
    ControllerCRDAddetto controller;
    ControllerUpdateAddetto controllerTable;
    ImplMySqlAddettoDao dao;
    
   public void startMVCAddetti()
   {
    
        dao = new ImplMySqlAddettoDao();
        // creo le addettiView passando il addettiModel
         addettiView = new AddettiPanel();
        //model registra un osservatore
        controller = new ControllerCRDAddetto(dao,addettiView);
        controllerTable = new ControllerUpdateAddetto(dao,addettiView);
        
        
        
        
        //visualizzo addettiView
      }

    public AddettiPanel getAddettiView() {
        return addettiView;
    }

    public void setAddettiView(AddettiPanel addettiView) {
        this.addettiView = addettiView;
    }
   }

