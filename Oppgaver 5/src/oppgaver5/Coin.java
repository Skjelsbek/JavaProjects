package oppgaver5;

import java.util.Random;

public class Coin {         
    private boolean face;
    Random rnd = new Random();
    
    // Giving the face boolean a random value
    public boolean flip() {
        face = rnd.nextBoolean();
        return face;
    }
    
    // Returning the face boolean
    public boolean getFace() {        
        return face;
    }
}
