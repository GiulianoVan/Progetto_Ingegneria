/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import java.util.Map;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Pirozzi
 */
public class PieChart implements Charts{

    @Override
    public JFreeChart drawChart(Map<Comparable,Number> map) {
        
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        
        for(Comparable key : map.keySet())
        {
            pieDataset.setValue(key.toString(),map.get(key));
        }
       
        JFreeChart chart = ChartFactory.createPieChart("Pie Chart", pieDataset, true, true, true);
        PiePlot P = (PiePlot) chart.getPlot();
      /*
        ChartFrame frame = new ChartFrame("Pie Chart", chart);
        //frame.setVisible(true);
        frame.setSize(450,500);
        
        return frame; */
       return chart;
    }

    
    
}
