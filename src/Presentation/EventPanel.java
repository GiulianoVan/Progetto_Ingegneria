/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import javax.swing.JComboBox;

/**
 *
 * @author INGSW2017_22
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
    private javax.swing.JButton buttonPanelCreateEvent;

    
    public EventPanel()
    {
        super();
        this.setComponentsPanel();
        buttonBackCreateEvent.setActionCommand("BACKCREATEEVENT");
        buttonPanelCreateEvent.setActionCommand("CREATEPANELEVENT");
        
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
        buttonPanelCreateEvent = getButtonCreateGeneral();
        textSearchEvent.setText("Insert Name Here...");
    
        tableSearchEvent.setModel(new javax.swing.table.DefaultTableModel(
                                                                            new Object [][] {},
                                                                            new String [] {"TITLE", "TYPE", "KIND", "DATE", "PLACE", "DESCRIPTION","ID CODE"}
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
    String setTextButtonCreate() {
        return "CREATE EVENT";
    }
    
    @Override
    public void clearAllTextCreate() {
       
         getTextNameEventCreate().setText("");
         getDescriptionArea().setText("");
         getTextLuogoCreateEvent().setText("");
         getDateCreateEvent().setDate(null);
         
    }
}

