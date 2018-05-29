/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestioneTabella;

import Model.Addetto.AddettiModel;
import Model.EventModel;
import View.GeneralPanel;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Pirozzi
 */
public class ControllerTableEvent extends ControllerTableGeneral{
    
    private EventModel model;
    private GeneralPanel view;
    boolean flag;
    
     public ControllerTableEvent(EventModel model, GeneralPanel view) 
     {
        super(model,view);
        this.model = model;
        this.view = view;
        view.addKeyListener(this);
    }
    
    

    @Override
    public void keyReleased(KeyEvent e) { //DA FARE . NON VA BENE.
       
        MyDefaultTableModel tab = (MyDefaultTableModel) view.getTableSearchGeneral().getModel();
        //SE PREMO INVIO E LA CELLA è EDITABILE.FAI UPDATE
        //ROW E COLUMN = -1 POICHE SE ENTRO QUI ,NON HO + LA CELLA EDITABILE
        if(e.getKeyChar()=='\n' && view.getTableSearchGeneral().isCellEditable(row, column)) 
        {
                tab.setColumnEditable(-1);
                tab.setRowEditable(-1);
                String value = view.getTableSearchGeneral().getValueAt(row, column).toString();
                if(!view.getTableSearchGeneral().getColumnName(column).equals("EMAIL"))
                    value = value.toUpperCase();

                if(view.getTableSearchGeneral().getColumnName(column).equals("TITOLO"))
                 {
                         flag =  validateTitolo(view.getTableSearchGeneral().getValueAt(row, column).toString());
                 }
                else if( view.getTableSearchGeneral().getColumnName(column).equals(""))

                if(flag != false)
                {
                    flag=false;
                    value= value.replace(",",".");
                    view.getTableSearchGeneral().setValueAt(value, row, column);
                    model.doUpdateEvent(value,view.getTableSearchGeneral().getColumnName(column),view.getTableSearchGeneral().getModel().getValueAt(row,tab.getId_column()).toString());
                    row = -1;
                    column=-1;
                }
                else
                {
                     System.out.println("ERRORE");   
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
            }
            //sto cambiando casella senza invio,quindi setto la cella cliccata nuovamente non editabile.
            
            
        }
          //ho confermato update o ho abbandonato la,quindi setto la cella cliccata nuovamente non editabile.
            
    }
    
    public boolean validateTitolo(String titolo)
    { 
         Pattern model = Pattern.compile("[a-z0-9,.;'\"/-_#?!]+$",Pattern.CASE_INSENSITIVE);
         Matcher t = model.matcher(titolo);        
         return t.find();
         
       
    }
}
