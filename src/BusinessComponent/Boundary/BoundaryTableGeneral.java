/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessComponent.Boundary;

import BusinessComponent.ManagementModelTable.MyDefaultTableModel;
import Presentation.GeneralPanel;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;

/**
 *
 * @author INGSW2017_22
 */
public abstract class BoundaryTableGeneral implements MouseListener,KeyListener,FocusListener {
   
    protected int row=-1;
    protected int column=-1;
    protected String oldvalue;
    protected JTable table;
    private GeneralPanel view;
    public BoundaryTableGeneral(JTable table)
    {
        this.table = table;
        this.table.addMouseListener(this);
        this.table.addKeyListener(this);
        this.table.addKeyListener(this);

    }
    //costruttore per elementi che si abilitato e disattivano in base ad azioni sulla tabella.
   
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        MyDefaultTableModel tab = (MyDefaultTableModel) table.getModel();
            if(e.getClickCount()==2 && table.getSelectedColumn()!= tab.getId_column())
            {
               if(table.getSelectedColumn()!= tab.getId_column())
                {
                    //SE CLICCO DUE VOLTE.MI SALVO I VALORI DELLA RIGA E COLONNA SELEZIONATA E LA RENDO EDITABILE
                   //--------->CAMBIATO QUA IN CONVERT INVECE DI GETSELECTED.
                    row = table.getSelectedRow();
                    column = table.getSelectedColumn();
                    tab.setColumnEditable(column);
                    tab.setRowEditable(row);
                    //---> edit cell resta per una questione grafica alla cella selezionata
                    table.editCellAt(table.getSelectedRow(), table.getSelectedColumn());
                    if(tab.getValueAt(row, column)!=null)
                    oldvalue=tab.getValueAt(row, column).toString();
                }
               else
                    oldvalue = null;
                //se sto modificando non posso cancellare.
                if(column != tab.getId_column())
                {
                    disactiveButtonDelete();
                }
                
            }
            else{
                    //SE PREMO UNA VOLTA SU UNA CELLA,E NON HO PREMUTO INVIO PER FARE L'UPDATE.
                    //RITORNO AL VECCHIO VALORE.
                    //ROW = -1 E COL = -1 PERCHè SE ENTRO QUI,NON HO PIU LA CELLA EDITABILE.
                   
                   activeButtonDelete();
                    
                    if(row != -1 && column != -1 )
                      resetValueTable(row, column, oldvalue);
                     tab.setColumnEditable(-1);
                     tab.setRowEditable(-1);
                     row = -1;
                     column=-1;
                     
            }
          
    }
    @Override
    public void mousePressed(MouseEvent e) {
     
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       }

    @Override
    public void mouseEntered(MouseEvent e) {
                
                

    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
     
    }

    @Override
    public void keyPressed(KeyEvent e) {
       

    }

   
    @Override
    public void keyReleased(KeyEvent e) {
      
    }

    @Override
    public void focusGained(FocusEvent e) {
            
        activeButtonDelete();    
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        
        if(table.getSelectedRow() == -1)
            disactiveButtonDelete();
    }
   
    public void resetValueTable(int row,int column,String oldvalue) {
            
            table.getModel().setValueAt((String) oldvalue, row, column);
     }  

    public abstract void disactiveButtonDelete();
    public abstract void activeButtonDelete();

}
