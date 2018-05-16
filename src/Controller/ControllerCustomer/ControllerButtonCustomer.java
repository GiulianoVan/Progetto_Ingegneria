/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ControllerCustomer;

import Model.CustomerModel;
import View.GeneralPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Vincent
 */
public class ControllerButtonCustomer implements ActionListener
{
/*
    Deve rendere generali anche il model e le view ? in maniera tale che posso gestire meglio.
    In pratica posso passargli delle cose + generali.-> dichiarare un model abstract e una view Abstract
    
    */
    GeneralPanel view;
    CustomerModel model;
 
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if(action.equals("CERCA"))
        {
            if(view.getTextSearchGeneral().getText().trim().length() == 0)
            {
              JOptionPane.showMessageDialog(view, "Impossibile cercare senza nessun valore.\nRiprovare inserendo un valore nel campo apposito.", "ERRORE", JOptionPane.ERROR_MESSAGE);

            }
            else
            {
                   ArrayList<String> parolechiavi;
                   String testo = view.getTextSearchGeneral().getText();
                   parolechiavi = EstraiParoleChiavi(testo);
                   model.doSearch(parolechiavi);      
            }
        }
    }
   public void setModel(CustomerModel nuovo)
      {
        model = nuovo;
      }
   
    public void setView(GeneralPanel nuovo)
      {
        view = nuovo;
      }

     public  ArrayList<String> EstraiParoleChiavi(String testo)
    {
       
        ArrayList<String> parolechiavi= new ArrayList<>();
         
                   while(testo.contains(" "))
                   {
                      if(testo.indexOf(" ")!= 0) //primo carattere non è uno spazio
                      {
                          parolechiavi.add(testo.substring(0,testo.indexOf(" ")));//prende sottostringa
                      }
                        
                       testo = testo.substring(testo.indexOf(" ")+1,testo.length()); 
                      
                   }
                  if(testo.trim().length()!=0 )//controllo che l'ultimo carattere non è uno spazio
                  {
                      parolechiavi.add(testo);
                  }//conterrà tutte le parole chiavi
             return parolechiavi;
    }
}
