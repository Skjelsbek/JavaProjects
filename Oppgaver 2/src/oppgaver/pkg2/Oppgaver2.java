// Author Jon Skjelsbæk
package oppgaver.pkg2;

import java.util.Random;

public class Oppgaver2 {

    // Kjører alle oppgavene/metodene
    public static void main(String[] args) {
        oppgave1();
        oppgave2();
        oppgave3();
        oppgave4();
        oppgave5();
        oppgave6();
        oppgave7();
        oppgave8();

    }

    // Oppgave 1
    static void oppgave1() {

        System.out.println("Oppgave 1:");
        for (int i = 1; i <= 10; i++) {

            System.out.println(i);

        } // End for

        System.out.println();

    } // End oppgave1

    // Oppgave 2
    static void oppgave2() {

        System.out.println("Oppgave 2:");

        for (int i = 1; i <= 10; i++) {

            for (int n = 1; n <= 10; n++) {

                System.out.print(n * i + "\t");

            } // End for n

            System.out.println();

        } // End for i

        System.out.println();

    } // End oppgave2

    // Oppgave 3
    static void oppgave3() {

        System.out.println("Oppgave 3:");

        // Tall du vil ta fakultet av
        int n = 5;
        // Fakultet variabel
        int fakultet = 1;

        for (int i = 1; i <= n; i++) {

            // Endrer fakultetens verdi for hver gang loopen kjører med hensyn på i
            fakultet = fakultet * i;

        } // End for

        // Printer handlingen og resultatet
        System.out.print(n + "!=");
        int x = n;
        while (x >= 1) {
            if (x > 1) {
                System.out.print(x + "*");
                x--;
            } // End if
            if (x == 1) {
                System.out.print(x);
                x--;
            } // End if
        } // End while

        System.out.println("=" + fakultet + "\n");

    } // End oppgave3

    // Oppgave 4
    static void oppgave4() {

        System.out.println("Oppgave 4:");

        // Variabler
        int heltall = 3;
        float kommatall = 3;

        // Print
        System.out.println("3/2=" + heltall / 2 + " hvis man bruker int variabel.");
        System.out.println("3/2=" + kommatall / 2 + " hvis man bruker float variabel.");
        System.out.println("Dette skjer fordi 'int' ikke tar med det som ");
        System.out.println("kommer etter komma, i motsetning til 'float'." + "\n");

    } // End oppgave4

    // Oppgave 5
    static void oppgave5() {

        System.out.println("Oppgave 5:");

        for (int i = 0; i <= 10; i++) {
            System.out.print(i + "/3 = " + i / 3);
            System.out.println(" og " + i % 3 + " i rest");
        } // End for

        System.out.println("Dette kan brukes for å regne om fra et tallsystem til et annet, og for å se om en divisjon går opp." + "\n");

    } // End oppgave5

    // Oppgave 6
    static void oppgave6() {

        System.out.println("Oppgave 6:");

        System.out.println("Tall mellom 1 og 30 som er delelig med enten 2 eller 3:");

        for (int i = 1; i <= 30; i++) {

            // Sjekker om resten = 0 for i/2 eller i/3 og skriver ut i dersom dette er oppfylt for en av de
            if ((i % 2 == 0 || i % 3 == 0) && (i < 30)) {

                System.out.print(i + ", ");

            } else if (i % 2 == 0 || i % 3 == 0) {

                System.out.print(i + "\n" + "\n");

            } // end if-else if

        } // End for

    } // End oppgave6

    // Oppgave 7
    static void oppgave7() {

        System.out.println("Oppgave 7:");

        // Lager 2 terninger, og tildeler hver av de en tilfeldig verdi fra 1 til 6
        int terning1 = (int) (Math.random() * 6 + 1);
        int terning2 = (int) (Math.random() * 6 + 1);

        // Kaster terningene igjen hvis ikke terning 1 og terning 2 er like
        while (terning1 != terning2) {

            terning1 = (int) (Math.random() * 6 + 1);
            terning2 = (int) (Math.random() * 6 + 1);

        } // End while

        // Når terning 1 og terning 2 har like verdier, skrives verdiene ut
        System.out.println("Terning 1 = " + terning1 + "\n" + "Terning 2 = " + terning2);
        System.out.println("Sum = " + (terning1 + terning2) + "\n");

    } // End oppgave7

    // Oppgave 8
    static void oppgave8() {

        System.out.println("Oppgave 8:");

        // Variabler
        int terning1 = 0;
        int terning2 = 0;
        Random rnd = new Random();        

        // Kaster terning helt til verdien fra terning 1 = verdien fra terning 2
        do {
            terning1 = rnd.nextInt(6) + 1;
            terning2 = rnd.nextInt(6) + 1;
        } while (terning1 != terning2);

        // Skriver ut verdiene for begge terningene, og summen av de
        System.out.println("Terning 1 = " + terning1);
        System.out.println("Terning 2 = " + terning2);
        System.out.println("Sum = " + (terning1 + terning2) + "\n");

    } // End oppgave8

} // End class
