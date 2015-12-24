/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unamed;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Fachada;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import tweet.Tweet;
import utilitarios.ArquivoUtils;

/**
 *
 * @author Arthur Caique
 */
public class Gráficos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OutputStream arquivo = null;
        try {
            File arq = ArquivoUtils.selecionarArquivo();
            int total_pos = 0;
            int total_neg = 0;
            ArrayList<Tweet> tweets = Fachada.getINSTANCIA().recuperarTweets(arq);
            for (Tweet tweet : tweets) {
                if (tweet.getPolaridade() == Tweet.Polaridade.POSITIVA) {
                    total_pos++;
                } else {
                    total_neg++;
                }
            }
            // cria o conjunto de dados
            DefaultCategoryDataset ds = new DefaultCategoryDataset();
//            ds.addValue(total_pos, "Total", "Positivo");
//            ds.addValue(total_neg, "Total", "Negativo");
            ds.addValue(40.5, "maximo", "dia 1");
            ds.addValue(38.2, "maximo", "dia 2");
            ds.addValue(37.3, "maximo", "dia 3");
            ds.addValue(31.5, "maximo", "dia 4");
            ds.addValue(35.7, "maximo", "dia 5");
            ds.addValue(42.5, "maximo", "dia 6");
            // cria o gráfico
            
            JFreeChart grafico = ChartFactory.createLineChart("Meu Grafico", "Dia",
                    "Valor", ds, PlotOrientation.VERTICAL, true, true, false);
            File grafico2 = ArquivoUtils.abrirFileChooserSalvarArquivo(".png");
            arquivo = new FileOutputStream(grafico2);
            ChartUtilities.writeChartAsPNG(arquivo, grafico, 550, 400);
        } catch (Exception ex) {
            Logger.getLogger(Gráficos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (arquivo != null) {
                    arquivo.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Gráficos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
