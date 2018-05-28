/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.DAO;

import Model.JavaBean.Event;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author MarcelloQuattromani
 */
public interface EventDao
{
    //public Set<Event> searchEvent(String evtName);
    public Event advancedSearchEvent(String evtName, String codEvt, String dateEvt, String typeEvt);
    public void createEvent();
    public int updateEvent(String new_value,String attribute_to_change,String id);
    public int deleteEvent();  
    public Set<Event> searchEventKeysWords(ArrayList<String> words );
}
