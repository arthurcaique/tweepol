/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package captura.control;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import exceptions.ArquivoExistenteException;
import exceptions.ErroInternoException;
import utilitarios.ArquivoUtils;

/**
 *
 * @author W8
 */
public class ControladorStream {

    /**
     * Esse método vai salvar um arquivo dos termos de uma captura de tweets, no mesmo diretório que o arquivo com os tweets será salvo
     * @param arquivo Arquivo com os tweets 
     * @param termos Os termos a serem salvos
     * @throws ArquivoExistenteException
     * @throws ErroInternoException
     */
    public static void salvarArquivoTermos(File arquivo, String... termos) throws ArquivoExistenteException, ErroInternoException {
        try {
            String diretorio = arquivo.getAbsolutePath();
            diretorio = diretorio.substring(0, diretorio.lastIndexOf("\\"));
            File arquivoTermos = ArquivoUtils.criar(diretorio, arquivo.getName() + "termos.txt");
            ArquivoUtils.escrever(arquivoTermos, new Date() + Arrays.toString(termos), false);
        } catch (IOException ex) {
            throw new ErroInternoException(ex);
        } catch (ArquivoExistenteException ex) {
            throw ex;
        }
    }
}
