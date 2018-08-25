/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessComponent.Factory;

/**
 *
 * @author Pirozzi
 */
public class GenerateChart {
    
    
    public Charts getChart(String chart)
    {
        if(chart.equals("PIE"))
            return new PieChart();
        else if(chart.equals("LINE"))
            return new LineChart();
        
        return null;
    }
}
