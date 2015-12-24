/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafico;

import exceptions.ErroInternoException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author W8
 */
public class BarChart extends JFrame {

    public JFreeChart chart;

    public BarChart(String applicationTitle, String chartTitle, long positivo, long negativo) {
        super(applicationTitle);
        try {
            // This will create the dataset
            DefaultCategoryDataset dataset = createDataset2(positivo, negativo);
            // based on the dataset we create the chart
            this.chart = createBarChart(dataset, chartTitle);
            // we put the chart into a panel
            ChartPanel chartPanel = new ChartPanel(chart);
            // default size
            chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
            // add it to our application
            setContentPane(chartPanel);
        } catch (ErroInternoException ex) {
            Logger.getLogger(BarChart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates a sample dataset
     */
    private DefaultCategoryDataset createDataset2(long positivo, long negativo) {
        long total = positivo + negativo;
        String pos = "Positivo (" + String.valueOf(calcularPorcentagem(positivo, total)) + "%)";
        String neg = "Negativo (" + String.valueOf(calcularPorcentagem(negativo, total)) + "%)";
        DefaultCategoryDataset result = new DefaultCategoryDataset();
        result.addValue(positivo, pos, "Polaridade");
        result.addValue(negativo, neg, "Polaridade");
        return result;

    }

    private JFreeChart createBarChart(CategoryDataset dataset, String title) throws ErroInternoException {
        try {
            JFreeChart barChart = ChartFactory.createBarChart3D(
                    title,
                    "",
                    "",
                    dataset,
                    PlotOrientation.VERTICAL,
                    true, true, false);

//            File barChart3D = new File("barChart3D.jpeg");
//            ChartUtilities.saveChartAsJPEG(barChart3D, barChart, width, height);
            return barChart;
        } catch (Exception ex) {
            throw new ErroInternoException(ex);
        }
    }

    private String calcularPorcentagem(long positivo, long total) {
        float cem = 100;
        NumberFormat numberFormat = NumberFormat.getInstance(new Locale("pt", "BR"));
        numberFormat.setMaximumFractionDigits(2);
        float perc = (cem / total) * positivo;
        String wiw = numberFormat.format(perc);
        return wiw;
    }
}
