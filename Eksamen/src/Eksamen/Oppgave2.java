package Eksamen;

import java.util.Scanner;

public class Oppgave2 {

    public Oppgave2() {
        System.out.println("A:");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println("");
        }
        System.out.println();
        System.out.println("B:");
        int positive = 0;
        int negative = 0;
        int i = 1;
        Scanner sc = new Scanner(System.in);
        
        while (i != 0) {
            System.out.println("Skriv inn ett tall, avslutt med 0:");
            i = sc.nextInt();
            if (i > 0) {
                positive++;
            } else if (i < 0) {
                negative++;
            }
        }
        System.out.println("Negative: " + negative + "\nPositive: " + positive);
    }
}
