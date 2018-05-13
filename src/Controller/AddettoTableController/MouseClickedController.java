/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ControllerAddetti.AddettoTableController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Pirozzi
 */
public class MouseClickedController extends MouseAdapter{

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount()==2)
        {
            //vuoi eliminare ? se si,elimina.Altrimenti non eliminare
        }
        if(e.getClickCount() == 1)
        {
            
        }
    }
}
