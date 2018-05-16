/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.DAO;

import DB.Database.DBConnect;
import JavaBean.Admin;
import JavaBean.Event;
import View.EventView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author giuli
 */
public class ImplEventDao implements EventDao{
    
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    //override di tutti i metodi per ricercare, cancellare, modificare
    
    @Override
    public Set<Event> searchEvent(String evtName)
    {
        con = DBConnect.getConnection();
        String query="SELECT * FROM EVENTO WHERE TITOLO=?;";
        Set<Event> events = new HashSet();
        try
        {
            ps = con.prepareStatement(query);
            ps.setString(1,evtName);
            
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                System.out.println(rs.getString(2)); // PRENDO LA COLONNA DEL TITOLO
                //events.add((Event) rs.getObject(rs.getRow()));
                // COSì NON VA BENE PERCHè rs NON CONTIENTE UN EVENTO
                // CREDO CHE DOBBIAMO CREARE UN NUOVO OGGETTO EVENTO OGNI VOLTA CON GLI ATTRIBUTI PRESI DA rs
            }
            rs.close();
            ps.close();   
            con.close();
        }
        catch(SQLException x)
        {
            System.out.println("Errore query. Impossibile  trovare l'evento."); //dettagliare errore
        }
        System.out.println(events);
        return events;
    }

    @Override
    public Event advancedSearchEvent(String evtName, String codEvt, String dateEvt, String typeEvt) 
    {
        con = DBConnect.getConnection();
        String query = "SELECT * FROM EVENTO WHERE TITOLO = ? AND IDEVENTO = ? AND DATA = ? AND EVENTOTYPE = ?;";
        try
        {
            ps = con.prepareStatement(query);
            
            ps.setString(1, evtName);
            ps.setString(2, codEvt);
            ps.setString(3, dateEvt);
            ps.setString(4, typeEvt);
            
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex)
        {
            System.out.println("Errore query. Impossibile  trovare l'evento.");
            System.err.println(ex);
        }
        return null;
    }

    @Override
    public void createEvent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateEvent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteEvent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
