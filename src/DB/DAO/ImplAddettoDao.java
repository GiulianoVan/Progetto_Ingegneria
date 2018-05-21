/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.DAO;

import DB.Database.DBConnect;
import JavaBean.Addetto;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Pirozzi
 */
public class ImplAddettoDao implements AddettoDao {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public int aggiungiAddetto(Addetto addetto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int rimuoviAddetto(Addetto addetto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public Addetto cercaAddettoStipendioMax(double stipendio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Addetto> cercaAddettoStipendioMaggioredi(double stipendio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Addetto> cercaAddettoStipendioMinidoredi(double stipendio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Addetto cercaAddettoNomeCognomeCf(String nome, String cognome, String cf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Addetto> getAllAddetti()
    {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Addetto> getAddettiParolaChiave(ArrayList<String> parole){
         
         Set<Addetto>result = new HashSet<>();
         String sql = "SELECT NOME,COGNOME,CF,EMAIL,TEL,STIPENDIO,LIVELLO,IDSICUREZZA FROM ADDSICUREZZA WHERE ";
        //CREO LA STRINGA DINAMICAMENTE AGGIUNGENDO LA STESSA STRINGA PER QUANTE SONO LE PAROLE CHIAVI
        for(String parola : parole)
        {
             sql += "NOME LIKE ? OR COGNOME LIKE ? OR EMAIL LIKE ? OR LIVELLO LIKE ? OR ";
        }
        sql = sql.substring(0,sql.length()-3); //TOLGO ULTIMO OR.
        sql += ";"; //AGGIUNGO PUNTO E VIRGOLA ALLA FINE
    
        try 
        {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ResultSetMetaData column_name;
            
            //SETTO TUTTI I ? CON I VALORI DINAMICAMENTE. 
            for(int i = 1;i<=parole.size()*4;++i)
            { 
              int j = (i-1)/4;
              ps.setString(i,"%"+parole.get(j)+"%");
            }
            //EFFETTUO QUERY E LA METTO NEL RESULTSET
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                result.add(new Addetto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getInt(7),rs.getString(8)));
            }
            con.close();
            ps.close();
            rs.close();
        }
        catch (SQLException ex) {
            System.out.println("Errore in getAddettiParolaChiaveDao");
        }
        
        return result;
    }

    @Override
    public int updateAddetto(String new_value,String attribute_to_change,String id) {
        
       // String sql = "UPDATE ADDSICUREZZA SET "+attribute_to_change+ " = ? WHERE IDADDETTO = ?;";
        String sql = "UPDATE ADDSICUREZZA SET "+attribute_to_change+ " = '"+ new_value+"' WHERE IDSICUREZZA = ?;";
        int executeUpdate = 0;
        try 
        {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            
            //SETTO TUTTI I ? CON I VALORI DINAMICAMENTE. 
              //ps.setString(1,new_value.toUpperCase());
            
              
              ps.setString(1,id.toUpperCase());
              System.out.println(sql);
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
}
