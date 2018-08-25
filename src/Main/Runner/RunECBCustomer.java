/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Runner;


import BusinessComponent.Boundary.BoundaryViewCustomer;
import BusinessComponent.Controller.ControllerRUDCustomer;
import BusinessComponent.Boundary.BoundaryGeneralPanel;
import AccessDataStorage.DB.DAO.CustomerDao;
import AccessDataStorage.DB.DAO.ImplMySqlCustomerDao;
import BusinessComponent.Boundary.BoundaryTableCustomer;
import Presentation.CustomerPanel;


/**
 *
 * @author Vincent
 */
public class RunECBCustomer {
    
    private CustomerPanel customerView;
    private BoundaryViewCustomer boundary;
    private BoundaryTableCustomer boundaryTab;
    private CustomerDao dao;
    private ControllerRUDCustomer controller;
   public void startMVCCustomer()
   {
          dao= new ImplMySqlCustomerDao();
          customerView = new CustomerPanel();
          controller = new ControllerRUDCustomer(dao);
          boundary = new BoundaryViewCustomer(controller,customerView);
          boundaryTab = new BoundaryTableCustomer(controller,customerView);

          /*
          dao = new ImplMySqlAddettoDao();
         addettiView = new AddettiPanel();
         controller = new ControllerCRUDAddetto(dao);
         //controllerTable = new ControllerUpdateAddetto(dao,addettiView);
         boundary = new BoundaryViewSecurity(addettiView,controller);
         boundaryTab = new BoundaryTableSecurity(addettiView,controller);
          */ 
    }


    public CustomerPanel getCustomerView() {
        return customerView;
    }

    public void setCustomerView(CustomerPanel customerView) {
        this.customerView = customerView;
    }
}

