/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.DAO;

import DB.Database.DBConnect;
import Model.Admin;
import java.sql.*;


/**
 *
 * @author Pirozzi
 */
public class ImpAmministratore implements AmministratoreDao {
    
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    @Override
    public Admin searchbyUserAndPassword(String user, String password) {
            
        Admin amm = null;
        con = DBConnect.getConnection();
        String sql = "SELECT NOME,COGNOME,IDAMM,CF FROM AMMINISTRATORE WHERE USERNAME=? AND PASSWORD=?";
        try
        {
            ps = con.prepareStatement(sql);
            ps.setString(1,user);
            ps.setString(2,password);
            rs = ps.executeQuery();
            
            if(rs.next())
            {
               amm = new Admin(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }
         rs.close();
         ps.close();   
         con.close();
        }
        catch(SQLException x)
        {
            System.out.println("Errore in searchbyUserAndPassword Ammministratore");
        }
        
            
        return amm;
    }
    
}
