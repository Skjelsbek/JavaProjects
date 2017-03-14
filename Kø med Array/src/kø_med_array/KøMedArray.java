package kø_med_array;

import java.util.Random;

public class KøMedArray {
    
    public static void main(String[] args) {
        Queue queue = new Queue();
        Random rnd = new Random();
        
        System.out.println("Putter inn:");
        int i = 0;
        while (i < 10) {
            int j = rnd.nextInt(100);
            queue.enQueue(j);
            System.out.println(j);
            i++;
        }
        
        System.out.println("");
        System.out.println("Tar ut:");
        i = 0;
        while (i < 5) {            
            System.out.println(queue.deQueue());           
            i++;
        }
        
        i = 0;
        System.out.println("Putter inn igjen");
        while (i < 10) {
            int j = rnd.nextInt(100);
            queue.enQueue(j);
            System.out.println(j);
            i++;
        }
        
        System.out.println("Tar ut:");
        i = 0;
        while (i < 15) {            
            System.out.println(queue.deQueue());           
            i++;
        }        
    }    
}
