package Eksamen;

// Arver fra Animal klassen, og implementerer metoder fra FellesMetoder interfacet
public class Bird extends Animal implements FellesMetoder {    
    // Constructor
    public Bird() {
        super();    // Kaller constructoren til parent klassen
        System.out.println("A new bird has been created!");
    }
    
    // Metode fra interface
    @Override
    public void sleep() {
        System.out.println("A bird sleeps...");
    }
    
    // Metode fra interface
    @Override
    public void eat() {
        System.out.println("A brid eats...");
    }
}
