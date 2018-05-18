/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Addetto.AddettiModel;
import View.GeneralPanel;
import View.GeneralView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Pirozzi
 */
public class ControllerAddetto extends ControllerGeneral{ //o estende la generale ?
//UTILIZZANDOLA QUANDO ESTENDE,BASTA USARE UN SOLO CONTROLLER,CONTROLLERADDETTO. IL COLLEGAMENTI COL PADRE VENGONO
    //FATTI IN AUTOMATICO NEL COSTRUTTORE DEL APDRE
    GeneralPanel view;
    AddettiModel model;
    
    public ControllerAddetto(AddettiModel model,GeneralPanel view)
    {
        super(model,view);
        this.model = model;
        this.view = view;
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
                   model.doSearch(parolechiavi);      
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
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
                model.doSearch(parolechiavi);
            }
           }
    }
    
       
}
