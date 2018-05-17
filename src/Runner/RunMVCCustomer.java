/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;

import Controller.ControllerCustomer.ControllerButtonCustomer;
import Controller.ControllerCustomer.ControllerKeyCustomer;
import Controller.ControllerGeneral.ControllerGeneral;
import Model.CustomerModel;
import View.CustomerPanel;

/**
 *
 * @author Vincent
 */
public class RunMVCCustomer {
    
    private CustomerModel model;
    private CustomerPanel view;
    private ControllerButtonCustomer controllerButton;
    private ControllerKeyCustomer controllerText;
   // private ControllerKeyTableCustomer controllerTab;
    //private ControllerMouseTableCustomer controllerMouse;
    private ControllerGeneral controller;
    //private ControllerFocusTableCustomer controllerFocus;

   public void startMVCCustomer()
   {
    
         model = new CustomerModel();
        // creo le view passando il model
         view = new CustomerPanel();
        //model registra un osservatore
        model.addObserver(view);
        controller = new ControllerGeneral(model,view);
        /*
        controllerButton = new ControllerButtonCustomer();
        controllerButton.setModel(model);
        controllerButton.setView(view);
       
        view.SetControllerButton(controllerButton);
        //creo controllerButton per la tabella e lo registro alla view
        
        controllerTab = new ControllerKeyTable();
        controllerTab.setModel(model);
        controllerTab.setView(view);
        view.SetControllerKeyTable(controllerTab);
        
        controllerFocus = new ControllerFocusTableCustomer();
        controllerFocus.setModel(model);
        controllerFocus.setView(view);
        view.setControllerFocusTable(controllerFocus);
        controllerMouse = new ControllerMouseTableCustomer();
        controllerMouse.setModel(model);
        controllerMouse.setView(view);
        view.setControllerMouseTable(controllerMouse); 
        //creo controllerButton per la Jtext e le registro ai model ed al controllerButton
        controllerText = new ControllerKeyCustomer();
        controllerText.setModel(model);
        controllerText.setView(view);
        view.SetControllerKeyText(controllerText);
        x = new ControllerGeneralButton();
        x.setView(view);
        x.setModel(model);
        view.setControllerGeneralButton(x);
        
        */
        //visualizzo view
      }

    public CustomerPanel getView() {
        return view;
    }

    public void setView(CustomerPanel view) {
        this.view = view;
    }
   }

