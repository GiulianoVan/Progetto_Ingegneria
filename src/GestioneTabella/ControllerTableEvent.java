/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestioneTabella;

import DB.DAO.EventDao;
import View.GeneralPanel;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Pirozzi
 */
public class ControllerTableEvent extends ControllerTable{
    
    private EventDao dao;
    private GeneralPanel view;
    boolean flag;
    
     public ControllerTableEvent(EventDao dao, GeneralPanel view) 
     {
        super(view.getTableSearchGeneral(),new HashMap<String,Component>());
        comp.put("button1",view.getButtonDeleteAdvSearch());
        comp.put("button2",view.getButtonDeleteSearch());
        this.dao = dao;
        this.view = view;
        this.view.addKeyListener(this);
    }
    
    

    @Override
    public void keyReleased(KeyEvent e) {
       
        MyDefaultTableModel tab = (MyDefaultTableModel) table.getModel(); 
        //SE PREMO INVIO E LA CELLA è EDITABILE.FAI UPDATE
        //ROW E COLUMN = -1 POICHE SE ENTRO QUI ,NON HO + LA CELLA EDITABILE
        if(e.getKeyChar()=='\n' && table.isCellEditable(row, column) && row != -1 && column !=-1) 
        {
                tab.setColumnEditable(-1);
                tab.setRowEditable(-1);
                String value = table.getValueAt(row, column).toString();
                if(!table.getColumnName(column).equals("EMAIL"))
                    value = value.toUpperCase();

                
                    try {
                        flag=false;
                        value= value.replace(",",".");
                        table.setValueAt(value, row, column);
                        dao.updateEvent(value,table.getColumnName(column),table.getModel().getValueAt(row,tab.getId_column()).toString());
                        if(table.getModel().getColumnName(column).equals("EVENT_TYPE") )
                        {
                               table.setValueAt(null,row,2);
                        }
                        row = -1;
                        column=-1;
                        
                    } catch (SQLException ex) {
                        String event_type = table.getModel().getValueAt(row,1).toString();
                        
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
                        resetValueTable(row, column,oldvalue);
                        
                    }
                
        }
        else
        {
            
           //se non premo invio,RESETTO LA CELLA AL VALORE PRECEDENTE
            //ROW = -1 E COL = -1 PERCHè UNA VOLTA QUI NON HO PIU LA CELLA EDITABILE
            if(table.getSelectedRow() != row || view.getTableSearchGeneral().getSelectedColumn() != column)
            {  
                tab.setColumnEditable(-1);
                tab.setRowEditable(-1);
               if(row!= -1 && column != -1)
                  resetValueTable(row, column,oldvalue);
               row = -1;
               column = -1;
               //se non sto piu nella cella editabile,perche mi sono spostato con un tasto,risetto a true il pulsante delete
               for(String s : comp.keySet())
                   comp.get(s).setEnabled(true);
            }
            //sto cambiando casella senza invio,quindi setto la cella cliccata nuovamente non editabile.
            
            
        }
          //ho confermato update o ho abbandonato la,quindi setto la cella cliccata nuovamente non editabile.
            
    }
    
}
