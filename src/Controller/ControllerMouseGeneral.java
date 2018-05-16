/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.GeneralPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;

/**
 *
 * @author Pirozzi
 */
public class ControllerMouseGeneral extends MouseAdapter{
<<<<<<< HEAD
    //dichiarate model e view
    GeneralPanel view;
    Observable model; 

=======

    GeneralPanel view;
    Observable model; 
    
>>>>>>> c41c2e7b1fcca60396f3ce4de4bdc43f5587eaa4
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount()==1)
            view.getTextSearchGeneral().setText("");
       
    }
    
    public void setView(GeneralPanel panel)
    {
        view = panel;
    }
    
    public void setModel(Observable obs)
    {
        model = obs;
    }
    
    
    
   
    
}
