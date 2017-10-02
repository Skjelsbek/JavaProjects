package bubblesort;

import java.util.Random;

public class BubbleSort {

    public static void main(String[] args) {        
        int[] array = createArray(10);      // Lager array med 10 plasser
        int[] sortedArray;                  // Variabel for sortert array    
        
        System.out.println("Arrayet før noe som helst er gjort med det:");
        printArray(array);                  // Printer arrayet
        System.out.println();
        sortedArray = bubblesort(array);    // Sorterer arrayet
        System.out.println("Arrayet nå som det er sortert:");
        printArray(sortedArray);            // Printer sortert array
        System.out.println();
        System.out.println("Opprinnelig array:");
        printArray(array);                  // Printer opprinnelig array
        
    }
    
    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    
    public static int[] createArray(int size) {
        int[] array = new int[size];
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rnd.nextInt(100) + 1;            
        }
        
        return array;
    }
    
    public static int[] copyArray(int[] array) {                
        int[] copy = array.clone();
        return copy;
    }
    
    public static int[] bubblesort(int[] array) {
        int[] tmpArr = copyArray(array);        
        int temp;
        for (int x = tmpArr.length - 1; x > 0; x--) {
            for (int y = 0; y < x; y++) {
                if (tmpArr[y] > tmpArr[y + 1]) {
                    temp = tmpArr[y];
                    tmpArr[y] = tmpArr[y + 1];
                    tmpArr[y + 1] = temp;
                }
            }
        }
        
        return tmpArr;
    }
}
