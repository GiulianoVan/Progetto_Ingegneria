/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;

import Controller.AddettoTableController.ControllerMouseAddetto;
import Controller.ControllerAddetto.KeyControllerAddetti;
import Controller.ControllerAddetto.ControllerButtonAddetto;
import Controller.ControllerAddetto.ControllerTextAddetto;
import Controller.GeneralController;
import Model.Addetto.AddettiModel;
import View.AddettiView;
import javax.swing.SwingUtilities;

/**
 *
 * @author Pirozzi
 */
public class RunMVCAddetti {
    
    
//   public void startMVCAddetti()
  // {
    public static void main(String[] args)
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
        ControllerButtonAddetto controllerButton = new ControllerButtonAddetto();
        controllerButton.setModel(model);
        controllerButton.setView(viewAddetti);
        viewAddetti.setActionControllerButton(controllerButton);
        //creo controllerButton per la tabella e lo registro alla view
        KeyControllerAddetti controllerTab = new KeyControllerAddetti();
        controllerTab.setModel(model);
        controllerTab.setView(viewAddetti);
        viewAddetti.setControllerKeyTable(controllerTab);
        ControllerMouseAddetto controllerMouse = new ControllerMouseAddetto();
        controllerMouse.setModel(model);
        controllerMouse.setView(viewAddetti);
        viewAddetti.setControllerMouse(controllerMouse); 
        //creo controllerButton per la Jtext e le registro ai model ed al controllerButton
        ControllerTextAddetto controllerText = new ControllerTextAddetto();
        controllerText.setModel(model);
        controllerText.setView(viewAddetti);
        viewAddetti.setControllerText(controllerText);
        //visualizzo view
        viewAddetti.setVisible(true);
      }
    };
       SwingUtilities.invokeLater(target);  
   }
}
