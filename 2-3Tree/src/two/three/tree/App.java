package two.three.tree;

import java.util.Random;

public class App {

    public static void main(String[] args) {
        Random rnd = new Random();

        TwoThreeTree<Integer> ttt = new TwoThreeTree(rnd.nextInt(100) + 1);      
        
        for (int i = 0; i < 10; i++) {
            ttt.insert(rnd.nextInt(100) + 1);
        }
        System.out.println("\nTraversering: ");
        ttt.infix();
    }
}
