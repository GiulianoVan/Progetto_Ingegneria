/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.DAO;

import DB.Database.DBConnect;
import Model.JavaBean.Event;
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
    
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
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
    public int updateEvent(String new_value,String attribute_to_change,String id) {
        
        String sql = "UPDATE EVENTO SET "+attribute_to_change+ " = '"+ new_value+"' WHERE IDEVENTO = ?;";
        int executeUpdate = 0;
        try 
        {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            
            //SETTO TUTTI I ? CON I VALORI DINAMICAMENTE. 
              //ps.setString(1,new_value.toUpperCase());
            
              
              ps.setString(1,id.toUpperCase());
              executeUpdate = ps.executeUpdate();
              con.close();
              ps.close();
              rs.close();

        }
        catch (SQLException ex) {
            System.out.println("Errore!\nAggiornamento fallito.");
        }
        return executeUpdate;
      }

    @Override
    public int deleteEvent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Event> searchEventKeysWords(ArrayList<String> words) 
        {
            Set<Event> result = new HashSet<>();
            String sql = "SELECT TITOLO,EVENTOTYPE,GENERETYPE,DATA,NOMELUOGO,CAP,DESCRIZIONE,IDEVENTO FROM EVENTO WHERE ";
            //CREO LA STRINGA DINAMICAMENTE AGGIUNGENDO LA STESSA STRINGA PER QUANTE SONO LE PAROLE CHIAVI
            for(String word : words)
            {
             sql += "TITOLO LIKE ? OR EVENTOTYPE LIKE ? OR GENERETYPE LIKE ? OR NOMELUOGO LIKE ? OR ";
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
                  result.add(new Event(rs.getString(8),rs.getString(1),rs.getString(7),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getString(5)));
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
    
}    
    

