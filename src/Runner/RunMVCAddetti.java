/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;

import Controller.ControllerAddetti.KeyControllerAddetti;
import Controller.ControllerAddetti.ControllerButtonAddetto;
import Controller.ControllerAddetti.ControllerTextAddetto;
import Controller.GeneralController;
import Model.Addetto.AddettiModel;
import View.AddettiView;
import javax.swing.SwingUtilities;

/**
 *
 * @author Pirozzi
 */
public class RunMVCAddetti {
    
    
   // public void startMVCAddetti()
    //{
      public static void main(String []args)
      {
      Runnable target = new Runnable() {
      @Override
        public void run() {
        // creo model
        AddettiModel model = new AddettiModel();
        // creo le view passando il model
        AddettiView viewAddetti = new AddettiView();
        //model registra un osservatore
        model.addObserver(viewAddetti);
        //controller button della vista
        ControllerButtonAddetto controller = new ControllerButtonAddetto();
        //registro model e view al controller
        controller.setModel(model);
        controller.setView(viewAddetti);
        //registro controller al view
        viewAddetti.setActionControllerButton(controller);
        //creo controller per la tabella e lo registro alla view
        KeyControllerAddetti controllerTab = new KeyControllerAddetti();
        controllerTab.setModel(model);
        controllerTab.setView(viewAddetti);
        viewAddetti.setControllerKeyTable(controllerTab);
        //credo controller per la Jtext e le registro ai model ed al controller
       // ControllerTextAddetto controllerText = new ControllerTextAddetto();
       // controllerText.setModel(model);
        // controllerText.setView(viewAddetti);
       //  viewAddetti.setControllerText(controllerText);
        //visualizzo view
        viewAddetti.setVisible(true);
         
      }
    };
       SwingUtilities.invokeLater(target);  
   // }
   }
}
