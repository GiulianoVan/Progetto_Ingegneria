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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

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
        
        super.getLabelFirst().setText("Surname");
        super.getLabelSecond().setText("Name");
        super.getLabelTirth().setText("Tax Code");
        
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
        textSurnameCustomer = getTextSurnameGeneralSearch();
        textNameCustomer = getTextNameGeneralSearch();
        textCFGeneralSearch = getTextCfGeneralSearch();
             
        
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
               "USERNAME" ,"NAME", "SURNAME", "TAX CODE", "EMAIL", "PHONE", "BIRTH","PURCHASED","ID CODE"
            }
         ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,java.lang.String.class,java.lang.String.class
            };
            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
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
         int id = tableSearchCustomer.getColumnModel().getColumnIndex("ID");
         tab.setId_column(id);
         //Aggiorno i nomi delle colonne nella view 
         tableSearchCustomer.getColumnModel().getColumn(3).setHeaderValue("TAX CODE");
         tableSearchCustomer.getColumnModel().getColumn(id).setHeaderValue("ID CODE");
         int purch= tableSearchCustomer.getColumnModel().getColumnIndex("ACQUISTI"); //setHeaderValue("ID CODE");
         tableSearchCustomer.getColumnModel().getColumn(purch).setHeaderValue("PURCHASED");


         //rimuovo la colonna dalla Jtable. Remove vuole una TableColumn che mi prendo dal modello
         //ultimo indice contiene sempre id.
         //nt id_column = tab.getId_column();
         //SearchCustomer.removeColumn(tableSearchCustomer.getColumnModel().getColumn(id_column));
       
       }

    @Override
    public void clearAllTextCreate() {        
     }
    
    
}
