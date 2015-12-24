/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweet.repositorio;

import exceptions.DadoInvalidoException;
import exceptions.ErroInternoException;
import java.io.File;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import tweet.Tweet;

/**
 *
 * @author Arhur
 */
public interface IRepositorioTweet {
    
    public void inserirTweet(File arquivo, JSONObject tweet, boolean mantemConteudoArquivo) throws ErroInternoException;
    
    public void inserirWord(File arquivo, JSONObject word) throws ErroInternoException;
    
    public ArrayList<Tweet> recuperarTweets(File arquivo) throws ErroInternoException, DadoInvalidoException;
}
