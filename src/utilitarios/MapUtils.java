/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author W8
 */
public class MapUtils {

    public static Map ordenarLongKey(Map map) {
        Map sortedMap = new TreeMap(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return o1.compareTo(o2);
            }
        });
        sortedMap.putAll(map);
        return sortedMap;
    }
}
