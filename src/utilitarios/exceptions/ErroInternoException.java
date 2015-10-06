/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author W8
 */
public class ErroInternoException extends Exception {

    private Exception origem;

    public ErroInternoException(Exception exception) {
        super(exception);
        Logger.getLogger(ErroInternoException.class.getName()).log(Level.SEVERE, null, exception);
    }

    public ErroInternoException(String mensagem) {
        super(mensagem);
    }

    public ErroInternoException() {
        super("Erro interno!");
    }

    @Override
    public String getMessage() {
        return origem.getMessage();
    }

    public void exibirMensagemAoUsuario(Exception exception){
        Logger.getLogger(ErroInternoException.class.getName()).log(Level.SEVERE, null, exception);
        JOptionPane.showMessageDialog(null, "Ocorreu um erro interno!", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
