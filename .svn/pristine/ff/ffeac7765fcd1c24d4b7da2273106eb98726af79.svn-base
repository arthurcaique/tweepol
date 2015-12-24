/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricas;

import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author W8
 */
public class FabricaTwitterStream {

    private final TwitterStreamFactory twitterStreamFactory;
    private static FabricaTwitterStream instancia;
    private TwitterStream twitterStream;

    public FabricaTwitterStream() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("9ZZ1vBHDZdwunCsmvuhBbanss")
                .setOAuthConsumerSecret("rHB3PRJ7PH4aHxbaznqSCqlPdMklLWYwugJiLnNyWIJbu5EZin")
                .setOAuthAccessToken("300299780-ZnHnZWgMuMo1TDBHvukxGEK3NvfuQkbGpfzdjM7b")
                .setOAuthAccessTokenSecret("J2eucUXcx8h6ltugiGNkpgzkhUjtpW6a8YHskZnu1vo48")
                .setJSONStoreEnabled(true);
        twitterStreamFactory = new TwitterStreamFactory(cb.build());
    }

    private TwitterStreamFactory getTwitterStreamFactory() {
        return twitterStreamFactory;
    }

    public TwitterStream getTwitterStream() {
        return twitterStream = getTwitterStreamFactory().getInstance();
    }

    public static FabricaTwitterStream getInstancia() {
        if (instancia == null) {
            instancia = new FabricaTwitterStream();
        }
        return instancia;
    }
}
