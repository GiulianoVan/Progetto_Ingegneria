/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.GeneralPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Pirozzi
 */
public class ControllerButton implements ActionListener {

    GeneralPanel view;
    
    public void actionPerformed(ActionEvent e) {
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
   
    }
    
    
}
