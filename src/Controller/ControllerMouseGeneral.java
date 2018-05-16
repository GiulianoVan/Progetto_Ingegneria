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
    //dichiarate model e view
    GeneralPanel view;
    Observable model; 

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("ciao");
        if(e.getClickCount()==1)
            view.getTextSearchGeneral().setText("prova");
       
    }
    
   
    
}
