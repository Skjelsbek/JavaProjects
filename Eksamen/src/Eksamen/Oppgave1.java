package Eksamen;

public class Oppgave1 {
    public Oppgave1() {
        System.out.println("A:");
        System.out.println("Svaret på");
        System.out.print(" oppgaven er: ");
        System.out.println((24 + 7 * 3) / (17 - 2 * 4));
        System.out.println("");
        System.out.println("B:");
        System.out.println("Med for-loop:");
        System.out.println("Radius\tOmkrest\tAraeal");
        
        for (int i = 1; i < 10; i++) {
            System.out.println(i + " " + (2*Math.PI*i) + " " + (Math.PI *i * i));
        }
        
        System.out.println("");
        System.out.println("Med while-loop:");
        int i = 1;
        System.out.println("Radius\tOmkrest\tAraeal");
        while (i < 10) {
            System.out.println(i + " " + (2*Math.PI*i) + " " + (Math.PI *i * i));
            i++;
        }
    }
}
