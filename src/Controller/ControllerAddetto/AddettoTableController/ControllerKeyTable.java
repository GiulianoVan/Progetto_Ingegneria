/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ControllerAddetto.AddettoTableController;


import Model.Addetto.AddettiModel;
import View.AddettiView;
import View.GeneralPanel;
import java.awt.event.KeyAdapter;
import javax.swing.JOptionPane;


/**
 *
 * @author Pirozzi
 */
/*
    KEY ADAPTET IMPLEMENTA KEY LISTENER.QUINDI ADDETTOTABLECONTROLLER è  UN LISTENER
*/
public class ControllerKeyTable extends KeyAdapter{ 
    
    AddettiModel model;
    GeneralPanel  view;
    
    @Override
     public void keyReleased(java.awt.event.KeyEvent evt) 
    {
            int row = view.getTableSearchGeneral().getSelectedRow();
            int col = view.getTableSearchGeneral().getSelectedColumn();
                
                if(evt.getKeyChar()=='\n')
                {
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
                      //view.resetCellEditable();
                }
    }
    
    public void setModel(AddettiModel addetto)
    {
        this.model = addetto;
    }
    
    public void setView(GeneralPanel view)
    {
       this.view =view;
    }
}
