/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author W8
 */
public abstract class ModeloDeTabelaAbstrato extends AbstractTableModel {

    protected final JTable tabela;
    protected final ArrayList lista;

    public ModeloDeTabelaAbstrato(JTable tabela) {
        this.tabela = tabela;
        this.lista = new ArrayList<>();
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    public void addRow(Object objeto) {
        this.lista.add(objeto);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeRow(int indiceLinha) {
        this.lista.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    public void addRows(ArrayList lista) {
        int indice = getRowCount();
        this.lista.addAll(lista);
        fireTableRowsInserted(indice, indice + lista.size());
    }

    public void limpar() {
        this.lista.clear();
        fireTableDataChanged();
    }
}
