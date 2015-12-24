/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import regex.Regex;

/**
 *
 * @author W8
 */
public class StringUtils {

    /**
     * Esse método remove strings duplicadas
     *
     * @param lista
     * @return ArrayList sem duplicidades
     */
    public static ArrayList<String> removerDuplicidades(ArrayList<String> lista) {
        ArrayList<String> listaTemp = new ArrayList<>();
        lista.stream().filter((string) -> (!listaTemp.contains(string))).forEach((tweet) -> {
            listaTemp.add(tweet);
        });
        return listaTemp;
    }

    /**
     * Esse método pega as palavras de uma String
     *
     * @param texto
     * @return Uma ArrayList com as palavras do texto passado como parâmetro
     */
    public static ArrayList<String> getPalavrasTexto(String texto) {
        ArrayList<String> palavras = new ArrayList<>();
        Pattern p = Pattern.compile(Regex.PEGAR_PALAVRAS.getRegex());
        Matcher m = p.matcher(texto);
        while (m.find()) {
            String palavra = m.group().toUpperCase();
            palavras.add(palavra);
        }
        return palavras;
    }

    public static ArrayList<String> getPalavrasTextoNaoRepetidas(String texto) {
        ArrayList<String> palavras = new ArrayList<>();
        Pattern p = Pattern.compile(Regex.PEGAR_PALAVRAS.getRegex());
        Matcher m = p.matcher(texto);
        while (m.find()) {
            String palavra = m.group().toUpperCase();
            if (!palavras.contains(palavra)) {
                palavras.add(palavra);
            }
        }
        return palavras;
    }

    public static String removerUrl(String texto) {
        return remover(texto, Regex.REMOVER_URLS, Pattern.CASE_INSENSITIVE);
    }

    public static String removerUsername(String texto) {
        return remover(texto, Regex.REMOVER_TWITTER_USERNAMES, Pattern.CASE_INSENSITIVE);
    }

    private static String remover(String texto, Regex regex, int padrao) {
        String patternStr = regex.getRegex();
        Pattern pattern = Pattern.compile(patternStr, padrao);
        Matcher matcher = pattern.matcher(texto);
        while (matcher.find()) {
            String result = matcher.group();
            result = result.replace(" ", "");
            texto = texto.replace(result, "");
        }
        return texto;
    }

    public static String removerAcentos(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    public static String parseArrayToNormalString(String[] string) {
        String retorno = "";
        for (String string1 : string) {
            retorno = retorno.concat(string1 + " ");
        }
        return retorno;
    }
}
