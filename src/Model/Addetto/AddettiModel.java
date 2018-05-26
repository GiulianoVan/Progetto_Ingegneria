/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Addetto;

import JavaBean.Addetto;
import DB.DAO.ImplAddettoDao;
import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

/**
 *
 * @author Pirozzi
 */
public class AddettiModel extends Observable {
   
    public Set<Addetto>addetti;
    private ImplAddettoDao addettodao = new ImplAddettoDao();
 
 
    public void doSearch(ArrayList<String> parole)
    {
        
        addetti = addettodao.getAddettiParolaChiave(parole);     
        setChanged();
        notifyObservers(addetti);
    }
    public void doUpdate(String new_value,String attribute_to_change,String id)
    {
        addettodao.updateAddetto(new_value,attribute_to_change,id);
    }
   
    public void doAdvancedSearch(Map<String,String> field_value)
    {
        addetti= addettodao.advancedSearch(field_value);
        setChanged();
        notifyObservers(addetti);
    }
    
}