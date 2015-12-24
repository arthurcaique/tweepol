/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package words;

/**
 *
 * @author W8
 */
public class Word {

    private Long id;
    private String texto;
    private Long freq;

    public Word(Long id, String texto, Long freq) {
        this.id = id;
        this.texto = texto;
        this.freq = freq;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Long getFreq() {
        return freq;
    }

    public void setFreq(Long freq) {
        this.freq = freq;
    }

    @Override
    public String toString() {
        return "Word{" + "id=" + id + ", texto=" + texto + ", freq=" + freq + '}';
    }
    
}
