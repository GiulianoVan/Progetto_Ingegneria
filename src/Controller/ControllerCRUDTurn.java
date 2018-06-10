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
import GestioneTabella.MyDefaultTableModel;
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
    int flag_errorDelete;
    
    public ControllerCRUDTurn( ManagementTurnDao dao , ManagementTurnView view )
    {
        this.view = view;
        this.dao = dao;
        this.view.getButtonSearch().addActionListener(this);
        this.view.getButtonDelete().addActionListener(this);
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
                        turn.addAll(dao.getTurnEvent(view.getTextCodeEvent().getText()));
                    else
                        turn.retainAll(dao.getTurnEvent(view.getTextCodeEvent().getText()));
                }
                catch(SQLException err)
                {
                    JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);

                }
            }
            if(view.getTextTaxCode().getText().trim().length()!= 0)
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
            view.updateTable(turn);
            
        }
        else if(action.equalsIgnoreCase("DELETE"))
        {
            String deleteMessage;
            int rowCount = view.getTableMenagementEvents().getSelectedRowCount();
            if(rowCount > 1)
                deleteMessage = "Hai selezionato "+rowCount+" righe, sei sicuro di volerle eliminare tutte?";
            else
                deleteMessage = "Sei sicuro di voler eliminare la riga selezionata?";
            int answer  = JOptionPane.showConfirmDialog(view,deleteMessage,"DELETE",JOptionPane.YES_NO_OPTION);
            if(answer == 0) // ha cliccato si
            {
                MyDefaultTableModel tab = (MyDefaultTableModel) view.getTableMenagementEvents().getModel();
                int start_selection = view.getTableMenagementEvents().getSelectedRow();
                int end_selection = rowCount+start_selection-1;
                
                for(int i = end_selection ; i>= start_selection;--i)
                {
                    try
                    {
                        dao.deleteTurn(Integer.parseInt(view.getTableMenagementEvents().getValueAt(i,tab.getId_column()).toString()));
                        //dao.deleteTurn((tab.getValueAt(i,tab.getId_column()).toString()));
                        tab.removeRow(i);
                    }
                    catch(SQLException errorDelete)
                    {
                          if(flag_errorDelete==1)
                          {
                              JOptionPane.showMessageDialog(view, "Errore : "+errorDelete.getMessage(), "ERRORE", JOptionPane.ERROR_MESSAGE);
                              flag_errorDelete = 0;
                          }
                    }
                     
                }
                 flag_errorDelete=1;
                 //se cancello le righe,risetto a false il button.
                 view.getButtonDelete().setEnabled(false);
            }
            //JTable tab = view.getTableSearchGeneral();
            
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
