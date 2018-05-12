/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.EventModel;
import View.EventView;
import View.LoginView;
import java.awt.event.ActionEvent;

/**
 *
 * @author MarcelloQuattromani
 */
public class SearchEventController extends GeneralController
{
    private EventModel evtModel;
    private EventView evtView;
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String action = e.getActionCommand();
        if(action.equals("searchPress"))
        {
            String nameEvent = evtView.getEventNameText();
            
        }
    }
    
    public void setModel(EventModel nuovo)
    {
        evtModel = nuovo;
        
    }
    public void setView(EventView nuovo)
    {
        evtView = nuovo;
    }
    
}
