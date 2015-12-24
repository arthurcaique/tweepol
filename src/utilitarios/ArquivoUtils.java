/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import exceptions.ArquivoExistenteException;
import exceptions.ErroInternoException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author W8
 */
public class ArquivoUtils {

    public static File criar(String diretorio, String nomeArquivo) throws IOException, ArquivoExistenteException {
        try {
            File arquivo = new File(diretorio, nomeArquivo);
            if (arquivo.exists()) {
                throw new ArquivoExistenteException();
            }
            arquivo.createNewFile();
            return arquivo;
        } catch (ArquivoExistenteException | IOException e) {
            throw e;
        }
    }

    public static void escrever(File arquivo, Object texto, Boolean manterConteudoArquivo) throws IOException {
        try (FileWriter fW = new FileWriter(arquivo, manterConteudoArquivo); PrintWriter pW = new PrintWriter(fW)) {
            pW.println(texto);
            pW.flush();
        }
    }

    public static File selecionarArquivo() throws ArquivoNaoSelecionadoException {
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = file.showOpenDialog(null);
        if (i == 1) {
            throw new ArquivoNaoSelecionadoException("Arquivo não selecionado!");
        } else {
            return file.getSelectedFile();
        }
    }

    public static File selecionarDiretorio() {
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int i = file.showOpenDialog(null);
        if (i == 1) {
            throw new NullPointerException("Diretório não selecionado!");
        } else {
            return file.getSelectedFile();
        }
    }

    public static File[] selecionarArquivos() throws ArquivoNaoSelecionadoException {
        JFileChooser file = new JFileChooser();
        file.setMultiSelectionEnabled(true);
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = file.showOpenDialog(null);
        if (i == 1) {
            throw new ArquivoNaoSelecionadoException("Diretório não selecionado!");
        } else {
            return file.getSelectedFiles();
        }

    }

    public static void salvarArquivo(File arquivo) throws ArquivoNaoSalvoException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo))) {
            pw.close();
        } catch (IOException ex) {
            throw new ArquivoNaoSalvoException();
        }
    }

    public static File abrirFileChooserSalvarArquivo(String extensao) throws ArquivoNaoSalvoException {
        File arquivo = null;
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = file.showSaveDialog(null);
        if (i == 1) {
        } else {
            arquivo = new File(file.getSelectedFile().getAbsolutePath() + extensao);
            if (arquivo.exists()) {
                int r = JOptionPane.showConfirmDialog(null, "O arquivo já existe! Deseja sobrescrevê-lo?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (r == 0) {
                    salvarArquivo(arquivo);
                }
            } else {
                salvarArquivo(arquivo);
            }
        }
        if (arquivo != null) {
            return arquivo;
        }
        throw new ArquivoNaoSalvoException();
    }

    public static void limparConteudoTexto(File arq) throws ErroInternoException {
        try (PrintWriter writer = new PrintWriter(arq)) {
            writer.print("");
            writer.close();
        } catch (Exception ex) {
            throw new ErroInternoException(ex);
        }
    }

    public static class ArquivoNaoSalvoException extends Exception {

        public ArquivoNaoSalvoException() {
            super("Arquivo não salvo!");
        }

        public ArquivoNaoSalvoException(String message) {
            super(message);
        }
    }
    public static class ArquivoNaoSelecionadoException extends Exception {

        public ArquivoNaoSelecionadoException() {
            super("Arquivo não selecionado!");
        }

        public ArquivoNaoSelecionadoException(String message) {
            super(message);
        }
    }
}
