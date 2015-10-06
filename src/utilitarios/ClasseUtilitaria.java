/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import java.awt.Component;
import javax.swing.JDialog;
import javax.swing.JFrame;
import utilitarios.exceptions.ErroInternoException;

/**
 *
 * @author W8
 */
public class ClasseUtilitaria {

    public static void abrirView(Object tela, Component relativoA) throws ErroInternoException {
        try {
            if (tela instanceof JDialog) {
                ((JDialog) tela).setLocationRelativeTo(relativoA);
                ((JDialog) tela).setVisible(true);
            } else if (tela instanceof JFrame) {
                ((JFrame) tela).setLocationRelativeTo(relativoA);
                ((JFrame) tela).setVisible(true);
            }
        } catch (Exception e) {
            throw new ErroInternoException(e);
        }
    }


}
