/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oppgaver.pkg1;

/**
 *
 * @author Jon Skjelsbæk
 */
public class Oppgaver1 {

    public static void main(String[] args) {

        // Variabler (Brukt i oppgave 4 - 8)       
        String MyName = "Jon";     // Variabel for mitt navn
        String NeighName = "Tom";  // Variabel for neabeons navn
        // Siden jeg har 2 for-loops som begge gjentas 10 ganger, velger jeg å innføre en telle-variabel
        int Teller = 10;

        // For-loopen under tillhører oppgave 8, den repeterer hele koden 10 ganger
        for (int y = 1; y <= Teller; y++) {

            // Så det er lettere å se hvor mange ganger den faktisk er skrevet ut
            System.out.println("Utskrift: " + y);
            System.out.println();

            // Oppgave 1
            // Jeg har valgt å bruke dette hele veien så man kan se i programmet hvilken oppg det tillhører
            System.out.println("Oppgave 1:");

            System.out.println("Hello World!"); // Skriver ut "Hello World!"

            System.out.println();

            // Oppgave 2
            System.out.println("Oppgave 2:");

            System.out.println("Hello World!");
            System.out.println("Hello World!");

            System.out.println();

            // Oppgave 3
            System.out.println("Oppgave 3");

            System.out.print("Jeg skriver ");
            System.out.print("mitt første ");
            System.out.println("java-");
            System.out.print("program og ");
            System.out.println("dette er gøy!");

            System.out.println();

            // Oppgave 4
            System.out.println("Oppgave 4:");

            System.out.println(MyName);  // Skriver ut variabelen MyName, som er tildelt navnet mitt (Jon)

            System.out.println();

            // Oppgave 5
            System.out.println("Oppgave 5:");

            // Skriver ut "Mitt navn er:" først, og legger til innholdet i variabelen MyName
            System.out.println("Mitt navn er: " + MyName);

            System.out.println();

            // Oppgave 6
            System.out.println("Oppgave 6:");

            System.out.println("Jeg " + "heter " + MyName + " og " + "jeg " + "lærer " + "java!");

            System.out.println();

            // Oppgave 7
            System.out.println("Oppgave 7:");

            // For-loopen under repeterer innholdet 10 ganger ved hjelp av variabelen teller 
            for (int i = 1; i <= Teller; i++) {
                System.out.println(i + "." + " Jeg heter " + MyName + " og naboen min heter " + NeighName + "!");
            }

            // For å få litt mellomrom mellom hver utskrift
            System.out.println();
            System.out.println();

        } // End for              

        // Oppgave 8
        System.out.println("Oppgave 8:");
        System.out.print("Jeg valgte å gjøre oppgave 8 ved å legge til en for-loop for hele koden" + "\n");
    } // End main

} // end class
