/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Pirozzi
 */
public class DBConnect {

    private static Connection con;
    //progettoingprivate static  String user = "Marcello";
    //private static String password = "progettoing";
    //private static  String user = "cognomen1";
<<<<<<< HEAD
   // private static String password = "pippo";
     private static  String user = "cognomen";
     private static String password = "progettoing";
    //private static  String user = "Vincenzo";
    //private static String password = "bd12";
=======
    //private static String password = "pippo";
    //private static  String user = "cognomen";
    //private static String password = "progettoing";
    private static  String user = "Vincenzo";
    private static String password = "bd12";
>>>>>>> a56fa3ec6120562106a8973bcc0514d2a3558227
    private static String url = "jdbc:mysql://localhost/em17?useSSL=false&serverTimezone=Europe/Rome";

   
    
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
                 System.out.println("Errore connessione");
             }
        }
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
