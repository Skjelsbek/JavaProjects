package oppgaver.pkg3;

import java.util.Random;

public class Oppgaver3 {

    public static void main(String[] args) {

        System.out.println("Oppgave 1");
        oppgave1();
        System.out.println();
        System.out.println("Oppgave 2");
        oppgave2();
        System.out.println();
        System.out.println("Oppgave 3");
        oppgave3();
        System.out.println();
        System.out.println("Oppgave 4");
        oppgave4();
        System.out.println();
        System.out.println("Oppgave 5");
        oppgave5();
        System.out.println();
        System.out.println("Oppgave 6");
        oppgave6();

    } // end main

    static void oppgave1() {

        int i = 99;
        while (i > 1) {
            if (i == 2) {
                System.out.println(i + " bottles of beer on the wall, " + i + " bottles of beer.");
                i--;
                System.out.println("Take one down and pass it around, " + i + " bottle of beer on the wall.");
            } else {
                System.out.println(i + " bottles of beer on the wall, " + i + " bottles of beer.");
                i--;
                System.out.println("Take one down and pass it around, " + i + " bottles of beer on the wall.");
            } // end if-else
        } // end while

        System.out.println(i + " bottle of beer on the wall, " + i + " bottle of beer.");
        System.out.println("Take one down and pass it around, no more bottles of beer on the wall.");
        System.out.println("No more bottles of beer on the wall, no more bottles of beer.");
        i = 99;
        System.out.println("Go to the store and buy some more, " + i + " bottles of beer on the wall.");

    } // end oppgave1

    static void oppgave2() {

        int[] array = new int[10];

        for (int i = 0; i < 10; i++) {
            array[i] = i;
            System.out.println(array[i]);
        }

    } // end oppgave2

    static void oppgave3() {

        int[] array = new int[10];

        for (int i = 9; i >= 0; i--) {
            array[i] = i;
            System.out.println(array[i]);
        }

    } // end oppgave3

    static void oppgave4() {

        int a = 60;
        int b = 120;
        int hjelp = 0;

        System.out.println("Til å begynne med er:");
        System.out.println("A = " + a);
        System.out.println("B = " + b);
        System.out.println("Hjelpevariabel = " + hjelp + "\n");

        hjelp = a;
        a = b;
        b = hjelp;

        System.out.println("Nå bytter vi plass, og da blir:");
        System.out.println("A = " + a);
        System.out.println("B = " + b);
        System.out.println("Hjelpevariabel = " + hjelp);

    } // end oppgave4

    static void oppgave5() {

        int[] array = new int[10];
        int i;
        int n = 0;

        System.out.println("Til å begynne med har arrayet verdiene:");

        for (i = 2; i <= 1024; i *= 2) {
            array[n] = i;
            System.out.println(array[n]);
            n++;
        } // end for

        System.out.println();

        i = 0;
        n = 9;
        int hjelp = 0;

        System.out.println("Etter plassbytte blir verdiene: ");

        while (i < 10) {
            if (i < 5) {
                hjelp = array[i];
                array[i] = array[n];
                array[n] = hjelp;
                System.out.println(array[i]);
                i++;
                n--;
            } else {
                System.out.println(array[i]);
                i++;
                n--;
            } // end if-else
        } // end while

    } // end oppgave5

    static void oppgave6() {

        int[][] array = new int[4][4];
        Random rnd = new Random();

        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                array[x][y] = rnd.nextInt(100) + 1;
            }
        }

        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                System.out.print(array[x][y] + "\t");
            }
            System.out.println();
        }

    } // end oppgave6

} // end class
