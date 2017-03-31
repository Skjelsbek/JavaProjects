package graph;

public class Edge<TKey extends Comparable<TKey>, TValue> implements Comparable<Edge<TKey, TValue>>{
    Node<TKey, TValue> reference;   // Refrence to the node wich the edge is attached to
    private byte weight;    // The weight of the edge
    Edge nextEdge;  // The next edge wich originates from the same node
    
    // Constructor which takes a node and a weight in it's parameter and sets its instance variables accordingly
    public Edge(Node node, byte weight) {
        this.reference = node;
        this.weight = weight;
    }
    
    // Inserts the selected edge
    public void insertEdge(Node<TKey, TValue> from, Node<TKey, TValue> to, byte weight) {
        if (nextEdge == null) {
            nextEdge = new Edge(to, weight);
        } else {
            Edge tmp = new Edge(to, weight);
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
            if (nextEdge.reference.compareTo(n) == 0) {
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
        this.reference.deleteEdge(reference.key, n);
        if (nextEdge != null) {
            nextEdge.deleteEdges(n);
        }        
    }
    
    public Node<TKey, TValue> getRefrence() {
        return this.reference;
    }
    
    public byte getWeight() {
        return this.weight;
    }
    public boolean equals(Edge e) {
        if (this.reference.compareTo(e.reference) == 0) {
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        if (nextEdge == null) {
            return reference.toString();
        }
        return reference.toString() + ", " + nextEdge.toString();
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
