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
    private javax.swing.JButton buttonBackCreateEvent;
    private javax.swing.JComboBox<String> comboType_event;
    private javax.swing.JComboBox<String> comboKind_event;
    
    
    public EventPanel()
    {
        super();
        this.setComponentsPanel();
        buttonBackCreateEvent.setActionCommand("BACKCREATEEVENT");
        this.loadCombo();
        
        
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
        textCfGeneral = getTextCfGeneralSearch();
        textNameEventSearch = getTextNameGeneralSearch();
        textSearchEvent = getTextSearchGeneral();
        textCodeEventSearch = getTextSurnameGeneralSearch();
        buttonBackCreateEvent = getButtonBackCreate();
        comboKind_event = getComboGenEventCreate();
        comboType_event = getComboTypeEventCreate();
        jPanelAdvSearch.setVisible(false);
        
        textCodeEventSearch.setVisible(false);
        textCfGeneral.setVisible(false);
        buttonAdvEvent.setText("Advanced Search");
        buttonCreateEvent.setText("Create Event");
        comboTypeEventSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Type Event...", "Sport", "Concert", "Theater", "Cinema" }));
        
        textNameEventSearch.setText("Insert Name Here...");
        textSearchEvent.setText("Insert Name Here...");
    
        tableSearchEvent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "TITLE", "TYPE", "KIND", "DATE", "PLACE", "ZIP CODE", "DESCRIPTION","IDEVENT"
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
    public void updateTable(Object arg) {
         MyDefaultTableModel tab = new MyDefaultTableModel();
        tab.createModelBySetEvent((Set) arg);
        int id = tableSearchEvent.getColumnModel().getColumnIndex("IDEVENT");
        tab.setId_column(id);
        tableSearchEvent.setModel(tab);
        //Aggiorno i nomi delle colonne nella view 
        tableSearchEvent.getColumnModel().getColumn(1).setHeaderValue("TYPE");
        tableSearchEvent.getColumnModel().getColumn(2).setHeaderValue("KIND");
        tableSearchEvent.getColumnModel().getColumn(4).setHeaderValue("PLACE");
        tableSearchEvent.getColumnModel().getColumn(5).setHeaderValue("ZIP CODE");
         
       // int id_column = tab.getId_column();
        //tableSearchEvent.removeColumn(tableSearchEvent.getColumnModel().getColumn(id_column));
    }

    @Override
    String setTextButtonCreate() {
        return "CREATE EVENT";
    }
    
    @Override
    public void loadCombo()
    {
        comboKind_event.removeAllItems();
        
        if(comboType_event.getSelectedItem().equals("CINEMA"))
        {
            comboKind_event.addItem("COMEDY");
            comboKind_event.addItem("DRAMATIC");
            comboKind_event.addItem("HORROR");
            comboKind_event.addItem("OTHER");
        }
       else if(comboType_event.getSelectedItem().equals("SPORT"))
       {
            comboKind_event.addItem("FOOTBALL");
            comboKind_event.addItem("TENNES");
            comboKind_event.addItem("BASKET");
            comboKind_event.addItem("VOLLEYBALL");
            comboKind_event.addItem("SWIMMING");
            comboKind_event.addItem("OTHER");
       }
       else if(comboType_event.getSelectedItem().equals("CONCERT"))
       {
           //EW.KIND_TYPE != 'OTHER' AND NEW.KIND_TYPE != 'POP AND ROCK' AND NEW.KIND_TYPE != 'METAL'
            comboKind_event.addItem("POP AND ROCK");
            comboKind_event.addItem("METAL");
            comboKind_event.addItem("OTHER");
       }
        else if(comboType_event.getSelectedItem().equals("THEATER"))
       {
           //EW.KIND_TYPE != 'OTHER' AND NEW.KIND_TYPE != 'POP AND ROCK' AND NEW.KIND_TYPE != 'METAL'
            comboKind_event.addItem("MUSICAL");
            comboKind_event.addItem("CABARET");
            comboKind_event.addItem("OTHER");
       }

        
    }

    @Override
    public void clearAllTextCreate() {
       
         getTextNameCreate().setText("");
         getDescriptionArea().setText("");
         getDateCreateEvent().setDate(null);
         
    }
}

