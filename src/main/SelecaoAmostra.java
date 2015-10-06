/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import amostra.SelecionarAmostraView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utilitarios.Arquivo;

/**
 *
 * @author W8
 */
public class SelecaoAmostra {

    public static void selecionarAmostra() {
        try {
            File arquivo = Arquivo.selecionarArquivo();
            ArrayList<String> tweets = Arquivo.recuperarTweets(arquivo);
            SelecionarAmostraView selecionarAmostraView = new SelecionarAmostraView(null, true);
            selecionarAmostraView.exibirTweets(tweets, arquivo.getAbsolutePath());
            selecionarAmostraView.setLocationRelativeTo(null);
            selecionarAmostraView.setVisible(true);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(SelecaoAmostra.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao carregar arquivo!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
