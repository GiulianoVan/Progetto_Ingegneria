/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessComponent.Controller;

import DataStorage.DB.DAO.AddettoDao;
import BusinessComponent.GestioneTabella.MyDefaultTableModel;
import BusinessComponent.Entity.Addetto;
import Presentazione.AddettiPanel;
import Presentazione.GeneralPanel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import javax.swing.JOptionPane;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author Pirozzi
 */
public class ControllerCRUDAddetto{ //o estende la generale ?
//UTILIZZANDOLA QUANDO ESTENDE,BASTA USARE UN SOLO CONTROLLER,CONTROLLERADDETTO. IL COLLEGAMENTI COL PADRE VENGONO
    //FATTI IN AUTOMATICO NEL COSTRUTTORE DEL APDRE
    private Set<Addetto> addetti;
    private AddettoDao dao;
    private int flag_errorDelete = 1;
    private int flagtesting=0;
    private String flag_search= "";
    
    public ControllerCRUDAddetto(AddettoDao dao)
    {
        this.dao = dao;    
    }
                                     
    public void doUpdateAddetto(String value,String field,String id) throws SQLException
    {
        dao.updateAddetto(value,field,id);
    }
    
    public void  doDeleteAddetto(String idAddetto) throws SQLException
    {
          dao.deleteAddetto(idAddetto);              
    }    
                
    public MyDefaultTableModel doAdvancedSearch(String cf, String name, String surname, Date from, Date to) throws SQLException 
    {
        if(addetti != null)
          addetti.clear();
        
        MyDefaultTableModel tab = new MyDefaultTableModel();
        int intersect = 0;
        
        if(cf.trim().length() != 0)
        {

                addetti.add(dao.searchByTaxCode(cf));        
        }
        else
        {
            if(name.trim().length()!=0)
            { 
                     if(addetti.isEmpty() && intersect == 0)
                       addetti.addAll(dao.searchByName(name));
                     else
                        addetti.retainAll(dao.searchByName(name));

                     intersect = 1;
            }

            if(surname.trim().length() != 0)
            {
               
                   if(addetti.isEmpty() && intersect == 0) 
                     addetti.addAll(dao.searchBySurname(surname));
                   else
                     addetti.retainAll(dao.searchBySurname(surname));

                   intersect = 1;
               
            }
            
            if(from!= null && to != null)
            {
                
                   if(addetti.isEmpty() && intersect == 0)  
                      addetti.addAll(dao.searchByBirth(from,to));
                   else
                     addetti.retainAll(dao.searchByBirth(from,to));

                   intersect = 1;
               
            }
            else
            {
                if((from== null &&  to!= null) || (from!= null &&  to== null))       
                    throw new RuntimeException("Error : Fill both date fields. The search will not consider the date fields.");
                    
            }
        }
        tab.createModelBySetAddetto(addetti);
        return tab;
    }
    
    public void createAddetto(String name, String surname, String username, String password, String code, Date birth, String phone, String email,Double salary) throws SQLException 
    {
        Addetto security = new Addetto(name,surname,code,email,phone,salary,birth,username,password);
        dao.aggiungiAddetto(security);
    }

    public MyDefaultTableModel doSearch(ArrayList<String> parolechiavi) throws SQLException {

         if(addetti != null)
           addetti.clear();
         addetti = dao.getAddettiParolaChiave(parolechiavi);  
         MyDefaultTableModel tab = new MyDefaultTableModel();
         tab.createModelBySetAddetto(addetti);
         return tab;
    }

     public List<String> getTaxCodeBySurname(String surname) throws SQLException
    {
        Set<Addetto> addetti = null;
        LinkedList<String> surn_Add = new LinkedList<>();
        addetti = dao.searchBySurname(surname);
        
        for(Addetto add : addetti)
        {
            surn_Add.add(add.getCf());
        }
        
       return surn_Add;
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
