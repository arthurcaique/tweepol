/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import java.util.ArrayList;

/**
 *
 * @author W8
 */
public class ArrayUtils {

    /**
     * Esse método transforma uma ArrayList de String em um Array de String
     * @param list ArrayList de String que será transformada em um Array de String
     * @return Array de String
     */
    public static String[] transformarArrayListemArray(ArrayList<String> list) {
        String[] array = new String[list.size()];
        array = list.toArray(array);
        return array;
    }
}
