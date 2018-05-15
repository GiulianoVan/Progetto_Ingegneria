/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Addetto.AddettiModel;
import Model.CustomerModel;
import Model.EventModel;
import View.EventView;
import View.GeneralPanel;
import View.GeneralView;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Observable;

/**
 *
 * @author Pirozzi
 */
public class Controller extends GeneralController{

    GeneralPanel view;
    Observable model;
    
    public void setView(GeneralPanel y)
    {
        view = y;
    }
   
    public void setModel(Observable x)
    {
        model = x;    
    }
    
     @Override
    public void actionPerformed(ActionEvent e){

        //SE il comando si chiama CREA ADDETTO fai questo
        String action = e.getActionCommand();
        
        if(model instanceof EventModel)
        {
            // controlli Eventi
        }
        else if(model instanceof AddettiModel)
        {
            // controlli Addetti
        }
        else
        {
            // controlli Clienti
        }
        
        if(action.equals("ADVSEARCH"))
        {
            view.getButtonAdvGeneral().setVisible(false);
            view.getButtonCreateGeneral().setVisible(false);
            view.getTextSearchGeneral().setVisible(false);
            view.getButtonOkSearchGeneral().setVisible(false);
            view.getjPanelAdvSearch().setVisible(true);
        }
        else if(action.equals("BACKSEARCH"))
        {
            view.getButtonAdvGeneral().setVisible(true);
            view.getButtonCreateGeneral().setVisible(true);
            view.getTextSearchGeneral().setVisible(true);
            view.getButtonOkSearchGeneral().setVisible(true);
            view.getjPanelAdvSearch().setVisible(false);
       }
    };

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        Object object;
        
        if(e.getKeyChar() == '\n')
        {
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
