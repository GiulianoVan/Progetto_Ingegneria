/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ControllerAddetti;

import Controller.GeneralController;
import Model.AddettiModel;
import View.AddettiView;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Pirozzi
 */
public class ControllerTextAddetti extends GeneralController{
    
    AddettiView view;
    AddettiModel model;
  

    @Override
    public void keyReleased(KeyEvent e) {
        
      
           if(view.getCercaText().trim().length()>0)
           {
             if(e.getKeyChar()=='\n')
            {
                String testo = view.getCercaText();
                ArrayList<String> parole  = EstraiParoleChiavi(testo);
                model.doSearch(parole);
            }
           }
        
    }
    
    public void setModel(AddettiModel model)
    {
        this.model = model;
    }
    
    public void setView(AddettiView view)
    {
        this.view = view;
    }
    
}
