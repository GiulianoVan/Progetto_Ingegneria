/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestioneTabella;

import DB.DAO.EventDao;
import Model.MODELDACANCELARE.AddettiModel;
import Model.MODELDACANCELARE.EventModel;
import View.GeneralPanel;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Pirozzi
 */
public class ControllerTableEvent extends ControllerTableGeneral{
    
    private EventDao dao;
    private GeneralPanel view;
    boolean flag;
    
     public ControllerTableEvent(EventDao dao, GeneralPanel view) 
     {
        super(view);
        this.dao = dao;
        this.view = view;
        view.addKeyListener(this);
    }
    
    

    @Override
    public void keyReleased(KeyEvent e) {
       
        MyDefaultTableModel tab = (MyDefaultTableModel) view.getTableSearchGeneral().getModel(); 
        //SE PREMO INVIO E LA CELLA è EDITABILE.FAI UPDATE
        //ROW E COLUMN = -1 POICHE SE ENTRO QUI ,NON HO + LA CELLA EDITABILE
        if(e.getKeyChar()=='\n' && view.getTableSearchGeneral().isCellEditable(row, column) && row != -1 && column !=-1) 
        {
                tab.setColumnEditable(-1);
                tab.setRowEditable(-1);
                String value = view.getTableSearchGeneral().getValueAt(row, column).toString();
                if(!view.getTableSearchGeneral().getColumnName(column).equals("EMAIL"))
                    value = value.toUpperCase();

                
                    try {
                        flag=false;
                        value= value.replace(",",".");
                        view.getTableSearchGeneral().setValueAt(value, row, column);
                        dao.updateEvent(value,view.getTableSearchGeneral().getColumnName(column),view.getTableSearchGeneral().getModel().getValueAt(row,tab.getId_column()).toString());
                        if(view.getTableSearchGeneral().getModel().getColumnName(column).equals("EVENT_TYPE") )
                        {
                               view.getTableSearchGeneral().setValueAt(null,row,2);
                        }
                        row = -1;
                        column=-1;
                        
                    } catch (SQLException ex) {
                        String event_type = view.getTableSearchGeneral().getModel().getValueAt(row,1).toString();
                        
                        if(ex.getErrorCode() == 1265)
                        {
                            if(!(event_type.equalsIgnoreCase("SPORT")) && !(event_type.equalsIgnoreCase("CONCERT")) && !(event_type.equalsIgnoreCase("THEATER")) && !(event_type.equalsIgnoreCase("CINEMA")) && !(event_type.equalsIgnoreCase("OTHER")))
                                JOptionPane.showMessageDialog(view,"Event type not valid.\nYou can choose one of the following:\n'SPORT', 'CONCERT', 'THEATER', 'CINEMA','OTHER'", "ERROR :" + ex.getErrorCode(),JOptionPane.ERROR_MESSAGE);
                            else if(event_type.equalsIgnoreCase("SPORT"))
                              JOptionPane.showMessageDialog(view,"Error! Event type is : "+event_type+".\nYou can choose one of the following kind type:\n'FOOTBALL', 'TENNIS', 'BASKET', 'VOLLEYBALL', 'SWIMMING','OTHER'", "ERROR :" + ex.getErrorCode(),JOptionPane.ERROR_MESSAGE);
                            else if(event_type.equalsIgnoreCase("CONCERT"))
                              JOptionPane.showMessageDialog(view,"Error! Event type is : "+event_type+".\nYou can choose one of the following kind type:\n'POP AND ROCK', 'METAL', 'OTHER'", "ERROR :" + ex.getErrorCode(),JOptionPane.ERROR_MESSAGE);
                            else if(event_type.equalsIgnoreCase("THEATER"))
                              JOptionPane.showMessageDialog(view,"Error! Event type is : "+event_type+".\nYou can choose one of the following kind type:\n'MUSICAL','CABARET','OTHER' ", "ERROR :" + ex.getErrorCode(),JOptionPane.ERROR_MESSAGE);
                            else if(event_type.equalsIgnoreCase("CINEMA"))
                              JOptionPane.showMessageDialog(view,"Error! Event type is : "+event_type+".\nYou can choose one of the following kind type:\n'COMEDY','DRAMATIC','HORROR','OTHER' ", "ERROR :" + ex.getErrorCode(),JOptionPane.ERROR_MESSAGE);
                            }
                        else
                        {
                             String msg = ex.getMessage();
                             JOptionPane.showMessageDialog(view,msg, "Errore :" + ex.getErrorCode(),JOptionPane.ERROR_MESSAGE);
                        }
                        view.resetValueTable(row, column,oldvalue);
                        
                    }
                
        }
        else
        {
            
           //se non premo invio,RESETTO LA CELLA AL VALORE PRECEDENTE
            //ROW = -1 E COL = -1 PERCHè UNA VOLTA QUI NON HO PIU LA CELLA EDITABILE
            if(view.getTableSearchGeneral().getSelectedRow() != row || view.getTableSearchGeneral().getSelectedColumn() != column)
            {  
                tab.setColumnEditable(-1);
                tab.setRowEditable(-1);
               if(row!= -1 && column != -1)
                  view.resetValueTable(row, column,oldvalue);
               row = -1;
               column = -1;
               //se non sto piu nella cella editabile,perche mi sono spostato con un tasto,risetto a true il pulsante delete
               view.getButtonDeleteAdvSearch().setEnabled(true);
               view.getButtonDeleteSearch().setEnabled(true);
            }
            //sto cambiando casella senza invio,quindi setto la cella cliccata nuovamente non editabile.
            
            
        }
          //ho confermato update o ho abbandonato la,quindi setto la cella cliccata nuovamente non editabile.
            
    }
    
}
