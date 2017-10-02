package oppgaver.pkg4;

import java.util.Scanner;

public class Oppgaver4 {

    public static void main(String[] args) {

        System.out.println("Oppgave 1:");
        oppgave1();
        System.out.println();

        System.out.println("Oppgave 2:");
        oppgave2();
        System.out.println();

        System.out.println("Oppgave 3:");
        oppgave3();
        System.out.println();

        System.out.println("Oppgave 4:");        
        System.out.println(helloWorld());   // Skriver ut fra helloWorld metoden
        System.out.println();

        System.out.println("Oppgave 5:");
        //Lager et array som metoden skal reversere
        int[] tabell = new int[4];
        for (int i = 0; i < tabell.length; i++){
            tabell[i] = i + 1;
        } // End for
        
        // Skriver ut arrayet før reversering
        System.out.println("Arrayet før reversering:");
        for (int i = 0; i < tabell.length; i++){
            System.out.println(tabell[i]);
        } // End for
        
        // Reverserer arrayet med metoden
        reverseArray(tabell);
        
        // Skriver ut arrayet etter reversering
        System.out.println("Arrayet etter reversering:");
        for (int i = 0; i < tabell.length; i++){
            System.out.println(reverseArray(tabell)[i]);
        } // End for

    } // End main
    
    static void oppgave1() {
        // Setter maks verdi
        int max = 100;

        // For-loop som gir x verdier mellom 1 og 100
        for (int x = 2; x < max; x++) {
            boolean prime = true;           // Setter boolean prime = true

            // Sjekker om tallet x er delelig på tall som ikke er seg selv eller 1
            for (int y = 2; y < x; y++) {
                if (x % y == 0) {           // Setter boolean prime = false hvis det er delelig på noe annet
                    prime = false;
                } // End if             
            } // End for

            // Skriver ut tallet hvis prime = true, og tallet ikke er 29, 59 og 61
            if ((prime == true) && (x != 29) && (x != 59) && (x != 61)) {
                System.out.println(x);
            } // End if
        } // End for

    } // End oppgave1

    static void oppgave2() {
        // Lager scanner og variabler
        Scanner scan = new Scanner(System.in);
        String string1;
        String string2;

        // Scanner inn
        System.out.println("Skriv et ord:");
        string1 = scan.nextLine();
        System.out.println("Skriv et ord til:");
        string2 = scan.nextLine();

        // Skriver ut om string1 ligger alfabetisk før eller etter string2
        System.out.println(string1.compareTo(string2));

    } // End oppgave2

    static void oppgave3() {
        // Lager scanner og variabler
        Scanner scan = new Scanner(System.in);
        int arrayStørrelse;

        // Lar brukeren velge størrelsen på arrayet
        System.out.println("Skriv inn størrelsen du ønsker på arrayet:");
        arrayStørrelse = scan.nextInt();
        scan.nextLine();
        String[] array = new String[arrayStørrelse];

        for (int i = 0; i < arrayStørrelse; i++) {
            System.out.println("Skriv inn teksten du ønsker i plass " + i + " i arrayet:");
            array[i] = scan.nextLine();
        }

        System.out.println("Arrayets rekkefølge før sortering:");

        for (int i = 0; i < arrayStørrelse; i++) {
            System.out.println(array[i]);
        }

        // bubbleSort
        String hjelp;
        for (int i = arrayStørrelse - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    hjelp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = hjelp;                    
                } // End if
            } // End for
        } // End for
        
        System.out.println("Arrayets rekkefølge etter sortering:");

        for (int i = 0; i < arrayStørrelse; i++) {
            System.out.println(array[i]);
        }

    } // End oppgave3
    
    // Oppgave 4
    public static String helloWorld() {
        return "Hello World!";
    } // End helloWorld

    // Oppgave 5    
    public static int[] reverseArray(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }             
        return reversed;
    } // End oppgave5

} // End class