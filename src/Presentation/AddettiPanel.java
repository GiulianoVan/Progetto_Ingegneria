/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import BusinessComponent.ManagementModelTable.MyDefaultTableModel;
import java.util.Set;

/**
 *
 * @author INGSW2017_22
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
    private javax.swing.JTable tableSearchAddetto;
    private javax.swing.JTextField textPlaceGeneralSearch;
    private javax.swing.JTextField textCFGeneralSearch;
    private javax.swing.JTextField textSearchAddetto;
    private javax.swing.JTextField textNameAddetto;
    private javax.swing.JTextField textSurnameAddetto;
    private javax.swing.JButton buttonBackCreateSecurity;
    private MyDefaultTableModel tab;
    private javax.swing.JButton buttonPanelCreate;
 
    public AddettiPanel()
    {
        super();
        this.setComponentsPanel();
        buttonBackCreateSecurity.setActionCommand("BACKSECURITY");
        buttonPanelCreate.setActionCommand("CREATEPANELADDETTI");
        tab = null;
    }
    
    public void setComponentsPanel()
    {
        super.getLabelFirst().setText("Surname");
        super.getLabelSecond().setText("Name");
        super.getLabelTirth().setText("Tax Code");
        
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
        getButtonCreate().setText("CREATE S.OFFICER");
        

        jPanelAdvSearch.setVisible(false);
        comboGenereTypeSearch.setVisible(false);    
        comboTypeGeneralSearch.setVisible(false);

        buttonAdvGeneral.setText("Advanced Search");
        buttonCreateGeneral.setText("Create Security Officer");  
        textSearchAddetto.setText("Insert Something here");
        buttonPanelCreate = getButtonCreateGeneral();
        
        tableSearchAddetto.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new String [] {"NAME", "SURNAME", "TAX CODE", "EMAIL", "PHONE", "SALARY", "BIRTH","ID CODE"})
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

