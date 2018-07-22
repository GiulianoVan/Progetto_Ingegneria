/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.DAO.AddettoDao;
import GestioneTabella.MyDefaultTableModel;
import Model.JavaBean.Addetto;
import View.AddettiPanel;
import View.GeneralPanel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import javax.swing.JOptionPane;
import java.util.HashSet;

/**
 *
 * @author Pirozzi
 */
public class ControllerCRDAddetto extends ListenerPanell{ //o estende la generale ?
//UTILIZZANDOLA QUANDO ESTENDE,BASTA USARE UN SOLO CONTROLLER,CONTROLLERADDETTO. IL COLLEGAMENTI COL PADRE VENGONO
    //FATTI IN AUTOMATICO NEL COSTRUTTORE DEL APDRE
    private Set<Addetto> addetti;
    private AddettoDao dao;
    private AddettiPanel view;
    private int flag_errorDelete = 1;
    private int flagtesting=0;
    private String flag_search= "";
    
    public ControllerCRDAddetto(AddettoDao dao,AddettiPanel view)
    {
        super(view);
        this.dao = dao;
        this.view = view;
        this.view.getButtonOkSearchGeneral().addActionListener(this);
        this.view.getTextSearchGeneral().addKeyListener(this);
        this.view.getButtonCreate().addActionListener(this);
        this.view.getButtonOkAdvSearchGeneral().addActionListener(this);
        this.view.getTextSurnameGeneralSearch().addKeyListener(this);
        this.view.getTextNameGeneralSearch().addKeyListener(this);
        this.view.getTextCfGeneralSearch().addKeyListener(this);
      
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        super.actionPerformed(e);//fai quello del pradre e poi questo.
        String action = e.getActionCommand();
        if(action.equals("CERCA"))
        {
            flag_search="cerca";
            String testo = view.getTextSearchGeneral().getText();
            if(testo.trim().length() > 0)
            {
                   ArrayList<String> parolechiavi;
                   parolechiavi = EstraiParoleChiavi(testo);
                   doSearch(parolechiavi); //ricerca
                          
            }
            if(view.getTableSearchGeneral().getRowCount()==0)
            {
                view.getButtonDeleteSearch().setEnabled(false);
                view.getButtonDeleteAdvSearch().setEnabled(false);
            }
        }
        /*
        else if(action.equals("CREATEPANEL"))
        {
            //view.getjPanelAdvSearch().setVisible(false);
            updateViewForCreatepanel();
           
        }
        
        else if(action.equals("BACKSECURITY"))
        {
            //view.getjPanelAdvSearch().setVisible(false);
            updateViewForBackSecurity();
            
        }*/
        else if(action.equals("DELETE"))
        {
             doDelete();
           
            //JTable tab = view.getTableSearchGeneral();
            
        }
        else if(action.equals("CREATE"))
        {
            String name = view.getTextNameSecurityCreate().getText();
            String surname = view.getTextSurnameCreate().getText();
            String username = view.getTextUsernameCreate().getText();
            String password = view.getTextPasswordCreate().getText();
            String code = view.getTextCFCreate().getText();
            Date birth =view.getDateCreateAddetto().getDate();
            String phone = view.getTextNumberCreate().getText();
            String email = view.getTextEmailCreate().getText();
            //Timestamp birth = new Timestamp(birth.getTime());
            String salar = view.getTextSalaryCreate().getText();
            salar = salar.replace(",", ".");
            Double salary = null;
            int errorSalary = 0;
            
            try
            {
                salary= Double.parseDouble(salar);
            }
            catch(NumberFormatException err)
            {
                if(view.getTextSalaryCreate().getText().trim().length()!=0)
                  JOptionPane.showMessageDialog(view,"Error : Cannot convert salary","ERROR", JOptionPane.ERROR_MESSAGE);
                else
                {
                    JOptionPane.showMessageDialog(view,"Error : Salary field empty","ERROR", JOptionPane.ERROR_MESSAGE);
                    
                }
                //se va in eccezion,mettimi errore sul salary
                errorSalary = 1;
            }
             if(errorSalary != 1) // non continua se ci sta un errore sul salary
             {
                 int createok = createAddetto(name, surname, username, password, code, birth, phone, email, salary);
                 if(createok == 1)
                 {
                     if(flag_search.equalsIgnoreCase("cerca"))
                          view.getButtonOkSearchGeneral().doClick();
                    else if(flag_search.equalsIgnoreCase("search_advanced"))
                          view.getButtonOkAdvSearchGeneral().doClick();  
                     
                     view.clearAllTextCreate();
                 }
             }
             errorSalary=0;
        }
        else if(action.equalsIgnoreCase("SEARCH_ADVANCED"))
        {
             flag_search="search_advanced";
            String cf =view.getTextCfGeneralSearch().getText();
            String name = view.getTextNameGeneralSearch().getText();
            String surname = view.getTextSurnameGeneralSearch().getText();
            Date from = view.getDateFromGeneral().getDate();
            Date to = view.getDateToGeneral().getDate();
            addetti = doAdvancedSearch(cf, name,surname,from,to);
            
            
             view.updateTable(addetti);
              if(view.getTableSearchGeneral().getRowCount()==0)
                     {
                        view.getButtonDeleteSearch().setEnabled(false);
                        view.getButtonDeleteAdvSearch().setEnabled(false);
                     }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) 
    {
                  
        if(e.getKeyChar()=='\n' && e.getComponent()==view.getTextSearchGeneral())
            {
            if(view.getTextSearchGeneral().getText().trim().length() > 0)
               {
                    flag_search = "search";
                    String testo = view.getTextSearchGeneral().getText();
                    ArrayList<String> parolechiavi = EstraiParoleChiavi(testo);
                    try
                    {
                        addetti=dao.getAddettiParolaChiave(parolechiavi);
                        view.updateTable(addetti);
                    }
                    catch(SQLException ex)
                    {
                       JOptionPane.showMessageDialog(view, "Mancata comunicazione col database.\nImpossibile effetuare la ricerca.", "ERRORE", JOptionPane.ERROR_MESSAGE);
                    }
                    if(view.getTableSearchGeneral().getRowCount()==0)
                     {
                        view.getButtonDeleteSearch().setEnabled(false);
                        view.getButtonDeleteAdvSearch().setEnabled(false);
                     }
               }
                
           }
        else if(e.getKeyChar() == '\n' && (e.getComponent()== view.getTextNameGeneralSearch() || e.getComponent()== view.getTextSurnameGeneralSearch() || e.getComponent()== view.getTextCfGeneralSearch()))
        {       
           flag_search ="search_advanced";
           view.getButtonOkAdvSearchGeneral().doClick();
        }
    }
 
/*
    private void updateViewForCreatepanel() {
            view.getDeleteSearch().setVisible(false);
            view.getjScrollPane1().setVisible(false);
            view.getButtonAdvGeneral().setVisible(false);
            view.getButtonCreateGeneral().setVisible(false);
            view.getTextSearchGeneral().setVisible(false);
            view.getButtonOkSearchGeneral().setVisible(false);
            view.getPanelCreateEvent().setVisible(false);
            view.getCreatePanel().setVisible(true);
    }

    private void updateViewForBackSecurity() {
            view.getDeleteSearch().setVisible(true);
            view.getjScrollPane1().setVisible(true);
            view.getButtonAdvGeneral().setVisible(true);
            view.getButtonCreateGeneral().setVisible(true);
            view.getTextSearchGeneral().setVisible(true);
            view.getButtonOkSearchGeneral().setVisible(true);
            view.getCreatePanel().setVisible(false);
    }
*/
    private void doDeleteEvent(int rowCount) {
        
             MyDefaultTableModel tab = (MyDefaultTableModel) view.getTableSearchGeneral().getModel();
                int start_selection = view.getTableSearchGeneral().getSelectedRow();
                int end_selection = rowCount+start_selection-1;
                
                for(int i = end_selection ; i>= start_selection;--i)
                {
                    try
                    {
                        dao.deleteAddetto((tab.getValueAt(i,tab.getId_column()).toString()));
                        tab.removeRow(i);
                    }
                    catch(SQLException errorDelete)
                    {
                          if(flag_errorDelete==1)
                          {
                              JOptionPane.showMessageDialog(view, "Errore : "+errorDelete.getMessage(), "ERRORE", JOptionPane.ERROR_MESSAGE);
                              flag_errorDelete = 0;
                          }
                    }
                     
                }
                 flag_errorDelete=1;
    }

    private Set<Addetto> doAdvancedSearch(String cf, String name, String surname, Date from, Date to) {
        {
            Set<Addetto> addetti = new HashSet<>();
            int intersect = 0;
            
            if(cf.trim().length() != 0)
            {
                try
                {
                    addetti.add(dao.searchByTaxCode(cf));
                }
                catch(SQLException err)
                {
                   JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                    if(name.trim().length()!=0)
                    { 
                        
                        try
                        {
                             if(addetti.isEmpty() && intersect == 0)
                               addetti.addAll(dao.searchByName(name));
                             else
                                addetti.retainAll(dao.searchByName(name));
                             
                             intersect = 1;
                        }
                        catch(SQLException err)
                        {
                             JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if(surname.trim().length() != 0)
                    {
                        try{
                           if(addetti.isEmpty() && intersect == 0) 
                             addetti.addAll(dao.searchBySurname(view.getTextSurnameGeneralSearch().getText()));
                           else
                             addetti.retainAll(dao.searchBySurname(view.getTextSurnameGeneralSearch().getText()));
                       
                           intersect = 1;
                        }
                        catch(SQLException err)
                        {
                              JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if(from!= null && to != null)
                    {
                        try{
                           if(addetti.isEmpty() && intersect == 0)  
                              addetti.addAll(dao.searchByBirth(from,to));
                           else
                             addetti.retainAll(dao.searchByBirth(from,to));
                        
                           intersect = 1;
                        }
                        catch(SQLException err)
                        {
                           JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                   
                    else
                    {
                        if((from== null &&  to!= null) || (from!= null &&  to== null))       
                           JOptionPane.showMessageDialog(view,"Fill both date fields. The search will not consider the date fields.","INFO", JOptionPane.INFORMATION_MESSAGE);

                    }
            }
          return addetti;
        }
    }

    private int createAddetto(String name, String surname, String username, String password, String code, Date birth, String phone, String email, Double salary) {
        
            int ok = 0;
            try
            {
                 Addetto security = new Addetto(name,surname,code,email,phone, salary,birth,username,password);
                 dao.aggiungiAddetto(security);
                 JOptionPane.showMessageDialog(view,"Successfull insert","INSERT",JOptionPane.INFORMATION_MESSAGE);
                 ok=1;
            }
            catch(SQLException err)
            {
               JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
            }
            return ok;
    }

    private void doSearch(ArrayList<String> parolechiavi) {
             
       try {
                addetti = dao.getAddettiParolaChiave(parolechiavi);  
                view.updateTable(addetti);
           }

           catch(SQLException ex)
           {
              JOptionPane.showMessageDialog(view, "Connection failed to Database.\nCannot do search.", "ERROR", JOptionPane.ERROR_MESSAGE);
           }
    }

    private void doDelete() {
             String deleteMessage;
            int rowCount = view.getTableSearchGeneral().getSelectedRowCount();
            if(rowCount > 1)
                deleteMessage = "You selected "+rowCount+" rows, are you sure that you want delete them?";
            else
                deleteMessage = "Are you sure that you want delete it?";
            int answer  = JOptionPane.showConfirmDialog(view,deleteMessage,"DELETE",JOptionPane.YES_NO_OPTION);
            if(answer == 0) // ha cliccato si
            {
                 doDeleteEvent(rowCount);
                 //se cancello le righe,risetto a false il button.
                 view.getButtonDeleteAdvSearch().setEnabled(false);
                 view.getButtonDeleteSearch().setEnabled(false);
            }
    }
}
