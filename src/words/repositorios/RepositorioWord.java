/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package words.repositorios;

import exceptions.ErroInternoException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import utilitarios.Arquivo;
import words.Word;

/**
 *
 * @author W8
 */
public class RepositorioWord implements IRepositorioWord {

    private static IRepositorioWord INSTANCIA;

    public static IRepositorioWord getINSTANCIA() {
        if (INSTANCIA == null) {
            INSTANCIA = new RepositorioWord();
        }
        return INSTANCIA;
    }

    @Override
    public ArrayList<Word> recuperarWordList(File arquivo) throws ErroInternoException {
        ArrayList<Word> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), "ISO-8859-1"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!"".equals(line)) {
                    try {
                        org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) new JSONParser().parse(line);
                        Long freq = jsonObject.get("freq") != null ? (Long) jsonObject.get("freq") : 0;
                        String texto = jsonObject.get("palavra") != null ? (String) jsonObject.get("palavra") : "";
                        Long id = jsonObject.get("id_palavra") != null ? (Long) jsonObject.get("id_palavra") : 0;
                        Word word = new Word(id, texto, freq);
                        words.add(word);
                    } catch (ParseException ex) {
                        Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            return words;
        } catch (IOException ex) {
            throw new ErroInternoException(ex);
        }
    }

}
