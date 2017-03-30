package graph;

public class Edge<TKey extends Comparable, TValue> {
    Node<TKey, TValue> reference;   // Refrence to the node wich the edge is attached to
    private byte weight;    // The weight of the edge
    Edge nextEdge;  // The next edge wich originates from the same node
    
    // Constructor which takes a node and a weight in it's parameter and sets its instance variables accordingly
    public Edge(Node node, byte weight) {
        this.reference = node;
        this.weight = weight;
    }
    
    // Inserts the selected edge
    public void insertEdge(Node node, byte weight) {
        if (nextEdge == null) {
            nextEdge = new Edge(node, weight);
        } else {
            nextEdge.insertEdge(node, weight);
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
    
    @Override
    public String toString() {
        if (nextEdge == null) {
            return reference.toString();
        }
        return reference.toString() + nextEdge.toString();
    }
}
