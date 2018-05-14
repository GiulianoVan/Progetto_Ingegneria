/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ControllerAddetti;

import Model.Addetto.AddettiModel;
import View.AddettiView;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Pirozzi
 */
public class MouseControllerAddetti extends MouseAdapter{

    AddettiModel model;
    AddettiView  view;

    public AddettiModel getModel() {
        return model;
    }

    public void setModel(AddettiModel model) {
        this.model = model;
    }

    public AddettiView getView() {
        return view;
    }

    public void setView(AddettiView view) {
        this.view = view;
    }
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount()==2)
        {
            
        }
       
    }
}
