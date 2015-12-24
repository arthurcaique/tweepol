package classifica;

import exceptions.DadoInvalidoException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.MenuPrincipal;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import tweet.Tweet;
import exceptions.ErroInternoException;
import java.io.FileReader;
import libsvm.svm;
import libsvm.svm_model;
import main.Fachada;
import main.RotulacaoAmostra;
import utilitarios.ArquivoUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author W8
 */
public class Classifica {

    public static ArrayList<Tweet> classificar(File model, File arquivo) throws ErroInternoException, DadoInvalidoException {
        try {
            svm_model model2 = svm.svm_load_model(new BufferedReader(new FileReader(model)));
            ArrayList<Tweet> tweets = Fachada.getINSTANCIA().recuperarTweets(arquivo);
            float numTotal = tweets.size();
            int total_favor = 0;
            int total_contra = 0;
            double favor = 1;
            for (Tweet tweet : tweets) {
                double svm_predict = svm.svm_predict(model2, RotulacaoAmostra.setarSVMNodes(tweet.getTfidf()));
                System.out.println(tweet.getTextoSemStemm());
                System.out.println("Classificação: " + svm_predict);
                if (svm_predict == 1) {
                    tweet.setPolaridade(Tweet.Polaridade.POSITIVA);
                    total_favor++;
                } else {
                    tweet.setPolaridade(Tweet.Polaridade.NEGATIVA);
                    total_contra++;
                }
            }
            float perc_favor = (100 / numTotal) * total_favor;
            float perc_contra = (100 / numTotal) * total_contra;
            System.out.println("Total a favor:" + total_favor + " - " + perc_favor + "%.");
            System.out.println("Total contra:" + total_contra + " - " + perc_contra + "%.");
            return tweets;
        } catch (Exception ex) {
            throw new ErroInternoException(ex);
        }
    }
}
