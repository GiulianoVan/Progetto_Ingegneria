/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestioneTabella;


import Model.JavaBean.Customer;
import Model.JavaBean.Addetto;
import Model.JavaBean.Event;
import java.util.Set;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Pirozzi
 */

public class  MyDefaultTableModel<T>  extends DefaultTableModel {
   
    
    private  int row;
    private  int column;
    private String oldvalue;
    private int id_column; // l'ultima colonna contiene sempre id.
    private int row_changed;
    private int column_changed;

    public void setRow_changed(int row) {
        row_changed = row;
    }

    public void setColumn_changed(int col) {
        column_changed = col;
    }
    
    
    
    public int getId_column() {
        return id_column;
    }
    
    
    public MyDefaultTableModel()
    {
        super();
        row = -1;
        column=-1; 
    }
 
    
     @Override
    public boolean isCellEditable(int row, int column) {
           
           if(this.row==row && this.column==column)
           {
                  return true;
           }
           else{
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
       this.addColumn("CF");
       this.addColumn("EMAIL");
       this.addColumn("TEL");
       this.addColumn("STIPENDIO");
       this.addColumn("LIVELLO");
       this.addColumn("ID");

       for(Addetto add : addetti)
       {
           this.addRow(new String[]{add.getNome(),add.getCognome(),add.getCf(),add.getEmail(),add.getTel(),add.getStipendio().toString(),add.getLivello().toString(),add.getId()});
       }   
       //setto sempre l'id all'ultima colonna;
       this.id_column = this.getColumnCount()-1;
    }
    
        public  void createModelBySetEvent(Set<Event> events)
    {
      //  TITOLO,EVENTOTYPE,GENERETYPE,DATA,NOMELUOGO,CAP,DESCRIPTION,IDEVENTO 
       this.addColumn("TITOLO");
       this.addColumn("EVENTOTYPE");
       this.addColumn("GENERETYPE");
       this.addColumn("DATA");
       this.addColumn("LUOGO");
       this.addColumn("CAP");
       this.addColumn("DESCRIZIONE");
       this.addColumn("ID");

       for(Event event : events)
       {
           this.addRow(new String[]{event.getTitle(),event.getTypeEvent(),event.getTypeGender(),event.getDataEvent(),event.getPlaceName(),event.getCap(),event.getDescription(),event.getIdEvent()});
       }   
       //setto sempre l'id all'ultima colonna;
       this.id_column = this.getColumnCount()-1;
    }
    
    public  void createModelBySetCustomer(Set<Customer> customer)
    {
       //SELECT NOME,COGNOME,CF,EMAIL,TEL,STIPENDIO,LIVELLO 
              
       this.addColumn("USERNAME");
       this.addColumn("NOME");
       this.addColumn("COGNOME");
       this.addColumn("CF");
       this.addColumn("EMAIL");
       this.addColumn("TEL");
       this.addColumn("DNASCITA");
       this.addColumn("ID");
       for(Customer add : customer)
       {
           this.addRow(new String[]{add.getUsername(),add.getName(),add.getSurname(),add.getTax_code(),add.getEmail(),add.getPhone(),add.getDate_born().toString(),add.getIdCustomer()});
       }   
       //ID SEMPRE SU ULTIMA COLONNA,XKè COLONNE IN MEZZO NON POSSONO ESSERE NASCOSTE.
       this.id_column = this.getColumnCount()-1;
        
    }

  
}
