/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.MODELDACANCELARE;

import Model.JavaBean.Event;
import DB.DAO.ImplEventDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Observable;
import java.util.Set;


/**
 *
 * @author giuli
 */
public class EventModel extends Observable{
    
    Set<Event> events;
    ImplEventDao evtDao;
    
    public EventModel()
    {
        events = new HashSet();
    }
    
    // metodi che il controller chiama per inserimento, cancellazione ecc...
    // ricerca su database
    
    public void notifySearchName(ArrayList<String> words)
    {
        evtDao = new ImplEventDao();
        events = evtDao.searchEventKeysWords(words);     
        setChanged();
        notifyObservers(events);
    }

     public void doUpdateEvent(String new_value,String attribute_to_change,String id)
    {
        evtDao.updateEvent(new_value,attribute_to_change,id);
    }

}
