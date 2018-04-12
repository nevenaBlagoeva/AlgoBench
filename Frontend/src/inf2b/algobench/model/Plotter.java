/*
 * The MIT License
 *
 * Copyright 2015 Eziama Ubachukwu (eziama.ubachukwu@gmail.com).
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/*
 * Modified by Yufen Wang and Nevena Blagoeva.
 * 2016, 2018
 */

package inf2b.algobench.model;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.style.Styler;
/**
 * Parses the returned execution data and gets a chart object for display by the
 * ResultsChartPanel. Extends JPanel only to be capable of displaying the chart
 * by itself if required.
 *
 * @author eziama ubachukwu and Yufen Wang
 * 
 */
public class Plotter extends JPanel implements Serializable {

    private LineChart chart;
    private double xData[];
    private double ySeries[][]; // for multi-series charts
    private double averageSeries[];
    private String xAxisLabel;
    private String yAxisLabel;
    private final String title;
    private final String dataString;
    private int numValidColumns;
    private double averageValue;
    private double standardDeviation;
    String[] seriesTitles;
    private boolean runAverage;
    
    /**
     * Handles obtaining the charts of the runtimes, which the caller should
     * wrap in an XChartPanel and then display.
     *
     * @param title The chart title
     * @param dataString The data string as tab-separated values. The first line
     * is the heading.
     * @param numValidColumns Tells this class how many columns are plottable,
     * i.e. are of numerical type. 0 means everything should be used. This is
     * necessary because results can come in with the final columns containing
     * textual data not suitable for plotting. Hash algos generate this for
     * example.
     */
    public Plotter(String title, String dataString, int numValidColumns) {
        this.title = title;
        this.dataString = dataString;
        this.numValidColumns = numValidColumns;
        this.xAxisLabel = "No label";
        this.yAxisLabel = "No label";
        this.averageValue = -1;
        this.standardDeviation = -1;
        this.runAverage = false;
        extractData();
    }

    public String getXAxisLabel() {
        return xAxisLabel;
    }

    public void setXAxisLabel(String xAxisLabel) {
        this.xAxisLabel = xAxisLabel;
    }

    public String getYAxisLabel() {
        return yAxisLabel;
    }

    public void setYAxisLabel(String yAxisLabel) {
        this.yAxisLabel = yAxisLabel;
    }

    private void extractData() {
        if (dataString.isEmpty()) {
            System.err.println("Empty values supplied to Plotter.");
        }
        String[] lines = dataString.split("\n");
        // contains:  Size  Run1  Run2 etc
        
        seriesTitles = lines[0].split("\t"); // label line
        //set average line if repeats more than once and not for hash algorithm
        if(numValidColumns != 2 && seriesTitles.length > 2 && !lines[0].contains("Checkpoint")){
            this.runAverage = true;
        }

        // use only valid columns
        if (numValidColumns == 0) {
            // then use every column that the split produces
            numValidColumns = seriesTitles.length - 1;
        }
        else {
            // to get the y series, we subtract 1 (for the x series)
            --numValidColumns;
        }
        if (numValidColumns < 1) {
            // something is wrong: no y series!
            Logger.getLogger(Plotter.class.getName()).log(Level.SEVERE, null,
                    "No y series data supplied to Plotter (in extractData())!");
        }
        
        ySeries = new double[numValidColumns][lines.length - 1];
        xData = new double[lines.length - 1];
        if(this.runAverage) averageSeries = new double[lines.length - 1];
        for (int i = 1; i < lines.length; ++i) {
            String[] parts = lines[i].split("\t");
            xData[i - 1] = Double.parseDouble(parts[0]);
            double sum = 0;
            for (int j = 0; j < numValidColumns; ++j) {
                ySeries[j][i - 1] = Double.parseDouble(parts[j + 1]);
                sum += ySeries[j][i - 1];
            }
            if(this.runAverage){
               averageSeries[i-1] = sum/(numValidColumns);
            }
        }
    }
    
    public LineChart getLineChart() {
        // create chart
        chart = new LineChartBuilder().theme(Styler.ChartTheme.Matlab)
                .width(800).height(600).title(title).xAxisTitle(xAxisLabel).yAxisTitle(yAxisLabel).build();
        // populate the series with the processed data
        if(this.runAverage)chart.addSeries("Average", xData, averageSeries);
        for (int i = 0; i < ySeries.length; ++i) {
            if (xData.length > 0 && ySeries[i].length == xData.length) {
                chart.addSeries(seriesTitles[i + 1], xData, ySeries[i]);
            }
        }
        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setAxisTitlesVisible(true);   

        return chart;
    }
    
    public boolean hasAverage(){
        return this.runAverage;
    }
    
    
    public CategoryChart getBarChart() {
        // create chart
        CategoryChart chart = new CategoryChartBuilder().width(800).
                                                        height(600).
                                                        title(title).
                                                        xAxisTitle(xAxisLabel).
                                                        yAxisTitle(yAxisLabel).
                                                        build();

        for (int i = 0; i < ySeries.length; ++i) {
            if (xData.length > 0 && ySeries[i].length == xData.length) {
                chart.addSeries(seriesTitles[i + 1], xData, ySeries[i]);
            }
        }
        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(true);

        return chart;
    }

    public double getAverage() {
        if (averageValue >= 0) {
            return averageValue;
        }
        if (ySeries[0].length <= 0) {
            return 0;
        }
        long sum = 0;
        for (int i = 0; i < ySeries[0].length; ++i) {
            sum += ySeries[0][i];
        }
        averageValue = ((double)sum / ySeries[0].length);
        return averageValue;
    }

    public double getStandardDeviation() {
        if (standardDeviation >= 0) {
            return standardDeviation;
        }
        if (ySeries[0].length <= 0) {
            return 0;
        }
        if (averageValue < 0) {
            this.getAverage();
        }
        double deviation = 0;
        for (int i = 0; i < ySeries[0].length; ++i) {
            deviation += Math.pow(ySeries[0][i] - averageValue, 2.0);
        }
        this.standardDeviation = Math.sqrt(deviation);
        return standardDeviation;
    }
    
}

