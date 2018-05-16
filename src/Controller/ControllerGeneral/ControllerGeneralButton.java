/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ControllerGeneral;

import View.GeneralPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
