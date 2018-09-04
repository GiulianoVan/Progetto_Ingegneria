/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessComponent.Controller;

import AccessDataStorage.DB.DAO.AddettoDao;
import BusinessComponent.ManagementModelTable.MyDefaultTableModel;
import BusinessComponent.Entity.Addetto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author INGSW2017_22
 */
public class ControllerCRUDAddetto{
//UTILIZZANDOLA QUANDO ESTENDE,BASTA USARE UN SOLO CONTROLLER,CONTROLLERADDETTO. IL COLLEGAMENTI COL PADRE VENGONO
    //FATTI IN AUTOMATICO NEL COSTRUTTORE DEL APDRE
    private Set<Addetto> addetti;
    private AddettoDao dao;
    private int flag_errorDelete = 1;
    private int flagtesting=0;
    private String flag_search= "";
    
    public ControllerCRUDAddetto(AddettoDao dao)
    {
        this.dao = dao;    
    }
                                     
    public void doUpdateAddetto(String value,String field,String id) throws SQLException
    {
        dao.updateAddetto(value,field,id);
    }
    
    public void  doDeleteAddetto(String idAddetto) throws SQLException
    {
          dao.deleteAddetto(idAddetto);              
    }    
                
    public MyDefaultTableModel doAdvancedSearch(String cf, String name, String surname, Date from, Date to) throws SQLException 
    {
        if(addetti != null)
          addetti.clear();
        
        MyDefaultTableModel tab = new MyDefaultTableModel();
        int intersect = 0;
        
        if(cf.trim().length() != 0)
        {

                addetti.add(dao.searchByTaxCode(cf));        
        }
        else
        {
            if(name.trim().length()!=0)
            { 
                     if(addetti.isEmpty() && intersect == 0)
                       addetti.addAll(dao.searchByName(name));
                     else
                        addetti.retainAll(dao.searchByName(name));

                     intersect = 1;
            }

            if(surname.trim().length() != 0)
            {
               
                   if(addetti.isEmpty() && intersect == 0) 
                     addetti.addAll(dao.searchBySurname(surname));
                   else
                     addetti.retainAll(dao.searchBySurname(surname));

                   intersect = 1;
               
            }
            
            if(from!= null && to != null)
            {
                
                   if(addetti.isEmpty() && intersect == 0)  
                      addetti.addAll(dao.searchByBirth(from,to));
                   else
                     addetti.retainAll(dao.searchByBirth(from,to));

                   intersect = 1;
               
            }
            else
            {
                if((from== null &&  to!= null) || (from!= null &&  to== null))       
                    throw new RuntimeException("Error : Fill both date fields. The search will not consider the date fields.");
                    
            }
        }
        tab.createModelBySetAddetto(addetti);
        return tab;
    }
    
    public void createAddetto(String name, String surname, String username, String password, String code, Date birth, String phone, String email,Double salary) throws SQLException 
    {
        Addetto security = new Addetto(name,surname,code,email,phone,salary,birth,username,password);
        dao.aggiungiAddetto(security);
    }

    public MyDefaultTableModel doSearch(ArrayList<String> parolechiavi) throws SQLException {

         if(addetti != null)
           addetti.clear();
         addetti = dao.getAddettiParolaChiave(parolechiavi);  
         MyDefaultTableModel tab = new MyDefaultTableModel();
         tab.createModelBySetAddetto(addetti);
         return tab;
    }

     public List<String> getTaxCodeBySurname(String surname) throws SQLException
    {
        Set<Addetto> addetti = null;
        LinkedList<String> surn_Add = new LinkedList<>();
        addetti = dao.searchBySurname(surname);
        
        for(Addetto add : addetti)
        {
            surn_Add.add(add.getCf());
        }
        
       return surn_Add;
    }
      
}
