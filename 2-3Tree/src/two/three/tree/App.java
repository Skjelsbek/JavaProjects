package two.three.tree;

import java.util.Random;

public class App {

    public static void main(String[] args) {
        // Nødvendige objekter
        Random rnd = new Random();
        TwoThreeTree<Integer> ttt = new TwoThreeTree();
        
        // Tester hva som skjer når jeg prøver å søke og traversere når treet er tomt
        System.out.println(ttt.search(rnd.nextInt(100) + 1));
        ttt.infix();
        
        // Setter inn 10 tilfeldige verdier mellom 1 og 100
        for (int i = 0; i < 10; i++) {
            ttt.insert(rnd.nextInt(100) + 1);
        }
        
        // Traverserer
        System.out.println("\nTraversering: ");
        ttt.infix();
        
        // Søker etter alle tall mellom 1 og 100
        // Det er ett tilfelle hvor det ikke funker som det skal!
        System.out.println("\nSearching:");
        for (int i = 1; i <= 100; i++) {
            System.out.println(ttt.search(i));
        }
    }
}
