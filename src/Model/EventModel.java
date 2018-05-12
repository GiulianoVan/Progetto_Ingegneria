/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DB.DAO.ImpEventDao;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Observable;
import java.util.Set;


/**
 *
 * @author giuli
 */
public class EventModel extends Observable{
    
    // insieme di eventi
    // Set<Event> eventi;
    // ImpEvent evento = new ImpEvent();
    Set<Event> events;
    ImpEventDao evtDao;
    
    public EventModel()
    {
        events = new HashSet();
    }
    
    // metodi che il controller chiama per inserimento, cancellazione ecc...
    // ricerca su database
    
    public void notifySearchName(String eventName) throws SQLException
    {
        evtDao = new ImpEventDao();
        events = evtDao.searchEvent(eventName);
        
        System.out.println(events); // stampa tutto il Set...voglio vedere se prende le cose.
        
        int x = 0;
        if(!events.isEmpty())
            x=1;
        setChanged();
        notifyObservers(x);
    }
}
