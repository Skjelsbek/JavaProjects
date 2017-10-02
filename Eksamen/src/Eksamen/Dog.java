package Eksamen;

// Arver fra Animal klassen, og implementerer metoder fra FellesMetoder interfacet
public class Dog extends Animal implements FellesMetoder {    
    // Constructor
    public Dog() {
        super();    // Kaller constructoren til parent klassen
        System.out.println("A new dog has been created!");
    }
    
    // Metode fra interface
    @Override
    public void sleep() {
        System.out.println("A dog sleeps...");
    }
    
    // Metode fra interface
    @Override
    public void eat() {
        System.out.println("A dog eats...");
    }    
}
