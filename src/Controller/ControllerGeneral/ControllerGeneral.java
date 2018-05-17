/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ControllerGeneral;

import View.GeneralPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;

/**
 *
 * @author Pirozzi
 */
public class ControllerGeneral implements ActionListener,MouseListener,FocusListener{

    GeneralPanel view;
    Observable model;
    
    public ControllerGeneral(Observable model,GeneralPanel view)
    {
        this.model = model;
        this.view =view;
        view.getButtonAdvGeneral().addActionListener(this);
        view.getButtonBackSearchGeneral().addActionListener(this);
        view.getTextSearchGeneral().addFocusListener(this);
        view.getTextSearchGeneral().addMouseListener(this);
        
    }
 
    
     @Override
    public void actionPerformed(ActionEvent e){

        //SE il comando si chiama CREA ADDETTO fai questo
        String action = e.getActionCommand();
    
        if(action.equals("ADVSEARCH"))
        {
            view.changeAdvGeneral();
            
        }
        else if(action.equals("BACKSEARCH"))
        {
            view.backNormalSearch();
        }
    };

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
         if(view.getTextSearchGeneral().getText().equals(""))
        {
            view.setNameSearch();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
            if(e.getClickCount()==1)
            view.getTextSearchGeneral().setText("");
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
