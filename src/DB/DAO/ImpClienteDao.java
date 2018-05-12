/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.DAO;

import DB.DAO.ClienteDao;
import Model.clientModel;
import java.util.List;

/**
 *
 * @author Pirozzi
 */
public class ImpClienteDao implements ClienteDao{

    @Override
    public int delete(String CF) {
            
        //fare interrogazione;
        return 0;
    }

    @Override
    public List<clientModel> searchByEtà(int età) {
        List<clientModel> clienti = null;
        //codice
        return clienti;
    }

    @Override
    public List<clientModel> searchByBigliettiAcquistati(int n) {
         List<clientModel> clienti = null;
        //codice
         return clienti;
    }
    
    
    
}
