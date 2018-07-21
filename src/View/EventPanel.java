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
import javax.swing.JComboBox;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

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
        this.loadComboTypeEvent(comboType_event,comboKind_event);
        this.loadComboTypeEvent(comboType_event,comboKind_event);
        
    }
    
    public void setComponentsPanel() {
        
        
        super.getLabelFirst().setText("Type Event");
        super.getLabelSecond().setText("Title");
        super.getLabelTirth().setText("Kind Type");
        
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
        getButtonCreate().setText("CREATE EVENT");
        textCodeEventSearch.setVisible(false);
        textCfGeneral.setVisible(false);
        buttonAdvEvent.setText("Advanced Search");
        buttonCreateEvent.setText("Create Event");
        comboTypeEventSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NOT SELECTED", "SPORT", "CONCERT", "THEATER", "CINEMA" }));
        
        //textNameEventSearch.setText("Insert Name Here...");
        textSearchEvent.setText("Insert Name Here...");
    
        tableSearchEvent.setModel(new javax.swing.table.DefaultTableModel(
                                                                            new Object [][] {},
                                                                            new String [] {"TITLE", "TYPE", "KIND", "DATE", "PLACE", "ZIP CODE", "DESCRIPTION","ID CODE"}
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
        tableSearchEvent.setModel(tab);
        
        int id = tableSearchEvent.getColumnModel().getColumnIndex("ID");
        tab.setId_column(id);
        
        
        //Aggiorno i nomi delle colonne nella view 
        
        tableSearchEvent.getColumnModel().getColumn(1).setHeaderValue("TYPE");
        tableSearchEvent.getColumnModel().getColumn(2).setHeaderValue("KIND");
        tableSearchEvent.getColumnModel().getColumn(4).setHeaderValue("PLACE");
        tableSearchEvent.getColumnModel().getColumn(5).setHeaderValue("ZIP CODE");
        tableSearchEvent.getColumnModel().getColumn(id).setHeaderValue("ID CODE");


       // int id_column = tab.getId_column();
        //tableSearchEvent.removeColumn(tableSearchEvent.getColumnModel().getColumn(id_column));
    }

    @Override
    String setTextButtonCreate() {
        return "CREATE EVENT";
    }
    
    @Override
    public void loadComboTypeEvent(JComboBox comboType,JComboBox comboKind)
    {
        comboKind.removeAllItems();
        
        if(comboType.getSelectedItem().equals("CINEMA"))
        {
            comboKind.addItem("COMEDY");
            comboKind.addItem("DRAMATIC");
            comboKind.addItem("HORROR");
            comboKind.addItem("OTHER");
        }
       else if(comboType.getSelectedItem().equals("SPORT"))
       {
            comboKind.addItem("FOOTBALL");
            comboKind.addItem("TENNES");
            comboKind.addItem("BASKET");
            comboKind.addItem("VOLLEYBALL");
            comboKind.addItem("SWIMMING");
            comboKind.addItem("OTHER");
       }
       else if(comboType.getSelectedItem().equals("CONCERT"))
       {
           //EW.KIND_TYPE != 'OTHER' AND NEW.KIND_TYPE != 'POP AND ROCK' AND NEW.KIND_TYPE != 'METAL'
            comboKind.addItem("POP AND ROCK");
            comboKind.addItem("METAL");
            comboKind.addItem("OTHER");
       }
        else if(comboType.getSelectedItem().equals("THEATER"))
       {
           //EW.KIND_TYPE != 'OTHER' AND NEW.KIND_TYPE != 'POP AND ROCK' AND NEW.KIND_TYPE != 'METAL'
            comboKind.addItem("MUSICAL");
            comboKind.addItem("CABARET");
            comboKind.addItem("COMEDY");
            comboKind.addItem("OTHER");
       }
        else
        {
            comboKind.addItem("NOT SELECTED");
        }
                    
        
    }
   

    @Override
    public void clearAllTextCreate() {
       
         getTextNameEventCreate().setText("");
         getDescriptionArea().setText("");
         getTextLuogoCreateEvent().setText("");
         getDateCreateEvent().setDate(null);
         
    }
}

