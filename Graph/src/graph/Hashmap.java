package graph;

public class Hashmap<TKey extends Comparable, TValue> {
    private Node<TKey, TValue>[] array; // Array to store linkedlist of nodes
    
    // Constructor which decides the size of the array
    public Hashmap(int size) {
        array = new Node[size];
    }
    
    // Inserts a node in the hash map
    public void insertNode(TKey key, TValue data) {
        int arrayIndex = getIndex(key);
        if (array[arrayIndex] == null) {
            array[arrayIndex] = new Node(key, data);
        } else {
            array[arrayIndex].insertNode(key, data);
        }
    }
    
    // Takes two keys(from and to) and the weight of the edge, and inserts the edge at the correct place with the correct weight
    public void insertEdge(TKey from, TKey to, byte weight) {
        int toIndex = getIndex(to);
        int fromIndex = getIndex(from);
        
        if (array[toIndex] == null || array[fromIndex] == null) {
            System.out.println("One of the keys you specified doesn't appear to exist!");            
        } else {
            Node fromNode = getNode(from);
            Node toNode = getNode(to);
            array[fromIndex].insertEdge(from, toNode, weight);
            array[toIndex].insertEdge(to, fromNode, weight);
        }
    }      
    
    // Deletes the passed node, and also removes all the edges linked to it
    public void deleteNode(TKey key) {
        int arrayIndex = getIndex(key);
        if (array[arrayIndex] != null) {
            if (array[arrayIndex].key == key) {
                if (array[arrayIndex].edges != null) {
                    array[arrayIndex].edges.deleteEdges(array[arrayIndex]);
                }
                array[arrayIndex] = array[arrayIndex].nextNode;
                return;
            } else if (array[arrayIndex].nextNode != null) {
                array[arrayIndex].deleteNode(key);
                return;
            }
        } 
        System.out.println("There's no such key to be found!");
    }
    
    // Deletes a single edge
    public void deleteEdge(TKey from, TKey to) {
        int fromIndex = getIndex(from);
        int toIndex = getIndex(to);
        
        if (array[toIndex] == null || array[fromIndex] == null) {
            System.out.println("One of the keys you specified doesn't appear to exist!");            
        } else {
            Node fromNode = getNode(from);
            Node toNode = getNode(to);
            array[fromIndex].deleteEdge(from, toNode);
            array[toIndex].deleteEdge(to, fromNode);
        }             
    }
    
    // Get-function returns a nodes data
    public TValue getValue(TKey key) {
        int arrayIndex = getIndex(key);
        if (array[arrayIndex] != null) {
            return array[arrayIndex].getNode(key).data;
        }
        return null;
    }
    
    // Get-function returning the whole node
    private Node<TKey, TValue> getNode(TKey key) {
        int arrayIndex = getIndex(key);
        if (array[arrayIndex] != null) {
            return array[arrayIndex].getNode(key);
        }
        return null;
    }
    
    public String getEdges(TKey key) {
        int arrayIndex = getIndex(key);
        if (array[arrayIndex] != null) {
            return array[arrayIndex].getEdges(key);
        }
        return "There is no such node!";
    }
    
    // Returns the index of the array where the node should be placed
    private int getIndex(TKey key) {
        return (Math.abs(key.hashCode()) % array.length);
    }
    
    // toString-function which returns a string containing data from all the linked lists in the array
    @Override
    public String toString() {
        String s = "Hashmap:\n";
        for(int i=0; i<array.length; i++){
            if (array[i] != null){
                s += i + ": " + array[i].toString();
            }
            s += (s.charAt(s.length()-1) == '\n')?"":"\n";
        }
        return s;
    }
}
