/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessComponent.Boundary;

import BusinessComponent.Controller.ControllerCRUDTurn;
import Presentation.ManagementTurnView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import BusinessComponent.ManagementModelTable.MyDefaultTableModel;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Pirozzi
 */
public class BoundaryViewTurn implements ActionListener,KeyListener,MouseListener {
    
    ManagementTurnView view;
    ControllerCRUDTurn controller;
    int flag_errorDelete;
    
    public BoundaryViewTurn( ControllerCRUDTurn contr , ManagementTurnView view )
    {
        this.view = view;
        this.controller = contr;
        this.view.getButtonSearch().addActionListener(this);
        this.view.getButtonDelete().addActionListener(this);
        //this.view.getTextCodeEvent().addKeyListener(this);
        //this.view.getTextTaxCode().addKeyListener(this);
        this.view.getTextTitleEventWork().addKeyListener(this);
        this.view.getTextSurnameSecurityWork().addKeyListener(this);
        this.view.getButtonCreate().addActionListener(this);
        this.view.getButtonLoadEventWork().addActionListener(this);
        this.view.getButtonLoadTaxWork().addActionListener(this);
        this.view.getTableMenagementEvents().addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();
      
        
        if(action.equals("SEARCH"))
        {
           
            doSearch();
            
        }
        
        
        else if(action.equalsIgnoreCase("DELETE"))
        {
            doDelete();
            //JTable tab = view.getTableSearchGeneral();  
        }
        else if(action.equalsIgnoreCase("CREATE"))
        {
            if(view.getComboEventWork().isEnabled())
            {
                doCreate();
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
        
        if(e.getComponent() == view.getTableMenagementEvents())
        {
            if(view.getTableMenagementEvents().getSelectedRow() != -1)
            {
                view.getButtonDelete().setEnabled(true);
            }
            else
                view.getButtonDelete().setEnabled(false);
        }
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
        view.getComboEventWork().removeAllItems();
        List<String> list_id = null;
        try {
             list_id = controller.getIdEventByTitle(view.getTextTitleEventWork().getText());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error : load combo event failed", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        if(list_id != null)
        {
            if(!list_id.isEmpty())
            {
                for(String idEv : list_id)
                {
                   view.getComboEventWork().addItem(idEv);
                }
                view.getComboEventWork().setEnabled(true);
            }
            else
             view.getComboEventWork().setEnabled(false);

        }
        else
        {
            view.getComboEventWork().setEnabled(false);
            view.getComboEventWork().removeAllItems();
        }         
    }
    
    public void loadTaxCode()
    {
        
        view.getComboTaxCodeWork().removeAllItems();
        List<String> list_code = null;
        try {
            list_code = controller.getTaxCodeAddettoBySurname(view.getTextSurnameSecurityWork().getText());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error : Load combo tax code failed", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        if(list_code != null)
        {
            if(!list_code.isEmpty())
            {
                for(String tmp : list_code)
                {
                   view.getComboTaxCodeWork().addItem(tmp);
                }
                view.getComboTaxCodeWork().setEnabled(true);
            }
            else
            {
                view.getComboTaxCodeWork().setEnabled(false);
            }
        }
        else
        {
            view.getComboTaxCodeWork().setEnabled(false);   
            view.getComboTaxCodeWork().removeAllItems();
        }
             
    }
/*
    private Set<ManagementTurn> doSearch(String event, String tax_code) {
        
       Set<ManagementTurn> turn = new HashSet<>();
       int intersect = 0;
       
        if(!event.equals(""))
            {
                intersect = 1;
                try{
                        turn.addAll(dao.getTurnEvent(event));
                }
                catch(SQLException err)
                {
                    JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            if(!tax_code.equals(""))
            {
                try{
                    if(turn.isEmpty() && intersect==0)
                    {
                        turn.addAll(dao.getTurnAddetto(tax_code));
                    }
                    else
                    {
                        turn.retainAll(dao.getTurnAddetto(tax_code));
                    }
                    
                     intersect = 1;
                    }
                catch(SQLException err)
                {
                    JOptionPane.showMessageDialog(view,"Error : "+err.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }         
            return turn;
    }
*/
    private void doDelete() {
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
                        controller.doDeleteTurn(Integer.parseInt(view.getTableMenagementEvents().getValueAt(i,tab.getId_column()).toString()));
                        view.getTableMenagementEvents().getColumnModel().getColumn(4).setHeaderValue("START TURN");
                        view.getTableMenagementEvents().getColumnModel().getColumn(5).setHeaderValue("END TURN");
                        view.getTableMenagementEvents().getColumnModel().getColumn(6).setHeaderValue("TURN NUMBER");
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
                /* if(view.getTableMenagementEvents().getRowCount()>0)
                 view.getTableMenagementEvents().setRowSelectionInterval(0, 0);*/
            }
    }

    private void doSearch()
    {
        String event = "";
        String tax_code = "";

        if(view.getComboEventWork().getSelectedItem() != null)
           event = view.getComboEventWork().getSelectedItem().toString();

        if(view.getComboTaxCodeWork().getSelectedItem() != null)
          tax_code = view.getComboTaxCodeWork().getSelectedItem().toString();


        try 
        {
            view.getTableMenagementEvents().setModel(controller.doSearch(tax_code, event));
        } 
        catch (SQLException ex) 
        {
          JOptionPane.showMessageDialog(view,ex.getMessage(), "Errore",JOptionPane.ERROR_MESSAGE);
        }

        if(view.getTableMenagementEvents().getSelectedRow()==-1)
        {
           view.getButtonDelete().setEnabled(false);
        }
        /*            
        if(view.getTableMenagementEvents().getRowCount()>0)
            view.getTableMenagementEvents().setRowSelectionInterval(0, 0);
        else
        {
            view.getButtonDelete().setEnabled(false);
        }*/
    }

    private void doCreate()
    {
        try 
        {
            String CF = view.getComboTaxCodeWork().getSelectedItem().toString();
            Integer codeEvent = Integer.parseInt(view.getComboEventWork().getSelectedItem().toString());
            Time start = new Time((int) view.getSpinnerStart().getValue(), 0, 0);
            Time end = new Time((int) view.getSpinnerEnd().getValue(), 0, 0);

            controller.createTurn(CF, codeEvent, start, end);
            JOptionPane.showMessageDialog(view, "Successfull Insert", "INSERT", JOptionPane.INFORMATION_MESSAGE);
           // view.getButtonSearch().doClick(); //aggiorno tabella.
            } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(view, "Error : "+ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(view, "Error : "+ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
            
    }  
       
}
