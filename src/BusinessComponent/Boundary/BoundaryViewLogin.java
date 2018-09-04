/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessComponent.Boundary;


import AccessDataStorage.DB.Database.DBConnect;
import Presentation.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author INGSW2017_22
 */
public class BoundaryViewLogin implements ActionListener,KeyListener{
    

      
      private LoginView viewLog;
      
      private int flag_joptionpane = 1;//flag che controlla lo stato del bottone JOptionPane
      private Object[] ok_options = {"OK"};//setto 'Ok' come unica opzione dei JOptionPane.showOptionDialog
      
    public BoundaryViewLogin(LoginView view)
    {
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
        if(action.equalsIgnoreCase("ACCEDI"))
        {
            try {
                String user = viewLog.getUsernameText();
                String password = viewLog.getPasswordText();
                DBConnect.setUser(user);
                DBConnect.setPassword(password);
                DBConnect.getConnection();
                viewLog.accessApp();
               }
                catch(SQLException ex)
                {

                   if(ex.getErrorCode() == 1045)
                    flag_joptionpane = JOptionPane.showOptionDialog(viewLog,"Errore connessione : Accesso Negato per l'user inserito","ERROR",JOptionPane.ERROR_MESSAGE,JOptionPane.OK_OPTION,null,ok_options,ok_options[0]);
                   else
                    flag_joptionpane= JOptionPane.showOptionDialog(viewLog,"Errore connessione : "+ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,JOptionPane.OK_OPTION,null,ok_options,ok_options[0]);
   
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
        
            if(flag_joptionpane  == JOptionPane.OK_OPTION)
                flag_joptionpane = 1;
            
            else if(e.getKeyChar()=='\n' && e.getComponent()!= viewLog.getExitButton() )
            {
                viewLog.getAccediButton().doClick();
            }
            else
            {
                if(e.getKeyChar()=='\n' && e.getComponent() == viewLog.getExitButton())
                {
                    viewLog.getExitButton().doClick();
                }
            }
    }
    
}
