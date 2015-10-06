/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.io.IOException;
import libsvm.svm;
import libsvm.svm_model;
import libsvm.svm_node;
import libsvm.svm_parameter;
import libsvm.svm_problem;

/**
 *
 * @author W8
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        gerarProblems();
    }

    private static void gerarProblems() {
        try {
            svm_problem problem = setarProblem();
            svm_parameter parameter = new svm_parameter();
            parameter.cache_size = 3;
            parameter.eps = 0.001;
            parameter.C = 1;
            svm_model model = svm.svm_train(problem, parameter);
            svm.svm_save_model("\\\\ARTHUR\\Users\\W8\\Desktop\\libsvm-3.20\\libsvm-3.20\\windows\\teste2.model", model);
            svm_node[] n1 = setarNode(4, 170, 32, 25);
            double svm_predict = svm.svm_predict(model, n1);
            System.out.println(svm_predict);
        } catch (IOException ex) {

        }
    }

    private static svm_problem testar(svm_node[]... nodes) {
        svm_problem problem1 = new svm_problem();
        problem1.l = nodes.length;
        svm_node[][] b = nodes;
        problem1.x = b;
        problem1.y = new double[]{1, 1, 0, -1};
        return problem1;
    }

    private static svm_problem setarProblem() {
        svm_node[] n1 = setarNode(12, 150, 3, 15);
        svm_node[] n2 = setarNode(4, 170, 32, 25);
        svm_node[] n3 = setarNode(1, 10, 3, 25);
        svm_node[] n4 = setarNode(12, 20, 31, 15);
        return testar(n1, n2, n3, n4);
    }

    private static svm_node[] setarNode(int nV1, int nV2, int nV3, int nV4) {
        svm_node n1 = new svm_node();
        n1.index = 1;
        n1.value = nV1;
        svm_node n2 = new svm_node();
        n2.index = 2;
        n2.value = nV2;
        svm_node n3 = new svm_node();
        n3.index = 3;
        n3.value = nV3;
        svm_node n4 = new svm_node();
        n4.index = 4;
        n4.value = nV4;
        svm_node[] a = new svm_node[]{n1, n2, n3, n4};
        return a;
    }

    public void testar() {

    }
}
