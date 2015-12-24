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
public enum KernelType {

    LINEAR(0, "Linear"),
    POLYNOMIAL(1, "Polinomial"),
    RADIAL_BASIS_FUNCTION(2, "RBF"),
    SIGMOID(3, "Sigmoid"),
    PRECOMPUTED_KERNEL(4, "Pré-computado");

    private final int id;
    private final String descricao;

    private KernelType(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static KernelType buscarKernelType(int id) throws DadoInvalidoException {
        for (KernelType kType : KernelType.values()) {
            if (Objects.equals(kType.getId(), id)) {
                return kType;
            }
        }
        throw new DadoInvalidoException("Kernel Type inexistente.");
    }
}
