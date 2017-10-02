package Kont2013Oppgave4;

public class Konto {
    String eier = "";
    double saldo;
    
    public Konto(String eier, double saldo) {
        this.eier = eier;
        this.saldo = saldo;
    }
    
    public void settInn(double verdi) {
        if (verdi > 0) {            
            saldo += verdi;
        } else {
            System.out.println("Sett inn ett beløp som er større enn null neste gang!");
        }
    }
    
    public void taUt(double verdi) {
        if (erDekningFor(verdi) && verdi > 0) {
            saldo -= verdi;
        } else if (verdi < 0) {
            System.out.println("Ikke prøv deg!");
        } else {
            System.out.println(this.eier + " har ikke nok penger på konto!");
        }
    }
    
    private boolean erDekningFor(double verdi) {
        if (this.saldo >= verdi) {
            return true;
        } else {
            return false;
        }
    }
}
