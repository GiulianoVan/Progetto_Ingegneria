/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessDataStorage.DB.DAO;

import AccessDataStorage.DB.Database.DBConnect;
import java.util.List;
import BusinessComponent.Entity.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author Vincent
 */
public class ImplMySqlCustomerDao implements CustomerDao{
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public int deleteCustomer(Customer customer) {
            
        //fare interrogazione;
        return 0;
    }
    
    @Override
    public Set<Customer> searchCustomerKeysWords(ArrayList<String> words) throws SQLException{
         
         Set<Customer>result = new HashSet<>();
         String sql = "SELECT IDCLIENTE,USERNAME,NAME,SURNAME,EMAIL,TAX_CODE,PHONE,BIRTH,ACQUISTI FROM CLIENTE WHERE ";
        //CREO LA STRINGA DINAMICAMENTE AGGIUNGENDO LA STESSA STRINGA PER QUANTE SONO LE PAROLE CHIAVI
        for(String parola : words)
        {
             sql += "NAME LIKE ? OR SURNAME LIKE ? OR EMAIL LIKE ? OR ";
        }
        sql = sql.substring(0,sql.length()-3); //TOLGO ULTIMO OR.
        sql += ";"; //AGGIUNGO PUNTO E VIRGOLA ALLA FINE
    
        
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            
            //SETTO TUTTI I ? CON I VALORI DINAMICAMENTE. 
            for(int i = 1;i<=words.size()*3;++i)
            { 
              int j = (i-1)/3;
              ps.setString(i,"%"+words.get(j)+"%");
            }
            //EFFETTUO QUERY E LA METTO NEL RESULTSET
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                result.add(new Customer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8),rs.getInt(9)));
            }
        
        
        return result;
    }
    
    @Override
    public int updateCustomer(String new_value, String attribute_to_change, String id) throws SQLException{
        
        int executeUpdate=0;
        
            String sql = "UPDATE CLIENTE SET "+attribute_to_change+ " = ? WHERE IDCLIENTE = ?;";
            
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            
            //SETTO TUTTI I ? CON I VALORI DINAMICAMENTE.
            ps.setString(1,new_value.toUpperCase());
            ps.setString(2,id.toUpperCase());
            executeUpdate = ps.executeUpdate();
            con.close();
            ps.close();
            rs.close();
            if(executeUpdate < 1)
                System.out.println("Errore!\nCampi inseriti non validi.");
            
      
         return executeUpdate;
    }



    @Override
    public int deleteCustomer(String idcustomer) throws SQLException {
        
            String sql = "DELETE FROM CLIENTE WHERE IDCLIENTE = ?";
            con = DBConnect.getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1,idcustomer);
            int del= ps.executeUpdate();//ritorna 1 se viene eliminato un addetto o 0 se nn viene eliminato
            con.close();
            ps.close();
            return del;
    }

    @Override
    public Set<Customer> searchByName(String name) throws SQLException {
        
        Set<Customer> result = new HashSet<>();
        String sql = "SELECT IDCLIENTE,USERNAME,NAME,SURNAME,EMAIL,TAX_CODE,PHONE,BIRTH,ACQUISTI FROM CLIENTE WHERE NAME = ?";
        con = DBConnect.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1,name);
        rs = ps.executeQuery();
        while(rs.next())
        {
            result.add(new Customer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8),rs.getInt(9)));
        }
        return result;
    }

    @Override
    public Set<Customer> searchBySurname(String surname) throws SQLException {
        Set<Customer> result = new HashSet<>();
        String sql = "SELECT IDCLIENTE,USERNAME,NAME,SURNAME,EMAIL,TAX_CODE,PHONE,BIRTH,ACQUISTI FROM CLIENTE WHERE SURNAME = ?";
        con = DBConnect.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1,surname);
        rs = ps.executeQuery();
        while(rs.next())
        {
            result.add(new Customer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8),rs.getInt(9)));
        }
        return result;

    }

    @Override
    public Set<Customer> searchByBirth(Date from, Date to) throws SQLException {
        
        Set<Customer> result = new HashSet<>();
        String sql = "SELECT IDCLIENTE,USERNAME,NAME,SURNAME,EMAIL,TAX_CODE,PHONE,BIRTH,ACQUISTI FROM CLIENTE WHERE BIRTH >= ? AND BIRTH <= ?";
        con = DBConnect.getConnection();
        ps = con.prepareStatement(sql);
        ps.setTimestamp(1,new Timestamp(from.getTime()));
        ps.setTimestamp(2,new Timestamp(to.getTime()));
        rs = ps.executeQuery();
        while(rs.next())
        {
            result.add(new Customer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8),rs.getInt(9)));
        }
        return result;
    }

    @Override
    public Customer searchByTaxCode(String tax_code) throws SQLException {

        
        String sql = "SELECT IDCLIENTE,USERNAME,NAME,SURNAME,EMAIL,TAX_CODE,PHONE,BIRTH,ACQUISTI FROM CLIENTE WHERE TAX_CODE = ?";
        con = DBConnect.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1,tax_code);
        rs = ps.executeQuery();
        if(rs.next())
        {
            return new Customer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8),rs.getInt(9));
        }
        return null;
    }

    @Override
    public int updateCustomer(Customer customer) throws SQLException {
        
         String sql = "UPDATE ADDSICUREZZA "
                + "SET NAME = "+customer.getName()+" "
                +",SET SURNAME = "+customer.getSurname()
                +",SET EMAIL = " +customer.getEmail()
                +",SET PHONE = "+ customer.getPhone()
                +",SET BIRTH = "+ new Timestamp(customer.getDate_born().getTime())
                +",SET USERNAME = "+customer.getUsername()
                +",SET ACQUISTI = "+customer.getTickets_purchased()
                +",SET TAX_CODE = "+customer.getTax_code()
                +" WHERE IDSICUREZZA = ?;";
        
                con = DBConnect.getConnection();
                ps = con.prepareStatement(sql);
                ps.setString(1,customer.getIdCustomer());
                
                return ps.executeUpdate();
    }
    

    
    
    
}
