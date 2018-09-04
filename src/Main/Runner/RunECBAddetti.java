/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Runner;


import BusinessComponent.Controller.ControllerCRUDAddetto;
import AccessDataStorage.DB.DAO.ImplMySqlAddettoDao;
import Presentation.AddettiPanel;
import BusinessComponent.Boundary.BoundaryTableSecurity;
import BusinessComponent.Boundary.BoundaryViewSecurity;


/**
 *
 * @author INGSW2017_22
 */
public class RunECBAddetti {
    
    AddettiPanel addettiView;
    ControllerCRUDAddetto controller;
    ImplMySqlAddettoDao dao;
    BoundaryViewSecurity boundary;
    BoundaryTableSecurity boundaryTab;
    
    public void startECBAddetti()
   {
         dao = new ImplMySqlAddettoDao();
         addettiView = new AddettiPanel();
         controller = new ControllerCRUDAddetto(dao);
         boundary = new BoundaryViewSecurity(addettiView,controller);
         boundaryTab = new BoundaryTableSecurity(addettiView,controller);
      }

    public AddettiPanel getAddettiView() {
        return addettiView;
    }

    public void setAddettiView(AddettiPanel addettiView) {
        this.addettiView = addettiView;
    }
   }

