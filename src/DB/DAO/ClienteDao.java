/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.DAO;

import Model.clientModel;
import java.util.List;

/**
 *
 * @author Pirozzi
 */

public interface ClienteDao {
    
    public int delete(String CF);
    public List<clientModel> searchByEtà(int età);
    public List<clientModel> searchByBigliettiAcquistati(int n);
    
    //public int delete(clientModel x);
    
}
