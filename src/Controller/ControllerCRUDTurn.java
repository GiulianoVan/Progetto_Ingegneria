/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.DAO.AddettoDao;
import DB.DAO.EventDao;
import DB.DAO.ImplAddettoDao;
import DB.DAO.ImplEventDao;
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
import Model.JavaBean.Addetto;
import Model.JavaBean.Event;
import View.MenagementCustomers;
import java.sql.SQLException;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        //this.view.getTextCodeEvent().addKeyListener(this);
        //this.view.getTextTaxCode().addKeyListener(this);
        this.view.getTextTitleEventWork().addKeyListener(this);
        this.view.getTextSurnameSecurityWork().addKeyListener(this);
        this.view.getButtonCreate().addActionListener(this);
        this.view.getButtonLoadEventWork().addActionListener(this);
        this.view.getButtonLoadTaxWork().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();
        
        if(action.equals("SEARCH"))
        {
            Set<ManagementTurn> turn = new HashSet<>(); 
            if(view.getComboEventWork().getSelectedItem() != null)
            {
                try{
                    if(turn.isEmpty())
                        turn.addAll(dao.getTurnEvent(view.getComboEventWork().getSelectedItem().toString()));
                    else
                        turn.retainAll(dao.getTurnEvent(view.getComboEventWork().getSelectedItem().toString()));
                }
                catch(SQLException err)
                {
                    JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);

                }
            }
            if(view.getComboTaxCodeWork().getSelectedItem()!= null)
            {
                try{
                    if(turn.isEmpty())
                        turn.addAll(dao.getTurnAddetto(view.getComboTaxCodeWork().getSelectedItem().toString()));
                    else
                        turn.retainAll(dao.getTurnAddetto(view.getComboTaxCodeWork().getSelectedItem().toString()));
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
                deleteMessage = "You selected "+rowCount+" rows, do you want delete them?";
            else
                deleteMessage = "Do you want delete it?";
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
                              JOptionPane.showMessageDialog(view, "Error : "+errorDelete.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
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
        else if(action.equalsIgnoreCase("CREATE"))
        {
            if(view.getComboEventWork().isEnabled())
            {
                try {
                String CF = view.getComboTaxCodeWork().getSelectedItem().toString();
                Integer codeEvent = Integer.parseInt(view.getComboEventWork().getSelectedItem().toString());
                Time start = new Time((int) view.getSpinnerStart().getValue(), 0, 0);
                Time end = new Time((int) view.getSpinnerEnd().getValue(), 0, 0);
                
                dao.insertTurn(CF, codeEvent, start, end);
                JOptionPane.showMessageDialog(view, "Successfull Insert", "INSERT", JOptionPane.INFORMATION_MESSAGE);
                
                } catch (SQLException ex) 
                {
                    JOptionPane.showMessageDialog(view, "Error : "+ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(view, "Error : "+ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            else
                JOptionPane.showMessageDialog(view, "Error : Tax code or ID Event are not selected", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else if(action.equalsIgnoreCase("LOADEVENT"))
        {
            loadEvent();
        }
        else if(action.equalsIgnoreCase("LOADTAX"))
        {
            loadTaxCode();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
            /*if(e.getKeyChar() == '\n')
                view.getButtonSearch().doClick();//clicca il pulsante da solo xD.. risparmio codice*/
            if(e.getKeyChar()=='\n')
            {
                if(e.getComponent().equals(view.getTextSurnameSecurityWork()))
                {
                    loadTaxCode();
                }
                if(e.getComponent().equals(view.getTextTitleEventWork()))
                {
                    loadEvent();
                }
            }
       }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
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
    
    public void loadEvent()
    {
        EventDao eventDao = new ImplEventDao();
        Set<Event> evt = null;
        try {
            evt = eventDao.searchByTitle(view.getTextTitleEventWork().getText());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error : load combo event failed", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        if(!evt.isEmpty())
        {
            for(Event tmp : evt)
            {
               view.getComboEventWork().addItem(tmp.getIdEvent());
            }
            view.getComboEventWork().setEnabled(true);
        }
        else
        {
            view.getComboEventWork().setEnabled(false);
            view.getComboEventWork().removeAllItems();
        }         
    }
    
    public void loadTaxCode()
    {
        AddettoDao addettoDao = new ImplAddettoDao();
        Set<Addetto> addetto = null;
        try {
            addetto = addettoDao.searchBySurname(view.getTextSurnameSecurityWork().getText());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error : Load combo tax code failed", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        if(!addetto.isEmpty())
        {
            for(Addetto tmp : addetto)
            {
               view.getComboTaxCodeWork().addItem(tmp.getCf());
            }
            view.getComboTaxCodeWork().setEnabled(true);
        }
        else
        {
            view.getComboTaxCodeWork().setEnabled(false);   
            view.getComboTaxCodeWork().removeAllItems();
        }
             
    }
    
}
