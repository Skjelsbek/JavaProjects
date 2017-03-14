package binary.tree;

public class App {
    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<>(1);
        
        bt.append(2);
        bt.append(3);
        bt.append(4);
        bt.append(5);
        bt.append(6);
        bt.append(7);
        bt.append(8);
        
        bt.preorderTraverse();
    }
}
