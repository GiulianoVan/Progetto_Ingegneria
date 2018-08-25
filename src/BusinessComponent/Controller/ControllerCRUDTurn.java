/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessComponent.Controller;

import DataStorage.DB.DAO.EventDao;
import DataStorage.DB.DAO.ImplMySqlAddettoDao;
import DataStorage.DB.DAO.ImplMySqlEventDao;
import DataStorage.DB.DAO.ManagementTurnDao;
import BusinessComponent.GestioneTabella.MyDefaultTableModel;
import BusinessComponent.Entity.Event;
import BusinessComponent.Entity.ManagementTurn;
import Presentazione.EventPanel;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Pirozzi
 */
public class ControllerCRUDTurn
{
    private ManagementTurnDao dao;
    private Set<ManagementTurn> turn;
    private int flag_errorDelete = 1;
    private String flag_search = "";
    
    
     public ControllerCRUDTurn(ManagementTurnDao dao)
    {
        this.dao = dao;    
    }
                                     
    public void doUpdateTurn(int value,String field,String id) throws SQLException
    {
        dao.updateTurn(value,field, id);
    }
    
    public void  doDeleteTurn(int idTurn) throws SQLException
    {
        dao.deleteTurn(idTurn);
    }    
    
    
    public void createTurn(String cf,int codeEvent,Time start,Time end) throws SQLException 
    {
        dao.insertTurn(cf,codeEvent,start,end);        
    }

    public MyDefaultTableModel doSearch(String tax_code,String event ) throws SQLException {

    
        Set<ManagementTurn> turn = new HashSet<>();
        MyDefaultTableModel tab = new MyDefaultTableModel();
        int intersect = 0;
       
        if(!event.equals(""))
            {
                intersect = 1;
                turn.addAll(dao.getTurnEvent(event));
            }
        
        if(!tax_code.equals(""))
        {
            
                if(turn.isEmpty() && intersect==0)
                {
                    turn.addAll(dao.getTurnAddetto(tax_code));
                }
                else
                {
                    turn.retainAll(dao.getTurnAddetto(tax_code));
                }

                 intersect = 1;
        }                  
         tab.createModelBySetTurn(turn);
         return tab;
    }
    
    public List<String> getIdEventByTitle(String title) throws SQLException
    {   
        ControllerCRUDEvent controller = new ControllerCRUDEvent(new ImplMySqlEventDao());
        List evt = null;    
        evt = controller.getIdEventByTitle(title);
        return evt;
    }
    
     public List<String> getTaxCodeAddettoBySurname(String surname) throws SQLException
    {   
        ControllerCRUDAddetto controller = new ControllerCRUDAddetto(new ImplMySqlAddettoDao());
        List evt = null;    
        evt = controller.getTaxCodeBySurname(surname);
        return evt;
    }
   
}
