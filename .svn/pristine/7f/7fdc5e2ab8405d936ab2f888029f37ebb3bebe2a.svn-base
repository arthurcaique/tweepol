/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unamed;

import exceptions.DadoInvalidoException;
import exceptions.ErroInternoException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Fachada;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import tweet.Tweet;
import utilitarios.ArquivoUtils;
import utilitarios.MapUtils;
import utilitarios.StringUtils;

/**
 *
 * @author W8
 */
public class RecuperaTweetChrEspecial {

    /**
     * @param args the command line arguments
     * @throws exceptions.ErroInternoException
     * @throws exceptions.DadoInvalidoException
     * @throws utilitarios.ArquivoUtils.ArquivoNaoSalvoException
     */
    public static void main(String[] args) throws ErroInternoException, DadoInvalidoException, ArquivoUtils.ArquivoNaoSalvoException {
        try {
            File arq = ArquivoUtils.selecionarArquivo();
            ArrayList<Tweet> tweets = recuperarTweets(arq);
            File arq2 = ArquivoUtils.abrirFileChooserSalvarArquivo(".txt");
            Fachada.getINSTANCIA().inserirTweets(arq2, tweets);
        } catch (ArquivoUtils.ArquivoNaoSelecionadoException ex) {
            Logger.getLogger(RecuperaTweetChrEspecial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Tweet> recuperarTweets(File arquivo) throws ErroInternoException, DadoInvalidoException {
        ArrayList<Tweet> tweets = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), "ISO-8859-1"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!"".equals(line)) {
                    try {
                        org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) new JSONParser().parse(line);
                        boolean isRT = jsonObject.containsKey("retweeted_status") ? jsonObject.get("retweeted_status") != null
                                : jsonObject.get("rt") != null ? (Boolean) jsonObject.get("rt") : false;
                        String texto = jsonObject.get("text") != null ? ((String) jsonObject.get("text")).toUpperCase() : "";
                        Long id = jsonObject.get("id") != null ? (Long) jsonObject.get("id") : 0;
                        Tweet.Polaridade polaridade = jsonObject.containsKey("polaridade") && jsonObject.get("polaridade") != null
                                ? Tweet.Polaridade.buscarPolaridade(((Integer.valueOf(String.valueOf(jsonObject.get("polaridade"))))))
                                : Tweet.Polaridade.NAO_INFORMADA;
                        Map<Long, BigDecimal> tfidfs = getTfidf(jsonObject);
                        String textoProcessado = jsonObject.containsKey("text_processado") && jsonObject.get("text_processado") != null
                                ? ((String) jsonObject.get("text_processado")).toUpperCase()
                                : texto.toUpperCase();
                        texto = StringUtils.removerAcentos(texto);
                        textoProcessado = StringUtils.removerAcentos(textoProcessado);
                        Tweet tweet = new Tweet(id, texto, textoProcessado, isRT, tfidfs, polaridade);
                        tweets.add(tweet);
                    } catch (ParseException ex) {
                        System.err.println(ex.getMessage());
                    }
                }
            }
            return tweets;
        } catch (IOException e) {
            throw new ErroInternoException(e);
        } catch (DadoInvalidoException ex) {
            throw ex;
        }
    }

    private static Map<Long, BigDecimal> getTfidf(JSONObject jsonObject) {
        Map<Long, BigDecimal> tfidfs = new HashMap<>();
        if (jsonObject.containsKey("tfidf")) {
            JSONObject tfidf = (JSONObject) jsonObject.get("tfidf");
            Set<Map.Entry<String, Double>> entrySet = tfidf.entrySet();
            for (Map.Entry<String, Double> entrySet1 : entrySet) {
                BigDecimal value = new BigDecimal(entrySet1.getValue()).setScale(20, RoundingMode.HALF_DOWN);
                tfidfs.put(Long.valueOf(entrySet1.getKey()), value);
            }
            tfidfs = MapUtils.ordenarLongKey(tfidfs);
        }
        return tfidfs;
    }
}
