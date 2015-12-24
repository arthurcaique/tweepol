/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfidf;

import java.util.ArrayList;
import java.util.Collections;
import utilitarios.StringUtils;

/**
 *
 * @author W8
 */
public class CalcularTFIDF {

    public static Long getTermFrequencyDocument(String term, String document) {
        ArrayList<String> palavras = StringUtils.getPalavrasTexto(document);
        return (Long.valueOf(String.valueOf(Collections.frequency(palavras, term))));
    }
}
