package Main;


import JavaBean.Admin;
import Runner.RunMVCLogin;
import View.*;
import Runner.RunMVCEvents;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pirozzi
 */
public class StartProject {

    public static Admin admin;
    public StartProject()
    {
       RunMVCLogin log = new RunMVCLogin();
       log.startRunMVCLogin();
       
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            
            java.awt.EventQueue.invokeLater(new Runnable()
            {
                @Override
                 public void run()
            {
               StartProject home = new StartProject();
            }
        });
    }
    
}
