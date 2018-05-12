/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Main.StartProject;
import DB.DAO.ImpAdminDao;
import java.util.Observable;

/**
 *
 * @author Pirozzi
 */
public class LoginModel extends Observable{
    
    private String host;
    private String schema;
    private String DbUser;
    private String DbPassword;
    private Admin amministratore;
    private ImpAdminDao adminDAO;
    
    public LoginModel()
    {
        amministratore = StartProject.admin;
    }
    
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getDbUser() {
        return DbUser;
    }

    public void setDbUser(String DbUser) {
        this.DbUser = DbUser;
    }

    public String getDbPassword() {
        return DbPassword;
    }

    public void setDbPassword(String DbPassword) {
        this.DbPassword = DbPassword;
    }
    
    public void setValueAmminnistratore(String user, String password)
    {
        adminDAO = new ImpAdminDao();
        amministratore = adminDAO.searchbyUserAndPassword(user, password);
        int x=0;       
        if(this.amministratore != null)
          x=1;  
        
        setChanged();
        notifyObservers(x);
    }
}
