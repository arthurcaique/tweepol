/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweet.repositorio;

import exceptions.DadoInvalidoException;
import exceptions.ErroInternoException;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.json.simple.JSONObject;
import tweet.Tweet;
import tweet.TweetUtils;
import utilitarios.ArquivoUtils;
import utilitarios.MapUtils;
import utilitarios.StringUtils;
import words.Word;

/**
 *
 * @author Arthur Caique
 */
public class ControladorTweet {

    private final IRepositorioTweet iRep;

    public ControladorTweet(IRepositorioTweet iRep) {
        this.iRep = iRep;
    }

    public void inserirTweet(File arquivo, Tweet tweet, boolean mantemConteudoArquivo) throws ErroInternoException {
        if (tweet.getTfidf() != null) {
            tweet.setTfidf(MapUtils.ordenarLongKey(tweet.getTfidf()));
        } else {
            tweet.setTfidf(new HashMap<>());
        }
        JSONObject json = TweetUtils.parseTweetToJSon(tweet);
        if (!tweet.getTextoSemStemm().trim().isEmpty()) {
            this.iRep.inserirTweet(arquivo, json, mantemConteudoArquivo);
        }
    }

    public void inserirWords(File arquivo, ArrayList<Word> words) throws ErroInternoException {
        for (Word word : words) {
            this.inserirWord(arquivo, word);
        }
    }

    public void inserirWord(File arquivo, Word word) throws ErroInternoException {
        JSONObject json = TweetUtils.parseWordToJson(word);
        this.iRep.inserirWord(arquivo, json);
    }

    public ArrayList<Tweet> recuperarTweets(File arquivo) throws ErroInternoException, DadoInvalidoException {
        return this.iRep.recuperarTweets(arquivo);
    }

    public ArrayList<Tweet> setTermFrequency(ArrayList<Tweet> tweets, ArrayList<Word> terms) throws ErroInternoException {
        for (Tweet tweet : tweets) {
            try {
                tweet.setTermFrequency(new HashMap<>());
                ArrayList<String> palavras = StringUtils.getPalavrasTexto(tweet.getTextoProcessado());
                for (String palavra : palavras) {
                    for (Word word : terms) {
                        if (palavra.equalsIgnoreCase(word.getTexto())) {
                            if (!tweet.getTermFrequency().containsKey(word.getTexto())) {
                                tweet.getTermFrequency().put(palavra, Long.valueOf(0));
                            }
                            Long novoValor = tweet.getTermFrequency().get(palavra) + 1;
                            tweet.getTermFrequency().replace(palavra, novoValor);
                        }
                    }
                }
            } catch (Exception ex) {
                throw new ErroInternoException(ex);
            }
        }
        return tweets;
    }

    public void atualizarPolaridadeTweets(File arq, ArrayList<Tweet> tweets) throws ErroInternoException, DadoInvalidoException {
        ArrayList<Tweet> tweetsAntigos = this.recuperarTweets(arq);
        for (Tweet tweetsAntigo : tweetsAntigos) {
            for (Tweet tweet : tweets) {
                if (Objects.equals(tweetsAntigo.getId(), tweet.getId())) {
                    tweetsAntigo.setPolaridade(tweet.getPolaridade());
                }
            }
        }
        ArquivoUtils.limparConteudoTexto(arq);
        this.inserirTweets(arq, tweetsAntigos);
    }

    public ArrayList<Tweet> setTFidf(ArrayList<Tweet> tweets, ArrayList<Word> bagOfWords) {
        int totalDocCorpus = tweets.size();
        for (Tweet tweet : tweets) {
            Set<Map.Entry<String, Long>> termsFrequency = tweet.getTermFrequency().entrySet();
            tweet.setTfidf(new HashMap<>());
            for (Map.Entry<String, Long> tf : termsFrequency) {
                for (Word word : bagOfWords) {
                    if (tf.getKey().equals(word.getTexto())) {
                        //Num total de documentos
                        BigDecimal tamCorpus = new BigDecimal(totalDocCorpus);
                        //IDF
                        //Número de documentos que o termo aparece
                        BigDecimal freqDoc = new BigDecimal(word.getFreq());
                        BigDecimal freqCorpus = tamCorpus.divide(freqDoc, 10, RoundingMode.HALF_DOWN);
                        double idf = Math.log10(freqCorpus.doubleValue());
                        //IDF
                        Long freqTermDoc = tf.getValue();
                        String valueOf = String.valueOf(idf * freqTermDoc);
                        BigDecimal tfidf = new BigDecimal(valueOf);
                        tweet.getTfidf().put(word.getId(), tfidf);
                    }
                }
            }
        }
        return tweets;
    }

    public void inserirTweets(File arquivo, ArrayList<Tweet> tweets) throws ErroInternoException {
        for (Tweet tweet : tweets) {
            this.inserirTweet(arquivo, tweet, true);
        }
    }

}
