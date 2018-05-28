/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.DAO;

import java.time.Year;
import java.util.Map;

/**
 *
 * @author Pirozzi
 */
public interface StatisticsDao  {
   
    public Map<String,Double> etaMediaTipoEvento(String[] tipo_evento);//istogramma
    public Map<Year,Integer>  bigliettiVendutiPerAnno(Year annoInizio,Year annoFine);//line chart
    public Map <String,Double> eventiSeguitiInUnAnno(Year year); //pieChart
    public Map<Year,Double>  incassiPerAnno(Year annoInizio,Year annoFine);
    
}
