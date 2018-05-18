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
import javax.swing.CellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

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

    @Override
    public void mouseClicked(MouseEvent e) {
       
        
        int row;
        int column;
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
    }

   
    @Override
    public void keyReleased(KeyEvent e) {
        int row = view.getTableSearchGeneral().getSelectedRow();
        int column = view.getTableSearchGeneral().getSelectedColumn();
        boolean editable= view.getTableSearchGeneral().isCellEditable(row, column);
        if(e.getKeyChar()== '\n' && editable)
        {
            MyDefaultTableModel tab = (MyDefaultTableModel) view.getTableSearchGeneral().getModel();
            System.out.println("Row : "+row+" Column : "+column);
            //nell'ultima colonna ci saranno sempre gli id.che sono nascosti.
           System.out.println(tab.getId_column());
        //model.doUpdate((String) view.getTableSearchGeneral().getValueAt(row,column).toString(),view.getTableSearchGeneral().getColumnName(column),view.getTableSearchGeneral().getModel().getValueAt(row,0).toString());
        }
        else if(e.getKeyChar()!= '\n' && view.getTableSearchGeneral().isCellEditable(row, column))
        {
             view.resetValueTable();
        }
        else{}
    }
    

 

  
}
