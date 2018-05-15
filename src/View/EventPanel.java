/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author giuli
 */
public class EventPanel extends GeneralPanel {
    
    private javax.swing.JButton buttonAdvSearch;
    private javax.swing.JButton buttonCreateEvent;
    private javax.swing.JButton buttonOkSearchEvent;
    private javax.swing.JButton buttonBackSearch;
    private javax.swing.JComboBox<String> comboTypeEventSearch;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelAdvSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableSearchEvent;
    private javax.swing.JTextField textCodeEventSearch;
    private javax.swing.JTextField textNameEventSearch;
    private javax.swing.JTextField textSearchEvent;
    private javax.swing.JButton buttonAdvGeneral;
    
    
    
    public EventPanel()
    {
        super();
        this.setComponentsPanel();
    }
    
    public void setComponentsPanel() {
        
    buttonAdvSearch = getButtonOkAdvSearchGeneral();
    buttonAdvGeneral = getButtonAdvGeneral();
    buttonCreateEvent = getButtonCreateGeneral();
    buttonOkSearchEvent = getButtonOkSearchGeneral();
    buttonBackSearch = getButtonBackSearchGeneral();
    comboTypeEventSearch = getComboTypeGeneralSearch();
    jDateChooser1 = getDateGeneral();
    jPanelAdvSearch = getjPanelAdvSearch();
    jScrollPane1 = getjScrollPane1();
    tableSearchEvent = getTableSearchGeneral();
    textCodeEventSearch = getTextCodeGeneralSearch();
    textNameEventSearch = getTextNameGeneralSearch();
    textSearchEvent = getTextSearchGeneral();
    
    jPanelAdvSearch.setVisible(false);
    buttonAdvGeneral.setText("Advanced Search");
    buttonCreateEvent.setText("Create Event");
    comboTypeEventSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Type Event...", "Sport", "Cinema", "Teatro", "Concerto", "Museo" }));
    textCodeEventSearch.setText("Insert Code Here...");
    textNameEventSearch.setText("Insert Name Here...");
    textSearchEvent.setText("Insert Name Here...");
    
    }
    
}
