package Controller.ControllerAddetti;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Controller.GeneralController;
import Model.Addetto.AddettiModel;
import View.AddettiView;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Pirozzi
 */
public class ControllerButtonAddetto extends GeneralController
{
/*
    Deve rendere generali anche il model e le view ? in maniera tale che posso gestire meglio.
    In pratica posso passargli delle cose + generali.-> dichiarare un model abstract e una view Abstract
    
    */
    AddettiView view;
    AddettiModel model;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String action = e.getActionCommand();
        if(action.equals("CERCA"))
        {
            if(view.getCercaText().trim().length() == 0)
            {
              JOptionPane.showMessageDialog(view, "Impossibile cercare senza nessun valore.\nRiprovare inserendo un valore nel campo apposito.", "ERRORE", JOptionPane.ERROR_MESSAGE);

            }
            else
            {
                   ArrayList<String> parolechiavi;
                   String testo = view.getCercaText();
                   parolechiavi = EstraiParoleChiavi(testo);
                   model.doSearch(parolechiavi);      
            }
        }
    }
   public void setModel(AddettiModel nuovo)
      {
        model = nuovo;
      }
    public void setView(AddettiView nuovo)
      {
        view = nuovo;
      }
   
}
