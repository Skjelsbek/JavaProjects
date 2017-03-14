package binary.search.tree;

import java.util.Random;

public class App {
    public static void main(String[] args) {        
        BinarySearchTree<Integer> bst = new BinarySearchTree(); // Lager et objekt av klassen BinarySearchTree som tar inn Integere
        Random rnd = new Random(); // Lager et objekt av Random for å senere kunne gi tilfeldige verdier
        
        // Tester search og delete før jeg har satt noen noder inn i treet
        bst.search(1);
        bst.delete(1);
          
        System.out.println("\nPutter følgende inn i treet:");
        int i = rnd.nextInt(101); // Lagrer en random int mellom 0 og 100 for å kunne skrive den ut før jeg putter den inn i treet
        System.out.print(i + " ");  // Skriver ut den random genererte inten
        bst.insert(i);  // Setter den inn i treet
        i = 22; // Endrer i til et tall jeg vet hva er slik at jeg kan sjekke om søking fungerer som det skal
        // Repeat (Vet jeg skulle gjort det med en for loop)
        System.out.print(i + " ");
        bst.insert(i);
        i = rnd.nextInt(101);
        System.out.print(i + " ");
        bst.insert(i);
        i = rnd.nextInt(101);
        System.out.print(i + " ");
        bst.insert(i);
        i = rnd.nextInt(101);
        System.out.print(i + " ");
        bst.insert(i);
        i = rnd.nextInt(101);
        System.out.print(i + " ");
        bst.insert(i);
                    
        System.out.println("\n\nSkriver ut inorder:");
        bst.infix(); // Skriver ut med inorder traversering
                
        System.out.println("\nSøker etter 22:");
        bst.search(22); // Søker etter 22, og skriver ut resultat

        System.out.println("\nSøker etter 120:");
        bst.search(120); // Søker etter 120, og skriver ut resultat
        
        System.out.println("\nNå som vi vet at 22 finnes sletter vi 22 og skriver ut treet på nytt:");
        bst.delete(22); // Sletter et ønsket tall (i dette tilfellet 22 siden jeg vet det er i treet)
        bst.infix(); // Skriver ut med inorder traversering etter sletting
        
        System.out.println("\nPrøver å slette 120 som jeg vet ikke er i treet:");
        bst.delete(120); // Prøver å slette noe jeg vet ikke er i treet for å se hva som skjer
    }
}
