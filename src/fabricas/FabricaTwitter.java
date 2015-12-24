/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricas;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author W8
 */
public class FabricaTwitter {

    private final TwitterFactory twitterFactory;
    private static FabricaTwitter INSTANCIA;
    private Twitter twitter;

    public FabricaTwitter() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("9ZZ1vBHDZdwunCsmvuhBbanss")
                .setOAuthConsumerSecret("rHB3PRJ7PH4aHxbaznqSCqlPdMklLWYwugJiLnNyWIJbu5EZin")
                .setOAuthAccessToken("300299780-ZnHnZWgMuMo1TDBHvukxGEK3NvfuQkbGpfzdjM7b")
                .setOAuthAccessTokenSecret("J2eucUXcx8h6ltugiGNkpgzkhUjtpW6a8YHskZnu1vo48")
                .setJSONStoreEnabled(true);
        this.twitterFactory = new TwitterFactory(cb.build());
    }

    private TwitterFactory getTwitterFactory() {
        return this.twitterFactory;
    }

    public Twitter getTwitter() {
        this.twitter = getTwitterFactory().getInstance();
        return this.twitter;
    }

    public static FabricaTwitter getINSTANCIA() {
        if (INSTANCIA == null) {
            INSTANCIA = new FabricaTwitter();
        }
        return INSTANCIA;
    }

}
