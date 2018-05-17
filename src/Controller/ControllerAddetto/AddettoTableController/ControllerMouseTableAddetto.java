/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ControllerAddetto.AddettoTableController;

import GestioneTabella.MyTableCellRenderer;
import Model.Addetto.AddettiModel;
import GestioneTabella.MyDefaultTableModel;
import View.AddettiView;
import View.GeneralPanel;
import View.GeneralView;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;

/**
 *
 * @author Pirozzi
 */
public class ControllerMouseTableAddetto extends MouseAdapter{

    AddettiModel model;
    GeneralPanel view;

    public AddettiModel getModel() {
        return model;
    }

    public void setModel(AddettiModel model) {
        this.model = model;
    }

 

    public void setView(GeneralPanel view) {
        this.view = view;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount()==2)
        {
          
        }       
    }
    
  
    
}    
