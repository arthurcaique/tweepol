/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unamed;

import exceptions.DadoInvalidoException;
import exceptions.ErroInternoException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Fachada;
import tweet.Tweet;
import utilitarios.ArquivoUtils;

/**
 *
 * @author W8
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            File arq = ArquivoUtils.selecionarArquivo();
            ArrayList<Tweet> recuperarTweets = Fachada.getINSTANCIA().recuperarTweets(arq);
            File a = ArquivoUtils.abrirFileChooserSalvarArquivo(".txt");
            for (Tweet tweet : recuperarTweets) {
                String t = tweet.getPolaridade().getValue() + " " +tweet.getTfidf();
                ArquivoUtils.escrever(a, t, Boolean.TRUE);
            }
        } catch (ErroInternoException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DadoInvalidoException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ArquivoUtils.ArquivoNaoSalvoException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ArquivoUtils.ArquivoNaoSelecionadoException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
