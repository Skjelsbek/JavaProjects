package hashmap;

public class App {
    public static void main(String[] args) {
        Hashmap<Integer, String> hm = new Hashmap(8);
        
        String[] array = {"Jon", "Martin", "Nils", "Marius", "Vegard", "Vegar", "Espen", "Lars", "Olav", "Jens"};
        for (int i = 0; i < 10; i++) {
            hm.insert(i, array[i]);
        }
        System.out.println(hm);
        hm.delete(0);        
        System.out.println(hm);
        hm.delete(9);        
        System.out.println(hm);
    }
}
