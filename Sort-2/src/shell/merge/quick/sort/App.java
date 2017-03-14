package shell.merge.quick.sort;

import java.util.Random;

public class App {
    
    public static void main(String[] args) {
        Random rnd = new Random();      // Random objekt
        Person[] arr = new Person[10];  // Person array
        
        // Oppretter 10 personer i arrayet med randomgenererisert alder
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Person(rnd.nextInt(90) + 1);   
        }
        
        // Skriver ut alderen før sortering
        System.out.println("Før sortering:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Person " + (i) + ": " + arr[i].getAge() + "år");
        }
        System.out.println(""); // Ny linje
        
//        // ShellSort
//        ShellSort sort1 = new ShellSort();
//        sort1.sort(arr);

        // MergeSort
        MergeSort sort2 = new MergeSort();
        sort2.sort(arr);
        
        // Skriver ut etter sortering
        System.out.println("Etter sortering:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Person " + (i) + ": " + arr[i].getAge() + "år");
        }
    }
}
