package Eksamen;

import java.util.Random;

public class Tabell {
    int[] tabell = new int[8];
    
    public Tabell() {
        Random rnd = new Random();
        
        for (int i = 0; i < tabell.length; i++) {
            tabell[i] = rnd.nextInt(100) + 1;
        }
        
        skrivUt();
        sorter();
        System.out.println("");
        skrivUt();
    }
    
    public void skrivUt() {
        for (int i = 0; i < tabell.length; i++) {
            System.out.println(tabell[i]);
        }        
    }
    
    public void sorter() {
        for (int i = 0; i < tabell.length; i++) {
            for (int j = 0; j < tabell.length - 1; j++) {
                if (tabell[j] > tabell[j + 1]) {
                    int hjelp = tabell[j];
                    tabell[j] = tabell[j + 1];
                    tabell[j + 1] = hjelp;
                }
            }
        }
    }
}
