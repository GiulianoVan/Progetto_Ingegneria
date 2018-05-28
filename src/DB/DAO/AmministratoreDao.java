/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.DAO;

import Model.JavaBean.Admin;

/**
 *
 * @author Pirozzi
 */
public interface AmministratoreDao {
    
    public Admin searchbyUserAndPassword(String user,String password);
}
