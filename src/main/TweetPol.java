/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import exceptions.ErroInternoException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import utilitarios.ClasseUtilitaria;

/**
 *
 * @author Arthur
 */
public class TweetPol {

    private static ArrayList<String> stopWordList;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            TweetPol.stopWordList = getStopWordList();
            setarLookAndFeel();
            abrirMenuPrincipal();
        } catch (ErroInternoException ex) {
            ex.exibirMensagemAoUsuario(ex);
        }
    }

    private static ArrayList<String> getStopWordList() throws ErroInternoException {
        ArrayList<String> stopWords = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/data/stopwords.txt")), "ISO-8859-1"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!"".equals(line)) {
                    stopWords.add(line);
                }
            }
            return stopWords;
        } catch (Exception ex) {
            throw new ErroInternoException(ex);
        }
    }

    private static void abrirMenuPrincipal() throws ErroInternoException {
        MenuPrincipal menu = new MenuPrincipal();
        ClasseUtilitaria.abrirView(menu, null);
    }

    private static void setarLookAndFeel() throws ErroInternoException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            throw new ErroInternoException(e);
        }
    }

}
