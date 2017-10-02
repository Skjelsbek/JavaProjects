package Eksamen2012;

import java.util.Random;

public class Konto {
    double saldo;
    String eier;
    static double bankSaldo;
    
    public Konto(double innsaldo, String inneier) {
        saldo = innsaldo;
        bankSaldo += innsaldo;
        eier = inneier;
    }
    
    public static void main(String[] args) {
        Konto[] kontoer = new Konto[10];
        String[] navn = {"Jon", "Karoline", "Nils", "Martin", "Marius", "Espen", "Vegard", "Adrian", "Marcus", "Magnus"};
        Random rnd = new Random();
        
        for (int i = 0; i < kontoer.length; i++) {
            kontoer[i] = new Konto(rnd.nextInt(100) + 1, navn[i]);
        }
        
        for (int i = 0; i < kontoer.length; i++) {
            kontoer[i].getSaldo();
        }
        
        System.out.println("");        
        bankTotal();
        
        kontoer[5].taUt(5);
        bankTotal();
        kontoer[5].settInn(15);
        bankTotal();
    }
    
    public void getSaldo() {
        System.out.println(eier + "s slado er: " + saldo + "kr");
    }
    
    public void settInn(double verdi) {
        if (verdi > 0) {
            saldo += verdi;
            bankSaldo += verdi;
        } else {
            System.out.println("Beløpet må være større enn 0!");
        }
    }
    
    public void taUt(double verdi) {
        if (saldo >= verdi) {
            saldo -= verdi;
            bankSaldo -= verdi;
        } else {
            System.out.println("Ikke nok penger på konto!");
        }
    }
    
    public static void bankTotal() {
        System.out.println("Banken har totalt: " + bankSaldo + "kr");
    }
}
