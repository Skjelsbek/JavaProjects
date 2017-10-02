package switchtest;

import java.util.Scanner;

public class SwitchTest {

    public static void main(String[] args) {
        int x = 0;
        System.out.println("Skriv inn ett tall fra og med 1 til og med 3:");
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
                
        //switch-statement for x
        switch(x){
            // Skriver ut "Heihei!" hvis x = 1
            case 1:
                System.out.println("Heihei!");
                break;
            // Skriver ut "yo!" hvis x = 2    
            case 2:               
                System.out.println("yo!");
                break;
            // Skriver ut "Halla! :D" hvis x = 3    
            case 3:
                System.out.println("Halla! :D");
                break;
            // Hvis ingen over er tilfellet skrives koden under ut. Her er dette tilfellet siden x = 0.    
            default:
                System.out.println("x er verken 1, 2 eller 3");        
        } // End switch
        
    }
    
}
