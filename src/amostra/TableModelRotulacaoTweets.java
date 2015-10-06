/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amostra;

import java.util.ArrayList;
import javax.swing.JTable;
import utilitarios.ModeloDeTabelaAbstrato;

/**
 *
 * @author W8
 */
public class TableModelRotulacaoTweets extends ModeloDeTabelaAbstrato {

    public String[] colunas = new String[]{"Nº", "Tweet", "Positivo"};

    public TableModelRotulacaoTweets(JTable tabela) {
        super(tabela);
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TweetAmostra tweet = (TweetAmostra) this.lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return tweet.getTexto();
            case 2:
                return tweet.isPositivo();
            default:
                throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        TweetAmostra tweet = (TweetAmostra) this.lista.get(rowIndex);
        switch (columnIndex) {
            case 1:
                tweet.setTexto((String) value);
                break;
            case 2:
                tweet.setPositivo((Boolean) value);
                break;
            default:
                throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String getColumnName(int indice) {
        return this.colunas[indice];
    }

    public void addRow(String texto, boolean positivo) {
        this.lista.add(new TweetAmostra(texto, positivo));
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public TweetAmostra getTweetAmostra(int indice) {
        return (TweetAmostra) this.lista.get(indice);
    }

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

    public ArrayList<TweetAmostra> getTweetAmostras() {
        return this.lista;
    }

}