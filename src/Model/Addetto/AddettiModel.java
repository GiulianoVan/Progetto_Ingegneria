/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Addetto;

import DB.DAO.ImpAddettoDao;
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
    DefaultTableModel table ;
    private ImpAddettoDao addettodao = new ImpAddettoDao();
                
    public void doSearch(ArrayList<String> parole)
    {
        
        addetti = addettodao.getAddettiParolaChiave(parole);
        
        setChanged();
        notifyObservers(MyDefaultTableModel.createModelBySet(addetti));
    }
    public void doUpdate(String text,String campo,String id)
    {
        addettodao.aggiornaAddetto(text,campo,id);
    }
    
}