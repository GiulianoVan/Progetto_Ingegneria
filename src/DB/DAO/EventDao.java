/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.DAO;

import Model.JavaBean.Event;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author MarcelloQuattromani
 */
public interface EventDao
{
    //public Set<Event> searchEvent(String evtName);
    public Event advancedSearchEvent(String evtName, String codEvt, String dateEvt, String typeEvt) throws SQLException;
    public void createEvent(Event event) throws SQLException;
    public int updateEvent(String new_value,String attribute_to_change,String id) throws SQLException;
    public int updateEvent(Event e) throws SQLException;
    public int deleteEvent(Event event) throws SQLException;  
    public Set<Event> searchEventKeysWords(ArrayList<String> words ) throws SQLException;
    public int deleteEvent(String idEvent) throws SQLException;  
    public Set<Event> searchByTypeEvent(String type_event) throws SQLException;
    public Set<Event> searchByKindEvent(String kind_event) throws SQLException;
    public Set<Event> searchByTitle(String title) throws SQLException;
    public Set<Event> searchByPlace(String place) throws SQLException;
    public Set<Event> searchByProvince(String province) throws SQLException ;
    public Set<Event> searchByDate(Date from,Date to) throws SQLException;



}
