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
    
    private CustomerModel customerModel;
    private CustomerPanel customerView;
    private ControllerGeneralButton customerController;
    private ControllerButtonCustomer controllerButton;
<<<<<<< HEAD
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
=======
    
    
    public CustomerModel getCustomerModel() {
        return customerModel;
    }

    public void setCustomerModel(CustomerModel customerModel) {
        this.customerModel = customerModel;
    }

    public CustomerPanel getCustomerView() {
        return customerView;
    }

    public void setCustomerView(CustomerPanel customerView) {
        this.customerView = customerView;
    }

    
    
   public void startMVCCustomer()
   {
    
        customerModel = new CustomerModel();
        // creo le customerView passando il customerModel
        customerView = new CustomerPanel();
        //customerModel registra un osservatore
        customerModel.addObserver(customerView);
        customerController = new ControllerGeneralButton();
        customerController.setView(customerView);
        customerController.setModel(customerModel);
        
        customerView.setControllerGeneralButton(customerController);
        
        
>>>>>>> 0f78e3499ab69c5e108fd2918c78ec1c0e7fe9ae
        
        // VINCENZO
        
        /*controllerButton = new ControllerButtonCustomer();
        controllerButton.setModel(customerModel);
        controllerButton.setView(customerView);*/
        
        
        //customerView.setControllerGeneralButton(controllerButton);
        //creo controllerButton per la tabella e lo registro alla customerView
        
        /*controllerTab = new ControllerKeyTable();
        controllerTab.setModel(customerModel);
        controllerTab.setView(customerView);
        customerView.SetControllerKeyTable(controllerTab);
        
        controllerFocus = new ControllerFocusTableCustomer();
        controllerFocus.setModel(customerModel);
        controllerFocus.setView(customerView);
        customerView.setControllerFocusTable(controllerFocus);
        controllerMouse = new ControllerMouseTableCustomer();
        controllerMouse.setModel(customerModel);
        controllerMouse.setView(customerView);
        customerView.setControllerMouseTable(controllerMouse); 
        //creo controllerButton per la Jtext e le registro ai customerModel ed al controllerButton
        controllerText = new ControllerKeyCustomer();
        controllerText.setModel(customerModel);
        controllerText.setView(customerView);
        customerView.SetControllerKeyText(controllerText);
        x = new ControllerGeneralButton();
        x.setView(customerView);
        x.setModel(customerModel);
        customerView.setControllerGeneralButton(x);
        
        
        //visualizzo customerView*/
        
<<<<<<< HEAD
        */
        //visualizzo view
      }

    public CustomerPanel getView() {
        return view;
    }

    public void setView(CustomerPanel view) {
        this.view = view;
    }
=======
        
>>>>>>> 0f78e3499ab69c5e108fd2918c78ec1c0e7fe9ae
   }
}

