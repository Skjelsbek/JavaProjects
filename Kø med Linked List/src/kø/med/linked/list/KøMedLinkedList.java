package kø.med.linked.list;

import java.util.Random;

public class KøMedLinkedList {

    public static void main(String[] args) {
        Kø kø = new Kø();
        Random rnd = new Random();
        
        System.out.println("Setter inn:");
        int i = 0;
        while (i < 5) {
            int j = rnd.nextInt(100);
            kø.enQueue(j);
            System.out.println(j);
            i++;
        }
        
        System.out.println("");
        System.out.println("Tar ut:");
        i = 0;
        while (i < 2) {
            System.out.println(kø.deQueue());
            i++;
        }
        
        System.out.println("");
        System.out.println("Setter inn igjen");
        i = 0;
        while (i < 2) {
            int j = rnd.nextInt(100);
            kø.enQueue(j);
            System.out.println(j);
            i++;
        }
        
        System.out.println("");
        System.out.println("Tar ut alt:");
        i = 0;
        while (i < 5) {
            System.out.println(kø.deQueue());    
            i++;
        }
    }
    
}
