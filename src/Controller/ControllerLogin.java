/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.DAO.ImplAdminDao;
import Model.JavaBean.Admin;
import Model.LoginModel;
import View.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

/**
 *
 * @author Pirozzi
 */
public class ControllerLogin implements ActionListener,KeyListener{
    
    private LoginModel modLog;
    private LoginView viewLog;
    
    public ControllerLogin(LoginModel model, LoginView view)
    {
        modLog = model;
        viewLog = view;
        viewLog.getAccediButton().addActionListener(this);
        viewLog.getExitButton().addActionListener(this);
        viewLog.JTextPassword().addKeyListener(this);
        viewLog.JTextUsername().addKeyListener(this);
        viewLog.getAccediButton().addKeyListener(this);
        viewLog.getExitButton().addKeyListener(this);
    }
    
    
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        
            if(e.getKeyChar()=='\n' && e.getComponent()!= viewLog.getExitButton())
            {
                String user = viewLog.getUsernameText();
                String password = viewLog.getPasswordText();
                modLog.setValueAmminnistratore(user,password);
            }
            else
            {
                if(e.getKeyChar()=='\n' && e.getComponent() == viewLog.getExitButton())
                {
                    System.exit(0);
                }
            }
    }
    
}
