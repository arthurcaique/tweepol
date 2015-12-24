/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treino.control;

import exceptions.ErroInternoException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import libsvm.svm;
import libsvm.svm_model;
import libsvm.svm_node;
import libsvm.svm_parameter;
import libsvm.svm_problem;
import main.RotulacaoAmostra;
import svm_tweet.KernelType;
import svm_tweet.SvmType;
import tweet.Tweet;

/**
 *
 * @author Arthur
 */
public class ControladorTreino {

    public static svm_parameter setarSVMParameter(svm_tweet.SvmType svm_type, svm_tweet.KernelType kernelType, Integer degree,
            Double gamma, double num_features, Double coef0, Double eps, Double C, Integer nr_weight, Integer[] weight_label, Double[][] weight,
            Double nu, Double p, boolean use_shrink_heuristics, boolean prob_estimates) {
        svm_parameter param = new svm_parameter();
        param.svm_type = svm_type.getId();
        param.kernel_type = kernelType.getId();
        if (kernelType == KernelType.POLYNOMIAL) {
            param.degree = degree != null ? degree : 3;
        }
        if (kernelType == KernelType.POLYNOMIAL || kernelType == KernelType.SIGMOID || kernelType == KernelType.RADIAL_BASIS_FUNCTION) {
            param.gamma = gamma != null ? gamma : 1 / num_features;
        }
        if (kernelType == KernelType.POLYNOMIAL || kernelType == KernelType.SIGMOID) {
            param.coef0 = coef0 != null ? coef0 : 0;
        }
//        parameter.cache_size = ;
        param.eps = eps != null ? eps : 0.001;
        if (svm_type == SvmType.C_SVC || svm_type == SvmType.EPSILON_SVR || svm_type == SvmType.NU_SVR) {
            param.C = C != null ? C : 1;
        }
        if (svm_type == SvmType.C_SVC) {
            param.nr_weight = nr_weight != null ? nr_weight : 1;
//        parameter.weight = weight!=null?weight:;
//        parameter.weight_label = weight_label!=null?weight_label:;
        }
        if (svm_type == SvmType.NU_SVC || svm_type == SvmType.NU_SVR || svm_type == SvmType.ONE_CLASS_SVM) {
            param.nu = nu != null ? nu : 0.5;
        }
        if (svm_type == SvmType.EPSILON_SVR) {
            param.p = p != null ? p : 0.001;
        }
        param.shrinking = use_shrink_heuristics ? 1 : 0;
        param.probability = prob_estimates ? 1 : 0;
        return param;
    }

    public static svm_model treinar(svm_parameter param, List<Tweet> tweets, String diretorio) throws ErroInternoException {
        try {
            param.kernel_type = KernelType.LINEAR.getId();
            ArrayList<Double> listaClassificacoes = new ArrayList<>();
            ArrayList<svm_node[]> atributos = new ArrayList<>();
            svm_node[][] nodes = new svm_node[][]{};
            Double[] classific = new Double[]{};
            tweets.stream().forEach((tweet) -> {
                Double polaridade = getDoubleValuePolaridade(tweet.getPolaridade().getValue());
                listaClassificacoes.add(polaridade);
                atributos.add(RotulacaoAmostra.setarSVMNodes(tweet.getTfidf()));
            });
            classific = listaClassificacoes.toArray(classific);
            nodes = atributos.toArray(nodes);
            svm_problem problem = setarProblema(classific, nodes);
            svm_model model = svm.svm_train(problem, param);
            svm.svm_save_model(diretorio + "\\modelo.model", model);
            return model;
        } catch (Exception ex) {
            throw new ErroInternoException(ex);
        }
    }

    public static svm_model treinar(svm_parameter param, List<Tweet> tweets) throws ErroInternoException {
        try {
            ArrayList<Double> listaClassificacoes = new ArrayList<>();
            ArrayList<svm_node[]> atributos = new ArrayList<>();
            svm_node[][] nodes = new svm_node[][]{};
            Double[] classific = new Double[]{};
            tweets.stream().forEach((tweet) -> {
                Double polaridade = getDoubleValuePolaridade(tweet.getPolaridade().getValue());
                listaClassificacoes.add(polaridade);
                atributos.add(RotulacaoAmostra.setarSVMNodes(tweet.getTfidf()));
            });
            classific = listaClassificacoes.toArray(classific);
            nodes = atributos.toArray(nodes);
            svm_problem problem = setarProblema(classific, nodes);
            svm_model model = svm.svm_train(problem, param);
            return model;
        } catch (Exception ex) {
            throw new ErroInternoException(ex);
        }
    }

    private static Double getDoubleValuePolaridade(Integer value) {
        return Double.parseDouble(String.valueOf(value));
    }

    private static svm_problem setarProblema(Double[] classific, svm_node[][] nodes) {
        svm_problem problem1 = new svm_problem();
        problem1.l = classific.length;
        problem1.x = nodes;
        problem1.y = Stream.of(classific).mapToDouble(Double::doubleValue).toArray();
        return problem1;
    }
}
