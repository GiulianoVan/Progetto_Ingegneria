/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerGeneral;

import Model.Addetto.AddettiModel;
import Model.CustomerModel;
import Model.EventModel;
import View.EventView;
import View.GeneralPanel;
import View.GeneralView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Observable;

/**
 *
 * @author Pirozzi
 */
public class ControllerGeneralButton implements ActionListener{

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
    
        if(action.equals("ADVSEARCH"))
        {
            view.changeAdvGeneral();
            
        }
        else if(action.equals("BACKSEARCH"))
        {
            view.backNormalSearch();
        }
    };

   
}
