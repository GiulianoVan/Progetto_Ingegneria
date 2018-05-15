/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;

import Controller.LoginButtonController;
import Model.LoginModel;
import View.LoginView;

/**
 *
 * @author Pirozzi
 */
public class RunMVCLogin {
    
    public RunMVCLogin()
    {
        LoginModel loginmod = new LoginModel();
        LoginView loginview = new LoginView();
        loginmod.addObserver(loginview);
        LoginButtonController controlLogin = new LoginButtonController();
        controlLogin.setModel(loginmod);
        controlLogin.setView(loginview);
        loginview.setControllerAccediButton(controlLogin);
        loginview.setControllerExitButton(controlLogin);
        loginview.setVisible(true);
        
    }
}
