/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ControllerGeneral;

import View.GeneralPanel;
import View.GeneralView;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Observable;

/**
 *
 * @author MarcelloQuattromani
 */
public class ControllerGeneralFocus extends FocusAdapter
{
    GeneralPanel view;
    Observable model;
    

    @Override
    public void focusLost(FocusEvent e)
    {
        
        if(view.getTextSearchGeneral().getText().equals(""))
        {
            view.setNameSearch();
        }
    }
    
    public void setView(GeneralPanel view)
    {
        this.view = view;
    }
    
    public void setModel(Observable model)
    {
        this.model = model;
    }
    
}
