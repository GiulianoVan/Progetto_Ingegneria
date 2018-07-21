/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;

import Controller.ControllerCRDTurn;
import DB.DAO.ImpMySqlManagementTurnDao;
import DB.DAO.ImpMySqlStatisticsDao;
import DB.DAO.StatisticsDao;
import Controller.ControllerStatistics;
import Controller.ControllerUpdateTurn;
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
        dao = new ImpMySqlStatisticsDao();
        view = new StatisticsView();
        controller = new ControllerStatistics(dao, view);
    }
    
}
