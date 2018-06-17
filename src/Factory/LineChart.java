/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import java.awt.Color;
import java.util.Map;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Pirozzi
 */
public class LineChart implements Charts{

    @Override
    public JFrame drawChart(Map<Comparable,Number> map) {
            
        DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
        for(Comparable key : map.keySet())
        {
           linedataset.setValue(map.get(key),"",key.toString());
        }
        
        JFreeChart chart = ChartFactory.createLineChart("LINE CHART", "X","Y", linedataset);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLUE);
        ChartFrame frame = new ChartFrame("Bar Chart for Parameters", chart);
        //frame.setVisible(true);
        frame.setSize(450,500);
        return frame;
    }
    
    @Override
     public JFrame drawChart(Map<Comparable,Number> map,String asseX,String asseY) 
     {
         DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
        for(Comparable key : map.keySet())
        {
           linedataset.setValue(map.get(key),"",key.toString());
        }
        
        JFreeChart chart = ChartFactory.createLineChart("LINE CHART",asseX,asseY, linedataset);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLUE);
        ChartFrame frame = new ChartFrame("Bar Chart for Parameters", chart);
        //frame.setVisible(true);
        frame.setSize(450,500);
        return frame;
     }
     
}
