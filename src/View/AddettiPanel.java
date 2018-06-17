/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import GestioneTabella.MyDefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Observable;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author giuli
 */
public class AddettiPanel extends GeneralPanel{
    
    private javax.swing.JButton buttonAdvGeneral;
    private javax.swing.JButton buttonBackSearchGeneral;
    private javax.swing.JButton buttonCreateGeneral;
    private javax.swing.JButton buttonOkAdvSearchGeneral;
    private javax.swing.JButton buttonOkSearchAddetto;
    private javax.swing.JComboBox<String> comboTypeGeneralSearch;
    private javax.swing.JComboBox<String> comboGenereTypeSearch;
    
    private com.toedter.calendar.JDateChooser dateGeneral;
    private javax.swing.JPanel jPanelAdvSearch;
    //private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableSearchAddetto;
    private javax.swing.JTextField textPlaceGeneralSearch;
    private javax.swing.JTextField textCFGeneralSearch;
    private javax.swing.JTextField textSearchAddetto;
    private javax.swing.JTextField textNameAddetto;
    private javax.swing.JTextField textSurnameAddetto;
    private javax.swing.JButton buttonBackCreateSecurity;
    private MyDefaultTableModel tab;
    public AddettiPanel()
    {
        super();
        this.setComponentsPanel();
        buttonBackCreateSecurity.setActionCommand("BACKSECURITY");
        tab = null;
    }
    
    public void setComponentsPanel()
    {
        // ******** TEXT RICERCA AVANZATA ********
        textCFGeneralSearch = getTextCfGeneralSearch();
        textSurnameAddetto = getTextSurnameGeneralSearch();// RICORDARE DI UTILIZZARE LA TEXT_CODE PER IL COGNOME
        textNameAddetto = getTextNameGeneralSearch();
        // ********************************
        textSearchAddetto = getTextSearchGeneral();
        buttonBackCreateSecurity = getButtonBackCreate();
        buttonAdvGeneral = getButtonAdvGeneral();
        buttonOkSearchAddetto = getButtonOkSearchGeneral();
        buttonCreateGeneral = getButtonCreateGeneral();
        dateGeneral = getDateGeneral();
        comboTypeGeneralSearch = getComboTypeGeneralSearch();
        comboGenereTypeSearch = getComboGenereType();
        tableSearchAddetto = getTableSearchGeneral();
        jPanelAdvSearch = getjPanelAdvSearch();
        
        // ******* SETTAGGIO TEXT RICARVA AVANZATA *******
        textCFGeneralSearch.setText("Insert CF here");
        textNameAddetto.setText("Insert Name here");
        textSurnameAddetto.setText("Insert Surname here");
        // ******************************************
        jPanelAdvSearch.setVisible(false);
        comboGenereTypeSearch.setVisible(false);    
        comboTypeGeneralSearch.setVisible(false);
        //buttonCreateGeneral.setVisible(false);
        buttonAdvGeneral.setText("Advanced Search");
        buttonCreateGeneral.setText("Create Security Officer");  
        textSearchAddetto.setText("Insert Something here");
        
        
        tableSearchAddetto.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new String [] {"NAME", "SURNAME", "TAX CODE", "EMAIL", "PHONE", "SALARY", "BIRTH","ID"})
            {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };
                @Override
                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }
            });
    }
    

     @Override
    public void setNameSearch()
    {
        textSearchAddetto.setText("Insert something here..");
    }
        
    @Override
    public void updateTable(Object arg) {
              
         tab = new MyDefaultTableModel();
         tab.createModelBySetAddetto((Set) arg);
         tableSearchAddetto.setModel(tab);
         int id = tableSearchAddetto.getColumnModel().getColumnIndex("ID");
         tab.setId_column(id);
         //Aggiorno i nomi delle colonne nella view 
         tableSearchAddetto.getColumnModel().getColumn(2).setHeaderValue("TAX CODE");
         tableSearchAddetto.getColumnModel().getColumn(7).setHeaderValue("ID CODE");
         tableSearchAddetto.setRowSorter(new TableRowSorter(tab));
         //rimuovo la colonna dalla Jtable. Remove vuole una TableColumn che mi prendo dal modello
         //ultimo indice contiene sempre id.
       //  int id_column = tab.getId_column();
         //tableSearchAddetto.removeColumn(tableSearchAddetto.getColumnModel().getColumn(id_column));
        }
            
                              
    @Override
    String setTextButtonCreate() {
        return "CREATE SECURITY";
    }
    
    @Override
     public void clearAllTextCreate()
     {
         getTextNameCreate().setText("");
         getTextSurnameCreate().setText("");
         getTextSalaryCreate().setText("");
         getTextEmailCreate().setText("");
         getTextCFCreate().setText("");
         getTextUsernameCreate().setText("");
         getTextPasswordCreate().setText("");
         getDateCreateAddetto().setDate(null);
         getTextNumberCreate().setText("");
     }
}
