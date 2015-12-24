/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package words.repositorios;

import exceptions.ErroInternoException;
import java.io.File;
import java.util.ArrayList;
import words.Word;

/**
 *
 * @author W8
 */
public class ControladorWord {
    
    private final IRepositorioWord iRep;

    public ControladorWord(IRepositorioWord iRep) {
        this.iRep = iRep;
    }
    
    public ArrayList<Word> recuperarWordList(File arquivo) throws ErroInternoException {
        return this.iRep.recuperarWordList(arquivo);
    }
}
