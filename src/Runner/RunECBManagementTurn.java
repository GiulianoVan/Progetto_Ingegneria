/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;

import Controller.ControllerCRUDTurn;
import DB.DAO.ImpManagementTurnDao;
import DB.DAO.ManagementTurnDao;
import View.ManagementTurnView;

/**
 *
 * @author giuli
 */
public class RunECBManagementTurn {

    public ManagementTurnView getView() {
        return view;
    }
    
    ControllerCRUDTurn controller;
    ManagementTurnDao dao;
    ManagementTurnView view;
    
    public void start()
    {
        dao = new ImpManagementTurnDao();
        view = new ManagementTurnView();
        controller = new ControllerCRUDTurn(dao,view);
        
    }
}
