package oppgaver5;

public class CoinStats {
        
    Coin coin = new Coin();     //Creating an object of the Coin class
    
    // Variables
    public String history = "";     
    public int countHeads = 0;
    public int countTails = 0;
    
    // Using the flip method in the Coin class to flip the coin and send it to the add result method
    public boolean flipCoin() {
        boolean flipped = coin.flip();
        addResult(flipped);
        
        return flipped;
    }
    
    // Returning face from the getFace method in the Coin Class
    public boolean getFace() {
        return coin.getFace();
    }
    
    // Converts the boolean values received from the flipCoin method to letters 
    private void addResult(boolean result) {
        String face = "";
        if (result) {
            face = "H";
            countHeads++;
        } else {
            face = "T";
            countTails++;            
        }
        
        history += face;
    }
    
    public String getHistory() {
        return history;
    }
    
    public int getSequence(String sequence) {        
        int count = 0;
        String seq = "";
        int i = 0;
        while (i < getHistory().length() - sequence.length() + 1) {
            for (int j = i; j < sequence.length() + i; j++) {                
                seq += getHistory().charAt(j);                
            }
            
            if (sequence.equalsIgnoreCase(seq)) {
                count++;
            }
            seq = "";
            i++;
        }
        
        return count;
    }
}
