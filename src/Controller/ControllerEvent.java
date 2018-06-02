/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.DAO.EventDao;
import GestioneTabella.MyDefaultTableModel;
import Model.MODELDACANCELARE.EventModel;
import Model.JavaBean.Event;
import View.GeneralPanel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Pirozzi
 */
public class ControllerEvent extends ControllerGeneral{
    
    private GeneralPanel view;
    private EventDao dao;
    private Set<Event> event;
    private int flag_errorDelete = 1;
    
    public ControllerEvent(EventDao dao, GeneralPanel view) {
        super(view);
        this.dao = dao;
        this.view = view;
        this.view.getButtonOkSearchGeneral().addActionListener(this);
        this.view.getTextSearchGeneral().addKeyListener(this);
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
        else if(action.equals("CREATE"))
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
    
    
}
