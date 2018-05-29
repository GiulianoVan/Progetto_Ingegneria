/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.DAO;

import Model.JavaBean.Addetto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Pirozzi
 */
public interface AddettoDao {
    
    public int aggiungiAddetto(Addetto addetto) throws SQLException;
    public int rimuoviAddetto(String idaddetto) throws SQLException;
    public int updateAddetto(String new_value,String attribute_to_change,String id) throws SQLException;
 // public Addetto cercaAddettoStipendioMax(double stipendio);
 // public List<Addetto> cercaAddettoStipendioMaggioredi(double stipendio);
 // public List<Addetto> cercaAddettoStipendioMinidoredi(double stipendio); 
 // public Addetto cercaAddettoNomeCognomeCf(String nome,String cognome,String cf);
 // public List<Addetto> getAllAddetti();
    public Set<Addetto> advancedSearch(Map<String,String> campo_value) throws SQLException; //ogni chiave della mappa è un campo,ed ogni campo ha un valore associato.
    public Set<Addetto> getAddettiParolaChiave(ArrayList<String> parola) throws SQLException;
}
