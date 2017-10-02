package Kont2011;

public class Person {
    // Variabler for info som trengs om kunder i et kunderegister
    private String navn;
    private long personNummer;
    private int alder;
    
    // Henter inn verdier til navn, personNummer og alder i parameteret til konstruktøren, og setter variablene i klassen lik de innhentede verdiene
    public Person(String navn, long personNummer, int alder) {
        this.navn = navn;
        this.personNummer = personNummer;
        this.alder = alder;
    }
    
    // Returnerer navnet på personen
    public String getNavn(){
        return navn;
    }
    
    // returnerer personens personnummer
    public long getPersonNummer() {
        return personNummer;
    }
    
    // returnerer alder
    public int getAlder() {
        return alder;
    }
}
