package bytteplass;

public class ByttePlass {

    public static void main(String[] args) {       
        //Opprette variabler
        int a = 5;
        int b = 10;
        int help = 0;
        
        // Skrive ut resultatet
        System.out.println("A = " + a);        
        System.out.println("B = " + b);
        System.out.println("Hjelpevariabelen = " + help + "\n");        
        
        // Bytte plass på variablenes verdi    
        help = a;
        a = b;
        b = help;
        
        // Skrive ut resultat
        System.out.println("Vi bytter plass!");
        System.out.println("A = " + a);        
        System.out.println("B = " + b);
        System.out.println("Hjelpevariabelen = " + help);
    }
    
}
