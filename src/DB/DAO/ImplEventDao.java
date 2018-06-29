/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.DAO;

import DB.Database.DBConnect;
import Model.JavaBean.Addetto;
import Model.JavaBean.Event;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author giuli
 */
public class ImplEventDao implements EventDao{
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    //override di tutti i metodi per ricercare, cancellare, modificare
    /*
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
*/
    @Override
    public Event advancedSearchEvent(String evtName, String codEvt, String dateEvt, String typeEvt) throws SQLException 
    {
        con = DBConnect.getConnection();
        String query = "SELECT * FROM EVENTO WHERE TITLE = ? AND IDEVENTO = ? AND DATE = ? AND EVENT_TYPE = ?;";
        
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
      
        return null;
    }

    @Override
    public void createEvent(Event event) throws SQLException{
        
        String sql = "INSERT INTO EVENTO(TITLE,EVENT_TYPE,KIND_TYPE,DATE,PLACE_NAME,DESCRIPTION) VALUES (?,?,?,?,?,?);";
        con = DBConnect.getConnection();
        ps=con.prepareStatement(sql);
        ps.setString(1,event.getTitle());
        ps.setString(2, event.getTypeEvent());
        ps.setString(3,event.getTypeGender());
        if(event.getDataEvent()!=null)
        {
            ps.setTimestamp(4, new Timestamp(event.getDataEvent().getTime()));
        }
        else
        {
            ps.setTimestamp(4, null);
        }
        
        ps.setString(5,event.getPlaceName());
        ps.setString(6,event.getDescription());
        
        ps.executeUpdate();
        con.close();
        ps.close();
        
    }

    @Override
    public int updateEvent(String new_value,String attribute_to_change,String id) throws SQLException  {
        
        int executeUpdate = 0;
        
        String sql = "UPDATE EVENTO SET "+attribute_to_change+ " = '"+ new_value+"' WHERE IDEVENTO = ?;";
        executeUpdate = 0;
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            
            //SETTO TUTTI I ? CON I VALORI DINAMICAMENTE. 
              //ps.setString(1,new_value.toUpperCase());
            
              
              ps.setString(1,id.toUpperCase());
              executeUpdate = ps.executeUpdate();
              con.close();
              ps.close();
              rs.close();
              
        return executeUpdate;
      }

