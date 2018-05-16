/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ControllerAddetto.AddettoTableController;

import Model.Addetto.AddettiModel;
import View.AddettiPanel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Pirozzi
 */
public class ControllerFocusTableAddetto extends FocusAdapter {

    private AddettiModel model;
    private AddettiPanel view;

    public AddettiModel getModel() {
        return model;
    }

    public void setModel(AddettiModel model) {
        this.model = model;
    }

    public AddettiPanel getView() {
        return view;
    }

    public void setView(AddettiPanel view) {
        this.view = view;
    }
    
    @Override
    public void focusLost(FocusEvent e) {
        int row = view.getTableSearchGeneral().getSelectedRow();
        int col = view.getTableSearchGeneral().getSelectedColumn();
        System.out.println("Ev PReso fuori");
        if(view.getTableSearchGeneral().isCellEditable(row,col))
        {
            System.out.println("Ev PReso dentro");
            int scelta=JOptionPane.showOptionDialog(view,"Vuoi modificare il campo selezionato?","Richiesta",JOptionPane.YES_OPTION,JOptionPane.INFORMATION_MESSAGE,null,new String[]{"Modifica","Annulla"},null);
                      
                      if(scelta==0)
                      { 
                          row = view.getTableSearchGeneral().getSelectedRow();
                          col = view.getTableSearchGeneral().getSelectedColumn();
                          String text = (String) view.getTableSearchGeneral().getValueAt(row, col);
                          String field = view.getTableSearchGeneral().getColumnName(col);
                          String id = (String) view.getTableSearchGeneral().getModel().getValueAt(row,7);//7 PERCHè è LA POSIZIONE DELL'ID.CHE INVISIBILE ALL'INTERNO DELLA JTABLE
                          model.doUpdate(text,field,id);
                      }
                      else
                      {
                            view.resetValueTable();
                      }
        }
    }
 
    
}
