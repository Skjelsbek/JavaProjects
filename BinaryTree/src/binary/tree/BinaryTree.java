package binary.tree;

public class BinaryTree<item> {
    private item data;
    private BinaryTree<item> rightChild;
    private BinaryTree<item> leftChild;
    private int size;
    
    public BinaryTree(item i) {
        data = i;            
        leftChild = null;
        rightChild = null;
        size = 1;
    }
    
    public void append(item i) {
        if (leftChild == null) {
            leftChild = new BinaryTree(i);            
        } else if (rightChild == null) {
            rightChild = new BinaryTree(i);            
        } else if (size < getMid()){
            leftChild.append(i);
        } else {
            rightChild.append(i);
        }
        size++;
    }
    
    public int getMid() {
        int mid = 0;
        Double i = 0.0;
        boolean midFound = false;
        while (!midFound) {
            if ((size + 1) < Math.pow(2.0, i)) {
                mid = (int) ((Math.pow(2.0, i - 1) + Math.pow(2.0, i))/2);
                midFound = true;
            }
            i++;
        }        
        return mid - 1;
    }
    
    public void postTraverse() {
        if (leftChild == null && rightChild == null) {
            System.out.println(data);
            return;
        } else if (leftChild == null){
            rightChild.postTraverse();
            System.out.println(data);
            return;
        } else if (rightChild == null) {
            leftChild.postTraverse();
            System.out.println(data);
            return;
        } 
        leftChild.postTraverse();
        rightChild.postTraverse();
        System.out.println(data);
    }
    
    public void preorderTraverse() {
        System.out.println(data);
        if(leftChild == null && rightChild == null) {            
            return;
        } else if (leftChild == null) {
            rightChild.preorderTraverse();
        } else if (rightChild == null) {
            leftChild.preorderTraverse();
        } else {
            leftChild.preorderTraverse();
            rightChild.preorderTraverse();
        }                
    }
    
    public void inorderTraverse() {        
        if(leftChild == null && rightChild == null) {                        
            return;
        } else if (leftChild == null) {
            rightChild.preorderTraverse();
        } else if (rightChild == null) {
            leftChild.preorderTraverse();
        } else {
            leftChild.preorderTraverse();
            System.out.println(data);
            rightChild.preorderTraverse();
        } 
    }
}  
