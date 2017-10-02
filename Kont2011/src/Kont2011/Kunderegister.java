package Kont2011;

import java.util.Scanner;

public class Kunderegister {

    private Scanner input;
    private Person[] brukere;
    private int antallBrukere = 0;  // Variabel for totalt antall brukere for å lettere kunne opprette kontoer på riktig plass osv.
    
    // Konstruktør som instansierer en ny scanner og ett nytt person array med plass til 20 personer
    public Kunderegister() {
        input = new Scanner(System.in);
        brukere = new Person[20];
    }
    
    // Legger til en ny bruker i arrayet 'brukere'    
    public void leggTilBruker(String navn, long personNummer, int alder) { // Klassen 'Person' har en konstruktør som trenger input i parameteret, så vi henter inn det her også.
        brukere[antallBrukere] = new Person(navn, personNummer, alder); // Bruker det vi hentet inn fra metodens parameter når vi oppretter ett objekt av klassen Person.
        antallBrukere++;
    }
    
    // Fjerner en bruker fra arrayet basert på personnummer, og flytter brukerene som ligger etter denne personen i arrayet, 1 plass tilbake.
    public void fjernBruker(long personNummer) {
        // Går fra 0 til antall brukere i arrayet
        for (int i = 0; i < antallBrukere; i++) {
            // Hvis brukerene på plass 'i' i arrayet har samme personnummer som brukeren som skal fjernes, kjør koden.            
            if (brukere[i].getPersonNummer() == personNummer){
                brukere[i] = null; // Fjerner bruker
                antallBrukere--;    // reduserer antall brukere

                // Brukere som kommer etter den slettede blir flyttet
                for (int j = i; j < antallBrukere; j++) {
                    brukere[j] = brukere[j + 1];
                }
            }
        }
    }
    
    // Viser en liste over kunder i registeret med oversikt over personnummer og navn.
    public void visPersonListe() {
        System.out.println("Personnummer\tNavn\n--------------------"); // Skriver ut 'Personnummer' og 'navn' med tab mellom, så '----------' på ny linje. 
        
        // Går igjennom alle brukerne i arrayet
        for (int i = 0; i < antallBrukere; i++) {
            System.out.print(brukere[i].getPersonNummer()); // Skriver ut personnummer
            
            /* 
                Avstanden mellom 'Personnummer' og 'Navn' i orverskriften er en tab, så for å lage en perfekt kolonne under 'Navn'
                tar jeg lengden på ordet 'Personnummer' og trekker fra lengden på personnummeret som allerde står
                i 'Personnummer'-kolonnen. Da vet programmet hvor mange mellomrom som må settes inn for at personnummeret skal bli
                like langt som ordet 'Personnummer', så det bare gjenstår å sette inn en tab, å skrive ut navnet på personen.
            */
            for (int j = 0; j < "Personnummer".length() - Long.toString(brukere[i].getPersonNummer()).length(); j++) {
                System.out.print(" ");
            }
            
            System.out.print("\t" + brukere[i].getNavn() + "\n"); // Setter inn tab etter personnummeret som nå er like langt som ordet 'Personnummer' pga mellomrom,
                                                                  // etterfulgt av navnet på personen på plass 'i' i arrayet.
        }
    }
    
    // Skriver ut den elste personen i arrayet
    public void skrivUtEldste() {
        Person eldste = brukere[0]; // må initialisere variabelen for å kunne bruke den i if-setningen. Velger å bruke Person og ikke int, for da har jeg tilgang til navnet også.
        
        // Går igjennom alle brukerne å oppdaterer 'eldste'-variabelen hvis brukeren på plass 'i' er eldre enn den som er satt som eldst.
        for (int i = 0; i < antallBrukere; i++) {
            if(brukere[i].getAlder() > eldste.getAlder()) {
                eldste = brukere[i];
            }
        }
        System.out.println("Den elste brukeren er: " + eldste.getNavn() + ", som er " + eldste.getAlder() + "år."); // Printer den elste brukerens navn og alder.
    }
    
    // Tester om alle metoder fungerer.
    public static void main(String[] args) {
        Kunderegister kunderegister = new Kunderegister(); // Lager et objekt av klassen 'Kunderegister'.
        
        // bruker metoden 'leggTilBruker' for å legge til brukere
        kunderegister.leggTilBruker("Jon", 20059744884L, 20);
        kunderegister.leggTilBruker("Jens", 20059612345L, 18);
        kunderegister.leggTilBruker("Ola", 20059543217L, 49);
        kunderegister.leggTilBruker("Trond", 20059432419L, 0);
        kunderegister.leggTilBruker("Bertil", 20059365871L, 16);
        kunderegister.leggTilBruker("Sven", 20059272721L, 14);
        kunderegister.leggTilBruker("Truls", 20059272722L, 14);
        kunderegister.leggTilBruker("Gudrunn", 20059272736L, 14);        
        kunderegister.visPersonListe(); // Viser personliste med 'visPersonListe'-metoden.
        kunderegister.fjernBruker(20059543217L);    // Tester metoden 'fjernBruker' på bruker 'Ola'.
        System.out.println(""); // For å få ett mellomrom i utskriften.
        kunderegister.visPersonListe(); // Viser personliste etter Ola er fjernet for å sjekke om 'fjernBruker'-metoden funker som den skal.
        kunderegister.skrivUtEldste(); // Bruker metoden 'skrivUtEldste' for å sjekke hvilken person som er eldst.

    }

}
