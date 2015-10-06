/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amostra;

/**
 *
 * @author W8
 */
public class TweetAmostra {

    private String texto;
    private boolean positivo;

    public TweetAmostra(String texto, boolean positivo) {
        this.texto = texto;
        this.positivo = positivo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isPositivo() {
        return positivo;
    }

    public void setPositivo(boolean positivo) {
        this.positivo = positivo;
    }
}
