/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amostra;

import java.util.ArrayList;
import javax.swing.JTable;
import tweet.Tweet;
import utilitarios.ModeloDeTabelaAbstrato;

/**
 *
 * @author Arthur Caique
 */
public class TableModelDefineConjuntoTreino extends ModeloDeTabelaAbstrato {

    public String[] colunas = new String[]{"Tweet", "Polaridade", "Treino"};

    public TableModelDefineConjuntoTreino(JTable tabela) {
        super(tabela);
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TweetTreino tweet = (TweetTreino) this.lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tweet.getTweet().getTextoSemStemm();
            case 1:
                return tweet.getTweet().getPolaridade() == Tweet.Polaridade.POSITIVA ? "Positiva" : "Negativa";
            case 2:
                return tweet.isTreino();
            default:
                throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        TweetTreino tweet = (TweetTreino) this.lista.get(rowIndex);
        switch (columnIndex) {
            case 2:
                tweet.setTreino((Boolean) value);
                break;
            default:
                throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String getColumnName(int indice) {
        return this.colunas[indice];
    }

//    public Tweet getTweet(int indice) {
//        return (Tweet) this.lista.get(indice);
//    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 2;
    }

    @Override
    public Class getColumnClass(int indice) {
        if (indice == 2) {
            return Boolean.class;
        } else {
            return String.class;
        }
    }

    public ArrayList<Tweet> getTweets() {
        ArrayList<Tweet> tweets = new ArrayList<>();
        for (TweetTreino tweet : (ArrayList<TweetTreino>) this.lista) {
            tweets.add(tweet.getTweet());
        }
        return tweets;
    }
    
    public ArrayList<TweetTreino> getTweetsTreino() {
        return this.lista;
    }
    

    public class TweetTreino {

        private Tweet tweet;
        private boolean treino;

        public TweetTreino(Tweet tweet, boolean treino) {
            this.tweet = tweet;
            this.treino = treino;
        }

        public Tweet getTweet() {
            return tweet;
        }

        public void setTweet(Tweet tweet) {
            this.tweet = tweet;
        }

        public boolean isTreino() {
            return treino;
        }

        public void setTreino(boolean treino) {
            this.treino = treino;
        }

    }

}
