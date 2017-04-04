package graph;

public class App {

    public static void main(String[] args) {
        Graph<String, String> graph = new Graph(6);    // Creating a new graph with a string as key and value just to make it easy to visualize
        
        // Adding nodes from A - F, also with keys A - F
        String[] array = {"A", "B", "C", "D", "E", "F"};
        for (int i = 0; i < 6; i++) {
            graph.insertNode(array[i], array[i]);
        }
        
        // Inserting some edges (TO, FROM, WEIGHT)
        graph.insertEdge("A", "B", (byte) 3);
        graph.insertEdge("A", "E", (byte) 3);
        graph.insertEdge("A", "F", (byte) 4);
        graph.insertEdge("B", "C", (byte) 2);
        graph.insertEdge("C", "E", (byte) 2);
        graph.insertEdge("C", "D", (byte) 1);
        graph.insertEdge("D", "F", (byte) 1);
        graph.insertEdge("D", "E", (byte) 4);
        graph.insertEdge("E", "F", (byte) 5);
       
        // Prints the graph before using prim's algorithm
        System.out.println("Graph:");
        System.out.println(graph);
        
        // Using prim's algorithm to generate minimal spanning tree, then print it
        System.out.println("Generate MST from node A in graph");
        System.out.println("Some error messages because i have edges both ways between two nodes...");
        Graph hm2 = graph.prim("A");
        System.out.println("\nMinimal spanning tree from A:");
        System.out.println(hm2);
        
        // Proving that resetVisited works
        System.out.println("Generating another MST from the same node in graph to prove that resetVisited-function works");
        System.out.println("Some error messages because i have edges both ways between two nodes...");
        Graph hm3 = graph.prim("A");
        System.out.println("\nMinimal spanning tree from A:");
        System.out.println(hm3);                        
    }
}
