/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessComponent.Boundary;

import BusinessComponent.Controller.ControllerStatistics;
import Presentation.StatisticsView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Pirozzi
 */
public class BoundaryViewStatistics implements ActionListener,ItemListener{

    StatisticsView view;
    ControllerStatistics controller;
    
 public BoundaryViewStatistics(ControllerStatistics contr,StatisticsView view)
 {
     this.controller = contr;
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
            if(view.getComboStatisticType().getSelectedItem().toString().equals("Distribution of the events and average age"))
            {
                try 
                {
                    Map<Comparable,Number> map = new HashMap<>();
                    map.put("SPORT",controller.everageAgeTypeEvent("SPORT"));
                    map.put("CINEMA",controller.everageAgeTypeEvent("CINEMA"));
                    map.put("THEATER",controller.everageAgeTypeEvent("THEATER"));
                    map.put("CONCERT",controller.everageAgeTypeEvent("CONCERT"));
                    controller.generateGraph(map,view.getComboStatisticType().getSelectedItem().toString());
                } 
                catch (SQLException ex) 
                {                  
                    JOptionPane.showMessageDialog(view,"Error " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if(view.getComboStatisticType().getSelectedItem().toString().equals("Tickets sold over the years"))
            {
                int start = Integer.parseInt(view.getComboDateStatisticFrom().getSelectedItem().toString());
                int end =  Integer.parseInt(view.getComboDateStatisticTo().getSelectedItem().toString());
                Map<Comparable,Number> map = new HashMap<>();
                if(start<end)
                {
                    for(int i=start;i<=end;++i)
                    {
                        try {
                            map.put(i,controller.ticketSoldForYear(i));
                        } catch (SQLException ex) {
                           JOptionPane.showMessageDialog(view,"Error " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    controller.generateGraph(map,view.getComboStatisticType().getSelectedItem().toString());
                }
                else
                {
                    JOptionPane.showMessageDialog(view,"Start date cannot be egual or greater than the end date ", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if(view.getComboStatisticType().getSelectedItem().toString().equals("Presences over the years by event"))
            {
                
                String event = view.getComboStatisticEventType().getSelectedItem().toString();
                if(!event.equalsIgnoreCase("SELECT EVENT TYPE"))
                {
                    int start = Integer.parseInt(view.getComboDateStatisticFrom().getSelectedItem().toString());
                    int end =  Integer.parseInt(view.getComboDateStatisticTo().getSelectedItem().toString());
                    Map<Comparable,Number> map = new HashMap<>();
                    if(start<end)
                    {
                        for(int i=start;i<=end;++i)
                        {
                            try {
                                map.put(i,controller.partecipationAtTypeEventInOneYear(i,event));
                            } catch (SQLException ex) {
                                  JOptionPane.showMessageDialog(view,"Error " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        controller.generateGraph(map,view.getComboStatisticType().getSelectedItem().toString());
                    }
                    else
                    {
                       JOptionPane.showMessageDialog(view,"Start date cannot be egual or greater than the end date ", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
            else if(view.getComboStatisticType().getSelectedItem().toString().equals("Earnings over the years"))
            {
                int start = Integer.parseInt(view.getComboDateStatisticFrom().getSelectedItem().toString());
                int end =  Integer.parseInt(view.getComboDateStatisticTo().getSelectedItem().toString());
                Map<Comparable,Number> map = new HashMap<>();
                if(start<end)
                {
                    for(int i=start;i<=end;++i)
                    {
                        try {
                            map.put(i,controller.EarnsInTheYear(i));
                        } catch (SQLException ex) 
                        {
                              JOptionPane.showMessageDialog(view,"Error " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    controller.generateGraph(map,view.getComboStatisticType().getSelectedItem().toString());
                }
                else
                {
                  JOptionPane.showMessageDialog(view,"Start date cannot be egual or greater than the end date ", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }
                  
        }
        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        
        if(view.getComboStatisticType().getSelectedItem().toString().equals("Distribution of the events and average age"))
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
