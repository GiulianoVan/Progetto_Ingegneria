/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import GestioneTabella.MyDefaultTableModel;
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
    private javax.swing.JComboBox<String> comboTypeEventCustomer;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelAdvSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableSearchCustomer;
    private javax.swing.JTextField textCodeCustomerSearch;
    private javax.swing.JTextField textNameCustomerSearch;
    private javax.swing.JTextField textSearchCustomer;
    private javax.swing.JButton buttonAdvCustomer;
    
    public CustomerPanel()
    {
        super();
        this.setComponentsPanel();
    }
    
    public void setComponentsPanel() {
        buttonAdvSearchCustomer = getButtonOkAdvSearchGeneral();
        buttonAdvCustomer = getButtonAdvGeneral();
        buttonCreateCustomer = getButtonCreateGeneral();
        buttonOkSearchCustomer = getButtonOkSearchGeneral();
        buttonBackSearchCustomer = getButtonBackSearchGeneral();
        comboTypeEventCustomer = getComboTypeGeneralSearch();
        jDateChooser1 = getDateGeneral();
        jPanelAdvSearch = getjPanelAdvSearch();
        jScrollPane1 = getjScrollPane1();
        tableSearchCustomer = getTableSearchGeneral();
        textCodeCustomerSearch = getTextCodeGeneralSearch();
        textNameCustomerSearch = getTextNameGeneralSearch();
        textSearchCustomer = getTextSearchGeneral();
        
         // ******* SETTAGGIO TEXT RICARVA AVANZATA *******
         /*
           textCFGeneralSearch.setText("Insert CF here");
           textPlaceGeneralSearch.setText("Insert Place here");
           textNameAddetto.setText("Insert Name here");
           textSurnameAddetto.setText("Insert Surname here");
         */
        
        jPanelAdvSearch.setVisible(false);
        comboTypeEventCustomer.setVisible(false);
        buttonCreateCustomer.setVisible(false);
        jDateChooser1.setVisible(false);
        buttonAdvCustomer.setText("Advanced Search");
        textCodeCustomerSearch.setText("Insert Place Here...");
        textNameCustomerSearch.setText("Insert CF Here...");
        textSearchCustomer.setText("Insert Something Here...");
    
        
        tableSearchCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
               "USERNAME" ,"NOME", "COGNOME", "CF", "EMAIL", "TEL", "DNASCITA"
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

    
    public void update(Observable o, Object arg) {
        
        if(arg.getClass()== Set.class)
        {
        MyDefaultTableModel tab = new MyDefaultTableModel();
        tab.createModelBySetCustomer((Set) arg);
        tableSearchCustomer.setModel(tab);
        //rimuovo la colonna dalla Jtable. Remove vuole una TableColumn che mi prendo dal modello
        //ultimo indice contiene sempre id.
        int id_column = tab.getId_column();
        tableSearchCustomer.removeColumn(tableSearchCustomer.getColumnModel().getColumn(id_column));
        }
        else if(arg.getClass() == Integer.class)
        {
            Integer error = (Integer) arg;
            if(error==1)
            {
                JOptionPane.showMessageDialog(this, "Dato inserito non valido.\nRiprovare inserendo un valore valido nel campo apposito.", "ERRORE", JOptionPane.ERROR_MESSAGE);
                this.resetValueTable(row, column,oldvalue);
            }
            
        }
    }
    
    
}
