/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import GestioneTabella.MyDefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Set;

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
    private com.toedter.calendar.JDateChooser dateGeneral;
    private javax.swing.JPanel jPanelAdvSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableSearchAddetto;
    private javax.swing.JTextField textUserGeneralSearch;
    private javax.swing.JTextField textCFGeneralSearch;
    private javax.swing.JTextField textSearchAddetto;
    private javax.swing.JButton buttonBackCreateSecurity;
    
    public AddettiPanel()
    {
        super();
        this.setComponentsPanel();
        buttonOkSearchAddetto.setActionCommand("CERCA");
        buttonBackCreateSecurity.setText("BACK SECURITY");
        buttonBackCreateSecurity.setActionCommand("BACKSECURITY");
    }
    
    public void setComponentsPanel()
    {
        buttonAdvGeneral = getButtonAdvGeneral();
        textCFGeneralSearch = getTextCodeGeneralSearch();
        textSearchAddetto = getTextSearchGeneral();
        textUserGeneralSearch = getTextNameGeneralSearch();
        jPanelAdvSearch = getjPanelAdvSearch();
        buttonOkSearchAddetto = getButtonOkSearchGeneral();
        buttonCreateGeneral = getButtonCreateGeneral();
        dateGeneral = getDateGeneral();
        comboTypeGeneralSearch = getComboTypeGeneralSearch();
        tableSearchAddetto = getTableSearchGeneral();
        jPanelAdvSearch.setVisible(false);
        //buttonCreateGeneral.setVisible(false);
        dateGeneral.setVisible(false);
        comboTypeGeneralSearch.setVisible(false);
        buttonAdvGeneral.setText("Advanced Search");
        buttonCreateGeneral.setText("Create Security Officer");
        textCFGeneralSearch.setText("Insert CF here...");
        textSearchAddetto.setText("Insert Something here...");
        textUserGeneralSearch.setText("Insert User here...");
        buttonBackCreateSecurity = getButtonBackCreate();
        
        
        tableSearchAddetto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "NOME", "COGNOME", "CF", "EMAIL", "TEL", "STIPENDIO", "LIVELLO"
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
    
        public void SetControllerButton(ActionListener controller)
        {
            buttonOkSearchAddetto.addActionListener(controller);
          
        }

        public void SetControllerKeyText(KeyListener controller)
        {
            textSearchAddetto.addKeyListener(controller);
        }
        
     @Override
    public void setNameSearch()
    {
        textSearchAddetto.setText("Insert something here..");
    }
        
    @Override
    public void update(Observable o, Object arg) {
        MyDefaultTableModel tab = new MyDefaultTableModel();
        tab.createModelBySetAddetto((Set) arg);
        tableSearchAddetto.setModel(tab);
            //rimuovo la colonna dalla Jtable. Remove vuole una TableColumn che mi prendo dal modello
            //ultimo indice contiene sempre id.
        int id_column = tab.getId_column();
        tableSearchAddetto.removeColumn(tableSearchAddetto.getColumnModel().getColumn(id_column));    
    }

      
                               
}

