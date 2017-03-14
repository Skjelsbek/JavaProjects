package insertion.sort;

import java.util.Random;
public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        Bil[] bilArr = new Bil[20];
        for (int i = 0; i < bilArr.length; i++) {
            bilArr[i] = new Bil(rnd.nextInt(20) + 2000);
        }     
        
        Sort sort = new Sort();
        //sort.insertionSort(bilArr);
        sort.selectionSort(bilArr);
        
        for (int i = 0; i < bilArr.length; i++) {
            System.out.println(bilArr[i]);
        }
    }            
}
