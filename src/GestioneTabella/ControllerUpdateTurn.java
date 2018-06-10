/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestioneTabella;

import DB.DAO.AddettoDao;
import Model.JavaBean.ManagementTurn;
import View.ManagementTurnView;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Pirozzi
 */
public class ControllerUpdateTurn extends ControllerTableGeneral{
    
    private ManagementTurn dao;
    private ManagementTurnView view;
   
    public ControllerUpdateTurn(ManagementTurn dao,ManagementTurnView view) {
        //super(view);
        this.dao = dao;
        this.view = view;
    }
    
      @Override
    public void keyReleased(KeyEvent e) {
       /*
        MyDefaultTableModel tab = (MyDefaultTableModel) view.getTableSearchGeneral().getModel();
        //SE PREMO INVIO E LA CELLA è EDITABILE.FAI UPDATE
        //ROW E COLUMN = -1 POICHE SE ENTRO QUI ,NON HO + LA CELLA EDITABILE
        if(e.getKeyChar()=='\n' && view.getTableSearchGeneral().isCellEditable(row, column) && row != -1 && column != -1) 
        {
            try {
                tab.setColumnEditable(-1);
                tab.setRowEditable(-1);
                String value = view.getTableMenagementEvents().getValueAt(row, column).toString();
                if(!view.getTableMenagementEvents().getColumnName(column).equals("EMAIL"))
                    value = value.toUpperCase();
                value= value.replace(",",".");
                view.getTableMenagementEvents().setValueAt(value, row, column);
                //dao.(value,view.getTableMenagementEvents().getColumnName(column),view.getTableSearchGeneral().getModel().getValueAt(row,tab.getId_column()).toString());
                row = -1;
                column=-1;
            } catch (SQLException ex) {
                  String msg = ex.getMessage();
                  JOptionPane.showMessageDialog(view,msg, "Errore :" + ex.getErrorCode(),JOptionPane.ERROR_MESSAGE);
                //  view.resetValueTable(row, column,oldvalue);//da fare.
  
            }
        }
        else
        {
            
           //se non premo invio,RESETTO LA CELLA AL VALORE PRECEDENTE
            //ROW = -1 E COL = -1 PERCHè UNA VOLTA QUI NON HO PIU LA CELLA EDITABILE,solo col doppio click è editabile
            if(view.getTableSearchGeneral().getSelectedRow() != row || view.getTableSearchGeneral().getSelectedColumn() != column)
            {  
                tab.setColumnEditable(-1);
                tab.setRowEditable(-1);
               if(row!= -1 && column != -1)
                  view.resetValueTable(row, column,oldvalue);
               row = -1;
               column = -1;
               view.getButtonDeleteAdvSearch().setEnabled(true);
               view.getButtonDeleteSearch().setEnabled(true);
            }
            //sto cambiando casella senza invio,quindi setto la cella cliccata nuovamente non editabile.
            
            
        }
          //ho confermato update o ho abbandonato la,quindi setto la cella cliccata nuovamente non editabile.
    */        
    }
    
    
    
}
