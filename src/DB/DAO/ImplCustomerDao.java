/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.DAO;

import Model.CustomerModel;
import java.util.List;
import JavaBean.Customer;

/**
 *
 * @author Vincent
 */
public class ImplCustomerDao implements CustomerDao{

    @Override
    public int deleteCustomer(Customer customer) {
            
        //fare interrogazione;
        return 0;
    }
    
    @Override
    public int refreshCustomer(String new_value, String attribute_to_change, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
