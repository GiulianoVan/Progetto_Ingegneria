package Main;


//import Model.JavaBean.Admin;
import Main.Runner.RunECBLogin;

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

   // public static Admin admin;
    public StartProject()
    {
       RunECBLogin log = new RunECBLogin();
       log.startRunECBLogin();
       
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
