/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import java.util.Map;
import javax.swing.JFrame;

/**
 *
 * @author Pirozzi
 */
public interface  Charts 
{    
    
    public  JFrame drawChart(Map<Comparable,Number> map);
    public  JFrame drawChart(Map<Comparable,Number> map,String asseX,String asseY);
    
}
