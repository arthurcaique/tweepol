/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweet;

import java.math.BigDecimal;
import java.util.Objects;
import exceptions.DadoInvalidoException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author W8
 */
public class Tweet {

    private Long id;
    private String textoSemStemm;
    private String textoProcessado;
    private boolean rt;
    private HashMap<String, Long> termFrequency;
    private Map<Long, BigDecimal> tfidf;
    private Polaridade polaridade;

    public Tweet(Long id, String texto, boolean rt) {
        this.id = id;
        this.textoSemStemm = texto;
        this.rt = rt;
    }

    public Tweet(Long id, String texto, HashMap<String, Long> termFrequency) {
        this.id = id;
        this.textoSemStemm = texto;
        this.termFrequency = termFrequency;
    }

    public Tweet(Long id, String texto, HashMap<String, Long> termFrequency, Map<Long, BigDecimal> tfidf) {
        this.id = id;
        this.textoSemStemm = texto;
        this.tfidf = tfidf;
    }

    public Tweet(Long id, String textoOriginal, String textoProcessado, boolean rt, Map<Long, BigDecimal> tfidf, Polaridade polaridade) {
        this.id = id;
        this.textoSemStemm = textoOriginal;
        this.textoProcessado = textoProcessado;
        this.rt = rt;
        this.tfidf = tfidf;
        this.polaridade = polaridade;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextoSemStemm() {
        return textoSemStemm;
    }

    public void setTextoSemStemm(String textoSemStemm) {
        this.textoSemStemm = textoSemStemm;
    }

    public HashMap<String, Long> getTermFrequency() {
        return termFrequency;
    }

    public void setTermFrequency(HashMap<String, Long> termFrequency) {
        this.termFrequency = termFrequency;
    }

    public boolean isRt() {
        return rt;
    }

    public void setRt(boolean rt) {
        this.rt = rt;
    }

    public Map<Long, BigDecimal> getTfidf() {
        return tfidf;
    }

    public void setTfidf(Map<Long, BigDecimal> tfidf) {
        this.tfidf = tfidf;
    }

    public Polaridade getPolaridade() {
        return polaridade;
    }

    public void setPolaridade(Polaridade polaridade) {
        this.polaridade = polaridade;
    }

    public String getTextoProcessado() {
        return textoProcessado;
    }

    public void setTextoProcessado(String textoProcessado) {
        this.textoProcessado = textoProcessado;
    }
    
    public enum Polaridade {

        POSITIVA(1),
        NEGATIVA(-1),
        NAO_INFORMADA(null);

        private final Integer value;

        private Polaridade(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public static Polaridade buscarPolaridade(Integer value) throws DadoInvalidoException {
            for (Polaridade polaridade : Polaridade.values()) {
                if (Objects.equals(polaridade.getValue(), value)) {
                    return polaridade;
                }
            }
            throw new DadoInvalidoException("Polaridade inexistente!");
        }
    }
}
