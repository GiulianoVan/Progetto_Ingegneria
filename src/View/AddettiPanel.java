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
public class AddettiPanel extends GeneralPanel{
    
    private javax.swing.JButton buttonAdvGeneral;
    private javax.swing.JButton buttonBackSearchGeneral;
    private javax.swing.JButton buttonCreateGeneral;
    private javax.swing.JButton buttonOkAdvSearchGeneral;
    private javax.swing.JButton buttonOkSearchGeneral;
    private javax.swing.JComboBox<String> comboTypeGeneralSearch;
    private com.toedter.calendar.JDateChooser dateGeneral;
    private javax.swing.JPanel jPanelAdvSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableSearchGeneral;
    private javax.swing.JTextField textUserGeneralSearch;
    private javax.swing.JTextField textCFGeneralSearch;
    private javax.swing.JTextField textSearchGeneral;
    
    public AddettiPanel()
    {
        super();
        this.setComponentsPanel();
    }
    
    public void setComponentsPanel()
    {
        buttonAdvGeneral = getButtonAdvGeneral();
        textCFGeneralSearch = getTextCodeGeneralSearch();
        textSearchGeneral = getTextSearchGeneral();
        textUserGeneralSearch = getTextNameGeneralSearch();
        jPanelAdvSearch = getjPanelAdvSearch();
        buttonOkSearchGeneral = getButtonOkSearchGeneral();
        buttonCreateGeneral = getButtonCreateGeneral();
        
        buttonCreateGeneral.setVisible(false);
        dateGeneral.setVisible(false);
        comboTypeGeneralSearch.setVisible(false);
        buttonAdvGeneral.setText("Advanced Search");
        textCFGeneralSearch.setText("Insert CF here...");
        textSearchGeneral.setText("Insert Name here...");
        textUserGeneralSearch.setText("Insert User here...");
        
    }
                
}
