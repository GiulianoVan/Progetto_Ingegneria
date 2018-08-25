/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessComponent.Controller;

import BusinessComponent.Factory.Charts;
import BusinessComponent.Factory.GenerateChart;
import BusinessComponent.Factory.LineChart;
import AccessDataStorage.DB.DAO.StatisticsDao;
import java.sql.SQLException;
import java.util.Map;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.LegendItemSource;
import org.jfree.chart.title.LegendTitle;

/**
 *
 * @author Pirozzi
 */

public class ControllerStatistics {

    private StatisticsDao dao;
    
    public ControllerStatistics(StatisticsDao dao) 
    {
        this.dao = dao;
        
    }
    
    public double everageAgeTypeEvent(String type_Event) throws SQLException
    {
        return dao.etaMediaTipoEvento(type_Event);
    }
    
    public int ticketSoldForYear(int year) throws SQLException
    {
       return  dao.bigliettiVendutiPerAnno(year);
    }
    
    public int partecipationAtTypeEventInOneYear(int year,String type_event) throws SQLException
    {
       return dao.partecipazioneTipoEventoInUnAnno(year,type_event);
    }
    
    public double EarnsInTheYear(int year) throws SQLException
    {
        return dao.incassiPerAnno(year);
    }
    
    public void generateGraph(Map<Comparable,Number> map,String choise)
    {
        GenerateChart charts = new GenerateChart();
        //Average age for events, Tickets sold over the years, Presences over the years by event, Earnings over the years
        if(choise.equals("Distribution of the events and average age"))
        {
            Charts chart = charts.getChart("PIE");
            JFreeChart Jchart = chart.drawChart(map);
            Jchart.addLegend(new LegendTitle(new LegendItemSource() {
            @Override
            public LegendItemCollection getLegendItems() 
            {
                    LegendItemCollection x =  new LegendItemCollection();
                    x.add(new LegendItem("(AverageAge,Distribution Event)"));
                    return x;
            }
            }));
            ChartFrame frame = new ChartFrame("Distribution of the events and average age",Jchart);
           
            frame.setSize(450,500);
            frame.setVisible(true);
            
        }
        else if(choise.equals("Tickets sold over the years"))
        {
            Charts chart = charts.getChart("LINE");
            //ame = new ChartFrame("Bar Chart for Parameters",chart.drawChart(map));
            JFreeChart k = chart.drawChart(map);
            LineChart lineChart = (LineChart) chart;
            lineChart.setAsseX("Year");
            lineChart.setAsseY("Ticket");
            ChartFrame frame = new ChartFrame("Tickets sold over the years", chart.drawChart(map));
            //frame.setVisible(true);
            frame.setSize(450,500);
            frame.setSize(450,500);
            frame.setVisible(true);
        }
        else if(choise.equals("Presences over the years by event"))
        {
             Charts chart = charts.getChart("LINE");
            //ame = new ChartFrame("Bar Chart for Parameters",chart.drawChart(map));
            JFreeChart k = chart.drawChart(map);
            LineChart lineChart = (LineChart) chart;
            lineChart.setAsseX("Year");
            lineChart.setAsseY("Presence");
            ChartFrame frame = new ChartFrame("Presences over the years by event", chart.drawChart(map));
            //frame.setVisible(true);
            frame.setSize(450,500);
            frame.setSize(450,500);
            frame.setVisible(true);
             
        }
        else if(choise.equals("Earnings over the years"))
        {
          Charts chart = charts.getChart("LINE");
            //ame = new ChartFrame("Bar Chart for Parameters",chart.drawChart(map));
            JFreeChart k = chart.drawChart(map);
            LineChart lineChart = (LineChart) chart;
            lineChart.setAsseX("Year");
            lineChart.setAsseY("Cash");
            ChartFrame frame = new ChartFrame("Earnings over the years", chart.drawChart(map));
            //frame.setVisible(true);
            frame.setSize(450,500);
            frame.setSize(450,500);
            frame.setVisible(true);
        }
        
    }

    
}
