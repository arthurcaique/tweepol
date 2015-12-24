/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unamed;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

/**
 *
 * @author Arthur
 */
public class RetroativeTweets {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Twitter twitter = fabricas.FabricaTwitter.getINSTANCIA().getTwitter();

        Query query = new Query("amor");
        // query.setRpp(100);

        try {
            QueryResult result = twitter.search(query);
            ArrayList tweets = (ArrayList) result.getTweets();

            for (int i = 0; i < tweets.size(); i++) {
                Status t = (Status) tweets.get(i);
                String msg = t.getText();
                User usr = t.getUser();
                System.out.println("Tweet by " + usr + ": " + msg);
            };
        } catch (TwitterException te) {
            System.out.println("Couldn't connect: " + te);
        }
//        try {
//            Query query = new Query();
//            query.setQuery("amor");
//            query.setSince("2015-12-02");
//            Twitter twitter = fabricas.FabricaTwitter.getINSTANCIA().getTwitter();
//            QueryResult search = twitter.search(query);
//            while (search.hasNext()) {
//                search = twitter.search(search.nextQuery());
//                List<Status> tweets = search.getTweets();
//                for (Status tweet : tweets) {
//                    System.out.println(tweet);
//                }
//            }
//        } catch (TwitterException ex) {
//            Logger.getLogger(RetroativeTweets.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

}
