package graph;

public class Node <TKey, TValue>{
    TKey key;
    TValue data;
    Node<TKey, TValue> nextNode;
    
    public Node (TKey key, TValue data) {
        this.key = key;
        this.data = data;
    }
    
    public void insert(TKey key, TValue data) {
        if (nextNode == null) {
            nextNode = new Node(key, data);
        } else {
            nextNode.insert(key, data);
        }
    }
    
    public Node<TKey, TValue> get(TKey key) {
        if (key == this.key) {
            return this;
        }
        if (nextNode != null) {
           return nextNode.get(key);
        }
        return null;
    } 

    public void delete(TKey key) {
        if (nextNode != null) {
            if (nextNode.key == key) {
                nextNode = null;
            } else {
                nextNode.delete(key);
            }          
        } else if (nextNode == null) {
            System.out.println("There's no such key to be found!");
        }
    }
    
    @Override
    public String toString() {
        if (nextNode == null){
            return data.toString();
        }
        return data.toString() + " , " + nextNode.toString();
    }
    
}
