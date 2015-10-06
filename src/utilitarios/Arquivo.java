/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import twitter4j.Status;
import utilitarios.exceptions.ArquivoExistenteException;
import utilitarios.exceptions.ErroInternoException;

/**
 *
 * @author W8
 */
public class Arquivo {

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

    public static void escrever(File arquivo, Object texto, Boolean apagarConteudoArquivo) throws IOException {
        try (FileWriter fW = new FileWriter(arquivo, apagarConteudoArquivo); PrintWriter pW = new PrintWriter(fW)) {
            pW.println(texto);
            pW.flush();
        }
    }

    public static File selecionarArquivo() {
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = file.showOpenDialog(null);
        if (i == 1) {
            throw new NullPointerException("Arquivo não selecionado!");
        } else {
            return file.getSelectedFile();
        }
    }

    public static ArrayList<String> recuperarTweets(File arquivo) throws IOException {
        ArrayList<String> tweets = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), "ISO-8859-1"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!"".equals(line)) {
                    try {
                        org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) new JSONParser().parse(line);
                        String texto = jsonObject.get("text") != null ? (String) jsonObject.get("text") : "";
                        tweets.add(texto);
                    } catch (ParseException ex) {
                        System.err.println(ex.getMessage());
                    }
                }
            }
        }
        return tweets;
    }

    public static ArrayList<String> recuperarTweets(File arquivo, boolean removeRT) throws IOException {
        ArrayList<String> tweets = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), "ISO-8859-1"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!"".equals(line)) {
                    try {
                        org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) new JSONParser().parse(line);
                        boolean isRT = jsonObject.get("retweeted_status") != null;
                        String texto = jsonObject.get("text") != null ? (String) jsonObject.get("text") : "";
                        if (isRT && !removeRT || !isRT) {
                            tweets.add(texto);
                        }
                    } catch (ParseException ex) {
                        System.err.println(ex.getMessage());
                    }
                }
            }
        }
        return tweets;
    }

    public static void salvarArquivo(File arquivo) throws ErroInternoException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo))) {
            pw.close();
        } catch (IOException ex) {
            throw new ErroInternoException(ex);
        }
    }

    public static File abrirFileChooserSalvarArquivo() throws ErroInternoException, IndexOutOfBoundsException {
        File arquivo = null;
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = file.showSaveDialog(null);
        if (i == 1) {
        } else {
            arquivo = new File(file.getSelectedFile().getAbsolutePath() + ".txt");
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
        throw new IndexOutOfBoundsException("Arquivo não salvo");
    }

}
