/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessComponent.Controller;

import DataStorage.DB.DAO.EventDao;
import BusinessComponent.GestioneTabella.MyDefaultTableModel;
import BusinessComponent.Entity.Event;
import Presentazione.EventPanel;
import Presentazione.GeneralPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Pirozzi
 */
public class ControllerCRUDEvent{
    
    private EventPanel view;
    private EventDao dao;
    private Set<Event> event;
    private int flag_errorDelete = 1;
    private String flag_search = "";
    
     public ControllerCRUDEvent(EventDao dao)
    {
        this.dao = dao;    
    }
                                     
    public void doUpdateEvent(String value,String field,String id) throws SQLException
    {
        dao.updateEvent(value,field, id);
    }
    
    public void  doDeleteEvent(String idEvent) throws SQLException
    {
        dao.deleteEvent(idEvent);
    }    
                
    public MyDefaultTableModel doAdvancedSearch(String title,String type,Date from,Date to,String kind) throws SQLException 
    {
        if(event != null)
           event.clear();
        else
           event = new HashSet<>();
        MyDefaultTableModel tab = new MyDefaultTableModel();
        int intersect = 0;
            
        if(title.trim().length()!=0)
        {
            event.addAll(dao.searchByTitle(title));
            intersect = 1;             
        }
        
        if(!type.equalsIgnoreCase("NOT SELECTED"))
         {
                
            if(event.isEmpty() && intersect == 0) 
              event.addAll(dao.searchByTypeEvent(type.toUpperCase()));
            else
              event.retainAll(dao.searchByTypeEvent(type.toUpperCase()));
            
            intersect = 1;
         }
        
        if(from != null && to != null)
        {
            try{
               if(event.isEmpty() && intersect ==0)  
                  event.addAll(dao.searchByDate(from,to));
               else
                 event.retainAll(dao.searchByDate(from,to));

               intersect = 1;
            }
            catch(SQLException err)
            {
               JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
                if((from == null &&  to!= null) || (from!= null &&  to== null))       
                   throw new RuntimeException("Fill both date fields. The search will not consider the date fields.");           
        }

        if(!kind.equalsIgnoreCase("NOT SELECTED"))
        {
              
                        if(event.isEmpty() && intersect ==0) 
                           event.addAll(dao.searchByKindEvent(kind));
                        else
                           event.retainAll(dao.searchByKindEvent(kind));

                        intersect = 1;
         }
        tab.createModelBySetEvent(event);
        return tab;
    }
    
    public void createEvent(String titolo,String description,String event_type,String kind_type,Date data,String luogo) throws SQLException 
    {
        Event event = new Event(titolo,description,event_type, kind_type, data, luogo);
        dao.createEvent(event);
    }

    public MyDefaultTableModel doSearch(ArrayList<String> parolechiavi) throws SQLException {

        if(event != null)
            event.clear();
         
         event = dao.searchEventKeysWords(parolechiavi);  
         MyDefaultTableModel tab = new MyDefaultTableModel();
         tab.createModelBySetEvent(event);
         return tab;
    }

    public List<String> getIdEventByTitle(String title) throws SQLException
    {
        Set<Event> evt = null;
        LinkedList<String> idEvent = new LinkedList<>();
        evt = dao.searchByTitle(title);
        
        for(Event event : evt)
        {
            idEvent.add(event.getIdEvent());
        }
        
       return idEvent;
    }
    
    
    
    /*
    private void updateTable(JTable table) {
         
         MyDefaultTableModel tab = new MyDefaultTableModel();
         tab.createModelBySetAddetto(addetti);
         table.setModel(tab);
         int id = table.getColumnModel().getColumnIndex("ID");
         tab.setId_column(id);
         //Aggiorno i nomi delle colonne nella view 
         table.getColumnModel().getColumn(2).setHeaderValue("TAX CODE");
        
         table.getColumnModel().getColumn(7).setHeaderValue("ID CODE");
        }
      */         
}
