package graph;

public class Edge<TKey extends Comparable<TKey>, TValue> implements Comparable<Edge<TKey, TValue>>{
    private Node<TKey, TValue> from; // Refrence to the node wich the edge goes from 
    private Node<TKey, TValue> to;   // Refrence to the node wich the edge goes to
    private byte weight;    // The weight of the edge
    private Edge nextEdge;  // The next edge wich originates from the same node
    
    // Constructor which takes a node and a weight in it's parameter and sets its instance variables accordingly
    public Edge(Node from, Node to, byte weight) {
        this.to = to;
        this.from = from;
        this.weight = weight;
    }
    
    // Inserts the selected edge
    public void insertEdge(Node<TKey, TValue> from, Node<TKey, TValue> to, byte weight) {
        if (nextEdge == null) {
            nextEdge = new Edge(from, to, weight);
        } else {
            Edge tmp = new Edge(from, to, weight);
            if (nextEdge.equals(tmp)) {
                System.out.println("There is already an edge between " + from + " and " + to);
            } else {
                nextEdge.insertEdge(from, to, weight);                
            }
        }
    }
    
    // Delete single edge
    public void deleteEdge(Node n) {
        if (nextEdge != null) {            
            if (nextEdge.to.compareTo(n) == 0) {
                nextEdge = nextEdge.nextEdge;
            } else {
                nextEdge.deleteEdge(n);
            }
        } else {
            System.out.println("The edge you're trying to delete doesn't seem to exist!");
        }
    }
    
    // Delete all the edges attached to the node to be deleted
    public void deleteEdges(Node n) {
        this.to.deleteEdge(to.getKey(), n);
        if (nextEdge != null) {
            nextEdge.deleteEdges(n);
        }        
    }
    
    public Node<TKey, TValue> getTo() {
        return this.to;
    }
    
    public Node<TKey, TValue> getFrom() {
        return this.from;
    }
    
    public byte getWeight() {
        return this.weight;
    }
    
    public Edge getNextEdge() {
        return this.nextEdge;
    }
    
    public boolean equals(Edge e) {
        if (this.to.compareTo(e.to) == 0) {
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        if (nextEdge == null) {
            return to.toString();
        }
        return to.toString() + ", " + nextEdge.toString();
    }

    @Override
    public int compareTo(Edge<TKey, TValue> e) {
        if (this.weight < e.weight) {
            return -1;
        }
        if (this.weight > e.weight) {
            return 1;
        }
        return 0;
    }
}
