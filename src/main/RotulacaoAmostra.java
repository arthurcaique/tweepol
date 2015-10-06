/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import amostra.RotularAmostraTweets;
import amostra.TweetAmostra;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import javax.swing.JOptionPane;
import libsvm.svm;
import libsvm.svm_model;
import libsvm.svm_node;
import libsvm.svm_parameter;
import libsvm.svm_problem;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import utilitarios.Arquivo;
import static utilitarios.Arquivo.selecionarArquivo;
import utilitarios.exceptions.ErroInternoException;

/**
 *
 * @author W8
 */
public class RotulacaoAmostra {

    public static void selecionarAmostraEIrParaTelaRotulacao() {
        try {
            File arquivo = selecionarArquivo();
            ArrayList<String> listaTweets = Arquivo.recuperarTweets(arquivo);
            irParaTelaRotulacaoDeTweets(listaTweets);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(RotulacaoAmostra.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao carregar arquivo!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void irParaTelaRotulacaoDeTweets(ArrayList<String> tweets) {
        if (tweets.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum tweet selecionado!", "Aviso do sistema", JOptionPane.WARNING_MESSAGE);
        } else {
            RotularAmostraTweets teste = new RotularAmostraTweets(null, true);
            teste.exibirTweets(tweets);
            teste.setLocationRelativeTo(null);
            teste.setVisible(true);
        }
    }

    public static void rotularAmostra(ArrayList<TweetAmostra> tweets) {
        try {
            ArrayList<String> listaPalavrasAmostra = getListaPalavrasAmostra(tweets);
            File arquivoPalavras = Arquivo.abrirFileChooserSalvarArquivo();
            salvarListaPalavras(arquivoPalavras, listaPalavrasAmostra);
            salvarTweetsRotulados(arquivoPalavras, tweets);
        } catch (ErroInternoException ex) {
            ex.exibirMensagemAoUsuario(ex);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private static ArrayList<String> getListaPalavrasAmostra(ArrayList<TweetAmostra> tweets) {
        ArrayList<String> palavras = new ArrayList<>();
        tweets.stream().map((tweet) -> tweet.getTexto()).map((texto) -> {
            Pattern p = Pattern.compile("[a-zA-Zà-úÀ-Ú]+");
            Matcher m = p.matcher(texto);
            return m;
        }).forEach((m) -> {
            while (m.find()) {
                String palavra = m.group().toUpperCase();
                if (!palavras.contains(palavra)) {
                    palavras.add(palavra);
                }
            }
        });
        return palavras;
    }

    private static void salvarListaPalavras(File arquivoPalavras, ArrayList<String> listaPalavrasConjuntoTreinamento) throws ErroInternoException {
        try {
            JOptionPane.showMessageDialog(null, "Arquivo de palavras!");
            int id = 1;
            for (String palavra : listaPalavrasConjuntoTreinamento) {
                try {
                    JSONObject json = new JSONObject();
                    json.put("id", id);
                    json.put("palavra", palavra);
                    Arquivo.escrever(arquivoPalavras, json, true);
                    id++;
                } catch (IOException ex) {
                    throw new ErroInternoException(ex);
                }
            }
        } catch (Exception e) {
            throw new ErroInternoException(e);
        }
    }

//    private static void selecionarArquivo2() {
//        try {
//            JFileChooser file = new JFileChooser();
//            file.setFileSelectionMode(JFileChooser.FILES_ONLY);
//            int i = file.showSaveDialog(null);
//            if (i == 1) {
//            } else {
//                File arquivo = new File(file.getSelectedFile().getAbsolutePath() + ".txt");
//                if (arquivo.exists()) {
//                    int r = JOptionPane.showConfirmDialog(null, "O arquivo já existe! Deseja sobrescrevê-lo?", "Confirmação", JOptionPane.YES_NO_OPTION);
//                    if (r == 0) {
//                        salvarArquivo(arquivo);
//                        arquivoPalavras = arquivo;
//                    }
//                } else {
//                    salvarArquivo(arquivo);
//                    arquivoPalavras = arquivo;
//                }
//            }
//        } catch (ErroInternoException e) {
//            e.exibirMensagemAoUsuario(e);
//        }
//    }
    private static void salvarTweetsRotulados(File arquivoPalavras, ArrayList<TweetAmostra> tweets) {
        HashMap<String, Long> listaPalavras = new HashMap<>();
        File arquivoTweetsRotulados = arquivar(arquivoPalavras.getAbsolutePath());
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arquivoPalavras), "ISO-8859-1"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!"".equals(line)) {
                    try {
                        org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) new JSONParser().parse(line);
                        String texto = jsonObject.get("palavra") != null ? (String) jsonObject.get("palavra") : "";
                        Long id = jsonObject.get("id") != null ? ((Long) jsonObject.get("id")) : 0;
                        listaPalavras.put(texto, id);
                    } catch (ParseException ex) {
                        System.err.println(ex.getMessage());
                    }
                }
            }
            tweets.stream().forEach((tweet) -> {
                String twet = tweet.isPositivo() ? "1" : "0";
                ArrayList<String> palavrasTweet = getPalavrasTexto(tweet.getTexto());
                ArrayList<Long> lista = new ArrayList<>();
                palavrasTweet.stream().filter((palavra) -> (listaPalavras.containsKey(palavra))).map((palavra) -> listaPalavras.get(palavra)).forEach((id) -> {
                    lista.add(id);
                });
                JSONObject listaAtributosOrdenados = ordenarListaAtributos(twet, lista);
                salvarNoArquivo(arquivoTweetsRotulados, listaAtributosOrdenados);
            });
            treinarClassificador(arquivoTweetsRotulados);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RotularAmostraTweets.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RotularAmostraTweets.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void treinarClassificador(File file) {
        ArrayList<Double> listaClassificacoes = new ArrayList<>();
        ArrayList<svm_node[]> atributos = new ArrayList<>();
        svm_node[][] nudes = new svm_node[][]{};
        Double[] classific = new Double[]{};
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!"".equals(line)) {
                    try {
                        ArrayList<Double> listaAtributos = new ArrayList<>();
                        org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) new JSONParser().parse(line);
                        listaClassificacoes.add(Double.valueOf((String) jsonObject.get("classificacao")));
                        JSONArray lista = (JSONArray) jsonObject.get("atributos");
                        for (Object lista1 : lista) {
                            listaAtributos.add(Double.valueOf(((String) lista1).split(":")[0]));
                        }
                        atributos.add(setarSVMNOde(listaAtributos));
                    } catch (ParseException ex) {
                        System.err.println(ex.getMessage());
                    }
                }
            }
            classific = listaClassificacoes.toArray(classific);
            nudes = atributos.toArray(nudes);
            treinar(classific, nudes);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RotularAmostraTweets.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RotularAmostraTweets.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static ArrayList<String> getPalavrasTexto(String texto) {
        ArrayList<String> palavras = new ArrayList<>();
        Pattern p = Pattern.compile("[a-zA-Zà-úÀ-Ú]+");
        Matcher m = p.matcher(texto);
        while (m.find()) {
            String palavra = m.group().toUpperCase();
            palavras.add(palavra);
        }
        return palavras;
    }

