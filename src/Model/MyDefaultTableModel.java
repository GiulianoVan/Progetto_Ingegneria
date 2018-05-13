/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.util.Set;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Pirozzi
 */

public class MyDefaultTableModel<T>  extends DefaultTableModel {
   
    TableColumnManager tmp;
    private int row = -1;
    private int column=-1;
    
    public MyDefaultTableModel()
    {
        
    }
 
     @Override
    public boolean isCellEditable(int row, int column) {
           if(this.row==row && this.column==column)
           {
               this.row=-1;
               this.column=-1;
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
    
     public static MyDefaultTableModel createModelBySet(Set<Addetto> addetti)
    {
       MyDefaultTableModel mod = new MyDefaultTableModel();
       //SELECT NOME,COGNOME,CF,EMAIL,TEL,STIPENDIO,LIVELLO 
       
       mod.addColumn("NOME");
       mod.addColumn("COGNOME");
       mod.addColumn("CF");
       mod.addColumn("EMAIL");
       mod.addColumn("TEL");
       mod.addColumn("STIPENDIO");
       mod.addColumn("LIVELLO");
       mod.addColumn("ID");
       for(Addetto add : addetti)
       {
           mod.addRow(new String[]{add.getNome(),add.getCognome(),add.getCf(),add.getEmail(),add.getTel(),add.getStipendio().toString(),add.getLivello().toString(),add.getId()});
       }   
        
        return mod; 
    }
}
