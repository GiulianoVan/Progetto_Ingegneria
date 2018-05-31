/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.DAO;

import DB.Database.DBConnect;
import Model.JavaBean.Addetto;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            
        try {
            String sql ="INSERT INTO ADDSICUREZZA(IDSICUREZZA,NAME,SURNAME,TAX_CODE,PHONE,SALARY,EMAIL,USERNAME,PASSWORD,BIRTH) VALUES (?,?,?,?,?,?,?,?,?,?)";
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,addetto.getId());
            ps.setString(2,addetto.getNome());
            ps.setString(3,addetto.getCognome());
            ps.setString(4,addetto.getCf());
            ps.setString(5,addetto.getTel());
            ps.setDouble(6,addetto.getStipendio());
            ps.setString(7,addetto.getEmail());
            ps.setString(8,addetto.getUsername());
            ps.setString(9,addetto.getPassword());
          //  ps.setDate(10, (Date) addetto.getDnascita());
            int insert=  ps.executeUpdate(); //ritorna 1 se l'inserimento va a buon fine.
            con.close();
            ps.close();
            return insert;
        } catch (SQLException ex) {
            Logger.getLogger(ImplAddettoDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("[ERRORE] Problema di comunicazione con il Db,impossibile inserire l'addetto");
            return 0;
        }
    }

    @Override
    public int rimuoviAddetto(String idAddetto) {

        try {
            String sql = "DELETE FROM ADDSICUREZZA WHERE ID =  ?";
            con = DBConnect.getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1,idAddetto);
            con.close();
            ps.close();
            int del= ps.executeUpdate();//ritorna 1 se viene eliminato un addetto o 0 se nn viene eliminato
            con.close();
            ps.close();
            return del;
        } catch (SQLException ex) {
            System.out.println("Errore : Mancata comunicazione con il  db.Impossibile eliminare l'addetto");
            return 0;
        }
    }

   


    @Override
    public Set<Addetto> getAddettiParolaChiave(ArrayList<String> parole) throws SQLException{
         
         Set<Addetto>result = new HashSet<>();
         String sql = "SELECT NAME,SURNAME,TAX_CODE,EMAIL,PHONE,SALARY,BIRTH,IDSICUREZZA FROM ADDSICUREZZA WHERE ";
        //CREO LA STRINGA DINAMICAMENTE AGGIUNGENDO LA STESSA STRINGA PER QUANTE SONO LE PAROLE CHIAVI
        for(String parola : parole)
        {
             sql += "NAME LIKE ? OR SURNAME LIKE ? OR EMAIL LIKE ? OR ";
        }
        sql = sql.substring(0,sql.length()-3); //TOLGO ULTIMO OR.
        sql += ";"; //AGGIUNGO PUNTO E VIRGOLA ALLA FINE
        
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            //SETTO TUTTI I ? CON I VALORI DINAMICAMENTE. 
            for(int i = 1;i<=parole.size()*3;++i)
            { 
              int j = (i-1)/3;
              ps.setString(i,"%"+parole.get(j)+"%");
            }
            //EFFETTUO QUERY E LA METTO NEL RESULTSET
          
            rs = ps.executeQuery();
          
            while(rs.next())
            {   
                result.add(new Addetto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getDate(7),rs.getString(8)));
            }
            
            con.close();
            ps.close();
            rs.close();
        
        
        return result;
    }

    @Override
    public int updateAddetto(String new_value,String attribute_to_change,String id) throws SQLException  {
       
        int executeUpdate = 0;


            // String sql = "UPDATE ADDSICUREZZA SET "+attribute_to_change+ " = ? WHERE IDADDETTO = ?;";
            String sql = "UPDATE ADDSICUREZZA SET "+attribute_to_change+ " = '"+ new_value+"' WHERE IDSICUREZZA = ?;";
            executeUpdate = 0;
            
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            
            //SETTO TUTTI I ? CON I VALORI DINAMICAMENTE.
            //ps.setString(1,new_value.toUpperCase());
            
            
            ps.setString(1,id.toUpperCase());
            executeUpdate = ps.executeUpdate();
            con.close();
            ps.close();
            rs.close();
            
       
        
        return executeUpdate;

    }

    @Override
    public Set<Addetto> advancedSearch(Map<String, String> campo_value) throws SQLException {

        String sql = "SELECT NAME,SURNAME,TAX_CODE,EMAIL,PHONE,SALARY,BIRTH,IDSICUREZZA FROM ADDSICUREZZA WHERE ";
        int i = 1;
        Set<Addetto> result = new HashSet<>();
        
        for(String key : campo_value.keySet()) // mi creao la string dell'interrogazione l'interrogazione o la devo creare dentro al controller ?
            {
                sql +=" "+key+" = ? AND";
                
            }
        
        sql = sql.substring(0,sql.length()-4);//TOLGO L'AND FINALE
        
                       
            con =DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            for(String key : campo_value.keySet())
            {
                ps.setString(i,campo_value.get(key));
                ++i;
            }
            rs = ps.executeQuery();
            while(rs.next())
            {
                result.add(new Addetto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getDate(7),rs.getString(8)));
            }
            
       
       return result;
    }
}
