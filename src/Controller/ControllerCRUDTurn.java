/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.JavaBean.ManagementTurn;
import View.ManagementTurnView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import DB.DAO.ManagementTurnDao;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Pirozzi
 */
public class ControllerCRUDTurn implements ActionListener,KeyListener,MouseListener {
    
    ManagementTurnView view;
    ManagementTurnDao dao;
    
    public ControllerCRUDTurn( ManagementTurnDao dao , ManagementTurnView view )
    {
        this.view = view;
        this.dao = dao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();
        
        if(action.equals("SEARCH"))
        {
            Set<ManagementTurn> turn = new HashSet<>();
            
            if(view.getTextCodeEvent().getText().trim().length()!= 0)
            {
                try{
                    if(turn.isEmpty())
                        turn.addAll(dao.getTurnAddetto(view.getTextTaxCode().getText()));
                    else
                        turn.retainAll(dao.getTurnAddetto(view.getTextTaxCode().getText()));
                }
                catch(SQLException err)
                {
                    JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);

                }
            }
            if(view.getTextCodeEvent().getText().trim().length()!= 0)
            {
                try{
                    if(turn.isEmpty())
                        turn.addAll(dao.getTurnEvent(view.getTextCodeEvent().getText()));
                    else
                        turn.retainAll(dao.getTurnEvent(view.getTextCodeEvent().getText()));
                }
                catch(SQLException err)
                {
                    JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);

                }
            }
            view.updateTable(turn);
            
        }
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
