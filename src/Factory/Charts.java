/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import java.util.Map;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author Pirozzi
 */
public interface Charts
{    
    public JFreeChart drawChart(Map<Comparable,Number> map);
}
