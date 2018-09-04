/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Runner;

import BusinessComponent.Boundary.BoundaryViewTurn;
import BusinessComponent.Controller.ControllerCRUDTurn;
import AccessDataStorage.DB.DAO.ImpMySqlManagementTurnDao;
import AccessDataStorage.DB.DAO.ManagementTurnDao;
import Presentation.ManagementTurnView;

/**
 *
 * @author INGSW2017_22
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
    public void start()
    {
        dao = new ImpMySqlManagementTurnDao();
        view = new ManagementTurnView();
        controller = new ControllerCRUDTurn(dao);
        boundary = new BoundaryViewTurn(controller,view);
    }
}
