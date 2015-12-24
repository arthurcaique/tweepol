/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unamed;

import exceptions.DadoInvalidoException;
import exceptions.ErroInternoException;
import java.io.File;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Fachada;
import tweet.Tweet;
import utilitarios.ArquivoUtils;

/**
 *
 * @author W8
 */
public class NewMain1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        replicarArquivo();
    }

    public static void replicarArquivo() {
        try {
            File arquivo = ArquivoUtils.selecionarArquivo();
            File arquivo2 = ArquivoUtils.selecionarArquivo();
            File arquivo3 = ArquivoUtils.selecionarArquivo();
            ArrayList<Tweet> a = Fachada.getINSTANCIA().recuperarTweets(arquivo);
            ArrayList<Tweet> b = Fachada.getINSTANCIA().recuperarTweets(arquivo2);
            ArrayList<Tweet> c = Fachada.getINSTANCIA().recuperarTweets(arquivo3);
            ListIterator<Tweet> listIterator = a.listIterator();
            while (listIterator.hasNext()) {
                Tweet tweet = listIterator.next();
                for (Tweet b1 : b) {
                    if (Objects.equals(b1.getId(), tweet.getId())) {
                        listIterator.remove();
                    }
                }
            }
            while (listIterator.hasNext()) {
                Tweet tweet = listIterator.next();
                for (Tweet b1 : c) {
                    if (Objects.equals(b1.getId(), tweet.getId())) {
                        listIterator.remove();
                    }
                }
            }
            System.out.println(a.size());
        } catch (ErroInternoException ex) {
            Logger.getLogger(RecuperarStatusJsonImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DadoInvalidoException ex) {
            Logger.getLogger(RecuperarStatusJsonImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ArquivoUtils.ArquivoNaoSelecionadoException ex) {
            Logger.getLogger(NewMain1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
