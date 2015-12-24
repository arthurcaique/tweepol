/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amostra.control;

import treino.view.DefineTreinoView;
import amostra.view.RotularAmostraTweets;
import java.io.File;
import java.util.ArrayList;
import tweet.Tweet;
import utilitarios.ClasseUtilitaria;
import exceptions.DadoInvalidoException;
import exceptions.ErroInternoException;
import javax.swing.JOptionPane;
import main.Fachada;
import utilitarios.ArquivoUtils;

/**
 *
 * @author W8
 */
public class ControladorRotulagemView {

    /**
     * O usuário vai selecionar o arquivo com os tweets a serem rotulados. A
     * tela de seleção de amostra será aberta.
     * @throws exceptions.DadoInvalidoException
     * @throws exceptions.ErroInternoException
     * @throws utilitarios.ArquivoUtils.ArquivoNaoSelecionadoException
     */
    public static void selecionarAmostraEIrParaTelaRotulacao() throws DadoInvalidoException, ErroInternoException, ArquivoUtils.ArquivoNaoSelecionadoException {
        try {
            JOptionPane.showMessageDialog(null, "Selecione o arquivo com os tweets a serem rotulados!");
            File arquivo = ArquivoUtils.selecionarArquivo();
            ArrayList<Tweet> listaTweets = Fachada.getINSTANCIA().recuperarTweets(arquivo);
            JOptionPane.showMessageDialog(null, "Rotule os tweets a serem designados para serem dos conjuntos de treino e teste!");
            irParaTelaRotulacaoDeTweets(arquivo.getPath(), listaTweets);
        } catch (NullPointerException e) {
            throw new ErroInternoException("Arquivo não selecionado!");
        }
    }

    /**
     * Abre a tela de rotulação de amostra.
     *
     * @param diretorioArq
     * @param tweets os quais alguns serão escolhidos pelo usuário para serem os
     * conjuntos de teste/treino.
     * @throws exceptions.DadoInvalidoException
     */
    public static void irParaTelaRotulacaoDeTweets(String diretorioArq, ArrayList<Tweet> tweets) throws DadoInvalidoException {
        if (tweets.isEmpty()) {
            throw new DadoInvalidoException("Nenhum tweet selecionado!");
        } else {
            RotularAmostraTweets teste = new RotularAmostraTweets(null, true);
            teste.irTelaRotulacao(diretorioArq, tweets);
            teste.setLocationRelativeTo(null);
            teste.setVisible(true);
        }
    }

    /**
     * Método para abrir a view de seleção do conjunto de treino/teste
     *
     * @param tweets
     * @throws ErroInternoException
     */
    public static void irParaSelecaoConjuntoTreino(ArrayList<Tweet> tweets) throws ErroInternoException {
        DefineTreinoView defineView = new DefineTreinoView(null, true);
        defineView.abrirParaSelecao(tweets);
        ClasseUtilitaria.abrirView(defineView, null);
    }
}
