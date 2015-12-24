/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amostra.control;

import java.util.ArrayList;
import tweet.Tweet;
import tweet.Tweet.Polaridade;
import exceptions.ErroInternoException;

/**
 *
 * @author W8
 */
public class ControladorRotulagemAmostra {

    /**
     * Esse método ordena os tuites nas 3 possíveis classificações: Positivo,
     * Negativo e Neutro.
     *
     * @param tweets
     * @return Lista dos tuítes ordenados
     * @throws ErroInternoException
     */
    public static ArrayList<Tweet> ordenarMsgPorClassificacao(ArrayList<Tweet> tweets) throws ErroInternoException {
        try {
            ArrayList<Tweet> tweetsOrdenados = new ArrayList<>();
            tweets.stream().filter((tweet) -> (tweet.getPolaridade() == Polaridade.POSITIVA)).forEach((tweet) -> {
                tweetsOrdenados.add(tweet);
            });
            tweets.stream().filter((tweet) -> (tweet.getPolaridade() == Polaridade.NEGATIVA)).forEach((tweet) -> {
                tweetsOrdenados.add(tweet);
            });
            return tweetsOrdenados;
        } catch (Exception e) {
            throw new ErroInternoException(e);
        }
    }
//
//    /**
//     * Esse método retorna uma ArrayList com todas as palavras de uma ArrayList
//     * de tuites
//     *
//     * @param tweets
//     * @return
//     */
//    public static ArrayList<String> getListaPalavrasAmostra(ArrayList<Tweet> tweets) {
//        ArrayList<String> palavras = new ArrayList<>();
//        tweets.stream().map((tweet) -> tweet.getTextoOriginal()).map((texto) -> {
//            Pattern p = Pattern.compile("[a-zA-Zà-úÀ-Ú]+");
//            Matcher m = p.matcher(texto);
//            return m;
//        }).forEach((m) -> {
//            while (m.find()) {
//                String palavra = m.group().toUpperCase();
//                if (!palavras.contains(palavra)) {
//                    palavras.add(palavra);
//                }
//            }
//        });
//        return palavras;
//    }

}
