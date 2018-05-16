/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.DAO;

import JavaBean.Customer;
import Model.CustomerModel;
import java.util.List;

/**
 *
 * @author Vincent
 */

public interface CustomerDao {
    
    public int deleteCustomer(Customer customer);
    public int refreshCustomer(String new_value,String attribute_to_change,String id);
    public List<CustomerModel> searchByEta(int eta);
    public List<CustomerModel> searchByBigliettiAcquistati(int n);
    
    //public int delete(clientModel x);
    
}



    public int aggiornaAddetto(Addetto addetto);
    public int aggiornaAddetto(String testo,String campo,String id);
    public Addetto cercaAddettoStipendioMax(double stipendio);
    public List<Addetto> cercaAddettoStipendioMaggioredi(double stipendio);
    public List<Addetto> cercaAddettoStipendioMinidoredi(double stipendio); 
    public Addetto cercaAddettoNomeCognomeCf(String nome,String cognome,String cf);
    public List<Addetto> getAllAddetti();
    public Set<Addetto> getAddettiParolaChiave(ArrayList<String> parola);