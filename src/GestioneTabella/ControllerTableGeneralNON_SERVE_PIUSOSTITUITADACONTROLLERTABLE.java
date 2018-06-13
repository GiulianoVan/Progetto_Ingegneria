/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestioneTabella;

import View.GeneralPanel;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import javax.swing.JTable;

/**
 *
 * @author Pirozzi
 */
public abstract class  ControllerTableGeneralNON_SERVE_PIUSOSTITUITADACONTROLLERTABLE implements MouseListener,KeyListener,FocusListener
{
    private GeneralPanel view;
    protected int row=-1;
    protected int column=-1;
    protected String oldvalue;
    
    public ControllerTableGeneralNON_SERVE_PIUSOSTITUITADACONTROLLERTABLE(GeneralPanel view)
    {
        this.view= view;
        this.view.getTableSearchGeneral().addMouseListener(this);
        this.view.getTableSearchGeneral().addKeyListener(this);
        this.view.getTableSearchGeneral().addFocusListener(this);
        

    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        MyDefaultTableModel tab = (MyDefaultTableModel) view.getTableSearchGeneral().getModel();
            if(e.getClickCount()==2)
            {   
               if(view.getTableSearchGeneral().getSelectedColumn()!= tab.getId_column())
                {
                    //SE CLICCO DUE VOLTE.MI SALVO I VALORI DELLA RIGA E COLONNA SELEZIONATA E LA RENDO EDITABILE
                    row = view.getTableSearchGeneral().getSelectedRow();
                    column = view.getTableSearchGeneral().getSelectedColumn();
                    tab.setColumnEditable(column);
                    tab.setRowEditable(row);
                    view.getTableSearchGeneral().editCellAt(row, column);
                    if(tab.getValueAt(row, column)!=null)
                    oldvalue=tab.getValueAt(row, column).toString();
                }
               else
                oldvalue = null;
                //se sto modificando non posso cancellare.
               view.getButtonDeleteAdvSearch().setEnabled(false);
               view.getButtonDeleteSearch().setEnabled(false);
                
            }
            else{
                    //SE PREMO UNA VOLTA SU UNA CELLA,E NON HO PREMUTO INVIO PER FARE L'UPDATE.
                    //RITORNO AL VECCHIO VALORE.
                    //ROW = -1 E COL = -1 PERCHè SE ENTRO QUI,NON HO PIU LA CELLA EDITABILE.
                   
                    view.getButtonDeleteAdvSearch().setEnabled(true);
                    view.getButtonDeleteSearch().setEnabled(true);
                    if(row != -1 && column != -1 )
                      view.resetValueTable(row, column, oldvalue);
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
        
          view.getButtonDeleteAdvSearch().setEnabled(true);
          view.getButtonDeleteSearch().setEnabled(true);
    }

    @Override
    public void focusLost(FocusEvent e) {
        
    }
   
}