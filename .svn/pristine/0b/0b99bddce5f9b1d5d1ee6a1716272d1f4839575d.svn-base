/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pre_processamento;

import java.util.ArrayList;
import javax.swing.JTable;
import utilitarios.ModeloDeTabelaAbstrato;

/**
 *
 * @author Arthur Caique
 */
public class TableModelTabelaTermos extends ModeloDeTabelaAbstrato {

    private final String[] colunas = new String[]{"Termos", "Excluir tweet que contenha?"};
    private static final int TERMO = 0;
    private static final int EXCLUI = 1;

    public TableModelTabelaTermos(JTable tabela) {
        super(tabela);
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Termo termo = (Termo) this.lista.get(rowIndex);
        switch (columnIndex) {
            case TERMO:
                return termo.getTermo();
            case EXCLUI:
                return termo.isExcluiTweet();
            default:
                throw new IndexOutOfBoundsException("Excedeu o número de colunas");
        }
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Termo termo = (Termo) this.lista.get(rowIndex);
        switch (columnIndex) {
            case TERMO:
                termo.setTermo((String) value);
                break;
            case EXCLUI:
                termo.setExcluiTweet((Boolean) value);
                break;
            default:
                throw new IndexOutOfBoundsException("Excedeu o número de colunas");
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case TERMO:
                return String.class;
            case EXCLUI:
                return Boolean.class;
            default:
                throw new IndexOutOfBoundsException("Excedeu o número de colunas!");
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == EXCLUI || columnIndex == TERMO;
    }

    public Termo getTermo(int indiceLinha) {
        return (Termo) this.lista.get(indiceLinha);
    }

    public ArrayList<Termo> getTermos() {
        return this.lista;
    }

}
