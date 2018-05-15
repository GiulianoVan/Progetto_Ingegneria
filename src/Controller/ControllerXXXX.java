/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.EventModel;
import View.EventView;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author Pirozzi
 */
public class ControllerXXXX extends GeneralController{

    EventView x;
    EventModel model;
    
    public void setView(EventView y)
    {
        x=y;
    }
   
    public void setModel(EventModel x)
    {
        model = x;
    }
    
     @Override
    public void actionPerformed(ActionEvent e){
    
        //SE il comando si chiama CREA ADDETTO fai questo
        String action = e.getActionCommand();
        if(action.equals("ADVS"))
        {
            x.getButtonAdvSearch().setVisible(false);
            x.getButtonCreateEvent().setVisible(false);
            x.getTextSearchEvent().setVisible(false);
            x.getjPanelAdvSearch().setVisible(true);
            x.getButtonOkSearchEvent().setVisible(false);
        }
        else if(action.equals("BACKS"))
        {
            x.getButtonAdvSearch().setVisible(true);
            x.getButtonCreateEvent().setVisible(true);
            x.getTextSearchEvent().setVisible(true);
            x.getjPanelAdvSearch().setVisible(false);
            x.getButtonOkSearchEvent().setVisible(true);
        }
    
    };
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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
    
}
