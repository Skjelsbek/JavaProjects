package two.three.tree;

public class TwoThreeTree<T extends Comparable<T>> {

    private Node<T> root;

    public TwoThreeTree(T data) {
        this.root = new Node(data);
    }

    public void insert(T data) {
        root = root.insert(data);
    }

    public String search(T data) {
        if (root == null) {
            return "The tree is empty!";
        }
        if (root.search(data) == true) {
            return data.toString() + " found.";
        }
        return data.toString() + " not found!";
    }

    public void infix() {
        if (root == null) {
            System.out.println("The tree is empty");
        } else {
            root.infix();
        }
    }
}
