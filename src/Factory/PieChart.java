/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.LegendItemSource;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
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
            pieDataset.setValue(key,map.get(key));
            
        }
       
        JFreeChart chart = ChartFactory.createPieChart("Result", pieDataset, true, true, true);
        PiePlot P = (PiePlot) chart.getPlot();
        /*chart.addLegend(new LegendTitle(new LegendItemSource() {
            @Override
            public LegendItemCollection getLegendItems() {
                    LegendItemCollection x =  new LegendItemCollection();
                    x.add(new LegendItem("(AverageAge,Distribution Event)"));
                    return x;
            }
        }));*/
      /*
        ChartFrame frame = new ChartFrame("Pie Chart", chart);
        //frame.setVisible(true);
        frame.setSize(450,500);
        
        return frame; */
       return chart;
    }
}
