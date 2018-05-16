/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.DAO;

import Model.Addetto.Addetto;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pirozzi
 */
public interface AddettoDao {
    
    public int aggiungiAddetto(Addetto addetto);
    public int rimuoviAddetto(Addetto addetto);
    public int refreshAddetto(String new_value,String attribute_to_change,String id);
    public Addetto cercaAddettoStipendioMax(double stipendio);
    public List<Addetto> cercaAddettoStipendioMaggioredi(double stipendio);
    public List<Addetto> cercaAddettoStipendioMinidoredi(double stipendio); 
    public Addetto cercaAddettoNomeCognomeCf(String nome,String cognome,String cf);
    public List<Addetto> getAllAddetti();
    public Set<Addetto> getAddettiParolaChiave(ArrayList<String> parola);
}
