package BusinessComponent.Boundary;


import BusinessComponent.Controller.ControllerCRUDAddetto;
import BusinessComponent.ManagementModelTable.MyDefaultTableModel;
import Presentation.AddettiPanel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author INGSW2017_22
 */
public class BoundaryViewSecurity extends BoundaryGeneralPanel
{
    private ControllerCRUDAddetto controller;
    private AddettiPanel view;
    
    public BoundaryViewSecurity(AddettiPanel view,ControllerCRUDAddetto controller)
    {
        super(view);
        this.view = view;
        this.controller=controller;
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
            super.actionPerformed(e);
            String action = e.getActionCommand();
            String flag_search;
                        
            if(action.equalsIgnoreCase("CERCA"))
            {
                doSearch();        
            }
            
            else if(action.equalsIgnoreCase("DELETE"))
            {
                doDelete();
            }
            else if(action.equals("CREATE"))
            {
                doCreate();
            }
            
            else if(action.equalsIgnoreCase("SEARCH_ADVANCED"))
            {
                doAdvancedSearch();
            }
    
    }
    
    @Override
    public void keyReleased(KeyEvent e) 
    {
                  
        if(e.getKeyChar()=='\n' && e.getComponent()==view.getTextSearchGeneral())
        {
           doSearch();    
        }
        else if(e.getKeyChar() == '\n' && (e.getComponent()== view.getTextNameGeneralSearch() || e.getComponent()== view.getTextSurnameGeneralSearch() || e.getComponent()== view.getTextCfGeneralSearch()))
        {       
           doAdvancedSearch();
        }
    }
    
    private void doSearch()
    {
        String testo = view.getTextSearchGeneral().getText();
        if(testo.trim().length()>0)
        {
            ArrayList<String> parolechiavi;
            parolechiavi = EstraiParoleChiavi(testo);
            try{
                view.getTableSearchGeneral().setModel(controller.doSearch(parolechiavi)); //ricerca
                view.getTableSearchGeneral().getColumnModel().getColumn(2).setHeaderValue("TAX CODE");
                view.getTableSearchGeneral().getColumnModel().getColumn(7).setHeaderValue("ID CODE");
            }         
            catch(Exception ex)
            {
               JOptionPane.showMessageDialog(view,"Errore : "+ex.getMessage()+" Cannot do search.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        if(view.getTableSearchGeneral().getSelectedRow()==-1)
        {
           view.getButtonDeleteSearch().setEnabled(false);
           view.getButtonDeleteAdvSearch().setEnabled(false);
        }
    }
    
    private void doDelete()
    {
        String deleteMessage;
        int rowdeleted;
        int rowCount = view.getTableSearchGeneral().getSelectedRowCount();
        int start_selection = view.getTableSearchGeneral().getSelectedRow();
        int end_selection = rowCount+start_selection-1;
        if(rowCount > 1)
        deleteMessage = "You selected "+rowCount+" rows, are you sure that you want delete them?";
        else
        deleteMessage = "Are you sure that you want delete it?";

        int answer  = JOptionPane.showConfirmDialog(view,deleteMessage,"DELETE",JOptionPane.YES_NO_OPTION);
        if(answer == 0) // ha cliccato si
        {
            int flag_errorDelete = 1;
            for(int i = end_selection ; i>= start_selection; --i)
            {
                try {
                    controller.doDeleteAddetto(view.getTableSearchGeneral().getValueAt(i,7).toString());
                    MyDefaultTableModel tab = (MyDefaultTableModel) view.getTableSearchGeneral().getModel();
                    tab.removeRow(i);
                } 
                catch (SQLException ex)
                {
                    if(flag_errorDelete==1)
                       {
                           JOptionPane.showMessageDialog(view, "Errore : "+ex.getMessage(), "ERRORE", JOptionPane.ERROR_MESSAGE);
                           flag_errorDelete = 0;
                       }
                }
            }
            //se cancello le righe,risetto a false il button.
            view.getButtonDeleteAdvSearch().setEnabled(false);
            view.getButtonDeleteSearch().setEnabled(false);
        }        
    }
    
    private void doCreate()
    {
        String name = view.getTextNameSecurityCreate().getText();
        String surname = view.getTextSurnameCreate().getText();
        String username = view.getTextUsernameCreate().getText();
        String password = view.getTextPasswordCreate().getText();
        String code = view.getTextCFCreate().getText();
        Date birth =view.getDateCreateAddetto().getDate();
        String phone = view.getTextNumberCreate().getText();
        String email = view.getTextEmailCreate().getText();
        String salary = view.getTextSalaryCreate().getText();
        salary = salary.replace(",", ".");
        Double salar = null;
        int error_salary = 0;

        try
        {
            salar= Double.parseDouble(salary);
        }
        catch(NumberFormatException err)
        {
            if(salary.trim().length()!=0)
             JOptionPane.showMessageDialog(view,"Error : Cannot convert salary","ERROR", JOptionPane.ERROR_MESSAGE);
            else
            {
               JOptionPane.showMessageDialog(view,"Error : Salary field empty","ERROR", JOptionPane.ERROR_MESSAGE);

            }
        //se va in eccezion,mettimi errore sul salary
           error_salary = 1;
        }

        if(error_salary != 1)
        {
            try 
            {   
                 controller.createAddetto(name, surname, username, password, code, birth, phone, email,salar);
                 JOptionPane.showMessageDialog(view,"Successfull insert","INSERT",JOptionPane.INFORMATION_MESSAGE);
                 clearTextCreate();
            } 
            catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(view,"Code : "+ex.getErrorCode()+"\n"+ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }        
    }
    
    private void doAdvancedSearch()
    {
        String cf =view.getTextCfGeneralSearch().getText();
        String name = view.getTextNameGeneralSearch().getText();
        String surname = view.getTextSurnameGeneralSearch().getText();
        Date from = view.getDateFromGeneral().getDate();
        Date to = view.getDateToGeneral().getDate();
        try 
        {
            view.getTableSearchGeneral().setModel(controller.doAdvancedSearch(cf, name, surname, from, to));
            view.getTableSearchGeneral().getColumnModel().getColumn(2).setHeaderValue("TAX CODE");
            view.getTableSearchGeneral().getColumnModel().getColumn(7).setHeaderValue("ID CODE");           
        } 
        catch (SQLException ex) {
             JOptionPane.showMessageDialog(view,"Code : "+ex.getErrorCode()+"\n"+ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception ex)
        {
           JOptionPane.showMessageDialog(view,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        if(view.getTableSearchGeneral().getSelectedRow()==-1)
        {
           view.getButtonDeleteSearch().setEnabled(false);
           view.getButtonDeleteAdvSearch().setEnabled(false);
        }
    }           

    private void clearTextCreate() {
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
