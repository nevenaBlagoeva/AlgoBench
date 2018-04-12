/**
 *
 * @authors Yufen WANG(2016) and Nevena Blagoeva(2018)
 * 
 */

package inf2b.algobench.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYSeries;

public class LineChart extends XYChart{
    
    private Map<String, XYSeries> All_series = new LinkedHashMap<>();
    
    public LineChart(int width, int height) {
        super(width, height);
    }
    
    public LineChart(LineChartBuilder builder){
        super(builder.width,builder.height,builder.getTheme());
        this.setTitle(builder.title);
        this.setXAxisTitle(builder.xAxisTitle);
        this.setYAxisTitle(builder.yAxisTitle);
    }
    
    public XYSeries addSeries(String seriesName, XYSeries series){
        super.addSeries(seriesName, series.getXData(), series.getYData());
        Map<String, XYSeries> seriesMap = super.getSeriesMap();
        XYSeries s = seriesMap.get(seriesName);
        All_series.put(seriesName, s);
        return s;
    }
    
    @Override
    public XYSeries addSeries(String seriesName, double[] xData, double[] yData){
        super.addSeries(seriesName, xData, yData);
        Map<String, XYSeries> seriesMap = super.getSeriesMap();
        XYSeries series = seriesMap.get(seriesName);
        All_series.put(seriesName, series);
        return series;
    }
    
    @Override 
    public XYSeries addSeries(String seriesName, List<?> xData, List<? extends Number> yData) {
        super.addSeries(seriesName, xData, yData);
        Map<String, XYSeries> seriesMap = super.getSeriesMap();
        XYSeries series = seriesMap.get(seriesName);
        All_series.put(seriesName, series);
        return series;
    }
    
    public boolean showSeries(String seriesName){
        XYSeries series = All_series.get(seriesName);
        if(series == null){
            System.out.println(seriesName +" not exists in All_series");
            return false;
        }
        Map<String, XYSeries> seriesMap = super.getSeriesMap();
        if(seriesMap.get(seriesName) != null){
            System.out.println(seriesName +" alredy exists");
            return false;
        }
        seriesMap.put(seriesName, series);
        return true;
    }
    
    public void showAllSeries(){
        Map<String, XYSeries> seriesMap = super.getSeriesMap();
        seriesMap.clear();
        seriesMap.putAll(this.All_series);
    }
    
    public boolean showOnlyAverage(){
        XYSeries series = All_series.get("Average");
        if(series == null){
            System.out.println("Average series do not exists in All_series");
            return false;
        }
        Map<String, XYSeries> seriesMap = super.getSeriesMap();
        seriesMap.clear();
        seriesMap.put("Average", series);
        return true;
    }
    
    public boolean showWithoutAverage(){
        XYSeries series = All_series.get("Average");
        if(series == null){
            System.out.println("Average series do not exists");
            return false;
        }
        Map<String, XYSeries> seriesMap = super.getSeriesMap();
        seriesMap.clear();
        seriesMap.putAll(this.All_series);
        seriesMap.remove("Average");
        return true;
    }
    
    public void showAsModel(DefaultListModel<JCheckBox> model){
        Map<String, XYSeries> seriesMap = super.getSeriesMap();
        seriesMap.clear();
        for(int i=0; i<model.size(); i++){
           JCheckBox c = (JCheckBox)model.getElementAt(i);
           if(c.isSelected()){
               String key = c.getText();
               XYSeries value = this.All_series.get(key);
               seriesMap.put(key,value);
           }
        }
        if(this.All_series.get("Boundary") != null){
            seriesMap.put("Boundary", All_series.get("Boundary"));
        }
    }
    
    public int getCurrentSeriesNum(){
        return this.getSeriesMap().size();
    }
    
    public Map<String, XYSeries> getAllSeriesMap() {
        return this.All_series;
    }
    
    /*
    just hide not delet this series, can invoke showSeries method to show again.
    */
    public boolean hideSeries(String seriesName){
        Map<String, XYSeries> seriesMap = super.getSeriesMap();
        XYSeries series = seriesMap.get(seriesName);
        if(series == null) return false;
        seriesMap.remove(seriesName);
        return true;
    }
}
