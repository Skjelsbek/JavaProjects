package Kont2013Oppgave4;

import java.util.Random;

public class Kontoer {
    Konto[] kontoArray = new Konto[10];
    String[] navnArray = {"Jon", "Turid", "Jens", "Olav", "Gudrunn", "Karl", "Karoline", "Adrian", "Espen", "Marcus"};
    Random rnd = new Random();
    
    public Kontoer() {        
        for (int i = 0; i < kontoArray.length; i++) {
            kontoArray[i] = new Konto(navnArray[i], (double) rnd.nextInt(1001));
        }
    }
    
    public void skrivUt() {
        System.out.println("Kontooversikt:\n---------------");
        for (int i = 0; i < kontoArray.length; i++) {
            System.out.println((i+1) + ": " + kontoArray[i].eier + ": " + kontoArray[i].saldo + "kr");
        }
    }
}
