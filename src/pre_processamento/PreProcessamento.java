/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pre_processamento;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import utilitarios.Arquivo;
import utilitarios.exceptions.ErroInternoException;

/**
 *
 * @author W8
 */
public class PreProcessamento {

    private static PreProcessamento INSTANCIA;
    private File arquivo;

    public void abrirPreProcessamento() {
        try {
            this.arquivo = utilitarios.Arquivo.selecionarArquivo();
            PreProcessamentoView preView = new PreProcessamentoView(null, true);
            preView.abrirTelaComArquivoParaProcessamento(arquivo);
            preView.setLocationRelativeTo(null);
            preView.setVisible(true);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    public File getArquivo() {
        return arquivo;
    }

    public ArrayList<String> preProcessar(File arquivo, boolean removerDadosDuplicados, boolean removeRTs, ArrayList<String> termosASeremRemovidos) throws IOException {
        ArrayList<String> tweets = Arquivo.recuperarTweets(arquivo, removeRTs);
        ArrayList<String> tweets2 = removerTweetsDuplicados(tweets, removerDadosDuplicados);
        ArrayList<String> tweets3 = removerTermosTweets(tweets2, termosASeremRemovidos);
        return tweets3;
    }

    public void salvarTweetsPreProcessados(ArrayList<String> tweets) throws IOException {
        try {
            File arqui = Arquivo.abrirFileChooserSalvarArquivo();
            for (String tweet : tweets) {
                JSONObject jS = new JSONObject();
                tweet = tweet.replace("\\", "");
                jS.put("text", tweet);
                Arquivo.escrever(arqui, jS, Boolean.TRUE);
            }
        } catch (ErroInternoException ex) {
            ex.exibirMensagemAoUsuario(ex);
        } catch (IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static PreProcessamento getINSTANCIA() {
        if (INSTANCIA == null) {
            INSTANCIA = new PreProcessamento();
        }
        return INSTANCIA;
    }

    private ArrayList<String> removerTweetsDuplicados(ArrayList<String> tweets, boolean removeDuplicados) {
        ArrayList<String> tweetsTemp = new ArrayList<>();
        tweets.stream().filter((tweet) -> (!tweetsTemp.contains(tweet))).forEach((tweet) -> {
            tweetsTemp.add(tweet);
        });
        return removeDuplicados ? tweetsTemp : tweets;
    }

    private ArrayList<String> removerTermosTweets(ArrayList<String> tweets2, ArrayList<String> termosASeremRemovidos) {
        if (!termosASeremRemovidos.isEmpty()) {
            ArrayList<String> tweetsTemp = new ArrayList<>();
            tweets2.stream().map((tweet) -> {
                for (String termoASerRemovido : termosASeremRemovidos) {
                    tweet = removerTermo(tweet, termoASerRemovido);
                }
                return tweet;
            }).forEach((tweet) -> {
                tweetsTemp.add(tweet);
            });//            
            return tweetsTemp;
        }
        return tweets2;
    }

    private String removerTermo(String tweet, String termo) {
        int indexOf = tweet.toLowerCase().indexOf(termo.toLowerCase());
        int length = termo.length();
        if (indexOf > -1) {
            String substring = tweet.substring(indexOf, indexOf + length);
            tweet = tweet.replaceAll("(?i)" + substring, "");
        }
        return tweet;
    }

}
