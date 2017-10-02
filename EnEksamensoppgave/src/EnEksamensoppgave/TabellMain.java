package EnEksamensoppgave;

public class TabellMain {
    public static void main(String[] args) {
        Tabell tabell1 = new Tabell();
        System.out.println("Array før sortering:");
        for (int i = 0; i < tabell1.array.length; i++) {
            System.out.println(tabell1.array[i]);            
        }
        System.out.println("Array etter sortering: ");
        tabell1.sorterArray();
        for (int i = 0; i < tabell1.array.length; i++) {
            System.out.println(tabell1.array[i]);            
        }
    }
}
