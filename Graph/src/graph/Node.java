package graph;

public class Node<TKey extends Comparable<TKey>, TValue> implements Comparable<Node<TKey, TValue>>{
    private TKey key;   // The key which the hash map uses to find the node with the associated data
    private TValue data;    // What we actually wanna store in the node
    private boolean visited = false;    // A variable that determines if the node has been visited before
    private Edge<TKey, TValue> edges;   // A variable which stores all the edges that originates from the node
    private Node<TKey, TValue> nextNode;    // The next node on the same index in the hash map
    
    // Constructor which takes a key and a value in it's parameter and sets its instance variables accordingly
    public Node(TKey key, TValue data) {
        this.key = key;
        this.data = data;
        this. visited = false;
    }
    
    // If there's already a node at the index, we place it further down in the linked list
    public void insertNode(TKey key, TValue data) {
        if (nextNode == null) {
            nextNode = new Node(key, data);
        } else {
            nextNode.insertNode(key, data);
        }
    }
    
    /*
    *   Inserts an edge at the correct place in the linked list of edges.
    *   If there's already a corresponding edge in the linked list, it print's an error message.
    *   The edge created contains both the node it originates from and the one it goes to, aswell as the weight.
    */
    public void insertEdge(Node from, Node to, byte weight) {
        if (this.key == from.getKey()) {
            if (this.edges == null) {
                this.edges = new Edge(from, to, weight);
            } else {
                Edge tmp = new Edge (from, to, weight);
                if (this.edges.equals(tmp)) {
                    System.out.println("There is already an edge between " + from + " and " + to);
                } else {
                    this.edges.insertEdge(from, to, weight);                    
                }
            }
        } else if (nextNode != null) {
            nextNode.insertEdge(from, to, weight);
        } else {
            System.out.println("The key: " + from + ", was not found!");
        }
    }    
    

    // Deletes the selcted node and removes all the edges to it
    public void deleteNode(TKey key) {
        if (nextNode != null) {
            if (nextNode.key == key) {
                if (nextNode.edges != null) {
                    nextNode.edges.deleteEdges(nextNode);
                }
                nextNode = nextNode.nextNode;
                return;
            } else {
                nextNode.deleteNode(key);
                return;
            }
        }
        System.out.println("There's no such key to be found!");
    }
    
    // Deletes a single edge originating from the node
    public void deleteEdge(TKey from, Node to) {
        if (this.key.compareTo(from) == 0) {
            if (edges != null) {
                if (edges.getTo().compareTo(to) == 0) {
                    edges = edges.getNextEdge();
                } else {
                    edges.deleteEdge(to);
                }                
            } else {
                System.out.println("The edge you're trying to delete doesn't seem to exist!");
            }
        } else if (nextNode != null){
            nextNode.deleteEdge(from, to);
        } else {
            System.out.println("The edge you're trying to delete doesn't seem to exist!");
        }
    }
    
    // A get function to get the node containing the matching key
    public Node<TKey, TValue> getNode(TKey key) {
        if (key == this.key) {
            return this;
        }
        if (nextNode != null) {
            return nextNode.getNode(key);
        }
        return null;
    }
    
    public TKey getKey() {
        return this.key;
    }
    
    public TValue getValue() {
        return this.data;
    }
    public Node<TKey, TValue> getNextNode() {
        return this.nextNode;
    }
    
    public Edge getEdges() {
        return this.edges;
    }
    
    // Overloads the getEdges-function above and it returns a string insted of the edges linked list
    public String getEdges(TKey key) {
        if (key == this.key) {
            if (this.edges != null) {
                return this.edges.toString();                
            } else {
                return "";
            }
        } else if (nextNode != null) {
            nextNode.getEdges(key);
        }
        return "";
    }
    
    // Sets the visited boolean true
    public void setVisited(boolean b) {
        if (b) {
            this.visited = true;            
        } else {
            this.visited = false;
        }
    }
    
    // Checks if the node is already visited
    public boolean isVisited() {
        return this.visited;
    }
    
    // Sets the visited variable of all the nodes in the linked list to false
    public void resetVisited() {
        setVisited(false);
        
        if (this.nextNode == null) {
            return;
        }
        
        nextNode.resetVisited();
    }
    
    // toString-function which returns the data variable
    @Override
    public String toString() {
        return data.toString();
    }
    
    // Used to determine which edge that should be removed
    @Override
    public int compareTo(Node<TKey, TValue> n) {
        return this.key.compareTo(n.key);
    }
}
