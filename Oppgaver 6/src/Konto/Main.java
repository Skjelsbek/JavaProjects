package Konto;

public class Main {
    
    // Objekter av klassen konto
    static Konto jon = new Konto();
    static Konto nils = new Konto();
    
    public static void main(String[] args){                
        opprettKonto1("Jon", 1000); // Oppretter en konto med navn Jon og start saldo 1000
        System.out.println("Etter oppretting av konto ser ting slik ut:");
        jon.skrivInfo();            // Skriver ut info
        System.out.println();
        
        System.out.println("Så setter vi inn 200kr: ");
        jon.settInnPenger(200);                                   // Setter inn penger
        System.out.println("Saldo: " + jon.getSaldo() + "kr\n");  // Skriver ut saldo med getSaldo metoden fra objektet jon
        
        // Gjør det samme med Nils
        System.out.println("Her har jeg opprettet en konto til Nils:");
        opprettKonto2("Nils", 200);
        nils.skrivInfo();
        System.out.println();
        
        System.out.println("Så setter vi inn 100kr:");
        nils.settInnPenger(100);
        System.out.println("Saldo: " + nils.getSaldo() + "kr\n");
        
        // Tar ut penger med taUtPenger metoden i både jon-objektet og nils-objektet
        System.out.println("La oss nå prøve å ta ut penger");
        System.out.println("Vi starter med å ta ut 500kr fra Jon's konto:");
        jon.taUtPenger(500);
        System.out.println("Saldo: " + jon.getSaldo() + "kr\n");
        
        System.out.println("Så prøver vi å ta ut mer enn Nils har, la oss prøve med 500 her også:");
        nils.taUtPenger(500);
        System.out.println("Saldo: " + nils.getSaldo() + "kr\n");
        
    }
    
    // Gir kontoen ett navn og en start saldo
    public static void opprettKonto1(String navn, int verdi){
        jon.setNavn(navn);
        jon.setSaldo(verdi); 
    }      
    
    // Gir kontoen ett navn og en start saldo
    public static void opprettKonto2(String navn, int verdi) {
        nils.setNavn(navn);
        nils.setSaldo(verdi);
    }        
}
