/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import JavaBean.Customer;
import Model.Addetto.Addetto;
import java.util.Set;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Pirozzi
 */

public class MyDefaultTableModel<T>  extends DefaultTableModel {
   
    
    private int row = -1;
    private int column=-1;
    String oldvalue;
 
    public MyDefaultTableModel()
    {
        super();
        
    }
 
    public String getOldValue()
    {
        return oldvalue;
    }
     @Override
    public boolean isCellEditable(int row, int column) {
           
           if(this.row==row && this.column==column)
           {
               
               oldvalue = (String) this.getValueAt(row, column).toString();
               
               return true;
           }
           return false;
    }

    public void setRowEditable(int row)
    {
        this.row=row;
    }

    public void setColumnEditable(int column)
    {
        this.column=column;
    }
    
    public void resetCellEditable()
    {
        this.row = -1;
        this.column=-1;
    }
    
    public  MyDefaultTableModel createModelBySetAddetto(Set<Addetto> addetti)
    {
       MyDefaultTableModel mod = new MyDefaultTableModel();
       //SELECT NOME,COGNOME,CF,EMAIL,TEL,STIPENDIO,LIVELLO 
       
       mod.addColumn("NOME");
       mod.addColumn("COGNOME");
       mod.addColumn("COD. FISCALE");
       mod.addColumn("EMAIL");
       mod.addColumn("TELEFONO");
       mod.addColumn("STIPENDIO");
       mod.addColumn("LIVELLO");
       mod.addColumn("ID");
       for(Addetto add : addetti)
       {
           mod.addRow(new String[]{add.getNome(),add.getCognome(),add.getCf(),add.getEmail(),add.getTel(),add.getStipendio().toString(),add.getLivello().toString(),add.getId()});
       }   
        
        return mod; 
    }
    
    public  MyDefaultTableModel createModelBySetCustomer(Set<Customer> customer)
    {
       MyDefaultTableModel mod = new MyDefaultTableModel();
       //SELECT NOME,COGNOME,CF,EMAIL,TEL,STIPENDIO,LIVELLO 
              
       mod.addColumn("USERNAME");
       mod.addColumn("NOME");
       mod.addColumn("COGNOME");
       mod.addColumn("COD. FISCALE");
       mod.addColumn("EMAIL");
       mod.addColumn("TELEFONO");
       mod.addColumn("ID");
       for(Customer add : customer)
       {
           mod.addRow(new String[]{add.getUsername(),add.getName(),add.getSurname(),add.getEmail(),add.getTax_code(),add.getPhone(),add.getDate_born().toString(),add.getIdCustomer()});
       }   
        
        return mod; 
    }

  
}
