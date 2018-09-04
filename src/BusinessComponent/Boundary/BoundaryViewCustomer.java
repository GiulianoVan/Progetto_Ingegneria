/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessComponent.Boundary;

import BusinessComponent.Controller.ControllerRUDCustomer;
import AccessDataStorage.DB.DAO.CustomerDao;
import BusinessComponent.ManagementModelTable.MyDefaultTableModel;
import BusinessComponent.Entity.Customer;
import Presentation.CustomerPanel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author INGSW2017_22
 */
public class BoundaryViewCustomer extends BoundaryGeneralPanel{
 
    
    private CustomerPanel view;
    private CustomerDao dao;
    private Set<Customer> customer;
    private int flag_errorDelete = 1;
    private ControllerRUDCustomer controller;
    
    public BoundaryViewCustomer(ControllerRUDCustomer contr, CustomerPanel view) {
        
        super(view);
        this.dao = dao;
        this.view = view;
        this.controller = contr;
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
            doSearch();
        }
        else if(action.equals("DELETE"))
        {
            doDelete();      
        }
        else if(action.equals("BACKSEARCH"))
        {
            super.actionPerformed(e);
            view.getButtonCreateGeneral().setVisible(false);
        }
        else if(action.equalsIgnoreCase("SEARCH_ADVANCED"))
        {
            doAdvancedSearch();
     }
}
    
    
    @Override
    public void keyReleased(KeyEvent e) 
    {
        if(e.getKeyChar()=='\n' && e.getComponent()==view.getTextSearchGeneral())
        { 
             doSearch();
        }
        
        else if(e.getKeyChar() == '\n' && (e.getComponent()== view.getTextNameGeneralSearch() || e.getComponent()== view.getTextSurnameGeneralSearch() || e.getComponent()== view.getTextCfGeneralSearch()))
        {
                doAdvancedSearch();
        }
            
    }

    private void doSearch()
    {
        String testo = view.getTextSearchGeneral().getText();
        if(testo.trim().length() > 0)
        {
            ArrayList<String> parolechiavi;
            parolechiavi = EstraiParoleChiavi(testo);
            try
            {
                view.getTableSearchGeneral().setModel(controller.doSearch(parolechiavi)); //ricerca
                view.getTableSearchGeneral().getColumnModel().getColumn(3).setHeaderValue("TAX CODE");
                view.getTableSearchGeneral().getColumnModel().getColumn(8).setHeaderValue("ID CODE");
                int purch= view.getTableSearchGeneral().getColumnModel().getColumnIndex("ACQUISTI"); //setHeaderValue("ID CODE");
                view.getTableSearchGeneral().getColumnModel().getColumn(purch).setHeaderValue("PURCHASED");
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

    private void doAdvancedSearch() 
    {
        String cf = view.getTextCfGeneralSearch().getText();
        String name = view.getTextNameGeneralSearch().getText();
        String surname = view.getTextSurnameGeneralSearch().getText();
        Date from = view.getDateFromGeneral().getDate();
        Date to = view.getDateToGeneral().getDate();

        try 
        {
            view.getTableSearchGeneral().setModel(controller.doAdvancedSearch(cf, name, surname, from, to));
            view.getTableSearchGeneral().getColumnModel().getColumn(3).setHeaderValue("TAX CODE");
            view.getTableSearchGeneral().getColumnModel().getColumn(8).setHeaderValue("ID CODE");
            int purch= view.getTableSearchGeneral().getColumnModel().getColumnIndex("ACQUISTI"); //setHeaderValue("ID CODE");
            view.getTableSearchGeneral().getColumnModel().getColumn(purch).setHeaderValue("PURCHASED");                    
        } 
        catch (SQLException ex) 
        {
             JOptionPane.showMessageDialog(view,"Code : "+ex.getErrorCode()+"\n"+ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception ex)
        {
           JOptionPane.showMessageDialog(view,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }

        if(view.getTableSearchGeneral().getRowCount()==0)
        {
           view.getButtonDeleteSearch().setEnabled(false);
           view.getButtonDeleteAdvSearch().setEnabled(false);
        }
    }
    
    private void doDelete()
    {
        String deleteMessage;
        int flag_errorDelete=1;
        int rowCount = view.getTableSearchGeneral().getSelectedRowCount();
        if(rowCount > 1)
            deleteMessage = "Hai selezionato "+rowCount+" righe, sei sicuro di volerle eliminare tutte?";
        else
            deleteMessage = "Sei sicuro di voler eliminare la riga selezionata?";
        int answer  = JOptionPane.showConfirmDialog(view,deleteMessage,"DELETE",JOptionPane.YES_NO_OPTION);
        if(answer == 0) // ha cliccato si
        {
            int start_selection = view.getTableSearchGeneral().getSelectedRow();
            int end_selection = rowCount+start_selection-1;

            for(int i = end_selection ; i>= start_selection;--i)
            {
                try
                {
                    controller.doDeleteAddetto(view.getTableSearchGeneral().getValueAt(i,8).toString());
                    MyDefaultTableModel tab = (MyDefaultTableModel) view.getTableSearchGeneral().getModel();
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
    }
    
}
