/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abreviaturas;

import exceptions.ErroInternoException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import utilitarios.ArquivoUtils;
import utilitarios.StringUtils;

/**
 *
 * @author Arthur Caique
 */
public class AbreviaturaUtils {

    public static JSONObject parseAbvToJson(Abreviatura abv) {
        JSONObject json = new JSONObject();
        json.put("abv", abv.getAbv());
        json.put("normal", abv.getNormal());
        return json;
    }

    public static void inserirAbv(Abreviatura abv) throws ErroInternoException {
        try {
            JSONObject json = parseAbvToJson(abv);
            File arq = new File("src/abreviaturas/abreviaturas.txt");
            ArquivoUtils.escrever(arq, json, Boolean.TRUE);
        } catch (IOException ex) {
            throw new ErroInternoException(ex);
        }
    }

    public static ArrayList<Abreviatura> recuperarAbv() throws ErroInternoException {
        File arq = new File("src/abreviaturas/abreviaturas.txt");
        ArrayList<Abreviatura> abreviatura = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arq), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!"".equals(line)) {
                    org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) new JSONParser().parse(line);
                    String abv = (String) jsonObject.get("abv");
                    String normal = (String) jsonObject.get("normal");
                    abreviatura.add(new Abreviatura(abv, normal));
                }
            }
            return abreviatura;
        } catch (Exception ex) {
            throw new ErroInternoException(ex);
        }
    }

    public static ArrayList<String> getAbvs() throws ErroInternoException {
        ArrayList<Abreviatura> abvs = recuperarAbv();
        ArrayList<String> abvs2 = new ArrayList<>();
        for (Abreviatura abv : abvs) {
            abvs2.add(abv.getAbv().toUpperCase());
        }
        return abvs2;
    }

    public static String desabreviar(String texto) throws ErroInternoException {
        ArrayList<Abreviatura> abvs = recuperarAbv();
        String retorno = "";
        String[] palavras = texto.split(" ");
        for (String palavra : palavras) {
            boolean temAbv = false;
            for (Abreviatura abv : abvs) {
                if (palavra.equalsIgnoreCase(abv.getAbv())) {
                    temAbv = true;
                    retorno = retorno.concat(abv.getNormal() + " ");
                    break;
                }
            }
            if (!temAbv) {
                retorno = retorno.concat(palavra + " ");
            }
        }
        return retorno.toUpperCase();
    }

}
