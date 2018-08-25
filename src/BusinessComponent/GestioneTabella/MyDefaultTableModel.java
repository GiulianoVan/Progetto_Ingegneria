/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessComponent.GestioneTabella;


import BusinessComponent.Entity.Customer;
import BusinessComponent.Entity.Addetto;
import BusinessComponent.Entity.Event;
import BusinessComponent.Entity.ManagementTurn;
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
    private int id_column;// l'ultima colonna contiene sempre id.
    private int row_changed;
    private int column_changed;

    public void setId_column(int id_column) {
        this.id_column = id_column;
    }

    public MyDefaultTableModel()
    {
        super();
        row = -1;
        column=-1; 
    }
    public MyDefaultTableModel(int IdColumn_Name)
    {
        id_column = IdColumn_Name;
        row = -1;
        column=-1; 
    }
    
    public String getOldvalue() {
        return oldvalue;
    }

    public void setOldvalue(String oldvalue) {
        this.oldvalue = oldvalue;
    }
    
    
    public void setRow_changed(int row) {
        row_changed = row;
    }

    public void setColumn_changed(int col) {
        column_changed = col;
    }

    public int getRow_changed() {
        return row_changed;
    }

    public int getColumn_changed() {
        return column_changed;
    }
    
    
    
    public int getId_column() {
        return id_column;
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
       
       this.addColumn("NAME");
       this.addColumn("SURNAME");
       this.addColumn("TAX_CODE");
       this.addColumn("EMAIL");
       this.addColumn("PHONE");
       this.addColumn("SALARY");
       this.addColumn("BIRTH");
       this.addColumn("ID");
       
       
       
       for(Addetto add : addetti)
       {
           if(add != null)
           this.addRow(new String[]{add.getNome(),add.getCognome(),add.getCf(),add.getEmail(),add.getTel(),add.getStipendio().toString(),add.getDnascita().toString(),add.getId()});
       }   
       
       //setto sempre l'id all'ultima colonna;
       this.id_column = 7;
    }
    
        public  void createModelBySetEvent(Set<Event> events)
    {
      //  TITOLO,EVENTOTYPE,GENERETYPE,DATA,NOMELUOGO,CAP,DESCRIPTION,IDEVENTO 
       this.addColumn("TITLE");
       this.addColumn("EVENT_TYPE");
       this.addColumn("KIND_TYPE");
       this.addColumn("DATE");
       this.addColumn("PLACE_NAME");
       this.addColumn("DESCRIPTION");
       this.addColumn("ID");

       for(Event event : events)
       {
           if(event != null)
           this.addRow(new String[]{event.getTitle(),event.getTypeEvent(),event.getTypeGender(),event.getDataEvent().toString(),event.getPlaceName(),event.getDescription(),event.getIdEvent()});
       }   
       //setto sempre l'id all'ultima colonna;
       this.id_column = 6;
    }
    
    public  void createModelBySetCustomer(Set<Customer> customer)
    {
       //SELECT NOME,COGNOME,CF,EMAIL,TEL,STIPENDIO,LIVELLO 
              
       this.addColumn("USERNAME");
       this.addColumn("NAME");
       this.addColumn("SURNAME");
       this.addColumn("TAX_CODE");
       this.addColumn("EMAIL");
       this.addColumn("PHONE");
       this.addColumn("BIRTH");
       this.addColumn("ACQUISTI");
       this.addColumn("ID");
       for(Customer add : customer)
       {
           if(add != null)
           this.addRow(new String[]{add.getUsername(),add.getName(),add.getSurname(),add.getTax_code(),add.getEmail(),add.getPhone(),add.getDate_born().toString(),add.getTickets_purchased().toString(),add.getIdCustomer()});
       }   
       //ID SEMPRE SU ULTIMA COLONNA,XKè COLONNE IN MEZZO NON POSSONO ESSERE NASCOSTE.
       this.id_column = 8;
        
    }

     public  void createModelBySetTurn(Set<ManagementTurn> turn)
    {
      //  TITOLO,EVENTOTYPE,GENERETYPE,DATA,NOMELUOGO,CAP,DESCRIPTION,IDEVENTO 
       this.addColumn("NAME");
       this.addColumn("SURNAME");
       this.addColumn("TITLE");
       this.addColumn("DATE");
       this.addColumn("START");
       this.addColumn("END");
       this.addColumn("TURN_NUMBER");
       
       for(ManagementTurn manTurn : turn)
       {
           if(manTurn != null)
           this.addRow(new String[]{manTurn.getAddetto().getNome(),manTurn.getAddetto().getCognome(),manTurn.getEvent().getTitle(),manTurn.getEvent().getDataEvent().toString(),manTurn.getStartTurn().toString(),manTurn.getEndTurn().toString(),manTurn.getIdTurn().toString()});
       }   
       this.id_column = 6;
    }
  
   public void SetColumnName(String [] nameColumn)
   {
       for(String name : nameColumn)
       {
           this.addColumn(name);
           
       }
   }
}
