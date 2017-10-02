package to_tabeller_på_annenhver_plass_i_en_ny;

import java.text.DecimalFormat;
import java.util.Random;

public class ToTabellerPåAnnenhverPlassIEnNy {

    public static void main(String[] args) {
        int[] array1 = new int[10];
        int[] array2 = new int[10];
        int[] array3 = new int [20];
        Random rnd = new Random();
        
        for (int i = 0; i < array1.length; i++) {
            array1[i] = rnd.nextInt(100) + 1;
        }
        
        for (int i = 0; i < array1.length; i++) {
            System.out.print(i + ": " + array1[i] + " ");
        }
        
        System.out.println("");
        
        for (int i = 0; i < array1.length; i++) {
            array2[i] = rnd.nextInt(100) + 1;
        }
        
        for (int i = 0; i < array1.length; i++) {
            System.out.print(i + ": " + array2[i] + " ");
        }
        
        System.out.println("");
        int teller1 = 0;
        int teller2 = 0;
        
        for (int i = 0; i < array3.length; i++) {
            if (i%2 == 0) {
                array3[i] = array1[teller1];
                teller1++;
            } else {
                array3[i] = array2[teller2];
                teller2++;
            }
        }
        
        for (int i = 0; i < array3.length; i++) {
            System.out.print(i + ": " + array3[i] + " ");
        }       
    }
}
