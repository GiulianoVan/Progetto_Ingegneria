/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.DAO.AmministratoreDao;
import DB.DAO.ImplAdminDao;
import Main.StartProject;
import Model.JavaBean.Admin;
import Model.MODELDACANCELARE.LoginModel;
import View.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Pirozzi
 */
public class ControllerLogin implements ActionListener,KeyListener{
    

      AmministratoreDao dao;
      private LoginView viewLog;
      Admin admin;
      private int flag = 0;
      
    public ControllerLogin(AmministratoreDao dao, LoginView view)
    {
        this.dao = dao;
        viewLog = view;
        viewLog.getAccediButton().addActionListener(this);
        viewLog.getExitButton().addActionListener(this);
        viewLog.JTextPassword().addKeyListener(this);
        viewLog.JTextUsername().addKeyListener(this);
        viewLog.getAccediButton().addKeyListener(this);
        viewLog.getExitButton().addKeyListener(this);
        this.admin =  StartProject.admin;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if(action.equals("ACCEDI"))
        {
            try {
                String user = viewLog.getUsernameText();
                String password = viewLog.getPasswordText();
                admin = dao.searchbyUserAndPassword(user, password);
                viewLog.accessApp(admin);
                if(admin == null )
                {
                   JOptionPane.showMessageDialog(viewLog,"Attenzione : username  o password errati","Error",JOptionPane.ERROR_MESSAGE);

                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(viewLog,"Mancata connessione al database.Impossibile effettuare l'accesso","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            System.exit(0);
        }
        
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
                  try {
                        String user = viewLog.getUsernameText();
                        String password = viewLog.getPasswordText();
                        admin = dao.searchbyUserAndPassword(user, password);
                        viewLog.accessApp(admin);
                        
                        if(admin == null )
                         {    
                              JOptionPane.showMessageDialog(viewLog,"Attenzione : username o password errati","Error",JOptionPane.ERROR_MESSAGE);
                              
                         }
                      }catch (SQLException ex) {
                          JOptionPane.showMessageDialog(viewLog,"Mancata connessione al database.Impossibile effettuare l'accesso","Error",JOptionPane.ERROR_MESSAGE);
           
                    }
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
