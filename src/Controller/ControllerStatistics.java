/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.DAO.StatisticsDao;
import View.StatisticsView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pirozzi
 */
public class ControllerStatistics implements ActionListener,ItemListener{

    StatisticsView view;
    StatisticsDao dao;
    
 public ControllerStatistics(StatisticsDao dao,StatisticsView view)
 {
     this.dao = dao;
     this.view = view;
     view.getButtonGenerateGraph().addActionListener(this);
     view.getComboStatisticType().addItemListener(this);
 }        
 
    @Override
    public void actionPerformed(ActionEvent e) {
            
        String action = e.getActionCommand();
        
        if(action.equalsIgnoreCase("GENERATE"))
        {
            //Average age for events, Tickets sold over the years, Presences over the years by event, Earnings over the years
            if(view.getComboStatisticType().getSelectedItem().toString().equals("Average age for events"))
            {
                Map<Comparable,Number> map = new HashMap<>();
                
    
                    try {
                        map.put("SPORT",dao.etaMediaTipoEvento("SPORT"));
                        map.put("CINEMA",dao.etaMediaTipoEvento("CINEMA"));
                        map.put("THEATER",dao.etaMediaTipoEvento("THEATER"));
                        map.put("CONCERT",dao.etaMediaTipoEvento("CONCERT"));
                        view.generateGraph(map,view.getComboStatisticType().getSelectedItem().toString());
                    } catch (SQLException ex) {
                        Logger.getLogger(ControllerStatistics.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            else if(view.getComboStatisticType().getSelectedItem().toString().equals("Tickets sold over the years"))
            {
                int start = Integer.parseInt(view.getComboDateStatisticFrom().getSelectedItem().toString());
                int end =  Integer.parseInt(view.getComboDateStatisticTo().getSelectedItem().toString());
                Map<Comparable,Number> map = new HashMap<>();
                
                for(int i=start;i<=end;++i)
                {
                    try {
                        map.put(i,dao.bigliettiVendutiPerAnno(i));
                    } catch (SQLException ex) {
                          
                    }
                    
                }
             view.generateGraph(map,view.getComboStatisticType().getSelectedItem().toString());

            }
            else if(view.getComboStatisticType().getSelectedItem().toString().equals("Presences over the years by event"))
            {
                String event = view.getComboStatisticEventType().getSelectedItem().toString();
                int start = Integer.parseInt(view.getComboDateStatisticFrom().getSelectedItem().toString());
                int end =  Integer.parseInt(view.getComboDateStatisticTo().getSelectedItem().toString());
                Map<Comparable,Number> map = new HashMap<>();
                
                for(int i=start;i<=end;++i)
                {
                    try {
                        map.put(i,dao.partecipazioneTipoEventoInUnAnno(i,event));
                    } catch (SQLException ex) {
                        Logger.getLogger(ControllerStatistics.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
               view.generateGraph(map,view.getComboStatisticType().getSelectedItem().toString());

            }
            else if(view.getComboStatisticType().getSelectedItem().toString().equals("Earnings over the years"))
            {
                int start = Integer.parseInt(view.getComboDateStatisticFrom().getSelectedItem().toString());
                int end =  Integer.parseInt(view.getComboDateStatisticTo().getSelectedItem().toString());
                Map<Comparable,Number> map = new HashMap<>();
                
                for(int i=start;i<=end;++i)
                {
                    try {
                        map.put(i,dao.incassiPerAnno(i));
                    } catch (SQLException ex) {
                        Logger.getLogger(ControllerStatistics.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                view.generateGraph(map,view.getComboStatisticType().getSelectedItem().toString());

                
            }
                   
               
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        
        if(view.getComboStatisticType().getSelectedItem().toString().equals("Average age for events"))
        {
            view.getjLabel2().setVisible(false);
            view.getjLabel3().setVisible(false);
            view.getButtonGenerateGraph().setEnabled(true);
            view.getComboDateStatisticFrom().setVisible(false);
            view.getComboDateStatisticTo().setVisible(false);
            view.getComboStatisticEventType().setVisible(false);
            
        }
        else if(view.getComboStatisticType().getSelectedItem().toString().equals("Tickets sold over the years") || view.getComboStatisticType().getSelectedItem().toString().equals("Earnings over the years"))
 
        {
            view.getjLabel2().setVisible(true);
            view.getjLabel3().setVisible(true);
            view.getButtonGenerateGraph().setEnabled(true);
            view.getComboDateStatisticFrom().setVisible(true);
            view.getComboDateStatisticTo().setVisible(true);
            view.getComboStatisticEventType().setVisible(false);
        }
        else if(view.getComboStatisticType().getSelectedItem().toString().equals("Presences over the years by event"))
        {
            view.getjLabel2().setVisible(true);
            view.getjLabel3().setVisible(true);
            view.getButtonGenerateGraph().setEnabled(true);
            view.getComboDateStatisticFrom().setVisible(true);
            view.getComboDateStatisticTo().setVisible(true);
            view.getComboStatisticEventType().setVisible(true);
        }
     else
        {
            view.getjLabel2().setVisible(false);
            view.getjLabel3().setVisible(false);
            view.getButtonGenerateGraph().setEnabled(false);
            view.getComboDateStatisticFrom().setVisible(false);
            view.getComboDateStatisticTo().setVisible(false);
            view.getComboStatisticEventType().setVisible(false);
        }
   }
}
