/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package view.beans;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.LineChartModel;

/**
 *
 * @author Tarnacki
 */
@Named(value = "chartBean")
@Dependent
public class ChartBean {

    
    private LineChartModel lineChartModel;
    
    /**
     * Creates a new instance of ChartBean
     */
    public ChartBean() {
        lineChartModel = new LineChartModel();

        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("sinus");

        for (int i = 0; i <= 360; i += 10) {
            series1.set(i, sin(Math.toRadians(i)));
        }

        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("cosinus");

        for (int i = 0; i <= 360; i += 10) {
            series2.set(i, cos(Math.toRadians(i)));
        }

        lineChartModel.addSeries(series1);
        lineChartModel.addSeries(series2);
        lineChartModel.setTitle("sinus i cosinus");
        lineChartModel.setLegendPosition("e");
        lineChartModel.setZoom(true);

        Axis xAxis = lineChartModel.getAxis(AxisType.X);
        xAxis.setMin(0);
        xAxis.setMax(360);
        xAxis.setTickInterval("10");

        Axis yAxis = lineChartModel.getAxis(AxisType.Y);
        yAxis.setMin(-1);
        yAxis.setMax(1);
    }

    /**
     * @return the lineChartModel
     */
    public LineChartModel getLineChartModel() {
        return lineChartModel;
    }
    
}
