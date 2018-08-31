/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessComponent.Factory;

import java.awt.Color;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Pirozzi
 */
public class LineChart implements Charts{

    private String asseX = "X";
    private String asseY = "Y";

    public String getAsseX() {
        return asseX;
    }

    public void setAsseX(String asseX) {
        this.asseX = asseX;
    }

    public String getAsseY() {
        return asseY;
    }

    public void setAsseY(String asseY) {
        this.asseY = asseY;
    }
    
    @Override
    public JFreeChart drawChart(Map<Comparable,Number> map) {
            
        DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
        for(Comparable key : map.keySet())
        {
           linedataset.setValue(map.get(key),"",key.toString());
        }
        
        JFreeChart chart = ChartFactory.createLineChart("LINE CHART",asseX,asseY, linedataset);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLUE);             
        return chart;
        /*
        ChartFrame frame = new ChartFrame("Bar Chart for Parameters", chart);
        //frame.setVisible(true);
        frame.setSize(450,500);
        return frame; */ 
    }
    
   
}
