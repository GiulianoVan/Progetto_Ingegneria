/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.DAO.AddettoDao;
import GestioneTabella.MyDefaultTableModel;
import Model.JavaBean.Addetto;
import View.GeneralPanel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.sql.Timestamp;
import java.util.HashSet;

/**
 *
 * @author Pirozzi
 */
public class ControllerAddetto extends ControllerGeneral{ //o estende la generale ?
//UTILIZZANDOLA QUANDO ESTENDE,BASTA USARE UN SOLO CONTROLLER,CONTROLLERADDETTO. IL COLLEGAMENTI COL PADRE VENGONO
    //FATTI IN AUTOMATICO NEL COSTRUTTORE DEL APDRE
    private Set<Addetto> addetti;
    private AddettoDao dao;
    private GeneralPanel view;
    private int flag_errorDelete = 1;
    
    public ControllerAddetto(AddettoDao dao,GeneralPanel view)
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
            if(view.getTextSearchGeneral().getText().trim().length() > 0)
            {
                   ArrayList<String> parolechiavi;
                   String testo = view.getTextSearchGeneral().getText();
                   parolechiavi = EstraiParoleChiavi(testo);
                   try{
                        addetti = dao.getAddettiParolaChiave(parolechiavi);  
                        view.updateTable(addetti);
                      }
                   catch(SQLException ex)
                   {
                      JOptionPane.showMessageDialog(view, "Mancata comunicazione col database.\nImpossibile effetuare la ricerca.", "ERRORE", JOptionPane.ERROR_MESSAGE);
                   }
         
            }
        }
        else if(action.equals("CREATEPANEL"))
        {
            //view.getjPanelAdvSearch().setVisible(false);
            view.getDeleteSearch().setVisible(false);
            view.getjScrollPane1().setVisible(false);
            view.getButtonAdvGeneral().setVisible(false);
            view.getButtonCreateGeneral().setVisible(false);
            view.getTextSearchGeneral().setVisible(false);
            view.getButtonOkSearchGeneral().setVisible(false);
            view.getPanelCreateEvent().setVisible(false);
            view.getCreatePanel().setVisible(true);
        }
        else if(action.equals("BACKSECURITY"))
        {
            //view.getjPanelAdvSearch().setVisible(false);
            view.getDeleteSearch().setVisible(true);
            view.getjScrollPane1().setVisible(true);
            view.getButtonAdvGeneral().setVisible(true);
            view.getButtonCreateGeneral().setVisible(true);
            view.getTextSearchGeneral().setVisible(true);
            view.getButtonOkSearchGeneral().setVisible(true);
            view.getCreatePanel().setVisible(false);
        }
        else if(action.equals("DELETE"))
        {
            
            String deleteMessage;
            int rowCount = view.getTableSearchGeneral().getSelectedRowCount();
            if(rowCount > 1)
                deleteMessage = "Hai selezionato "+rowCount+" righe, sei sicuro di volerle eliminare tutte?";
            else
                deleteMessage = "Sei sicuro di voler eliminare la riga selezionata?";
            int answer  = JOptionPane.showConfirmDialog(view,deleteMessage,"DELETE",JOptionPane.YES_NO_OPTION);
            if(answer == 0) // ha cliccato si
            {
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
                 //se cancello le righe,risetto a false il button.
                 view.getButtonDeleteAdvSearch().setEnabled(false);
                 view.getButtonDeleteSearch().setEnabled(false);
            }
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
            Double salary;
            
            try
            {
                 salary= Double.parseDouble(salar);
                 Addetto security = new Addetto(name,surname,code,email,phone, salary,birth,username,password);
                 dao.aggiungiAddetto(security);
                 JOptionPane.showMessageDialog(view,"Inserimento avvenuto con successo","INSERT",JOptionPane.INFORMATION_MESSAGE);
                 clearAllTextCreate();
            }
            catch(NumberFormatException err)
            {
                JOptionPane.showMessageDialog(view,"Error : Impossibile convertire lo stipendio","ERROR", JOptionPane.ERROR_MESSAGE);
            }
            catch(SQLException err)
            {
               JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
            }   
        }
        else if(action.equalsIgnoreCase("SEARCH_ADVANCED"))
        {
            addetti = new HashSet<>();
            
            if(view.getTextCfGeneralSearch().getText().trim().length() != 0)
            {
                try
                {
                    addetti.add(dao.searchByTaxCode(view.getTextCfGeneralSearch().getText()));

                }
                catch(SQLException err)
                {
                   JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                    if(view.getTextNameGeneralSearch().getText().trim().length()!=0)
                    {
                        
                        try
                        {
                             if(addetti.isEmpty())
                               addetti.addAll(dao.searchByName(view.getTextNameGeneralSearch().getText()));
                             else
                                addetti.retainAll(dao.searchByName(view.getTextNameGeneralSearch().getText()));
                        }
                        catch(SQLException err)
                        {
                             JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if(view.getTextSurnameGeneralSearch().getText().trim().length() != 0)
                    {
                        try{
                           if(addetti.isEmpty()) 
                             addetti.addAll(dao.searchBySurname(view.getTextSurnameGeneralSearch().getText()));
                           else
                             addetti.retainAll(dao.searchBySurname(view.getTextSurnameGeneralSearch().getText()));

                        }
                        catch(SQLException err)
                        {
                              JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if(view.getDateFromGeneral().getDate()!= null && view.getDateToGeneral().getDate()!= null)
                    {
                        try{
                           if(addetti.isEmpty())  
                              addetti.addAll(dao.searchByBirth(view.getDateFromGeneral().getDate(),view.getDateToGeneral().getDate()));
                           else
                             addetti.retainAll(dao.searchByBirth(view.getDateFromGeneral().getDate(),view.getDateToGeneral().getDate()));
                        }
                        catch(SQLException err)
                        {
                           JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                   
                    else
                    {
                        if((view.getDateFromGeneral().getDate()== null &&  view.getDateToGeneral().getDate()!= null) || (view.getDateFromGeneral().getDate()!= null &&  view.getDateToGeneral().getDate()== null))       
                             JOptionPane.showMessageDialog(view,"Error : Riempire entrambi i campi della data o lasciarli entrambi vuoti. ","ERROR", JOptionPane.ERROR_MESSAGE);

                    }
            }
             
             view.updateTable(addetti);
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
               }
                
           }
        else if(e.getKeyChar() == '\n' && (e.getComponent()== view.getTextNameGeneralSearch() || e.getComponent()== view.getTextSurnameGeneralSearch() || e.getComponent()== view.getTextCfGeneralSearch()))
        {       
           view.getButtonOkAdvSearchGeneral().doClick();
        }
    }
   
 public void clearAllTextCreate()
 {
     view.getTextNameCreate().setText("");
     view.getTextSurnameCreate().setText("");
     view.getTextSalaryCreate().setText("");
     view.getTextEmailCreate().setText("");
     view.getTextCFCreate().setText("");
     view.getTextUsernameCreate().setText("");
     view.getTextPasswordCreate().setText("");
     view.getDateCreateAddetto().setDate(null);
     view.getTextNumberCreate().setText("");
 }
}
