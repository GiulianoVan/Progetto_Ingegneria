/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Addetto;

import DB.DAO.ImplAddettoDao;
import Model.MyDefaultTableModel;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Set;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pirozzi
 */
public class AddettiModel extends Observable {
   
    public Set<Addetto>addetti;
    private ImplAddettoDao addettodao = new ImplAddettoDao();
    MyDefaultTableModel<Addetto> tab = new MyDefaultTableModel();      
    public void doSearch(ArrayList<String> parole)
    {
        
        addetti = addettodao.getAddettiParolaChiave(parole);
        
        setChanged();
        notifyObservers(tab.createModelBySet(addetti));
    }
    public void doUpdate(String text,String campo,String id)
    {
        addettodao.updateAddetto(text,campo,id);
    }
    
    
}