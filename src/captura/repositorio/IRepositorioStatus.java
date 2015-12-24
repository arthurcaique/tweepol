/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package captura.repositorio;

import java.io.File;
import exceptions.ErroInternoException;

/**
 *
 * @author W8
 */
public interface IRepositorioStatus {
    
    public void inserirStatus(File arquivo, Object status) throws ErroInternoException;
}
