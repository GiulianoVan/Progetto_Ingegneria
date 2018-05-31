/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.DAO.CustomerDao;
import Model.MODELDACANCELARE.CustomerModel;
import Model.MODELDACANCELARE.EventModel;
import Model.JavaBean.Customer;
import View.GeneralPanel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Pirozzi
 */
public class ControllerCustomer extends ControllerGeneral{
 
    
    GeneralPanel view;
    CustomerDao dao;
    Set<Customer> customer;
    
    public ControllerCustomer(CustomerDao dao, GeneralPanel view) {
        
        super(view);
        this.dao = dao;
        this.view = view;
        this.view.getButtonOkSearchGeneral().addActionListener(this);
        this.view.getTextSearchGeneral().addKeyListener(this);
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
            }
        }
        else if(action.equals("DELETE"))
        {
            //se tt è vuoto,impossibile effettuare la ricerca.
           //altrimenti creo una mappa campo-valore e la passo al model x fare l'interrogazione.
        }
        else if(action.equals("BACKSEARCH"))
        {
            super.actionPerformed(e);
            view.getButtonCreateGeneral().setVisible(false);
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) 
    {
        
        
             if(e.getKeyChar()=='\n')
             { 
                if(view.getTextSearchGeneral().getText().trim().length() > 0)
                {
                    System.out.println(view.getTextNameGeneralSearch().getText());
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
                }
                
            }
               
    }
    
}
