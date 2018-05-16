/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author Pirozzi
 */
public class ProvaController implements TableModelListener{

    
    @Override
    public void tableChanged(TableModelEvent e) {
            if(e.getType() == 1)
            {
                
            }
    }
    
}
