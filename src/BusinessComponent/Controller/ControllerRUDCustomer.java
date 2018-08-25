/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessComponent.Controller;

import AccessDataStorage.DB.DAO.AddettoDao;
import AccessDataStorage.DB.DAO.CustomerDao;
import BusinessComponent.ManagementModelTable.MyDefaultTableModel;
import BusinessComponent.Entity.Addetto;
import BusinessComponent.Entity.Customer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author Pirozzi
 */
public class ControllerRUDCustomer {
    
    private Set<Customer> customer;
    private CustomerDao dao;
    private int flag_errorDelete = 1;
    private int flagtesting=0;
    private String flag_search= "";
    
    public ControllerRUDCustomer(CustomerDao dao)
    {
        this.dao = dao;    
    }
                                     
    public void doUpdateAddetto(String value,String field,String id) throws SQLException
    {
        dao.updateCustomer(value,field,id);
    }
    
    public void  doDeleteAddetto(String idCustomer) throws SQLException
    {
          dao.deleteCustomer(idCustomer);              
    }    
                
    public MyDefaultTableModel doAdvancedSearch(String cf, String name, String surname, Date from, Date to) throws SQLException 
    {
        if(customer != null)
          customer.clear();
        
        MyDefaultTableModel tab = new MyDefaultTableModel();
        int intersect = 0;
        
        if(cf.trim().length() != 0)
        {

                customer.add(dao.searchByTaxCode(cf));        
        }
        else
        {
            if(name.trim().length()!=0)
            { 
                     if(customer.isEmpty() && intersect == 0)
                       customer.addAll(dao.searchByName(name));
                     else
                        customer.retainAll(dao.searchByName(name));

                     intersect = 1;
            }

            if(surname.trim().length() != 0)
            {
               
                   if(customer.isEmpty() && intersect == 0) 
                     customer.addAll(dao.searchBySurname(surname));
                   else
                     customer.retainAll(dao.searchBySurname(surname));

                   intersect = 1;
               
            }
            
            if(from!= null && to != null)
            {
                
                   if(customer.isEmpty() && intersect == 0)  
                      customer.addAll(dao.searchByBirth(from,to));
                   else
                     customer.retainAll(dao.searchByBirth(from,to));

                   intersect = 1;
               
            }
            else
            {
                if((from== null &&  to!= null) || (from!= null &&  to== null))       
                    throw new RuntimeException("Error : Fill both date fields. The search will not consider the date fields.");
                    
            }
        }
        tab.createModelBySetCustomer(customer);
        return tab;
    }
  
    public MyDefaultTableModel doSearch(ArrayList<String> parolechiavi) throws SQLException {

         if(customer != null)
           customer.clear();
         customer = dao.searchCustomerKeysWords(parolechiavi);  
         MyDefaultTableModel tab = new MyDefaultTableModel();
         tab.createModelBySetCustomer(customer);
         return tab;
    }
}
