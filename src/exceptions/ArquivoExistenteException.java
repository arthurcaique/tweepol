/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author W8
 */
public class ArquivoExistenteException extends Exception {

    public ArquivoExistenteException() {
        super("Arquivo existente!");
    }
    
}