    @Override
    public int deleteEvent(String idEvent) throws SQLException {
            
            String sql = "DELETE FROM EVENTO WHERE IDEVENTO = ?";
            con = DBConnect.getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1,idEvent);
            int del= ps.executeUpdate();//ritorna 1 se viene eliminato un addetto o 0 se nn viene eliminato
            con.close();
            ps.close();
            return del;
    }

    @Override
    public Set<Event> searchEventKeysWords(ArrayList<String> words) 
        {
            Set<Event> result = new HashSet<>();
            String sql = "SELECT TITLE,EVENT_TYPE,KIND_TYPE,DATE,PLACE_NAME,ZIP_CODE,DESCRIPTION,IDEVENTO FROM EVENTO WHERE ";
            //CREO LA STRINGA DINAMICAMENTE AGGIUNGENDO LA STESSA STRINGA PER QUANTE SONO LE PAROLE CHIAVI
            for(String word : words)
            {
             sql += "TITLE LIKE ? OR EVENT_TYPE LIKE ? OR KIND_TYPE LIKE ? OR PLACE_NAME LIKE ? OR ";
            }
            sql = sql.substring(0,sql.length()-3); //TOLGO ULTIMO OR.
            sql += ";"; //AGGIUNGO PUNTO E VIRGOLA ALLA FINE
            try 
            {
                con = DBConnect.getConnection();
                ps = con.prepareStatement(sql);

                //SETTO TUTTI I ? CON I VALORI DINAMICAMENTE. 
                for(int i = 1;i<=words.size()*4;++i)
                { 
                  int j = (i-1)/4;
                  ps.setString(i,"%"+words.get(j)+"%");
                }
                //EFFETTUO QUERY E LA METTO NEL RESULTSET
                rs = ps.executeQuery();
                while(rs.next())
                {
                  result.add(new Event(rs.getString(8),rs.getString(1),rs.getString(7),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(6),rs.getString(5)));
                }
                con.close();
                ps.close();
                rs.close();
            }
            catch (SQLException ex) {
                System.out.println("Errore in ricerca_paroleChiavi");
            }

            return result;
    }

    @Override
    public int deleteEvent(Event event) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Event> searchByTypeEvent(String type_event) throws SQLException {
        
        Set<Event> result = new HashSet<>();
        
        String sql = "SELECT TITLE,EVENT_TYPE,KIND_TYPE,DATE,PLACE_NAME,ZIP_CODE,DESCRIPTION,IDEVENTO FROM EVENTO WHERE EVENT_TYPE = ?";

        con = DBConnect.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1,type_event);
        rs = ps.executeQuery();
      
        while(rs.next())
        {
             result.add(new Event(rs.getString(8),rs.getString(1),rs.getString(7),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(6),rs.getString(5)));
        }
            
        return result;
    }

    @Override
    public Set<Event> searchByKindEvent(String kind_event) throws SQLException {
            
        Set<Event> result = new HashSet<>();
        
        String sql = "SELECT TITLE,EVENT_TYPE,KIND_TYPE,DATE,PLACE_NAME,ZIP_CODE,DESCRIPTION,IDEVENTO FROM EVENTO WHERE KIND_EVENT = ?";

        con = DBConnect.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1,kind_event);
        rs = ps.executeQuery();
      
        while(rs.next())
        {
             result.add(new Event(rs.getString(8),rs.getString(1),rs.getString(7),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(6),rs.getString(5)));
        }
            
        return result;
    }

    @Override
    public Set<Event> searchByTitle(String title) throws SQLException {
 
        Set<Event> result = new HashSet<>();
        
        String sql = "SELECT TITLE,EVENT_TYPE,KIND_TYPE,DATE,PLACE_NAME,ZIP_CODE,DESCRIPTION,IDEVENTO FROM EVENTO WHERE TITLE = ?";

        con = DBConnect.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1,title);
        rs = ps.executeQuery();
      
        while(rs.next())
        {
             result.add(new Event(rs.getString(8),rs.getString(1),rs.getString(7),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(6),rs.getString(5)));
        }
            
        return result;
    }

    @Override
    public Set<Event> searchByPlace(String place) throws SQLException {
        
          Set<Event> result = new HashSet<>();
        
        String sql = "SELECT TITLE,EVENT_TYPE,KIND_TYPE,DATE,PLACE_NAME,ZIP_CODE,DESCRIPTION,IDEVENTO FROM EVENTO WHERE PLACE_NAME = ?";

        con = DBConnect.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1,place);
        rs = ps.executeQuery();
      
        while(rs.next())
        {
             result.add(new Event(rs.getString(8),rs.getString(1),rs.getString(7),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(6),rs.getString(5)));
        }
            
        return result;
    }

    @Override
    public Set<Event> searchByProvince(String province) throws SQLException {
        
        Set<Event> result = new HashSet<>();
        
        String sql = "SELECT TITLE,EVENT_TYPE,KIND_TYPE,DATE,PLACE_NAME,ZIP_CODE,DESCRIPTION,IDEVENTO FROM EVENTO WHERE PROVINCE = ?";

        con = DBConnect.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1,province);
        rs = ps.executeQuery();
      
        while(rs.next())
        {
             result.add(new Event(rs.getString(8),rs.getString(1),rs.getString(7),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(6),rs.getString(5)));
        }
            
        return result;
    }

    @Override
    public Set<Event> searchByDate(java.util.Date from, java.util.Date to) throws SQLException{
            
         
        Set<Event> result = new HashSet<>();
        
        String sql = "SELECT TITLE,EVENT_TYPE,KIND_TYPE,DATE,PLACE_NAME,ZIP_CODE,DESCRIPTION,IDEVENTO FROM EVENTO WHERE DATE >= ? AND DATE <= ?";

        con = DBConnect.getConnection();
        ps = con.prepareStatement(sql);
        ps.setTimestamp(1,new Timestamp(from.getTime()));
        ps.setTimestamp(2,new Timestamp(to.getTime()));

        rs = ps.executeQuery();
      
        while(rs.next())
        {
             result.add(new Event(rs.getString(8),rs.getString(1),rs.getString(7),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(6),rs.getString(5)));
        }
            
        return result;
    }
    
}    
    

