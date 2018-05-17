/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestioneTabella;


import JavaBean.Customer;
import JavaBean.Addetto;
import java.util.Set;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Pirozzi
 */

public class MyDefaultTableModel<T>  extends DefaultTableModel {
   
    
    private  int row;
    private  int column;
    String oldvalue;
    
    public MyDefaultTableModel()
    {
        super();
        row = -1;
        column=-1; 
        System.out.println("CIAO");
    }
 
    public String getOldValue()
    {
        return oldvalue;
    }
     @Override
    public boolean isCellEditable(int row, int column) {
           System.out.println("thisRow : "+ this.row+ " thisColumn: "+this.column);
           System.out.println("RowArg :"+row+" ColumnArg :"+column);
           System.out.println("ModelloIndirizzo:"+this.toString());
           if(this.row==row && this.column==column)
           {
               System.out.println("True");
                  return true;
           }
           else{
           System.out.println("False");
           return false;
           }
    }

    public void setRowEditable(int row)
    {
        this.row=row;
    }

    public void setColumnEditable(int column)
    {
        this.column=column;
    }
    /*
    public void resetCellEditable()
    {
        this.row = -1;
        this.column=-1;
    }
    */
    public  void createModelBySetAddetto(Set<Addetto> addetti)
    {
       //SELECT NOME,COGNOME,CF,EMAIL,TEL,STIPENDIO,LIVELLO 
       
       this.addColumn("NOME");
       this.addColumn("COGNOME");
       this.addColumn("COD. FISCALE");
       this.addColumn("EMAIL");
       this.addColumn("TELEFONO");
       this.addColumn("STIPENDIO");
       this.addColumn("LIVELLO");
       this.addColumn("ID");
       for(Addetto add : addetti)
       {
           this.addRow(new String[]{add.getNome(),add.getCognome(),add.getCf(),add.getEmail(),add.getTel(),add.getStipendio().toString(),add.getLivello().toString(),add.getId()});
       }   
        
    }
    
    public  void createModelBySetCustomer(Set<Customer> customer)
    {
       //SELECT NOME,COGNOME,CF,EMAIL,TEL,STIPENDIO,LIVELLO 
              
       this.addColumn("USERNAME");
       this.addColumn("NOME");
       this.addColumn("COGNOME");
       this.addColumn("COD. FISCALE");
       this.addColumn("EMAIL");
       this.addColumn("TELEFONO");
       this.addColumn("ID");
       for(Customer add : customer)
       {
           this.addRow(new String[]{add.getUsername(),add.getName(),add.getSurname(),add.getEmail(),add.getTax_code(),add.getPhone(),add.getDate_born().toString(),add.getIdCustomer()});
       }   
        
        
    }

  
}
