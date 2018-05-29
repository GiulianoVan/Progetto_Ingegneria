/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestioneTabella;

import Model.CustomerModel;
import View.GeneralPanel;
import java.awt.event.KeyEvent;

/**
 *
 * @author Pirozzi
 */
public class ControllerTableCustomer extends ControllerTableGeneral {
  
    private CustomerModel model;
    private GeneralPanel view;
    
    
    public ControllerTableCustomer(CustomerModel model, GeneralPanel view) {
        super(model,view);
        this.model = model;
        this.view = view;
        view.addKeyListener(this);
    }
    
    @Override
    public void keyReleased(KeyEvent e) { 
       
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
            
            value= value.replace(",",".");
            view.getTableSearchGeneral().setValueAt(value, row, column);
            model.doUpdateCustomer(value,view.getTableSearchGeneral().getColumnName(column),view.getTableSearchGeneral().getModel().getValueAt(row,tab.getId_column()).toString());
            row = -1;
            column=-1;
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
    
}
