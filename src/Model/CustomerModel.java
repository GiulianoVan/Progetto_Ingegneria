/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import GestioneTabella.MyDefaultTableModel;
import DB.DAO.ImplCustomerDao;
import Model.JavaBean.Customer;
import java.sql.SQLException;
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
    public void doSearchCustomer(ArrayList<String> parole)
    {
        
        customer = customerdao.searchCustomerKeysWords(parole);
        
        setChanged();
        notifyObservers(customer);
    }
    public void doUpdateCustomer(String new_value,String attribute_to_change,String id)
    {
        Integer error = 0;
        try{
        customerdao.updateCustomer(new_value,attribute_to_change,id);
        }
        catch(SQLException e)
        {
             error=1;
             setChanged();
        }
          notifyObservers(error);
        }
  
  
}
