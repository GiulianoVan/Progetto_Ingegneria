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
    public int updateCustomer(String new_value,String attribute_to_change,String id);
    public List<CustomerModel> searchByEta(int eta);
    public List<CustomerModel> searchByBigliettiAcquistati(int n);
    
    //public int delete(clientModel x);
    
}