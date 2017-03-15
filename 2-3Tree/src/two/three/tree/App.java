package two.three.tree;

import java.util.Random;

public class App {

    public static void main(String[] args) {
        // Instansierer Random og TwoThreeTree objekter
        Random rnd = new Random();
        TwoThreeTree<Integer> ttt = new TwoThreeTree();
        
        // Tester hva som skjer når jeg prøver å søke og traversere når treet er tomt
        System.out.println(ttt.search(rnd.nextInt(100) + 1));
        ttt.infix();
        
        // Setter inn 10 tilfeldige verdier mellom 1 og 100        
        System.out.println("\nSetter inn i følgende rekkefølge:");
        int tmp;
        for (int i = 0; i < 10; i++) {
            tmp = rnd.nextInt(100) + 1;
            System.out.println(tmp);
            ttt.insert(tmp);
        }
        
        // Traverserer inorder
        System.out.println("\nTraversering: ");
        ttt.infix();
        
        // Søker i treet etter alle tall mellom 1 og 100
        System.out.println("\nSearching:");
        for (int i = 1; i <= 100; i++) {
            System.out.println(ttt.search(i));
        }
    }
}
