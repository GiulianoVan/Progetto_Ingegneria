/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.DAO.EventDao;
import GestioneTabella.MyDefaultTableModel;
import Model.JavaBean.Event;
import View.EventPanel;
import View.GeneralPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Pirozzi
 */
public class ControllerCRUDEvent extends ControllerGeneral implements ItemListener{
    
    private EventPanel view;
    private EventDao dao;
    private Set<Event> event;
    private int flag_errorDelete = 1;
    private String flag_search = "";
    
    public ControllerCRUDEvent(EventDao dao, EventPanel view) {
        super(view);
        this.dao = dao;
        this.view = view;
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
            flag_search = "cerca";
            if(view.getTextSearchGeneral().getText().trim().length() > 0)
            {
                
                 try {
                    ArrayList<String> parolechiavi;
                    String testo = view.getTextSearchGeneral().getText();
                    parolechiavi = EstraiParoleChiavi(testo);
                    event = dao.searchEventKeysWords(parolechiavi);
                    view.updateTable(event);
                } catch (SQLException ex) {
                
                    JOptionPane.showMessageDialog(view, "Mancata comunicazione col database.\nImpossibile effetuare la ricerca.", "ERRORE", JOptionPane.ERROR_MESSAGE);

                }
            }
        }
        else if(action.equals("CREATEPANEL"))
        {
            //view.getjPanelAdvSearch().setVisible(false);
            showCreatePanel();
            
        }
        else if(action.equals("BACKCREATEEVENT"))
        {
            //view.getjPanelAdvSearch().setVisible(false);
            showBackCreateEvent();
         }
        
        else if(action.equals("DELETE"))
        {
            doDelete();
            
        }
        else if(action.equalsIgnoreCase("CREATE"))//insert evento.
        {
            //MANCA LUOGO, DA CAMBIARE IN STRINGA.X ORA SARA A NULL.
            String titolo = view.getTextNameEventCreate().getText();
            Date data = view.getDateCreateEvent().getDate();
            String event_type = view.getComboTypeEventCreate().getSelectedItem().toString();
            String kind_type = view.getComboGenEventCreate().getSelectedItem().toString();
            String description = view.getDescriptionArea().getText();
            String luogo = view.getTextLuogoCreateEvent().getText();
            
            
            try
            {
                Event event = new Event(titolo,description,event_type, kind_type, data, luogo);
                dao.createEvent(event);
                JOptionPane.showMessageDialog(view,"Inserimento avvenuto con successo","INSERT",JOptionPane.INFORMATION_MESSAGE);
                
                if(flag_search.equalsIgnoreCase("cerca"))
                    view.getButtonOkSearchGeneral().doClick();
                else if(flag_search.equalsIgnoreCase("search_advanced"))
                    view.getButtonOkAdvSearchGeneral().doClick();
                view.clearAllTextCreate();
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(view,"Error : "+ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        else if(action.equalsIgnoreCase("SEARCH_ADVANCED"))
        {
            flag_search="search_advanced";
            String title = view.getTextNameGeneralSearch().getText();
            String type = view.getComboTypeGeneralSearch().getSelectedItem().toString();
            Date from = view.getDateFromGeneral().getDate();
            Date to = view.getDateToGeneral().getDate();
            String kind = view.getComboGenereType().getSelectedItem().toString();
           
            event = advancedSearch(title,type,from,to,kind);
            view.updateTable(event);
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) 
    {
          
         if(e.getKeyChar()=='\n' && e.getComponent().equals(view.getTextSearchGeneral()))
        { 

            if(view.getTextSearchGeneral().getText().trim().length() > 0)
                {
                    flag_search = "cerca";
                   try {
                     String testo = view.getTextSearchGeneral().getText();
                     ArrayList<String> parolechiavi = EstraiParoleChiavi(testo);
                     event = dao.searchEventKeysWords(parolechiavi);
                     view.updateTable(event);
                   } catch (SQLException ex) {
                      JOptionPane.showMessageDialog(view, "Mancata comunicazione col database.\nImpossibile effetuare la ricerca.", "ERRORE", JOptionPane.ERROR_MESSAGE);
                     } 
               }
               
        }
             
     }

    @Override
    public void itemStateChanged(ItemEvent e) {
        
        if(e.getItemSelectable() == view.getComboTypeEventCreate())
        {
            
           view.loadComboTypeEvent(view.getComboTypeEventCreate(),view.getComboGenEventCreate());
        }
        
        else if( e.getItemSelectable().equals(view.getComboTypeGeneralSearch()))
        {
            view.loadComboTypeEvent(view.getComboTypeGeneralSearch(),view.getComboGenereType());
             
        }
          

    }
    
    public Set<Event> advancedSearch(String title,String type,Date from,Date to,String kind)
    {
            
            Set<Event> event = new HashSet<>();
            int intersect = 0;
            if(title.trim().length()!=0)
                {
                    
                    try
                    {
                         
                           event.addAll(dao.searchByTitle(title));
                           intersect = 1;
                    }
                    catch(SQLException err)
                    {
                         JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            if(!type.equalsIgnoreCase("Select Type Event..."))
             {
                    try{
                       if(event.isEmpty() && intersect == 0) 
                         event.addAll(dao.searchByTypeEvent(type.toUpperCase()));
                       else
                         event.retainAll(dao.searchByTypeEvent(type.toUpperCase()));
                       
                       intersect = 1;
                    }
                    catch(SQLException err)
                    {
                          JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
                    }
             }
            if(from != null && to != null)
            {
                try{
                   if(event.isEmpty() && intersect ==0)  
                      event.addAll(dao.searchByDate(from,to));
                   else
                     event.retainAll(dao.searchByDate(from,to));
                
                   intersect = 1;
                }
                catch(SQLException err)
                {
                   JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                    if((from == null &&  to!= null) || (from!= null &&  to== null))       
                         JOptionPane.showMessageDialog(view,"Fill both date fields. The search will not consider the date fields.","INFO", JOptionPane.INFORMATION_MESSAGE);

            }
               
            if(!kind.equalsIgnoreCase("Genere"))
             {
                    try{
                            if(event.isEmpty() && intersect ==0) 
                               event.addAll(dao.searchByKindEvent(kind));
                            else
                               event.retainAll(dao.searchByKindEvent(kind));
                            
                            intersect = 1;
                    }
                    catch(SQLException err)
                    {
                         JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
                    }
             }
            return event;
    }

    private void doDelete() {
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
                        dao.deleteEvent((tab.getValueAt(i,tab.getId_column()).toString()));
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
                 view.getButtonDeleteAdvSearch().setEnabled(false);
                 view.getButtonDeleteSearch().setEnabled(false);
            }
    }

    private void showCreatePanel() {
            view.getjScrollPane1().setVisible(false);
            view.getDeleteSearch().setVisible(false);
            view.getButtonAdvGeneral().setVisible(false);
            view.getButtonCreateGeneral().setVisible(false);
            view.getTextSearchGeneral().setVisible(false);
            view.getButtonOkSearchGeneral().setVisible(false);
            view.getPanelCreateSecurity().setVisible(false);
            view.getCreatePanel().setVisible(true);
    }

    private void showBackCreateEvent() {
            view.getDeleteSearch().setVisible(true);
            view.getjScrollPane1().setVisible(true);
            view.getButtonAdvGeneral().setVisible(true);
            view.getButtonCreateGeneral().setVisible(true);
            view.getTextSearchGeneral().setVisible(true);
            view.getButtonOkSearchGeneral().setVisible(true);
            view.getCreatePanel().setVisible(false);

    }
}
