/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ControllerAddetti;

import Controller.GeneralController;
import Model.AddettiModel;
import Model.LoginModel;
import View.AddettiView;
import View.LoginView;
import View.AddettiViewX;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Pirozzi
 */
public class AddettoButtonController extends GeneralController{
/*
    Deve rendere generali anche il model e le view ? in maniera tale che posso gestire meglio.
    In pratica posso passargli delle cose + generali.-> dichiarare un model abstract e una view Abstract
    
    */
    private AddettiView viewAddetti;
    private AddettiModel modAddetti;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String action = e.getActionCommand();
        if(action.equals("CERCA"))
        {
            if(viewAddetti.getCercaText().trim().length() == 0)
            {
              JOptionPane.showMessageDialog(viewAddetti, "Impossibile cercare senza nessun valore.\nRiprovare inserendo un valore nel campo apposito.", "ERRORE", JOptionPane.ERROR_MESSAGE);

            }
            else
            {
                   ArrayList<String> parolechiavi;
                   String testo = viewAddetti.getCercaText();
                   parolechiavi = EstraiParoleChiavi(testo);
                   modAddetti.doSearch(parolechiavi);      
            }
        }
    }
   public void setModel(AddettiModel nuovo)
      {
        modAddetti = nuovo;
      }
    public void setView(AddettiView nuovo)
      {
        viewAddetti = nuovo;
      }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
