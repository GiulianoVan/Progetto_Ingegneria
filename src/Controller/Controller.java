/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.EventModel;
import View.EventView;
import View.GeneralPanel;
import View.GeneralView;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author Pirozzi
 */
public class Controller extends GeneralController{

    GeneralPanel view;
    EventModel model;
    //CIAO
    
    public void setView(GeneralPanel y)
    {
        view=y;
    }
   
    public void setModel(EventModel x)
    {
        model = x;
    }
    
     @Override
    public void actionPerformed(ActionEvent e){
    
        /*
        textSearchEvent.setVisible(false);
        buttonAdvSearch.setVisible(false);
        buttonCreateEvent.setVisible(false);
        buttonOkSearchEvent.setVisible(false);
        jPanelAdvSearch.setVisible(true);
        */
        //SE il comando si chiama CREA ADDETTO fai questo
        String action = e.getActionCommand();
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
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        e.getID();
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
        System.out.println(e.paramString());
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
