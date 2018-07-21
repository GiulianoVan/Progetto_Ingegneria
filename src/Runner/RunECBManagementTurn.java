/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;

import Controller.ControllerCRDTurn;
import DB.DAO.ImpMySqlManagementTurnDao;
import DB.DAO.ManagementTurnDao;
import Controller.ControllerUpdateTurn;
import View.ManagementTurnView;

/**
 *
 * @author giuli
 */
public class RunECBManagementTurn {
//turno
    public ManagementTurnView getView() {
        return view;
    }
    
    ControllerCRDTurn controller;
    ManagementTurnDao dao;
    ManagementTurnView view;
    //ControllerUpdateTurn controllerUpdate;
    public void start()
    {
        dao = new ImpMySqlManagementTurnDao();
        view = new ManagementTurnView();
        controller = new ControllerCRDTurn(dao,view);
        //controllerUpdate = new ControllerUpdateTurn(dao,view);
    }
}
