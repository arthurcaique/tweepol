/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import exceptions.ErroInternoException;
import java.util.Set;
import ptstemmer.Stemmer;
import ptstemmer.exceptions.PTStemmerException;
import ptstemmer.support.PTStemmerUtilities;

/**
 *
 * @author Arthur Caique
 */
public class StemmingUtils {

    private static StemmingUtils INSTANCE;
    private final Stemmer stemm;

    public static StemmingUtils getINSTANCE() throws PTStemmerException {
        if (INSTANCE == null) {
            INSTANCE = new StemmingUtils();
        }
        return INSTANCE;
    }

    public StemmingUtils() throws PTStemmerException {
        stemm = Stemmer.StemmerFactory(Stemmer.StemmerType.SAVOY);
    }

    public Stemmer getStemm() {
        return stemm;
    }

    public static Set<String> getStopWords() throws ErroInternoException {
        try {
            Set<String> stopWords = PTStemmerUtilities.fileToSet("src/data/stopwords.txt");
            return stopWords;
        } catch (PTStemmerException ex) {
            throw new ErroInternoException(ex);
        }
    }

}
