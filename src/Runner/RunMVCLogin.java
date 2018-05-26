/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;

import Controller.ControllerLogin;
import Model.LoginModel;
import View.LoginView;

/**
 *
 * @author Pirozzi
 */
public class RunMVCLogin {
    
    public void startRunMVCLogin()
    {
        LoginModel loginmod = new LoginModel();
        LoginView loginview = new LoginView();
        loginmod.addObserver(loginview);
        ControllerLogin controlLogin = new ControllerLogin(loginmod, loginview);
        loginview.setLocationRelativeTo(null);//apre la finestra al centro dello schermo
        loginview.setVisible(true);
    }
}
