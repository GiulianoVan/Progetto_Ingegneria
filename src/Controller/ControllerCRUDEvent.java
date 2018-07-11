/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.DAO.EventDao;
import GestioneTabella.MyDefaultTableModel;
import Model.JavaBean.Event;
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
    
    private GeneralPanel view;
    private EventDao dao;
    private Set<Event> event;
    private int flag_errorDelete = 1;
    
    public ControllerCRUDEvent(EventDao dao, GeneralPanel view) {
        super(view);
        this.dao = dao;
        this.view = view;
        this.view.getButtonOkSearchGeneral().addActionListener(this);
        this.view.getTextSearchGeneral().addKeyListener(this);
        this.view.getButtonCreate().addActionListener(this);
        this.view.getComboTypeEventCreate().addItemListener(this);
        this.view.getButtonOkAdvSearchGeneral().addActionListener(this);//button ricerca avanzata

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
            view.getjScrollPane1().setVisible(false);
            view.getDeleteSearch().setVisible(false);
            view.getButtonAdvGeneral().setVisible(false);
            view.getButtonCreateGeneral().setVisible(false);
            view.getTextSearchGeneral().setVisible(false);
            view.getButtonOkSearchGeneral().setVisible(false);
            view.getPanelCreateSecurity().setVisible(false);
            view.getCreatePanel().setVisible(true);
        }
        else if(action.equals("BACKCREATEEVENT"))
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
                view.clearAllTextCreate();
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(view,"Error : "+ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        else if(action.equalsIgnoreCase("SEARCH_ADVANCED"))
        {
            System.out.println("CIAO");
            event = new HashSet<>();
            if(view.getTextNameGeneralSearch().getText().trim().length()!=0)
                {
                    
                    try
                    {
                         if(event.isEmpty())
                           event.addAll(dao.searchByTitle(view.getTextNameGeneralSearch().getText()));
                         else
                            event.retainAll(dao.searchByTitle(view.getTextNameGeneralSearch().getText()));
                         System.out.println(view.getTextNameGeneralSearch().getText());
                    }
                    catch(SQLException err)
                    {
                         JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            if(!view.getComboTypeGeneralSearch().getSelectedItem().toString().equalsIgnoreCase("Select Type Event..."))
             {
                    try{
                       if(event.isEmpty()) 
                         event.addAll(dao.searchByTypeEvent(view.getComboTypeGeneralSearch().getSelectedItem().toString().toUpperCase()));
                       else
                         event.retainAll(dao.searchByTypeEvent(view.getComboTypeGeneralSearch().getSelectedItem().toString().toUpperCase()));
                    }
                    catch(SQLException err)
                    {
                          JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
                    }
             }
            if(view.getDateFromGeneral().getDate()!= null && view.getDateToGeneral().getDate()!= null)
             {
                    try{
                       if(event.isEmpty())  
                          event.addAll(dao.searchByDate(view.getDateFromGeneral().getDate(),view.getDateToGeneral().getDate()));
                       else
                         event.retainAll(dao.searchByDate(view.getDateFromGeneral().getDate(),view.getDateToGeneral().getDate()));
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
               
            if(!view.getComboGenereType().getSelectedItem().toString().equalsIgnoreCase("Genere"))
             {
                    try{
                            if(event.isEmpty()) 
                               event.addAll(dao.searchByKindEvent(view.getComboGenereType().getSelectedItem().toString()));
                            else
                               event.retainAll(dao.searchByKindEvent(view.getComboGenereType().getSelectedItem().toString()));
                       }
                    catch(SQLException err)
                    {
                         JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
                    }
             }
            
            
              
            view.updateTable(event);
        }
        
    }
    
    @Override
    public void keyReleased(KeyEvent e) 
    {
          
         if(e.getKeyChar()=='\n')
        { 

            if(view.getTextSearchGeneral().getText().trim().length() > 0)
                {
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
        
        view.loadCombo();
    }
    
    
}