    private static JSONObject ordenarListaAtributos(String classificacao, ArrayList<Long> lista) {
        JSONObject json = new JSONObject();
        JSONArray jArray = new JSONArray();
        json.put("classificacao", classificacao);
        lista = new Auxiliar().Ordena(lista);
        for (Long lista1 : lista) {
            jArray.add(lista1 + ":1");
        }
        json.put("atributos", jArray);
        return json;
    }

    private static void salvarNoArquivo(File arquivoTweets, JSONObject tweet) {
        try {
            Arquivo.escrever(arquivoTweets, tweet, true);
        } catch (IOException ex) {
            Logger.getLogger(RotularAmostraTweets.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static File arquivar(String diretorioArquivoPalavras) {
        File file = new File(diretorioArquivoPalavras + "2");
        return file;
    }

    public static svm_node[] setarSVMNOde(ArrayList<Double> listaAtributos) {
        ArrayList<svm_node> listaNodes = new ArrayList<>();
        svm_node[] nudes = new svm_node[]{};
        listaAtributos.stream().map((atributo) -> {
            svm_node node = new svm_node();
            node.index = listaAtributos.indexOf(atributo) + 1;
            node.value = atributo;
            return node;
        }).forEach((node) -> {
            listaNodes.add(node);
        });
        return listaNodes.toArray(nudes);
    }

    private static void treinar(Double[] classific, svm_node[][] nudes) {
        try {
            svm_problem problem = setarProblema(classific, nudes);
            svm_parameter parameter = new svm_parameter();
            parameter.cache_size = 3;
            parameter.eps = 0.001;
            parameter.C = 1;
            svm_model model = svm.svm_train(problem, parameter);
            svm.svm_save_model("\\\\ARTHUR\\Users\\W8\\Desktop\\libsvm-3.20\\libsvm-3.20\\windows\\testeiaiai2.model", model);
        } catch (IOException ex) {
            Logger.getLogger(RotularAmostraTweets.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static svm_problem setarProblema(Double[] classific, svm_node[][] nudes) {
        svm_problem problem1 = new svm_problem();
        problem1.l = nudes.length;
        problem1.x = nudes;
        problem1.y = Stream.of(classific).mapToDouble(Double::doubleValue).toArray();
        return problem1;
    }

    static class Auxiliar {

        public ArrayList<Long> Ordena(ArrayList<Long> lista) {
            Collections.sort(lista);
            return lista;
        }
    }
}
