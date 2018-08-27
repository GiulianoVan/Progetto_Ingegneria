package com.ingmobilescan.marcelloquattromani.em_17mobilescan;


        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;

public class DBConnect {

    private static Connection con;
    //private static  String user = "Marcello";
    //private static String password = "progettoing";
    //private static  String user = "cognomen1";
    //private static String password = "pippo";
    //private static  String user = "cognomen";
    //private static String password = "progettoing";
    //private static  String user = "Vincenzo";
    //private static String password = "bd12";

    //private static String url = "jdbc:mysql://127.0.0.1:3306/em17?useSSL=false&serverTimezone=Europe/Rome";
    //private static String url = "jdbc:mysql://hostingmysql331.register.it/registeringws?useSSL=false&serverTimezone=Europe/Rome";
    //private static String url = "jdbc:mysql://hostingmysql331.register.it/registeringws?useSSL=false&serverTimezone=Europe/Rome";
    private static String url = "jdbc:mysql://hostingmysql331.register.it:3306/registeringws";
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
        //con = DriverManager.getConnection(url,user,password);
        //con = DriverManager.getConnection(url,"cognomen","progettoing");
        con = DriverManager.getConnection(url,"security","progettoing");
        //con = DriverManager.getConnection(url,"systemadmin","progettoing");
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