/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStorage.DB.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Pirozzi
 */
public class DBConnect {

    private static Connection con;
    //progettoingprivate static  String user = "Marcello";
    //private static String password = "progettoing";
    //private static  String user = "cognomen1";
    //private static String password = "pippo";
    //private static  String user = "cognomen";
    //private static String password = "progettoing";
    //private static  String user = "Vincenzo";
    //private static String password = "bd12";

    //private static String url = "jdbc:mysql://localhost/em17?useSSL=false&serverTimezone=Europe/Rome";
    private static String url = "jdbc:mysql://hostingmysql330.register.it/em17?useSSL=false&serverTimezone=Europe/Rome";
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
  
   
  /*  
    public static Connection getConnection() 
    {
        if(password.equals("") || user.equals(""))
            System.out.println("Password o user vuoti");
        else
        {
           try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            } catch (ClassNotFoundException ex) {
            System.out.println("Driver Connector non funzionante");
             }
           try {
            
                con = DriverManager.getConnection(url,user,password);
            
             } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null,"Errore connessione : verificare username e password","ERROR",JOptionPane.ERROR_MESSAGE);
             }
        }
       return con;
    }
*/
    
    public static Connection getConnection() throws SQLException
    {
           try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            } catch (ClassNotFoundException ex) {
            System.out.println("Driver Connector non funzionante");
            }
             //con = DriverManager.getConnection(url,user,password);
             //con = DriverManager.getConnection(url,"cognomen","progettoing");
             //con = DriverManager.getConnection(url,"security","progettoing");
             //con = DriverManager.getConnection(url,"systemadmin","progettoing");
             con = DriverManager.getConnection(url,"cognomen1","progettoing");
             
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
