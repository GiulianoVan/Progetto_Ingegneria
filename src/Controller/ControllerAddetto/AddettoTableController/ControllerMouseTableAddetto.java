/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ControllerAddetto.AddettoTableController;

import Model.Addetto.AddettiModel;
import Model.MyDefaultTableModel;
import View.AddettiView;
import View.GeneralView;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Pirozzi
 */
public class ControllerMouseTableAddetto extends MouseAdapter{

    AddettiModel model;
    GeneralView view;

    public AddettiModel getModel() {
        return model;
    }

    public void setModel(AddettiModel model) {
        this.model = model;
    }

 

    public void setView(GeneralView view) {
        this.view = view;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount()==2)
        {
            int riga = view().getSelectedRow();
            int col = view.getTabellaAddetto().getSelectedColumn();
            MyDefaultTableModel tab = (MyDefaultTableModel) view.getTabellaAddetto().getModel();
            tab.setRowEditable(riga);
            tab.setColumnEditable(col);
            tab.isCellEditable(riga,col);
            
        }
       
    }
}
