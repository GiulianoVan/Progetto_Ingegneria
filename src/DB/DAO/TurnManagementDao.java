/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.DAO;

import Model.JavaBean.Addetto;
import Model.JavaBean.Event;
import Model.JavaBean.TurnManagement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Set;

/**
 *
 * @author Pirozzi
 */
public interface TurnManagementDao {
    
    //ritorna tutti i turni di quell'addetto.
    Set<TurnManagement> getTurnAddetto(Addetto addetto) throws SQLException;
    //ritorna tutti i turni per l'evento
    Set<TurnManagement> getTurnAddetto(String idAddetto) throws SQLException;
    Set<TurnManagement> getTurnEvent(Event event) throws SQLException;
    Set<TurnManagement> getTurnEvent(String idEvent) throws SQLException;
    //inserimento turno.
    int insertTurn(Addetto addetto,Event event,Time start,Time end)throws SQLException;
    int deleteTurn(Addetto addetto,Event event,Time start,Time end) throws SQLException;
   // int deleteTurn(String idAddetto,String idEvento);
}
