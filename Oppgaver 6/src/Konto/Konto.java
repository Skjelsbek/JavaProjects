package Konto;

public class Konto {
    double saldo;
    String eier;
    
    // Setter start saldo på kontoen
    public void setSaldo(int tall) {
        saldo = tall;        
    }
    
    // Setter navnet til eieren
    public void setNavn(String tekst){
        eier = tekst;
    }
    
    // Skriver ut eierens navn og start saldo
    public void skrivInfo(){
        System.out.println("Navn: " + eier);
        System.out.println("Saldo: " + saldo + "kr");
    }
    
    // Returnerer eierens saldo
    public double getSaldo() {
        return saldo;
    }
    
    // Setter inn penger
    public void settInnPenger(double verdi) {
        saldo += verdi;
    }
    
    // Tar ut penger
    public void taUtPenger(double verdi){
        // Trekker fra valgt sum penger fra konto, men ikke hvis du prøver å trekke fra mer enn det some er på kontoen
        if (saldo >= verdi) {
            saldo -= verdi;
        } else {
            System.out.println("Du har ikke nok penger på konto :(");
        }
    }
}
