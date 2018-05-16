/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DB.DAO.ImplCustomerDao;
import JavaBean.Customer;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Set;

/**
 *
 * @author Vincent
 */
public class CustomerModel extends Observable {
    
    public Set<Customer>customer;
    private ImplCustomerDao customerdao = new ImplCustomerDao();
    MyDefaultTableModel<Customer> tab = new MyDefaultTableModel();      

    /**
     *
     * @param parole
     */
    public void doSearch(ArrayList<String> parole)
    {
        
        customer = customerdao.getCustomerParolaChiave(parole);
        
        setChanged();
        notifyObservers(tab.createModelBySetCustomer(customer));
    }
    public void doUpdate(String new_value,String attribute_to_change,String id)
    {
        customerdao.updateCustomer(new_value,attribute_to_change,id);
    }
  
  
}
