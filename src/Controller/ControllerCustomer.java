/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CustomerModel;
import Model.EventModel;
import View.GeneralPanel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Pirozzi
 */
public class ControllerCustomer extends ControllerGeneral{
 
    
    GeneralPanel view;
    CustomerModel model;

    public ControllerCustomer(CustomerModel model, GeneralPanel view) {
        super(model, view);
        this.view = view;
        this.model = model;
        this.view.getButtonOkSearchGeneral().addActionListener(this);
        this.view.getTextSearchGeneral().addKeyListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        super.actionPerformed(e);//fai quello del pradre e poi questo.
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
                   model.doSearchCustomer(parolechiavi);      
            }
        }
        else if(action.equals("DELETE"))
        {
            //se tt è vuoto,impossibile effettuare la ricerca.
           //altrimenti creo una mappa campo-valore e la passo al model x fare l'interrogazione.
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) 
    {
        
        if(view.getTextNameGeneralSearch().getText().trim().length()>0)
           {
             if(e.getKeyChar()=='\n')
            { 
                String testo = view.getTextSearchGeneral().getText();
                ArrayList<String> parolechiavi = EstraiParoleChiavi(testo);
                model.doSearchCustomer(parolechiavi);
            }
           }
    }
    
}
