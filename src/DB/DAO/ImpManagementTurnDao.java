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

    public int deleteTurn(Integer idTurn) throws SQLException
    {
        String sql = "DELETE FROM GESTIONE_TURNO WHERE TURN_NUMBER = ?";
        con = DBConnect.getConnection();
        ps = con.prepareStatement(sql);
        ps.setInt(1,idTurn);
        return ps.executeUpdate();
    }
    
    @Override
    public Set<ManagementTurn> getTurnEvent(String idEvent) throws SQLException {
     
       Set<ManagementTurn> result = new HashSet();
       String sql = "SELECT A.NAME,A.SURNAME,A.TAX_CODE,A.EMAIL,A.PHONE,A.SALARY,A.BIRTH,A.IDSICUREZZA ,"
               + "E.TITLE,E.EVENT_TYPE,E.KIND_TYPE,E.PLACE_NAME,E.DESCRIPTION,E.IDEVENTO,E.DATE,"
               + "T.START,T.END,T.TURN_NUMBER "
               + " FROM GESTIONE_TURNO T JOIN ADDSICUREZZA A ON T.ADDSICUREZZA=A.IDSICUREZZA JOIN EVENTO E ON T.EVENTO = E.IDEVENTO WHERE E.IDEVENTO = ? ";
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
                  ,rs.getTime("END")
                  ,rs.getInt("TURN_NUMBER")
                  ));
       }
       
       return result;
    }

    @Override
    public Set<ManagementTurn> getTurnAddetto(String cf) throws SQLException {
          Set<ManagementTurn> result = new HashSet();
       String sql = "SELECT A.NAME,A.SURNAME,A.TAX_CODE,A.EMAIL,A.PHONE,A.SALARY,A.BIRTH,A.IDSICUREZZA,"
               + "E.TITLE,E.EVENT_TYPE,E.KIND_TYPE,E.PLACE_NAME,E.DESCRIPTION,E.IDEVENTO,E.DATE, "
               + "T.START,T.END,T.TURN_NUMBER"
               + " FROM GESTIONE_TURNO T JOIN EVENTO E ON E.IDEVENTO=T.EVENTO JOIN ADDSICUREZZA A  ON A.IDSICUREZZA=T.ADDSICUREZZA WHERE A.TAX_CODE = ? ";
       System.out.println(sql);
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
                  ,rs.getTime("END")
                  ,rs.getInt("TURN_NUMBER")));
       }
       
       return result;
    }

    @Override
    public int updateTurn(int turn,String campo,Object new_value) throws SQLException {
        
       String sql = "UPDATE GESTIONE_TURNO SET "+campo+ " = '"+new_value+"' WHERE TURN_NUMBER = ?";
       con = DBConnect.getConnection();
       ps = con.prepareStatement(sql);
       ps.setInt(1, turn);
       return ps.executeUpdate();
           }
    
}
