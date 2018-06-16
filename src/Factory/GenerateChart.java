/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

/**
 *
 * @author Pirozzi
 */
public class GenerateChart {
    
    Charts chart;
    
    public Charts getChart(String chart)
    {
        if(chart.equals("PIE"))
            return new PieChart();
        else if(chart.equals("LINE"))
            return new LineChart();
        
        return null;
    }
}
