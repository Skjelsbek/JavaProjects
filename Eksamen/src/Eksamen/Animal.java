package Eksamen;

// Implementerer metoder fra FellesMetoder interfacet
public class Animal implements FellesMetoder {
    // Constructor
    public Animal() {
        System.out.println("A new animal has been created!");
    }
    
    // Metode fra interface
    @Override
    public void sleep() {
        System.out.println("An animal sleeps...");
    }
    
    // Metode fra interface
    @Override
    public void eat() {
        System.out.println("An animal eats...");
    }
}
