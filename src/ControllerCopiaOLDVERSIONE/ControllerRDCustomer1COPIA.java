/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerCopiaOLDVERSIONE;

import BusinessComponent.Boundary.BoundaryGeneralPanel;
import DataStorage.DB.DAO.CustomerDao;
import BusinessComponent.GestioneTabella.MyDefaultTableModel;
import BusinessComponent.Entity.Customer;
import Presentazione.CustomerPanel;
import Presentazione.GeneralPanel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Pirozzi
 */
public class ControllerRDCustomer1COPIA extends BoundaryGeneralPanel{
 
    
    private CustomerPanel view;
    private CustomerDao dao;
    private Set<Customer> customer;
    private int flag_errorDelete = 1;
    
    public ControllerRDCustomer1COPIA(CustomerDao dao, CustomerPanel view) {
        
        super(view);
        this.dao = dao;
        this.view = view;
        this.view.getButtonOkSearchGeneral().addActionListener(this);
        this.view.getTextSearchGeneral().addKeyListener(this);
        this.view.getButtonOkAdvSearchGeneral().addActionListener(this);
        this.view.getTextNameGeneralSearch().addKeyListener(this);
        this.view.getTextSurnameGeneralSearch().addKeyListener(this);
        this.view.getTextCfGeneralSearch().addKeyListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        super.actionPerformed(e);//fai quello del pradre e poi questo.
        String action = e.getActionCommand();
        if(action.equals("CERCA"))
        {
            if(view.getTextSearchGeneral().getText().trim().length() > 0)
            {

                   ArrayList<String> parolechiavi;
                   String testo = view.getTextSearchGeneral().getText();
                   parolechiavi = EstraiParoleChiavi(testo);
                   try
                   {
                       customer = dao.searchCustomerKeysWords(parolechiavi);
                       view.updateTable(customer);
                   }
                   catch(SQLException ex)
                   {
                     JOptionPane.showMessageDialog(view, "Mancata comunicazione col database.\nImpossibile effetuare la ricerca.", "ERRORE", JOptionPane.ERROR_MESSAGE);

                   }
                    if(view.getTableSearchGeneral().getRowCount()==0)
                     {
                        view.getButtonDeleteSearch().setEnabled(false);
                        view.getButtonDeleteAdvSearch().setEnabled(false);
                     }
            }
        }
        else if(action.equals("DELETE"))
        {
            String deleteMessage;
            int rowCount = view.getTableSearchGeneral().getSelectedRowCount();
            if(rowCount > 1)
                deleteMessage = "Hai selezionato "+rowCount+" righe, sei sicuro di volerle eliminare tutte?";
            else
                deleteMessage = "Sei sicuro di voler eliminare la riga selezionata?";
            int answer  = JOptionPane.showConfirmDialog(view,deleteMessage,"DELETE",JOptionPane.YES_NO_OPTION);
            if(answer == 0) // ha cliccato si
            {
                MyDefaultTableModel tab = (MyDefaultTableModel) view.getTableSearchGeneral().getModel();
                int start_selection = view.getTableSearchGeneral().getSelectedRow();
                int end_selection = rowCount+start_selection-1;
                
                for(int i = end_selection ; i>= start_selection;--i)
                {
                    try
                    {
                        dao.deleteCustomer((tab.getValueAt(i,tab.getId_column()).toString()));
                        tab.removeRow(i);
                    }
                    catch(SQLException errorDelete)
                    {
                          if(flag_errorDelete==1)
                          {
                              JOptionPane.showMessageDialog(view, "Errore : "+errorDelete.getMessage(), "ERRORE", JOptionPane.ERROR_MESSAGE);
                              flag_errorDelete = 0;
                          }
                    }
                     
                }
                 flag_errorDelete=1;
                  view.getButtonDeleteAdvSearch().setEnabled(false);
                 view.getButtonDeleteSearch().setEnabled(false);
            }
            //JTable tab = view.getTableSearchGeneral();
            
        }
        else if(action.equals("BACKSEARCH"))
        {
            super.actionPerformed(e);
            view.getButtonCreateGeneral().setVisible(false);
        }
        else if(action.equalsIgnoreCase("SEARCH_ADVANCED"))
        {
            customer = new HashSet<>();
            int intersect = 0;
            if(view.getTextCfGeneralSearch().getText().trim().length() != 0)
            {
                try
                {
                    customer.add(dao.searchByTaxCode(view.getTextCfGeneralSearch().getText()));
                    intersect = 1;
                }
                catch(SQLException err)
                {
                   JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            else 
            {
                    if(view.getTextNameGeneralSearch().getText().trim().length()!=0)
                    {
                        
                        try
                        {
                             if(customer.isEmpty() && intersect == 0)
                               customer.addAll(dao.searchByName(view.getTextNameGeneralSearch().getText()));
                             else
                                customer.retainAll(dao.searchByName(view.getTextNameGeneralSearch().getText()));
                        
                             intersect = 1;
                        }
                        catch(SQLException err)
                        {
                             JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if(view.getTextSurnameGeneralSearch().getText().trim().length() != 0)
                    {
                        try{
                           if(customer.isEmpty() && intersect == 0) 
                             customer.addAll(dao.searchBySurname(view.getTextSurnameGeneralSearch().getText()));
                           else
                             customer.retainAll(dao.searchBySurname(view.getTextSurnameGeneralSearch().getText()));

                            intersect = 1;
                        }
                        catch(SQLException err)
                        {
                              JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if(view.getDateFromGeneral().getDate()!= null && view.getDateToGeneral().getDate()!= null)
                    {
                        try{
                           if(customer.isEmpty() && intersect == 0)  
                              customer.addAll(dao.searchByBirth(view.getDateFromGeneral().getDate(),view.getDateToGeneral().getDate()));
                           else
                             customer.retainAll(dao.searchByBirth(view.getDateFromGeneral().getDate(),view.getDateToGeneral().getDate()));
                           
                           intersect = 1;
                        }
                        catch(SQLException err)
                        {
                           JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                   
                    else
                    {
                        if((view.getDateFromGeneral().getDate()== null &&  view.getDateToGeneral().getDate()!= null) || (view.getDateFromGeneral().getDate()!= null &&  view.getDateToGeneral().getDate()== null))       
                             JOptionPane.showMessageDialog(view,"Error : Riempire entrambi i campi della data o lasciarli entrambi vuoti. ","ERROR", JOptionPane.ERROR_MESSAGE);

                    }
            }
             
             view.updateTable(customer);
              if(view.getTableSearchGeneral().getRowCount()==0)
                     {
                        view.getButtonDeleteSearch().setEnabled(false);
                        view.getButtonDeleteAdvSearch().setEnabled(false);
                     }
        }
     }
    
    
    @Override
    public void keyReleased(KeyEvent e) 
    {
             if(e.getKeyChar()=='\n' && e.getComponent()==view.getTextSearchGeneral())
             { 
                    if(view.getTextSearchGeneral().getText().trim().length() > 0)
                    {
                        String testo = view.getTextSearchGeneral().getText();
                        ArrayList<String> parolechiavi = EstraiParoleChiavi(testo);
                       try
                       {
                           customer = dao.searchCustomerKeysWords(parolechiavi);
                           view.updateTable(customer);
                       }
                       catch(SQLException ex)
                       {
                          JOptionPane.showMessageDialog(view, "Mancata comunicazione col database.\nImpossibile effetuare la ricerca.", "ERRORE", JOptionPane.ERROR_MESSAGE);
                       }
                        if(view.getTableSearchGeneral().getRowCount()==0)
                        {
                            view.getButtonDeleteSearch().setEnabled(false);
                            view.getButtonDeleteAdvSearch().setEnabled(false);
                        }
                    }
             }
             else if(e.getKeyChar() == '\n' && (e.getComponent()== view.getTextNameGeneralSearch() || e.getComponent()== view.getTextSurnameGeneralSearch() || e.getComponent()== view.getTextCfGeneralSearch()))
               {
                  //stesso comportamento del pulsante.
                    view.getButtonOkAdvSearchGeneral().doClick();
               }
            
    }
    
}
