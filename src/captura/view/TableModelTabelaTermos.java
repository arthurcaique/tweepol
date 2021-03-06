/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package captura.view;

import java.util.ArrayList;
import javax.swing.JTable;
import utilitarios.ModeloDeTabelaAbstrato;

/**
 *
 * @author Arthur Caique
 */
public class TableModelTabelaTermos extends ModeloDeTabelaAbstrato {

    private final String[] colunas = new String[]{"Termos"};
    private static final int TERMO = 0;

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
        String termo = (String) this.lista.get(rowIndex);
        switch (columnIndex) {
            case TERMO:
                return termo;
            default:
                throw new IndexOutOfBoundsException("Excedeu o número de colunas");
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case TERMO:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("Excedeu o número de colunas!");
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public String getTermo(int indiceLinha) {
        return (String) this.lista.get(indiceLinha);
    }

    public ArrayList<String> getTermos() {
        return this.lista;
    }

}
