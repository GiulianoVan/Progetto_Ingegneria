/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddettoTableController;


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
                
                if(evt.getKeyChar()=='\n')
                {
                      int scelta=JOptionPane.showOptionDialog(view,"Vuoi modificare il campo selezionato?","Richiesta",JOptionPane.YES_OPTION,JOptionPane.INFORMATION_MESSAGE,null,new String[]{"Modifica","Annulla"},null);
                      if(scelta==1)
                      {
                          model.doUpdate("Nuovo testo","Campo modificato","Id dell'addetto OR evento OR cliente dacambiare");//STRINGA DA SOSTITUIRE.
                      }
                      else
                      {
                          //risetta JTable al valore precedente.Come ? 
                      }
                
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
