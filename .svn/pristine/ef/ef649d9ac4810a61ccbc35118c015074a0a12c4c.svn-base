/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unamed;

import exceptions.ErroInternoException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import utilitarios.ArquivoUtils;

/**
 *
 * @author W8
 */
public class NewMain2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            File arq = ArquivoUtils.selecionarArquivo();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arq), "UTF-8"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (!"".equals(line)) {
                        try {
                            org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) new JSONParser().parse(line);
                            String data = (String) jsonObject.get("created_at");
                            System.out.println(data);
                        } catch (ParseException ex) {
                            System.err.println(ex.getMessage());
                        }
                    }
                }
            } catch (IOException e) {
                throw new ErroInternoException(e);
            }
        } catch (ArquivoUtils.ArquivoNaoSelecionadoException ex) {
            Logger.getLogger(NewMain2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ErroInternoException ex) {
            Logger.getLogger(NewMain2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
