/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestioneTabella;

import Model.Addetto.AddettiModel;
import View.AddettiPanel;
import View.GeneralPanel;
import View.GeneralView;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pirozzi
 */
public class ControllerTable implements MouseListener,KeyListener
{
    GeneralPanel view;
    AddettiModel model; // posso dare addettiModel
    public ControllerTable(AddettiModel model,GeneralPanel view)
    {
        this.model = model;
        this.view= view;
        this.view.getTableSearchGeneral().addMouseListener(this);
        this.view.getTableSearchGeneral().addKeyListener(this);
    }
    /*
    @Override
    public void focusGained(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusLost(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
    @Override
    public void mouseClicked(MouseEvent e) {
          int row;
          int column;
            if(e.getClickCount()==1)
            {   
                row = view.getTableSearchGeneral().getSelectedRow();
                column = view.getTableSearchGeneral().getSelectedColumn();
                model.getTab().setRowEditable(row);
                model.getTab().setColumnEditable(column);
                System.out.println(model.getTab().isCellEditable(row, column));
                MyTableCellRenderer tabRenderer = (MyTableCellRenderer) view.getTableSearchGeneral().getCellRenderer(row, column);         
            }
            else{}
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
        
        if(e.getKeyChar()== '\n')
        {
            
        }
        else
        {
            view.setL
        }
    }
  
}
