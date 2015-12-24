/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pre_processamento.control;

import abreviaturas.AbreviaturaUtils;
import exceptions.DadoInvalidoException;
import exceptions.ErroInternoException;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Fachada;
import pre_processamento.Termo;
import ptstemmer.exceptions.PTStemmerException;
import tweet.Tweet;
import utilitarios.StemmingUtils;
import words.Word;
import utilitarios.StringUtils;

/**
 *
 * @author W8
 */
public class ControladorPreProcessamento {

    /**
     * Esse método vai pré-processar os dados do arquivo passado como parâmetro.
     *
     * @param arquivo O arquivo com os dados a serem pré-processados
     * @param removerDadosDuplicados Se True, remove dados duplicados.
     * @param removeRTs Se True, remove RT's
     * @param remLink
     * @param remUserName
     * @param stemm
     * @param remStopW
     * @param termosASeremRemovidos Os termos a serem excluídos dos dados
     * @return Lista dos Dados após pré-processamento.
     * @throws exceptions.ErroInternoException
     * @throws exceptions.DadoInvalidoException
     */
    public ArrayList<Tweet> preProcessar(File arquivo, boolean removerDadosDuplicados, boolean removeRTs,
            boolean remLink, boolean remUserName, boolean stemm, boolean remStopW, ArrayList<Termo> termosASeremRemovidos) throws ErroInternoException, DadoInvalidoException {
        ArrayList<Tweet> tweets = Fachada.getINSTANCIA().recuperarTweets(arquivo);
        processar(tweets, removeRTs, remLink, remUserName, remStopW, termosASeremRemovidos);
        removerTweetsDuplicados(tweets);
        stemming(tweets, stemm);
        return tweets;
    }

