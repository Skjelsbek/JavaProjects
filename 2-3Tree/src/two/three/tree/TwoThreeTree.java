package two.three.tree;

public class TwoThreeTree<T extends Comparable<T>> {

    Node<T> root;

    public TwoThreeTree(T data) {
        this.root = new Node(data);
    }

    void insert(T data) {
        root = root.insert(data);
    }
    
    void infix() {
        if (root == null) {
            System.out.println("The tree is empty");
        } else {
            root.infix();
        }
    }
}
