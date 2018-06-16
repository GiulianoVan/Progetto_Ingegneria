/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;

import Controller.ControllerCRUDTurn;
import DB.DAO.ImpManagementTurnDao;
import DB.DAO.ImpStatisticsDao;
import DB.DAO.StatisticsDao;
import Controller.ControllerStatistics;
import GestioneTabella.ControllerUpdateTurn;
import View.ManagementTurnView;
import View.StatisticsView;

/**
 *
 * @author Pirozzi
 */
public class RunStatistics {
  
    ControllerStatistics controller;
    StatisticsDao dao;
    StatisticsView view;

    public StatisticsView getView() {
        return view;
    }
    
    public void start()
    {
        dao = new ImpStatisticsDao();
        view = new StatisticsView();
        controller = new ControllerStatistics(dao, view);
    }
    
}
