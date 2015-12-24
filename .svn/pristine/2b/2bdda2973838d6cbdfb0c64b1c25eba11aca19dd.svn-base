/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pre_processamento.control;

import exceptions.DadoInvalidoException;
import java.awt.HeadlessException;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pre_processamento.PreProcessamentoView;
import tweet.Tweet;
import words.Word;
import utilitarios.ClasseUtilitaria;
import exceptions.ErroInternoException;
import main.Fachada;
import pre_processamento.Termo;
import utilitarios.ArquivoUtils;

/**
 *
 * @author W8
 */
public class ControladorPreProcessamentoView {

    private static File arquivo;

    /**
     * A partir desse método é chamado o método para escolha do arquivo com os
     * tweets a serem pré-processados, e então é aberta a tela de
     * pré-processamento
     * @throws ErroInternoException
     * @throws utilitarios.ArquivoUtils.ArquivoNaoSelecionadoException
     */
    public static void abrirPreProcessamento() throws ErroInternoException, ArquivoUtils.ArquivoNaoSelecionadoException {
        try {
            setArquivo(ArquivoUtils.selecionarArquivo());
            PreProcessamentoView preView = new PreProcessamentoView(null, true);
            preView.abrirTelaComArquivoParaProcessamento(arquivo);
            ClasseUtilitaria.abrirView(preView, null);
        } catch (NullPointerException e) {
            throw new ErroInternoException(e);
        }
    }

    /**
     * Receber os valores da view e chama o método de processamento do
     * controlador. Após o pré-processamento dos dados, abre o seletor de
     * arquivos para salvar os dados pré-processados
     *
     * @param dadosDuplicados
     * @param ret
     * @param remLink
     * @param remUserName
     * @param stemmm
     * @param remStop
     * @param lista
     * @throws ErroInternoException
     * @throws utilitarios.ArquivoUtils.ArquivoNaoSalvoException
     */
    public static void preProcessar(boolean dadosDuplicados, boolean ret, boolean remLink, boolean remUserName, 
            boolean stemmm, boolean remStop, ArrayList<Termo> lista) throws ErroInternoException
            , ArquivoUtils.ArquivoNaoSalvoException {
        try {
            JOptionPane.showMessageDialog(null, "Salvar wordlist!");
            File arq = ArquivoUtils.abrirFileChooserSalvarArquivo(".txt");
            JOptionPane.showMessageDialog(null, "Salvar tweets pré-processados!");
            File prePros = ArquivoUtils.abrirFileChooserSalvarArquivo(".txt");
            ArrayList<Tweet> preProcessados = Fachada.getINSTANCIA().preProcessar(arquivo, dadosDuplicados, ret, remLink, remUserName, stemmm, remStop, lista);
            Fachada.getINSTANCIA().salvarBagofWords(arq, preProcessados);
            ArrayList<Word> wordList = Fachada.getINSTANCIA().recuperarWordList(arq);
            Fachada.getINSTANCIA().salvarTweetsPreProcessados(prePros, preProcessados, wordList);
            String numTweets = String.valueOf(preProcessados.size());
            JOptionPane.showMessageDialog(null, numTweets + " tweest salvos: Dados pré-processados com sucesso!", "Informação do sistema", JOptionPane.INFORMATION_MESSAGE);
        } catch (HeadlessException | ErroInternoException | IndexOutOfBoundsException | DadoInvalidoException ex) {
            throw new ErroInternoException(ex);
        }
    }

    public static File getArquivo() {
        return arquivo;
    }

    public static void setArquivo(File arquivo) {
        ControladorPreProcessamentoView.arquivo = arquivo;
    }

}
