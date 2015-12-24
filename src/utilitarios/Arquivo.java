/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import exceptions.DadoInvalidoException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import tweet.Tweet;
import exceptions.ErroInternoException;
import tweet.Tweet.Polaridade;

/**
 *
 * @author W8
 */
public class Arquivo {

    

//    public static ArrayList<Tweet> recoverTweets2(File arquivo) throws ErroInternoException {
//        ArrayList<Tweet> tweets = new ArrayList<>();
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), "ISO-8859-1"))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                if (!"".equals(line)) {
//                    try {
//                        org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) new JSONParser().parse(line);
//                        JSONObject tfidf = (JSONObject) jsonObject.get("tfidf");
//                        HashMap<Long, BigDecimal> tfidfs = new HashMap<>();
//                        Set<Map.Entry<Long, BigDecimal>> entrySet = tfidf.entrySet();
//                        for (Map.Entry<Long, BigDecimal> entrySet1 : entrySet) {
//                            tfidfs.put(entrySet1.getKey(), entrySet1.getValue());
//                        }
//                        String texto = jsonObject.get("text") != null ? (String) jsonObject.get("text") : "";
//                        Long id = jsonObject.get("id") != null ? (Long) jsonObject.get("id") : 1;
//                        Tweet tweet = new Tweet(id, texto, new HashMap(), tfidfs);
//                        tweets.add(tweet);
//                    } catch (ParseException ex) {
//                        Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            }
//        } catch (IOException ex) {
//            throw new ErroInternoException(ex);
//        }
//        return tweets;
//    }
    

}
