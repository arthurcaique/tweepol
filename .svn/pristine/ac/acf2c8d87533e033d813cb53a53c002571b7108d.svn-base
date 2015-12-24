/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweet;

import words.Word;
import java.util.ArrayList;
import org.json.simple.JSONObject;

/**
 *
 * @author W8
 */
public class TweetUtils {

    public static JSONObject parseTweetToJSon(Tweet tweet) {
        JSONObject json = new JSONObject();
        json.put("text", tweet.getTextoSemStemm());
        json.put("id", tweet.getId());
        json.put("tfidf", tweet.getTfidf());
        json.put("polaridade", tweet.getPolaridade() != null ? tweet.getPolaridade().getValue() : null);
        json.put("rt", tweet.isRt());
        json.put("text_processado", tweet.getTextoProcessado());
        return json;
    }
    
    public static ArrayList<JSONObject> parseTweetstoArrayJson(ArrayList<Tweet> tweets) {
        ArrayList<JSONObject> jsons = new ArrayList<>();
        tweets.stream().forEach((tweet) -> {
            jsons.add(parseTweetToJSon(tweet));
        });
        return jsons;
    }

    public static JSONObject parseWordToJson(Word word) {
        JSONObject json = new JSONObject();
        json.put("id_palavra", word.getId());
        json.put("palavra", word.getTexto());
        json.put("freq", word.getFreq());
        return json;
    }
}
