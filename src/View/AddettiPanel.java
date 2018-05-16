/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerAddetto.ControllerButtonAddetto;
import Controller.ControllerAddetto.ControllerKeyAddetto;
import Model.MyDefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.Observable;
import javax.swing.JTable;

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
    
    public AddettiPanel()
    {
        super();
        this.setComponentsPanel();
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
        
        jPanelAdvSearch.setVisible(false);
        buttonCreateGeneral.setVisible(false);
        dateGeneral.setVisible(false);
        comboTypeGeneralSearch.setVisible(false);
        buttonAdvGeneral.setText("Advanced Search");
        textCFGeneralSearch.setText("Insert CF here...");
        textSearchAddetto.setText("Insert Name here...");
        textUserGeneralSearch.setText("Insert User here...");
        
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
    
        public void SetControllerKeyTable(KeyListener controller)
        {
            tableSearchAddetto.addKeyListener(controller);
        }
        
        public void setControllerMouseTable(MouseListener controller)
        {
            
            tableSearchAddetto.addMouseListener(controller);
        }

    
        void changeTable()
        {
            int riga = tableSearchAddetto.getSelectedRow();
            int col = tableSearchAddetto.getSelectedColumn();
            tableSearcAddetto.getTabellaAddetto().getModel();
            tab.setRowEditable(riga);
            tab.setColumnEditable(col);
            tab.isCellEditable(riga,col);
            
        }
        
       
        
    @Override
    public void update(Observable o, Object arg) {
        
        tableSearchAddetto.setModel((MyDefaultTableModel) arg);
            //rimuovo la colonna dalla Jtable. Remove vuole una TableColumn che mi prendo dal modello
        tableSearchAddetto.removeColumn(tableSearchAddetto.getColumnModel().getColumn(7));
            //SUCCESSIVAMENTE SARA ANCORA PRESENTE NEL MODELLO.TabellaAddetto.getModel().getValueAt()
    }
               
    
      
                               
}
