/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package captura.repositorio;

import java.io.File;
import java.io.IOException;
import utilitarios.Arquivo;
import exceptions.ErroInternoException;
import utilitarios.ArquivoUtils;

/**
 *
 * @author W8
 */
public class RepositorioStatus implements IRepositorioStatus {

    public static IRepositorioStatus INSTANCIA;

    public static IRepositorioStatus getINSTANCIA() {
        if (INSTANCIA == null) {
            INSTANCIA = new RepositorioStatus();
        }
        return INSTANCIA;
    }

    @Override
    public void inserirStatus(File arquivo, Object status) throws ErroInternoException {
        try {
            ArquivoUtils.escrever(arquivo, status, Boolean.TRUE);
        } catch (IOException ex) {
            throw new ErroInternoException(ex);
        }
    }

}