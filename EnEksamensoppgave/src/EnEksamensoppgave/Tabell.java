package EnEksamensoppgave;

import java.util.Random;

public class Tabell {
    public int[] array = new int[25];
    Random rnd = new Random();
    
    public Tabell() {
        for (int i = 0; i < 25; i++) {
            array[i] = rnd.nextInt(100) + 1;
        }        
    }
    
    public void sorterArray() {
        int hjelp;
        for (int i = this.array.length - 1; i > 0; i--){
            for (int j = 0; j < i; j++) {
                if (this.array[j] > this.array[j + 1]) {
                    hjelp = this.array[j];
                    this.array[j] = this.array[j + 1];
                    this.array[j + 1] = hjelp;
                }
            }
        }
    }
}
