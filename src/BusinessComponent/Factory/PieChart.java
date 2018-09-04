/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessComponent.Factory;

import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author INGSW2017_22
 */
public class PieChart implements Charts{

    @Override
    public JFreeChart drawChart(Map<Comparable,Number> map) {
        
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        
        for(Comparable key : map.keySet())
        {
            pieDataset.setValue(key,map.get(key));
            
        }
       
        JFreeChart chart = ChartFactory.createPieChart("Result", pieDataset, true, true, true);
        PiePlot P = (PiePlot) chart.getPlot();
        
       return chart;
    }
}
