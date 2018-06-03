/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.DAO;

import DB.Database.DBConnect;
import Model.JavaBean.Addetto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
    public int aggiungiAddetto(Addetto addetto)throws SQLException{
            
            String sql ="INSERT INTO ADDSICUREZZA(NAME,SURNAME,TAX_CODE,PHONE,SALARY,EMAIL,USERNAME,PASSWORD,BIRTH) VALUES (?,?,?,?,?,?,?,?,?)";
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,addetto.getNome());
            ps.setString(2,addetto.getCognome());
            ps.setString(3,addetto.getCf());
            ps.setString(4,addetto.getTel());
            ps.setDouble(5,addetto.getStipendio());
            ps.setString(6,addetto.getEmail());
            ps.setString(7,addetto.getUsername());
            ps.setString(8,addetto.getPassword());
            ps.setTimestamp(9,new Timestamp(addetto.getDnascita().getTime()));
            int insert=  ps.executeUpdate(); //ritorna 1 se l'inserimento va a buon fine.
            con.close();
            ps.close();
            return insert;
    }

    @Override
    public int deleteAddetto(String idAddetto) throws SQLException {
        
            String sql = "DELETE FROM ADDSICUREZZA WHERE IDSICUREZZA = ?";
            con = DBConnect.getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1,idAddetto);
            int del= ps.executeUpdate();//ritorna 1 se viene eliminato un addetto o 0 se nn viene eliminato
            con.close();
            ps.close();
            return del;
  
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

    @Override
    public int deleteAddetto(Addetto employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Addetto> getAllAddetti() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Addetto> searchByName(String name) throws SQLException {
        
        Set<Addetto> result = new HashSet<>();
        String sql = "SELECT NAME,SURNAME,TAX_CODE,EMAIL,PHONE,SALARY,BIRTH,IDSICUREZZA FROM ADDSICUREZZA WHERE NAME = ?";
        con = DBConnect.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1,name);
        rs = ps.executeQuery();
        while(rs.next())
        {
             result.add(new Addetto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getDate(7),rs.getString(8)));
        }
            
        return result;

    }

    @Override
    public Set<Addetto> searchBySurname(String surname) throws SQLException{
        
        Set<Addetto> result = new HashSet<>();
        String sql = "SELECT NAME,SURNAME,TAX_CODE,EMAIL,PHONE,SALARY,BIRTH,IDSICUREZZA FROM ADDSICUREZZA WHERE SURNAME = ?";
        con = DBConnect.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1,surname);
        rs = ps.executeQuery();
        while(rs.next())
        {
             result.add(new Addetto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getDate(7),rs.getString(8)));
        }
            
        return result;
    }

    @Override
    public Set<Addetto> searchByBirth(Date from, Date to) throws SQLException {
       
        Set<Addetto> result = new HashSet<>();
        String sql = "SELECT NAME,SURNAME,TAX_CODE,EMAIL,PHONE,SALARY,BIRTH,IDSICUREZZA FROM ADDSICUREZZA WHERE BIRTH >= ? AND BIRTH <= ?";
        con = DBConnect.getConnection();
        ps = con.prepareStatement(sql);
        ps.setTimestamp(1,new Timestamp(from.getTime()));
        ps.setTimestamp(2,new Timestamp(to.getTime()));
        rs = ps.executeQuery();
        while(rs.next())
        {
             result.add(new Addetto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getDate(7),rs.getString(8)));
        }
            
        return result;
    }

    @Override
    public Addetto searchByTaxCode(String tax_code) throws SQLException {
      
        
        String sql = "SELECT NAME,SURNAME,TAX_CODE,EMAIL,PHONE,SALARY,BIRTH,IDSICUREZZA FROM ADDSICUREZZA WHERE TAX_CODE = ?";
        con = DBConnect.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1,tax_code);
        rs = ps.executeQuery();
             
             if(rs.next())
              return new Addetto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getDate(7),rs.getString(8));
                  
        return null;
    }
}
