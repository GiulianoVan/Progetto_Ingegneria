/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestioneTabella;

import DB.DAO.StatisticsDao;
import View.StatisticsView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Pirozzi
 */
public class ControllerStatistics implements ActionListener{

    StatisticsView view;
    StatisticsDao dao;
    
 public ControllerStatistics(StatisticsDao dao,StatisticsView view)
 {
     this.dao = dao;
     this.view = view;
 }        
 
    @Override
    public void actionPerformed(ActionEvent e) {
            
          
    }
    
}
