/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Runner;

import BusinessComponent.Boundary.BoundaryViewTurn;
import DataStorage.DB.DAO.ImpMySqlManagementTurnDao;
import DataStorage.DB.DAO.ImpMySqlStatisticsDao;
import DataStorage.DB.DAO.StatisticsDao;
import BusinessComponent.Controller.ControllerStatistics;
import BusinessComponent.Controller.ControllerUpdateTurn;
import Presentazione.ManagementTurnView;
import Presentazione.StatisticsView;

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
