package inf2b.algobench.model;

import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.style.Styler;

/**
 *
 * @authors Yufen Wang(2016) and Nevena Blagoeva(2018) 
 */
public class LineChartBuilder extends XYChartBuilder{
    
    int width;
    int height;
    String title;
    String xAxisTitle;
    String yAxisTitle;
    Styler.ChartTheme chartTheme;
    
    @Override
    public LineChart build(){
        return new LineChart(this);
    }

    @Override
    public LineChartBuilder width(int width) {
        this.width = width;
        return this;
    }

    @Override
    public LineChartBuilder height(int height) {
        this.height = height;
        return this;
    }

    @Override
    public LineChartBuilder title(String title) {
        this.title = title;
        return this;
    }

    @Override
    public LineChartBuilder xAxisTitle(String xAxisTitle) {
        this.xAxisTitle = xAxisTitle;
        return this;
    }

    @Override
    public LineChartBuilder yAxisTitle(String yAxisTitle) {
        this.yAxisTitle = yAxisTitle;
        return this;
    }

    @Override
    public LineChartBuilder theme(Styler.ChartTheme chartTheme) {
        this.chartTheme = chartTheme;
        return this;
    }
    
    public Styler.ChartTheme getTheme(){
        return this.chartTheme;
    }
}
