/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessDataStorage.DB.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author INGSW2017_22
 */
public class DBConnect {

    private static Connection con;
    
    private static String url = "jdbc:mysql://hostingmysql330.register.it/ingsw_em17?useSSL=false&serverTimezone=Europe/Rome";
    private static  String user = "";
    private static String password = "";
    
    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        DBConnect.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DBConnect.password = password;
    }
    
    public static Connection getConnection() throws SQLException
    {
           try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            } catch (ClassNotFoundException ex) {
            System.out.println("Driver Connector non funzionante");
            }
             con = DriverManager.getConnection(url,user,password);
             
       return con;
    }
    public static void closeConnection()
    {
        
             if(con != null)
             {
                 try
                 {
                    con.close();
 
                 }
                 catch(SQLException ex)
                 {
                     System.out.println("Errore nella chiusura");
                 }
             }
       
    }
    
}
