/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import exceptions.DadoInvalidoException;
import exceptions.ErroInternoException;
import java.io.File;
import java.util.ArrayList;
import pre_processamento.Termo;
import pre_processamento.control.ControladorPreProcessamento;
import tweet.Tweet;
import words.Word;
import tweet.repositorio.ControladorTweet;
import tweet.repositorio.RepositorioTweet;
import words.repositorios.ControladorWord;
import words.repositorios.RepositorioWord;

/**
 *
 * @author W8
 */
public class Fachada {

    private static Fachada INSTANCIA;
    private final ControladorTweet controlTweet;
    private final ControladorWord controlWord;
    private final ControladorPreProcessamento controlPreProcess;

    public static Fachada getINSTANCIA() {
        if (INSTANCIA == null) {
            INSTANCIA = new Fachada();
        }
        return INSTANCIA;
    }

    public Fachada() {
        this.controlTweet = new ControladorTweet(RepositorioTweet.getINSTANCIA());
        this.controlWord = new ControladorWord(RepositorioWord.getINSTANCIA());
        this.controlPreProcess = new ControladorPreProcessamento();
    }

    public void inserirTweet(File arquivo, Tweet tweet) throws ErroInternoException {
        this.controlTweet.inserirTweet(arquivo, tweet, true);
    }

    public ArrayList<Tweet> setTermFrequency(ArrayList<Tweet> tweets, ArrayList<Word> terms) throws ErroInternoException {
        return this.controlTweet.setTermFrequency(tweets, terms);
    }

    public ArrayList<Tweet> setTFidf(ArrayList<Tweet> tweets, ArrayList<Word> bagOfWords) {
        return this.controlTweet.setTFidf(tweets, bagOfWords);
    }

    public void inserirWords(File arquivo, ArrayList<Word> words) throws ErroInternoException {
        this.controlTweet.inserirWords(arquivo, words);
    }

    public void inserirWord(File arquivo, Word word) throws ErroInternoException {
        this.controlTweet.inserirWord(arquivo, word);
    }

    public ArrayList<Tweet> recuperarTweets(File arquivo) throws ErroInternoException, DadoInvalidoException {
        return this.controlTweet.recuperarTweets(arquivo);
    }

    public void inserirTweets(File arquivo, ArrayList<Tweet> tweets) throws ErroInternoException {
        this.controlTweet.inserirTweets(arquivo, tweets);
    }

    public void atualizarPolaridadeTweets(File arq, ArrayList<Tweet> tweets) throws ErroInternoException, DadoInvalidoException {
        this.controlTweet.atualizarPolaridadeTweets(arq, tweets);
    }

    public ArrayList<Word> recuperarWordList(File arquivo) throws ErroInternoException {
        return this.controlWord.recuperarWordList(arquivo);
    }

    public void salvarBagofWords(File arq, ArrayList<Tweet> tweets) throws ErroInternoException {
        this.controlPreProcess.salvarBagofWords(arq, tweets);
    }

    public ArrayList<Tweet> preProcessar(File arquivo, boolean removerDadosDuplicados, boolean removeRTs,
            boolean remLink, boolean remUserName, boolean stemm, boolean remStopWords, ArrayList<Termo> termosASeremRemovidos) throws ErroInternoException, DadoInvalidoException {
        return this.controlPreProcess.preProcessar(arquivo, removerDadosDuplicados, removeRTs, remLink,
                remUserName, stemm, remStopWords, termosASeremRemovidos);
    }

    public void salvarTweetsPreProcessados(File arquivo, ArrayList<Tweet> preProcessados, ArrayList<Word> wordList) throws ErroInternoException {
        this.controlPreProcess.salvarTweetsPreProcessados(arquivo, preProcessados, wordList);
    }
}