    public void stemming(ArrayList<Tweet> tweets, boolean stemm) {
        if (stemm) {
            for (Tweet tweet : tweets) {
                try {
                    tweet.setTextoProcessado(StringUtils.parseArrayToNormalString(StemmingUtils.getINSTANCE().getStemm().getPhraseStems(tweet.getTextoProcessado())));
                } catch (PTStemmerException ex) {
                    Logger.getLogger(ControladorPreProcessamento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * Remove termo
     *
     * @param texto
     * @param termo
     * @return
     */
    private static String removerTermo(String texto, String termo) {
        ArrayList<String> palavrasTexto = StringUtils.getPalavrasTexto(texto);
        String retorno = "";
        for (String palavra : palavrasTexto) {
            if (!palavra.equalsIgnoreCase(termo)) {
                retorno = retorno.concat(" " + palavra);
            }
        }
        return retorno;
    }

    /**
     * Remove termo
     *
     * @param texto
     * @param termo
     * @return
     */
    public static boolean verificarSePossuiTermo(String texto, String termo) {
        ArrayList<String> palavrasTexto = StringUtils.getPalavrasTexto(texto);
        for (String palavra : palavrasTexto) {
            if (palavra.equalsIgnoreCase(termo)) {
                return true;
            }
        }
        return false;
    }

    public void salvarBagofWords(File arq, ArrayList<Tweet> tweets) throws ErroInternoException {
        ArrayList<String> wordList = ControladorPreProcessamento.getWordList(tweets);
        for (String word : wordList) {
            int freq = 0;
            freq = tweets.stream().map((tweet) -> StringUtils.getPalavrasTexto(tweet.getTextoProcessado())).filter((palavras) -> (palavras.contains(word))).map((_item) -> 1).reduce(freq, Integer::sum);
            long id_palavra = wordList.indexOf(word) + 1;
            Fachada.getINSTANCIA().inserirWord(arq, new Word(id_palavra, word, (long) freq));
        }
    }

    public void salvarTweetsPreProcessados(File arquivo, ArrayList<Tweet> preProcessados, ArrayList<Word> wordList) throws ErroInternoException {
        preProcessados = Fachada.getINSTANCIA().setTermFrequency(preProcessados, wordList);
        preProcessados = Fachada.getINSTANCIA().setTFidf(preProcessados, wordList);
        for (Tweet tweet : preProcessados) {
            Fachada.getINSTANCIA().inserirTweet(arquivo, tweet);
        }
    }

    private static ArrayList<String> getWordList(ArrayList<Tweet> tweets) {
        ArrayList<String> listaPalavras = new ArrayList<>();
        tweets.stream().map((tweet) -> tweet.getTextoProcessado()).map((texto) -> StringUtils.getPalavrasTexto(texto)).forEach((palavras) -> {
            palavras.stream().filter((palavra) -> (!listaPalavras.contains(palavra))).forEach((palavra) -> {
                listaPalavras.add(palavra);
            });
        });
        return listaPalavras;
    }

    private static void processar(ArrayList<Tweet> tweets, boolean remRT, boolean remURL, boolean remUserName, boolean remStopWords,
            ArrayList<Termo> termos) throws ErroInternoException {
        ArrayList<Tweet> tweetsTemp = new ArrayList<>(tweets);
        boolean remTermo = !termos.isEmpty();
        for (Tweet tweet : tweetsTemp) {
            if (remRT && tweet.isRt()) {
                tweets.remove(tweet);
            }
            if (remURL) {
                if (tweets.contains(tweet)) {
                    tweets.get(tweets.indexOf(tweet)).setTextoProcessado(StringUtils.removerUrl(tweet.getTextoProcessado()));
                    tweets.get(tweets.indexOf(tweet)).setTextoSemStemm(StringUtils.removerUrl(tweet.getTextoSemStemm()));
                }
            }
            if (remUserName) {
                if (tweets.contains(tweet)) {
                    if (remUserName) {
                        tweets.get(tweets.indexOf(tweet)).setTextoProcessado(StringUtils.removerUsername(tweet.getTextoProcessado()));
                        tweets.get(tweets.indexOf(tweet)).setTextoSemStemm(StringUtils.removerUsername(tweet.getTextoSemStemm()));
                    }
                }
            }
            if (remTermo) {
                for (Termo termo : termos) {
                    if (tweets.contains(tweet)) {
                        if (verificarSePossuiTermo(tweet.getTextoSemStemm(), termo.getTermo())) {
                            if (termo.isExcluiTweet()) {
                                tweets.remove(tweet);
                            } else {
                                tweets.get(tweets.indexOf(tweet)).setTextoProcessado(removerTermo(tweet.getTextoProcessado(), termo.getTermo()));
                                tweets.get(tweets.indexOf(tweet)).setTextoSemStemm(removerTermo(tweet.getTextoProcessado(), termo.getTermo()));
                            }
                        }
                    }
                }
            }
            if (tweets.contains(tweet)) {
                tweets.get(tweets.indexOf(tweet)).setTextoProcessado(AbreviaturaUtils.desabreviar(tweets.get(tweets.indexOf(tweet)).getTextoProcessado()));
                tweets.get(tweets.indexOf(tweet)).setTextoSemStemm(AbreviaturaUtils.desabreviar(tweets.get(tweets.indexOf(tweet)).getTextoSemStemm()));
                if (remStopWords) {
                    Set<String> stopWords = StemmingUtils.getStopWords();
                    for (String stopWord : stopWords) {
                        tweets.get(tweets.indexOf(tweet)).setTextoProcessado(removerTermo(tweet.getTextoProcessado(), stopWord));
                    }
                }
                if (tweets.get(tweets.indexOf(tweet)).getTextoProcessado().trim().isEmpty()) {
                    tweets.remove(tweet);
                }
            }
        }
    }

    private static ArrayList<Tweet> removerTweetsDuplicados(ArrayList<Tweet> tweets) {
        boolean possueDup = false;
        ArrayList<Tweet> tweetsTemp = new ArrayList<>(tweets);
        ArrayList<Tweet> tweetsTemp2 = new ArrayList<>(tweets);
        for (Tweet tweet : tweetsTemp) {
            for (Tweet tweet2 : tweetsTemp2) {
                if (tweet.getTextoProcessado().equalsIgnoreCase(tweet2.getTextoProcessado()) && !Objects.equals(tweet.getId(), tweet2.getId())) {
                    possueDup = true;
                    tweets.remove(tweet2);
                }
            }
        }
        if (possueDup) {
            tweets = removerTweetsDuplicados(tweets);
        }
        return tweets;
    }

}
