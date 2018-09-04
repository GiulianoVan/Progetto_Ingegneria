/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Runner;


import BusinessComponent.Boundary.BoundaryViewCustomer;
import BusinessComponent.Controller.ControllerRUDCustomer;
import AccessDataStorage.DB.DAO.CustomerDao;
import AccessDataStorage.DB.DAO.ImplMySqlCustomerDao;
import BusinessComponent.Boundary.BoundaryTableCustomer;
import Presentation.CustomerPanel;


/**
 *
 * @author INGSW2017_22
 */
public class RunECBCustomer {
    
    private CustomerPanel customerView;
    private BoundaryViewCustomer boundary;
    private BoundaryTableCustomer boundaryTab;
    private CustomerDao dao;
    private ControllerRUDCustomer controller;
   public void startECBCustomer()
   {
          dao= new ImplMySqlCustomerDao();
          customerView = new CustomerPanel();
          controller = new ControllerRUDCustomer(dao);
          boundary = new BoundaryViewCustomer(controller,customerView);
          boundaryTab = new BoundaryTableCustomer(controller,customerView);

    }


    public CustomerPanel getCustomerView() {
        return customerView;
    }

    public void setCustomerView(CustomerPanel customerView) {
        this.customerView = customerView;
    }
}

