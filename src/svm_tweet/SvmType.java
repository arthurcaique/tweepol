/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svm_tweet;

import exceptions.DadoInvalidoException;
import java.util.Objects;

/**
 *
 * @author W8
 */
public enum SvmType {
    
    C_SVC(0, "C-SVC (Classificação multi-classes)"),
    NU_SVC(1, "NU-SVC (Classificação multi-classes)"),
    ONE_CLASS_SVM(2, "Classificação classe única SVM"),
    EPSILON_SVR(3, "Epsilon-SVR (Regressão)"),
    NU_SVR(4, "NU-SVR (Regressão)");
    
    private final int id;
    private final String descricao;

    private SvmType(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public static SvmType buscarSvmType(int id) throws DadoInvalidoException{
        for(SvmType svmType : SvmType.values()){
            if(Objects.equals(svmType.getId(), id)){
                return svmType;
            }
        }
        throw new DadoInvalidoException("SVM type inexistente.");
    }
    
}
