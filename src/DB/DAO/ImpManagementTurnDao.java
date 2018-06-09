/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.DAO;

import DB.Database.DBConnect;
import Model.JavaBean.Addetto;
import Model.JavaBean.Event;
import Model.JavaBean.ManagementTurn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Pirozzi
 */
public class ImpManagementTurnDao implements ManagementTurnDao{

   private Connection con;
   private PreparedStatement ps;
   private ResultSet rs;
    
    @Override
    public Set<ManagementTurn> getTurnAddetto(Addetto addetto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 /*   @Override
    public Set<ManagementTurn> getTurnAddetto(String idAddetto) throws SQLException {
       
       Set<ManagementTurn> result = new HashSet();
       String sql = "SELECT A.NAME,A.SURNAME,A.TAX_CODE,A.EMAIL,A.PHONE,A.SALARY,A.BIRTH,A.IDSICUREZZA ,"
               + "E.TITLE,E.EVENT_TYPE,E.KIND_TYPE,E.PLACE_NAME,E.DESCRIPTION,E.IDEVENTO,E.DATE "
               + "T.START,T.END"
               + "FROM GESTIONE_TURNO T,ADDSICUREZZA A,EVENTO E WHERE A.IDSICUREZZA = ? ";
       
       con = DBConnect.getConnection();
       ps = con.prepareStatement(sql);
       ps.setString(1,idAddetto);
       rs = ps.executeQuery();
       
       while(rs.next())
       {
           
           result.add(new ManagementTurn( 
                   new Addetto(rs.getString("NAME"),rs.getString("SURNAME"),rs.getString("TAX_CODE"),rs.getString("EMAIL"),rs.getString("PHONE"),rs.getDouble("SALARY"),rs.getDate("BIRTH"), rs.getString("IDSICUREZZA"))
                  ,new Event(rs.getString("IDEVENTO"),rs.getString("TITLE"),rs.getString("DESCRIPTION"),rs.getString("EVENT_TYPE"),rs.getString("KIND_TYPE"),rs.getDate("DATE"),"0000", rs.getString("PLACE_NAME"))
                  ,rs.getTime("START")
                  ,rs.getTime("END")));
       }
       
       return result;
    }
*/
    @Override
    public Set<ManagementTurn> getTurnEvent(Event event) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

    @Override
    public int insertTurn(Addetto addetto, Event event, Time start, Time end) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteTurn(Addetto addetto, Event event, Time start, Time end) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<ManagementTurn> getTurnEvent(String idEvent) throws SQLException {
     
       Set<ManagementTurn> result = new HashSet();
       String sql = "SELECT A.NAME,A.SURNAME,A.TAX_CODE,A.EMAIL,A.PHONE,A.SALARY,A.BIRTH,A.IDSICUREZZA ,"
               + "E.TITLE,E.EVENT_TYPE,E.KIND_TYPE,E.PLACE_NAME,E.DESCRIPTION,E.IDEVENTO,E.DATE "
               + "T.START,T.END"
               + "FROM GESTIONE_TURNO T,ADDSICUREZZA A,EVENTO E WHERE E.IDEVENTO = ? ";
       
       con = DBConnect.getConnection();
       ps = con.prepareStatement(sql);
       ps.setString(1,idEvent);
       rs = ps.executeQuery();
       
       while(rs.next())
       {
           
           result.add(new ManagementTurn( 
                   new Addetto(rs.getString("NAME"),rs.getString("SURNAME"),rs.getString("TAX_CODE"),rs.getString("EMAIL"),rs.getString("PHONE"),rs.getDouble("SALARY"),rs.getDate("BIRTH"), rs.getString("IDSICUREZZA"))
                  ,new Event(rs.getString("IDEVENTO"),rs.getString("TITLE"),rs.getString("DESCRIPTION"),rs.getString("EVENT_TYPE"),rs.getString("KIND_TYPE"),rs.getDate("DATE"),"0000", rs.getString("PLACE_NAME"))
                  ,rs.getTime("START")
                  ,rs.getTime("END")));
       }
       
       return result;
    }

    @Override
    public Set<ManagementTurn> getTurnAddetto(String cf) throws SQLException {
          Set<ManagementTurn> result = new HashSet();
       String sql = "SELECT A.NAME,A.SURNAME,A.TAX_CODE,A.EMAIL,A.PHONE,A.SALARY,A.BIRTH,A.IDSICUREZZA ,"
               + "E.TITLE,E.EVENT_TYPE,E.KIND_TYPE,E.PLACE_NAME,E.DESCRIPTION,E.IDEVENTO,E.DATE "
               + "T.START,T.END"
               + "FROM GESTIONE_TURNO T,ADDSICUREZZA A,EVENTO E WHERE A.TAX_CODE = ? ";
       
       con = DBConnect.getConnection();
       ps = con.prepareStatement(sql);
       ps.setString(1,cf);
       rs = ps.executeQuery();
       
       while(rs.next())
       {
           
           result.add(new ManagementTurn( 
                   new Addetto(rs.getString("NAME"),rs.getString("SURNAME"),rs.getString("TAX_CODE"),rs.getString("EMAIL"),rs.getString("PHONE"),rs.getDouble("SALARY"),rs.getDate("BIRTH"), rs.getString("IDSICUREZZA"))
                  ,new Event(rs.getString("IDEVENTO"),rs.getString("TITLE"),rs.getString("DESCRIPTION"),rs.getString("EVENT_TYPE"),rs.getString("KIND_TYPE"),rs.getDate("DATE"),"0000", rs.getString("PLACE_NAME"))
                  ,rs.getTime("START")
                  ,rs.getTime("END")));
       }
       
       return result;
    }
    
}
