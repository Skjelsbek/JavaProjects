package two.three.tree;

public class TwoThreeTree<T extends Comparable<T>> {

    private Node<T> root;

    public void insert(T data) {
        if (root == null) {
            root = new Node(data);
        } else {
            root = root.insert(data);            
        }
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
