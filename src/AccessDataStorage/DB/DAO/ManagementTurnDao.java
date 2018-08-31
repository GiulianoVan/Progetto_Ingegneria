/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessDataStorage.DB.DAO;

import BusinessComponent.Entity.ManagementTurn;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Set;

/**
 *
 * @author Pirozzi
 */
public interface ManagementTurnDao {
    
    //ritorna tutti i turni per l'evento
    //Set<ManagementTurn> getTurnAddetto(String idAddetto) throws SQLException;
    Set<ManagementTurn> getTurnAddetto(String cf) throws SQLException;
    Set<ManagementTurn> getTurnEvent(String idEvent) throws SQLException;
    //inserimento turno.
    int insertTurn(String CF, Integer codEvent, Time start,Time end)throws SQLException;
    int updateTurn(int turn,String field,Object new_value) throws SQLException;
    int deleteTurn(Integer idTurn) throws SQLException;

   // int deleteTurn(String idAddetto,String idEvento);
}
