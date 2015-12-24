/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amostra.control;

import amostra.view.RotularAmostraTweets;
import amostra.view.SelecionarAmostraView;
import java.io.File;
import java.util.ArrayList;
import tweet.Tweet;
import utilitarios.ClasseUtilitaria;
import exceptions.DadoInvalidoException;
import exceptions.ErroInternoException;
import main.Fachada;
import utilitarios.ArquivoUtils;

/**
 *
 * @author W8
 */
public class ControladorSelecionaAmostraView {

    /**
     * Esse método chama o seletor de arquivos para que o usuário selecione o
     * arquivo dos tweets a serem escolhidos para serem a amostra.
     * @return Retorna os tweets do arquivo
     * @throws exceptions.ErroInternoException
     * @throws exceptions.DadoInvalidoException
     * @throws utilitarios.ArquivoUtils.ArquivoNaoSelecionadoException
     */
    public static ArrayList<Tweet> recuperarTweetsArquivo() throws ErroInternoException, DadoInvalidoException, ArquivoUtils.ArquivoNaoSelecionadoException {
        try {
            File arquivo = ArquivoUtils.selecionarArquivo();
            ArrayList<Tweet> tweets = Fachada.getINSTANCIA().recuperarTweets(arquivo);
            return tweets;
        } catch (NullPointerException e) {
            throw new ErroInternoException("Nenhum arquivo selecionado!");
        }
    }

    /**
     * A partir desse método, a tela de Seleção de Amostra é chamada, e é
     * exibidos os tweets passados como parâmetro
     *
     * @param tweets Os tweets a serem escolhidos como amostra
     * @throws exceptions.ErroInternoException
     */
    public static void irParaSelecaoAmostra(ArrayList<Tweet> tweets) throws ErroInternoException {
        try {
            SelecionarAmostraView selecionarAmostraView = new SelecionarAmostraView(null, true);
            selecionarAmostraView.exibirTweets(tweets);
            ClasseUtilitaria.abrirView(selecionarAmostraView, null);
        } catch (ErroInternoException ex) {
            throw ex;
        }
    }

    /**
     * A partir desse método, a tela de Rotulação de Amostra é chamada, e é
     * exibidos os tweets passados como parâmetro
     *
     * @param listaTweets A amostra de tweets a ser rotulada
     * @throws DadoInvalidoException Caso nenhum tweet tenha sido selecionado
     * @throws exceptions.ErroInternoException
     */
    public static void irParaTelaRotulacao(ArrayList<Tweet> listaTweets) throws DadoInvalidoException, ErroInternoException {
        if (listaTweets.isEmpty()) {
            throw new DadoInvalidoException("Nenhum tweet selecionado!");
        } else {
            try {
                RotularAmostraTweets rotularView = new RotularAmostraTweets(null, true);
                rotularView.irTelaRotulacao(listaTweets);
                ClasseUtilitaria.abrirView(rotularView, null);
            } catch (ErroInternoException ex) {
                throw ex;
            }
        }
    }
}
