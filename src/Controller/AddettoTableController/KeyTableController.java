/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ControllerAddetti.AddettoTableController;

import Model.AddettiModel;
import View.AddettiView;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;


/**
 *
 * @author Pirozzi
 */
/*
    KEY ADAPTET IMPLEMENTA KEY LISTENER.QUINDI ADDETTOTABLECONTROLLER è  UN LISTENER
*/
public class KeyTableController extends KeyAdapter{ 
    
    AddettiModel addettimod;
    AddettiView  addettiview;
    
    @Override
     public void keyReleased(java.awt.event.KeyEvent evt) 
    {
                
                if(evt.getKeyChar() == '\t' || evt.getKeyChar()=='\n')
                {
                  int scelta=JOptionPane.showOptionDialog(addettiview,"Vuoi modificare il campo selezionato?","Richiesta",JOptionPane.YES_OPTION,JOptionPane.INFORMATION_MESSAGE,null,new String[]{"Modifica","Annulla"},null);
                }
    }
    
    
    public void setModel(AddettiModel addetto)
    {
        this.addettimod = addetto;
    }
    
    public void setView(AddettiView view)
    {
       this.addettiview=view;
    }
}
