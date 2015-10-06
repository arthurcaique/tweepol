/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

/**
 *
 * @author W8
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String str1 = "HurarTahuhuahuahuauhhuarThahhuauhauart";
        String str2 = "ARt";
        int indexOf = str1.toLowerCase().indexOf(str2.toLowerCase());
        int length = str2.length();
        String substring = str1.substring(indexOf, indexOf+length);
        str1 = str1.replaceAll("(?i)"+substring, "");
        System.out.println(str1);
    }
    
}
