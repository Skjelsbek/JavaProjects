package graph;

public class Graph {

    public static void main(String[] args) {
        Hashmap<String, String> hm = new Hashmap(8);

        String[] array = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        for (int i = 0; i < 10; i++) {
            hm.insertNode(array[i], array[i]);
        }
        
        hm.insertEdge("A", "B", (byte) 2);
        hm.insertEdge("A", "D", (byte) 3);
        hm.insertEdge("A", "E", (byte) 1);
        hm.insertEdge("B", "J", (byte) 4);
        hm.insertEdge("B", "C", (byte) 2);
        hm.insertEdge("B", "E", (byte) 2);
        hm.insertEdge("C", "J", (byte) 3);
        hm.insertEdge("C", "F", (byte) 5);
        hm.insertEdge("D", "G", (byte) 4);
        hm.insertEdge("E", "G", (byte) 1);
        hm.insertEdge("E", "F", (byte) 3);
        hm.insertEdge("E", "H", (byte) 4);
        hm.insertEdge("F", "H", (byte) 3);
        hm.insertEdge("G", "I", (byte) 2);
        hm.insertEdge("H", "I", (byte) 1);
        
        System.out.println(hm);        
    }
}
