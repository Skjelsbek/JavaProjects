package tall_i_synkede_rekkefølge;

public class TallISynkendeRekkefølge {
    
    public static void main(String[] args) {        
        long Start = 0;                  // Start variabel
        long Multiplier = 10;            // Multiplier variabel
        
        for (int x = 1; x <= 10; x++) {
            System.out.println(Start);
            Start += x * Multiplier;
            Multiplier *= 10;            
        }
    }

}
