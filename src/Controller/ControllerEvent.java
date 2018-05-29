/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.DAO.EventDao;
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
    
    GeneralPanel view;
    EventDao dao;
    Set<Event> event;

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
            if(view.getTextSearchGeneral().getText().trim().length() == 0)
            {
              JOptionPane.showMessageDialog(view, "Impossibile cercare senza nessun valore.\nRiprovare inserendo un valore nel campo apposito.", "ERRORE", JOptionPane.ERROR_MESSAGE);

            }
            else
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
            //se tt è vuoto,impossibile effettuare la ricerca.
           //altrimenti creo una mappa campo-valore e la passo al model x fare l'interrogazione.
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) 
    {
        
        if(view.getTextNameGeneralSearch().getText().trim().length()>0)
           {
             if(e.getKeyChar()=='\n')
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
