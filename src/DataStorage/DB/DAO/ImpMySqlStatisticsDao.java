/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStorage.DB.DAO;

import DataStorage.DB.Database.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.Map;

/**
 *
 * @author Pirozzi
 */
public class ImpMySqlStatisticsDao implements StatisticsDao{

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
 

    @Override
    public Double etaMediaTipoEvento(String tipo_evento) throws SQLException {
            
         String sql = "SELECT AVG(YEAR(CURDATE()) -  YEAR(C.BIRTH)) FROM EVENTO E JOIN BIGLIETTO B ON E.IDEVENTO=B.EVENTO JOIN CLIENTE C ON B.CLIENTE = C.IDCLIENTE WHERE EVENT_TYPE= ? ";
         con = DBConnect.getConnection();
         ps = con.prepareStatement(sql);
         ps.setString(1,tipo_evento);
         rs = ps.executeQuery();
         if(rs.next())
           return  rs.getDouble(1);
         
         return 0d;
    }
    
    
    
    @Override
    public Integer bigliettiVendutiPerAnno(int anno) throws SQLException {
            
         String sql = "SELECT COUNT(*) FROM BIGLIETTO WHERE YEAR(DATAEVENTO) = ?";
         con = DBConnect.getConnection();
         ps = con.prepareStatement(sql);
         ps.setInt(1,anno);
         
         rs = ps.executeQuery();
         if(rs.next())
             return rs.getInt(1);
         
         return 0;
    }

    

    @Override
    public Double incassiPerAnno(int anno) throws SQLException {

         
         String sql = "SELECT SUM(PREZZO) FROM BIGLIETTO WHERE YEAR(DATAEVENTO) = ? ";
         con = DBConnect.getConnection();
         ps = con.prepareStatement(sql);
         ps.setInt(1,anno);
         
         rs = ps.executeQuery();
         if(rs.next())
             return rs.getDouble(1);
         
         return 0d;
    }

    @Override
    public Integer partecipazioneTipoEventoInUnAnno(int year, String tipoEvento) throws SQLException {
         String sql ="SELECT COUNT(*) FROM BIGLIETTO B JOIN EVENTO E ON B.EVENTO=E.IDEVENTO WHERE YEAR(E.DATE)= ? AND E.EVENT_TYPE = ?";
         con = DBConnect.getConnection();
         ps = con.prepareStatement(sql);
         ps.setInt(1,year);
         ps.setString(2,tipoEvento);
         
         rs = ps.executeQuery();
         if(rs.next())
             return rs.getInt(1);
         
         return 0;
    }
    
}
