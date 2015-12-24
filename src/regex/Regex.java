/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regex;

/**
 *
 * @author W8
 */
public enum Regex {
    
    PEGAR_PALAVRAS("[a-zA-Zà-úÀ-Ú]+"),
    REMOVER_TWITTER_USERNAMES("(?:\\s|\\A)[@]+([A-Za-z0-9-_]+)"),
    REMOVER_URLS("((https?|ftp|gopher|telnet|file|Unsure|http):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)");
    
    private final String regex;

    private Regex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
    
    
}
