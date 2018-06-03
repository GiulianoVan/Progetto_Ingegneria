/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.GeneralPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Pirozzi
 */
public abstract class ControllerGeneral implements ActionListener,MouseListener,FocusListener,KeyListener{

    GeneralPanel view;
    
    
     ControllerGeneral(GeneralPanel view)
    {       
        this.view =view;
        this.view.getButtonAdvGeneral().addActionListener(this);
        this.view.getButtonBackSearchGeneral().addActionListener(this);
        this.view.getTextSearchGeneral().addFocusListener(this);
        this.view.getTextSearchGeneral().addMouseListener(this);
        this.view.getButtonCreateGeneral().addActionListener(this);
        this.view.getButtonBackCreate().addActionListener(this);
        this.view.getButtonDeleteAdvSearch().addActionListener(this);
        this.view.getButtonDeleteSearch().addActionListener(this);
    }
 
    
     @Override
    public void actionPerformed(ActionEvent e){

        //SE il comando si chiama CREA ADDETTO fai questo
        String action = e.getActionCommand();
    
        if(action.equals("ADVSEARCHPANEL"))
        {
            view.changeAdvGeneral();
            
        }
        else if(action.equals("BACKSEARCH"))
        {
            view.backNormalSearch();
        }
    };

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
         if(view.getTextSearchGeneral().getText().equals(""))
        {
            view.setNameSearch();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
            if(e.getClickCount()>=1)
             view.getTextSearchGeneral().setText("");
    }

    @Override
    public void mousePressed(MouseEvent e) {
         view.getTextSearchGeneral().setText("");

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
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
