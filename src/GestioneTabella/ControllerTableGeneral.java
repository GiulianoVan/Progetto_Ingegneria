/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestioneTabella;

import Model.Addetto.AddettiModel;
import View.GeneralPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;

/**
 *
 * @author Pirozzi
 */
public class ControllerTableGeneral implements MouseListener,KeyListener
{
    private GeneralPanel view;
    private Observable model; // posso dare addettiModel
    protected int row;
    protected int column;
    
    public ControllerTableGeneral(Observable model,GeneralPanel view)
    {
        this.model = model;
        this.view= view;
        this.view.getTableSearchGeneral().addMouseListener(this);
        this.view.getTableSearchGeneral().addKeyListener(this);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        MyDefaultTableModel tab = (MyDefaultTableModel) view.getTableSearchGeneral().getModel();
            if(e.getClickCount()==2)
            {   
                row = view.getTableSearchGeneral().getSelectedRow();
                column = view.getTableSearchGeneral().getSelectedColumn();
                tab.setColumnEditable(column);
                tab.setRowEditable(row);
                view.getTableSearchGeneral().editCellAt(row, column);
            }
            else{
                     tab.setColumnEditable(-1);
                     tab.setRowEditable(-1);

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
        //mi salvo la riga e la colonna in cui si è generato l'evento.
        //Cosi se l'invio cambia la riga e la colonna in cui si è verificato,le tengo salvate.
         row = view.getTableSearchGeneral().getSelectedRow();
         column = view.getTableSearchGeneral().getSelectedColumn();

    }

   
    @Override
    public void keyReleased(KeyEvent e) {
         /*  
        if(e.getKeyChar()=='\n' && view.getTableSearchGeneral().isCellEditable(row, column)) 
        {
            MyDefaultTableModel tab = (MyDefaultTableModel) view.getTableSearchGeneral().getModel();
            model.doUpdate((String) view.getTableSearchGeneral().getValueAt(row,column).toString(),view.getTableSearchGeneral().getColumnName(column),view.getTableSearchGeneral().getModel().getValueAt(row,0).toString());
        }
        else
        {
            view.resetValueTable(row, column);
        }*/
    }
   
}
