/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.DAO;

import Model.Event;
import View.EventView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Set;

/**
 *
 * @author giuli
 */
public class ImpEventDao implements EventDao{
    
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    //override di tutti i metodi per ricercare, cancellare, modificare
    
    @Override
    public Set<Event> searchEvent()
    {
        String query="SELECT * FROM EVENT";
        String eventName = 
        
    }
    
    
    
}
