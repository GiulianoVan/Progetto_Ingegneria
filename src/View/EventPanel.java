/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import GestioneTabella.MyDefaultTableModel;
import java.awt.event.FocusListener;
import java.util.Observable;
import java.util.Set;

/**
 *
 * @author giuli
 */
public class EventPanel extends GeneralPanel {
    
    private javax.swing.JButton buttonAdvSearchEvent;
    private javax.swing.JButton buttonCreateEvent;
    private javax.swing.JButton buttonOkSearchEvent;
    private javax.swing.JButton buttonBackSearchEvent;
    private javax.swing.JComboBox<String> comboTypeEventSearch;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelAdvSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableSearchEvent;
    private javax.swing.JTextField textCodeEventSearch;
    private javax.swing.JTextField textNameEventSearch;
    private javax.swing.JTextField textSearchEvent;
    private javax.swing.JTextField textCfGeneral;
    private javax.swing.JTextField textPlaceGeneral;
    private javax.swing.JButton buttonAdvEvent;
    
    
    
    public EventPanel()
    {
        super();
        this.setComponentsPanel();
        //MANCA->buttonbackCreateEvent.SetactionCommand
    }
    
    public void setComponentsPanel() {
        
        buttonAdvSearchEvent = getButtonOkAdvSearchGeneral();
        buttonAdvEvent = getButtonAdvGeneral();
        buttonCreateEvent = getButtonCreateGeneral();
        buttonOkSearchEvent = getButtonOkSearchGeneral();
        buttonBackSearchEvent = getButtonBackSearchGeneral();
        comboTypeEventSearch = getComboTypeGeneralSearch();
        jDateChooser1 = getDateGeneral();
        jPanelAdvSearch = getjPanelAdvSearch();
        jScrollPane1 = getjScrollPane1();
        tableSearchEvent = getTableSearchGeneral();
        textCodeEventSearch = getTextCodeGeneralSearch();
        textNameEventSearch = getTextNameGeneralSearch();
        textSearchEvent = getTextSearchGeneral();

        
        jPanelAdvSearch.setVisible(false);
        buttonAdvEvent.setText("Advanced Search");
        buttonCreateEvent.setText("Create Event");
        comboTypeEventSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Type Event...", "Sport", "Cinema", "Teatro", "Concerto", "Museo" }));
        textCodeEventSearch.setText("Insert Code Here...");
        textNameEventSearch.setText("Insert Name Here...");
        textSearchEvent.setText("Insert Name Here...");
    
        tableSearchEvent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "TITOLO", "TYPE", "GEN_TYPE", "DATA", "LUOGO", "CAP", "DESCR"
            }
          )
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
        textSearchEvent.setText("Insert Name Here...");
    }

    @Override
    public void update(Observable o, Object arg) {
         MyDefaultTableModel tab = new MyDefaultTableModel();
        tab.createModelBySetEvent((Set) arg);
        tableSearchEvent.setModel(tab);
        int id_column = tab.getId_column();
        tableSearchEvent.removeColumn(tableSearchEvent.getColumnModel().getColumn(id_column));
    }
    
    
}
