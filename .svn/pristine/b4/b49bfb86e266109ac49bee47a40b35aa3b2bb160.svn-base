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
public class ReplicarArquivo {

    static long id;

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
            ArrayList<Tweet> a = Fachada.getINSTANCIA().recuperarTweets(arquivo);
            ArrayList<Tweet> b = Fachada.getINSTANCIA().recuperarTweets(arquivo2);
            ArrayList<Tweet> c = new ArrayList<>();
            for (Tweet a1 : a) {
                for (Tweet b1 : b) {
                    if (Objects.equals(a1.getId(), b1.getId())) {
                        b1.setPolaridade(a1.getPolaridade());
                        c.add(b1);
                        System.out.println(b1.getId());
                    }
                }
            }
            File arq = ArquivoUtils.abrirFileChooserSalvarArquivo(".txt");
            Fachada.getINSTANCIA().inserirTweets(arq, c);
        } catch (ErroInternoException ex) {
            Logger.getLogger(RecuperarStatusJsonImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DadoInvalidoException ex) {
            Logger.getLogger(RecuperarStatusJsonImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ArquivoUtils.ArquivoNaoSalvoException ex) {
            Logger.getLogger(RecuperarStatusJsonImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ArquivoUtils.ArquivoNaoSelecionadoException ex) {
            Logger.getLogger(ReplicarArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
