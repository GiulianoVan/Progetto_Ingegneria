/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Runner;

import BusinessComponent.Boundary.BoundaryViewTurn;
import BusinessComponent.Controller.ControllerCRUDTurn;
import DataStorage.DB.DAO.ImpMySqlManagementTurnDao;
import DataStorage.DB.DAO.ManagementTurnDao;
import BusinessComponent.Controller.ControllerUpdateTurn;
import Presentazione.ManagementTurnView;

/**
 *
 * @author giuli
 */
public class RunECBManagementTurn {
//turno
    public ManagementTurnView getView() {
        return view;
    }
    
    BoundaryViewTurn boundary;
    ControllerCRUDTurn controller;
    ManagementTurnDao dao;
    ManagementTurnView view;
    //ControllerUpdateTurn controllerUpdate;
    public void start()
    {
        dao = new ImpMySqlManagementTurnDao();
        view = new ManagementTurnView();
        controller = new ControllerCRUDTurn(dao);
        boundary = new BoundaryViewTurn(controller,view);
    }
}
