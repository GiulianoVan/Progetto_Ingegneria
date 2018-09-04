/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Runner;

import AccessDataStorage.DB.DAO.ImpMySqlStatisticsDao;
import AccessDataStorage.DB.DAO.StatisticsDao;
import BusinessComponent.Boundary.BoundaryViewStatistics;
import BusinessComponent.Controller.ControllerStatistics;
import Presentation.StatisticsView;

/**
 *
 * @author INGSW2017_22
 */
public class RunStatistics {
  
    private BoundaryViewStatistics boundary;
    private StatisticsDao dao;
    private StatisticsView view;
    private ControllerStatistics controller;
    public StatisticsView getView() {
        return view;
    }
    
    public void start()
    {
        dao = new ImpMySqlStatisticsDao();
        view = new StatisticsView();
        controller = new ControllerStatistics(dao);
        boundary = new BoundaryViewStatistics(controller, view);
    }
    
}
