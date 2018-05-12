/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.DAO;

import Model.Event;
import java.util.Set;

/**
 *
 * @author MarcelloQuattromani
 */
public interface EventDao
{
    public Set<Event> searchEvent();
    public Event advancedSearchEvent();
    public void createEvent();
    public void updateEvent();
    public void deleteEvent();  
    
}
