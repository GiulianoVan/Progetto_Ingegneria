/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Runner;

import BusinessComponent.Boundary.BoundaryViewLogin;
import Presentation.LoginView;

/**
 *
 * @author Pirozzi
 */
public class RunECBLogin {
    
    
    public void startRunECBLogin()
    {

       // AmministratoreDao dao = new ImplAdminDao();
        LoginView loginview = new LoginView();
        BoundaryViewLogin controlLogin = new BoundaryViewLogin(/*dao,*/ loginview);
        loginview.setLocationRelativeTo(null);//apre la finestra al centro dello schermo
        loginview.setVisible(true);
    }
}
