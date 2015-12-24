/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pre_processamento;

/**
 *
 * @author Arthur Caique
 */
public class Termo {

    private String termo;
    private boolean excluiTweet;

    public Termo(String termo, boolean excluiTweet) {
        this.termo = termo;
        this.excluiTweet = excluiTweet;
    }

    public String getTermo() {
        return termo;
    }

    public void setTermo(String termo) {
        this.termo = termo;
    }

    public boolean isExcluiTweet() {
        return excluiTweet;
    }

    public void setExcluiTweet(boolean excluiTweet) {
        this.excluiTweet = excluiTweet;
    }

}
