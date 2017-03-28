package graph;

public class Edge<TKey, TValue> {
    Node<TKey, TValue> edge;
    Edge nextEdge;
    
    public Edge(Node node) {
        this.edge = node;
    }
    
    public void insertEdge(Node node) {
        if (nextEdge == null) {
            nextEdge = new Edge(node);
        } else {
            nextEdge.insertEdge(node);
        }
    }

    public void deleteEdges(TKey key) {
        deleteEdge(key);
        if (nextEdge != null) {
            nextEdge.deleteEdges(key);
        }         
    }
    
    private Edge deleteEdge(TKey key) {
        if (edge.edges.edge.key.equals(key)) {
            return edge.edges.nextEdge;
            
        } else if (edge.edges.nextEdge != null) {
            nextEdge.deleteEdge(key);
        }
    }
}
