/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import GestioneTabella.MyDefaultTableModel;
import java.util.HashSet;
import java.util.Observable;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Vincent
 */
public class CustomerPanel extends GeneralPanel {
    
    private javax.swing.JButton buttonAdvSearchCustomer;
    private javax.swing.JButton buttonCreateCustomer;
    private javax.swing.JButton buttonOkSearchCustomer;
    private javax.swing.JButton buttonBackSearchCustomer;
    private javax.swing.JComboBox<String> comboTypeGeneralSearch;
    private javax.swing.JComboBox<String> comboGenereTypeSearch;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelAdvSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableSearchCustomer;
    private javax.swing.JTextField textCodeCustomerSearch;
    private javax.swing.JTextField textNameCustomerSearch;
    private javax.swing.JTextField textSearchCustomer;
    private javax.swing.JButton buttonAdvCustomer;
    private javax.swing.JTextField textCFGeneralSearch;
    private javax.swing.JTextField textNameCustomer;
    private javax.swing.JTextField textSurnameCustomer;
    
    MyDefaultTableModel tab;
    
    
    public CustomerPanel()
    {
        super();
        this.setComponentsPanel();
        tab = null;
    }
    
    public void setComponentsPanel() {
        buttonAdvSearchCustomer = getButtonOkAdvSearchGeneral();
        buttonAdvCustomer = getButtonAdvGeneral();
        buttonCreateCustomer = getButtonCreateGeneral();
        buttonOkSearchCustomer = getButtonOkSearchGeneral();
        buttonBackSearchCustomer = getButtonBackSearchGeneral();
        comboTypeGeneralSearch = getComboTypeGeneralSearch();
        comboGenereTypeSearch = getComboGenereType();
        jDateChooser1 = getDateGeneral();
        jPanelAdvSearch = getjPanelAdvSearch();
        jScrollPane1 = getjScrollPane1();
        tableSearchCustomer = getTableSearchGeneral();
        textSearchCustomer = getTextSearchGeneral();
        // ADV SEARCH
        textSurnameCustomer = getTextCodeGeneralSearch();
        textNameCustomer = getTextNameGeneralSearch();
        textCFGeneralSearch = getTextCfGeneralSearch();
        
        
         // ******* SETTAGGIO TEXT RICARVA AVANZATA *******
         
         textCFGeneralSearch.setText("Insert CF here");
         textNameCustomer.setText("Insert Name here");
         textSurnameCustomer.setText("Insert Surname here");
         
        
        jPanelAdvSearch.setVisible(false);
        comboGenereTypeSearch.setVisible(false);    
        comboTypeGeneralSearch.setVisible(false);
        buttonCreateCustomer.setVisible(false);
        buttonAdvCustomer.setText("Advanced Search");
        textSearchCustomer.setText("Insert Something Here...");
    
        
        tableSearchCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
               "USERNAME" ,"NAME", "SURNAME", "TAX CODE", "EMAIL", "PHONE", "BIRTH"
            }
         ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            
        });
    
    }
 /*   
    @Override
    public void backNormalSearch()
    {
            getButtonAdvGeneral().setVisible(true);
            getButtonCreateGeneral().setVisible(false);
            getTextSearchGeneral().setVisible(true);
            getButtonOkSearchGeneral().setVisible(true);
            getjPanelAdvSearch().setVisible(false);
    }
   */ 
    @Override
    public void setNameSearch()
    {
      textSearchCustomer.setText("Insert Something Here...");
    }

    
    @Override
    public void updateTable(Object arg) {
           
         tab = new MyDefaultTableModel();
         tab.createModelBySetCustomer((Set) arg);
         tableSearchCustomer.setModel(tab);
         //Aggiorno i nomi delle colonne nella view 
         tableSearchCustomer.getColumnModel().getColumn(3).setHeaderValue("TAX CODE");
         
         //rimuovo la colonna dalla Jtable. Remove vuole una TableColumn che mi prendo dal modello
         //ultimo indice contiene sempre id.
         int id_column = tab.getId_column();
         tableSearchCustomer.removeColumn(tableSearchCustomer.getColumnModel().getColumn(id_column));
       
       }
    
    
}
