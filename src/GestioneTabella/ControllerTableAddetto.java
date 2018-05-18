/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestioneTabella;

import Model.Addetto.AddettiModel;
import View.GeneralPanel;
import java.awt.event.KeyEvent;

/**
 *
 * @author Pirozzi
 */
public class ControllerTableAddetto extends ControllerTableGeneral{
    
    private AddettiModel model;
    private GeneralPanel view;
    
    
    public ControllerTableAddetto(AddettiModel model, GeneralPanel view) {
        super(model,view);
        this.model = model;
        this.view = view;
        view.addKeyListener(this);
    }
    
    

    @Override
    public void keyReleased(KeyEvent e) { //DA FARE . NON VA BENE.
       /*
        MyDefaultTableModel tab = (MyDefaultTableModel) view.getTableSearchGeneral().getModel();

        if(e.getKeyChar()=='\n' && view.getTableSearchGeneral().isCellEditable(row, column)) 
        {
            model.doUpdate((String) view.getTableSearchGeneral().getValueAt(row,column).toString(),view.getTableSearchGeneral().getColumnName(column),view.getTableSearchGeneral().getModel().getValueAt(row,0).toString());
            tab.setColumnEditable(-1);
            tab.setRowEditable(-1);
        }
        else
        {
            
            
            //se si è cambiata cella,senza premere invio,ma un altro tasto
            //devo risettare la vecchia cella al vecchio valore,ma solo quando quella abbandonata è editabile.    
            if(view.getTableSearchGeneral().isCellEditable(row,column));
            {  
               tab.setColumnEditable(-1);
               tab.setRowEditable(-1);
               view.resetValueTable(row, column);
            }
            //sto cambiando casella senza invio,quindi setto la cella cliccata nuovamente non editabile.
            
            
        }
          //ho confermato update o ho abbandonato la,quindi setto la cella cliccata nuovamente non editabile.
            */
    }
    
}
