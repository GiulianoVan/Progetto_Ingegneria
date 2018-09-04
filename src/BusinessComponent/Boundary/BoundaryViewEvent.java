package BusinessComponent.Boundary;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import BusinessComponent.Controller.ControllerCRUDEvent;
import BusinessComponent.ManagementModelTable.MyDefaultTableModel;
import Presentation.EventPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

/**
 *
 * @author INGSW2017_22
 */
public class BoundaryViewEvent extends BoundaryGeneralPanel implements ItemListener{ //o estende la generale ?


    private EventPanel view;
    private int flag_errorDelete = 1;
    private int flagtesting=0;
    private String flag_search= "";
    private ControllerCRUDEvent controller;
    
    public BoundaryViewEvent(EventPanel view,ControllerCRUDEvent contr)
    {
        super(view);
        this.view = view;
        this.controller = contr;
        this.view.getButtonOkSearchGeneral().addActionListener(this);
        this.view.getTextSearchGeneral().addKeyListener(this);
        this.view.getButtonCreate().addActionListener(this);
        this.view.getComboTypeEventCreate().addItemListener(this);
        this.view.getButtonOkAdvSearchGeneral().addActionListener(this);//button ricerca avanzata
        this.view.getComboTypeGeneralSearch().addItemListener(this);
      
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        super.actionPerformed(e);//fai quello del pradre e poi questo.
        String action = e.getActionCommand();
        if(action.equals("CERCA"))
        {
            doSearch();    
        }
        else if(action.equals("DELETE"))
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
           doSearch();
                
        }
        else if(e.getKeyChar() == '\n' && (e.getComponent()== view.getTextNameGeneralSearch() || e.getComponent()== view.getTextSurnameGeneralSearch() || e.getComponent()== view.getTextCfGeneralSearch()))
        {       
            doAdvancedSearch();
        }
    }
   
    public void doSearch()
    {
        flag_search="cerca";
        String testo = view.getTextSearchGeneral().getText();
        if(testo.trim().length()>0)
        {
            ArrayList<String> parolechiavi;
            parolechiavi = EstraiParoleChiavi(testo);
            try{
                view.getTableSearchGeneral().setModel(controller.doSearch(parolechiavi)); //ricerca
                view.getTableSearchGeneral().getColumnModel().getColumn(1).setHeaderValue("TYPE");
                view.getTableSearchGeneral().getColumnModel().getColumn(2).setHeaderValue("KIND");
                view.getTableSearchGeneral().getColumnModel().getColumn(4).setHeaderValue("PLACE");
                view.getTableSearchGeneral().getColumnModel().getColumn(6).setHeaderValue("ID CODE");
            }         
            catch(Exception ex)
            {
               JOptionPane.showMessageDialog(view,"Errore : "+ex.getMessage()+". Cannot do search.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if(view.getTableSearchGeneral().getSelectedRow()==-1)
        {
            view.getButtonDeleteSearch().setEnabled(false);
            view.getButtonDeleteAdvSearch().setEnabled(false);
        }
    }
    
    public void doDelete()
    {
        String deleteMessage;
        int rowdeleted;
        int rowCount = view.getTableSearchGeneral().getSelectedRowCount();
        int start_selection = view.getTableSearchGeneral().getSelectedRow();
        int end_selection = rowCount+start_selection-1;
        if(rowCount > 1)
            deleteMessage = "You selected "+rowCount+" rows, are you sure that you want delete them? \nThe associated tickets will also be deleted";
        else
            deleteMessage = "Are you sure that you want delete it?\nThe associated tickets will also be deleted";

        int answer  = JOptionPane.showConfirmDialog(view,deleteMessage,"DELETE",JOptionPane.YES_NO_OPTION);
        if(answer == 0) // ha cliccato si
        {
            int flag_errorDelete = 1;
            for(int i = end_selection ; i>= start_selection; --i)
            {
                try {
                    controller.doDeleteEvent(view.getTableSearchGeneral().getValueAt(i,6).toString());
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
   
    public void doCreate()
    {
            String titolo = view.getTextNameEventCreate().getText();
            Date data = view.getDateCreateEvent().getDate();
            String event_type = view.getComboTypeEventCreate().getSelectedItem().toString();
            String kind_type = view.getComboGenEventCreate().getSelectedItem().toString();
            String description = view.getDescriptionArea().getText();
            String luogo = view.getTextLuogoCreateEvent().getText();            
            try
            {
                
                controller.createEvent(titolo, description, event_type, kind_type, data, luogo);
                JOptionPane.showMessageDialog(view,"Inserimento avvenuto con successo","INSERT",JOptionPane.INFORMATION_MESSAGE);
                
                clearAllTextCreate();
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(view,"Error : "+ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
            }
    }
    
    public void doAdvancedSearch()
    {
                      
        flag_search="search_advanced";
        String title = view.getTextNameGeneralSearch().getText();
        String type = view.getComboTypeGeneralSearch().getSelectedItem().toString();
        Date from = view.getDateFromGeneral().getDate();
        Date to = view.getDateToGeneral().getDate();
        String kind = view.getComboGenereType().getSelectedItem().toString();

        try 
        {
            view.getTableSearchGeneral().setModel(controller.doAdvancedSearch(title, type, from, to, kind)); 
            view.getTableSearchGeneral().getColumnModel().getColumn(1).setHeaderValue("TYPE");
            view.getTableSearchGeneral().getColumnModel().getColumn(2).setHeaderValue("KIND");
            view.getTableSearchGeneral().getColumnModel().getColumn(4).setHeaderValue("PLACE");
            view.getTableSearchGeneral().getColumnModel().getColumn(6).setHeaderValue("ID CODE");           
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(view,"Error : "+ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);

        }
        if(view.getTableSearchGeneral().getSelectedRow()==-1)
        {
           view.getButtonDeleteSearch().setEnabled(false);
           view.getButtonDeleteAdvSearch().setEnabled(false);
        }
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) 
    {
        
        if(e.getItemSelectable() == view.getComboTypeEventCreate())
        {  
           loadComboTypeEvent(view.getComboTypeEventCreate(),view.getComboGenEventCreate());
        }
        
        else if( e.getItemSelectable().equals(view.getComboTypeGeneralSearch()))
        {
            loadComboTypeEvent(view.getComboTypeGeneralSearch(),view.getComboGenereType());  
        }
    }
    
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
        else if(comboType.getSelectedItem().equals("OTHER"))
        {
            comboKind.addItem("OTHER");
        }
        else
        {
            comboKind.addItem("NOT SELECTED");
        }
                    
        
    }

    private void clearAllTextCreate() 
    {
        view.getTextNameEventCreate().setText("");
        view.getDescriptionArea().setText("");
        view.getTextLuogoCreateEvent().setText("");
        view.getDateCreateEvent().setDate(null);
    }
}
