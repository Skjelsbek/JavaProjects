package EnEksamensoppgave;

public class Oddetall {
    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            if (i%2 == 1 && i != 11 && i != 57 && i != 61 && i != 97) {
                System.out.println(i);
            }
        }
    }
}
