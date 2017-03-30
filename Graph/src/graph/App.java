package graph;

public class App {

    public static void main(String[] args) {
        Hashmap<Integer, String> hm = new Hashmap(8);

        String[] array = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        for (int i = 0; i < 10; i++) {
            hm.insertNode(i, array[i]);
        }
        hm.insertEdge(0, 10, (byte) 3);
        System.out.println(hm);
        //hm.deleteNode(0);        
        //System.out.println(hm);
        System.out.println(hm.getEdges(0));
        //hm.deleteNode(9);
        //System.out.println(hm);
        hm.insertEdge(1, 8, (byte)4);
        hm.deleteEdge(1, 8);
    }
}
