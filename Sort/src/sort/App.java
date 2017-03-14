package sort;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        Person[] arr = new Person[10];
        Random rnd = new Random();
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Person(rnd.nextInt(90) +1 );
        }
        
        System.out.println("Før sortering:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + ": " + arr[i].toString());
        }
        
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        
        System.out.println("");
        System.out.println("Etter sortering:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + ": " + arr[i].toString());
        }
        
    }
}
