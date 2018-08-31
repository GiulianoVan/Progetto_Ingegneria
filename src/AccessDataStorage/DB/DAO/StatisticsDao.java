/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessDataStorage.DB.DAO;

import java.sql.SQLException;

/**
 *
 * @author Pirozzi
 */
public interface StatisticsDao  {
   
    public Double etaMediaTipoEvento(String tipo_evento) throws SQLException;//istogramma
    public Integer  bigliettiVendutiPerAnno(int anno) throws SQLException;//line chart
    public Integer partecipazioneTipoEventoInUnAnno(int year,String tipoEvento) throws SQLException; //pieChart
    public Double incassiPerAnno(int anno) throws SQLException;
    
}
