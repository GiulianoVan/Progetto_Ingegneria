/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.DAO;

import DB.Database.DBConnect;
import Model.CustomerModel;
import java.util.List;
import Model.JavaBean.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Vincent
 */
public class ImplCustomerDao implements CustomerDao{
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public int deleteCustomer(Customer customer) {
            
        //fare interrogazione;
        return 0;
    }
    
    @Override
    public Set<Customer> getCustomerParolaChiave(ArrayList<String> parole){
         
         Set<Customer>result = new HashSet<>();
         String sql = "SELECT IDCLIENTE,USERNAME,NOME,COGNOME,EMAIL,CF,TEL,DNASCITA FROM CLIENTE WHERE ";
        //CREO LA STRINGA DINAMICAMENTE AGGIUNGENDO LA STESSA STRINGA PER QUANTE SONO LE PAROLE CHIAVI
        for(String parola : parole)
        {
             sql += "NOME LIKE ? OR COGNOME LIKE ? OR EMAIL LIKE ?  OR ";
        }
        sql = sql.substring(0,sql.length()-3); //TOLGO ULTIMO OR.
        sql += ";"; //AGGIUNGO PUNTO E VIRGOLA ALLA FINE
    
        try 
        {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            
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
                result.add(new Customer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8)));
            }
        }
        catch (SQLException ex) {
            System.out.println("Errore in getCustomerParolaChiaveDao");
        }
        
        return result;
    }
    
    @Override
    public int updateCustomer(String new_value, String attribute_to_change, String id) {

        String sql = "UPDATE CLIENTE SET "+attribute_to_change+ " = ? WHERE IDCLIENTE = ?;";
        int executeUpdate = 0;
        try 
        {
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
        }
        catch (SQLException ex) {
            System.out.println("Errore!\nAggiornamento fallito.");
        }
        return executeUpdate;
    }

    @Override
    public List<CustomerModel> searchByEta(int età) {
        List<CustomerModel> clienti = null;
        //codice
        return clienti;
    }

    @Override
    public List<CustomerModel> searchByBigliettiAcquistati(int n) {
         List<CustomerModel> clienti = null;
        //codice
         return clienti;
    }


    
    
    
}
