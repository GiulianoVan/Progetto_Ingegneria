/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLogin;

import DB.DAO.ImplAdminDao;
import Model.Admin;
import Model.LoginModel;
import View.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author Pirozzi
 */
public class LoginButtonController implements ActionListener {
    
    private LoginModel modLog;
    private LoginView viewLog;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if(action.equals("ACCEDI"))
        {
            String user = viewLog.getUsernameText();
            String password = viewLog.getPasswordText();
            modLog.setValueAmminnistratore(user,password);   
        }
        else
        {
            System.exit(0);
        }
        
    }
    
    public void setModel(LoginModel nuovo)
    {
        modLog = nuovo;
        
    }
    public void setView(LoginView nuovo)
    {
        viewLog = nuovo;
    }
    
}
