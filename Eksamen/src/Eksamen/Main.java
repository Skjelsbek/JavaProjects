package Eksamen;


public class Main {
    public static void main(String[] args) {
        System.out.println("Oppgave 1:");
        Oppgave1 oppgave1 = new Oppgave1();
        
        System.out.println();
        System.out.println("Oppgave2");
        Oppgave2 oppgave2 = new Oppgave2();
        
        System.out.println();
        System.out.println("Oppgave3");        
        Tabell oppgave3 = new Tabell();
        
        System.out.println();
        System.out.println("Oppgave4");
        Animal animal = new Animal();
        Bird bird = new Bird();
        Dog dog = new Dog();
        
        System.out.println("");
        animal.sleep();
        animal.eat();
        bird.sleep();
        bird.eat();
        dog.sleep();
        dog.eat();
    }
}
