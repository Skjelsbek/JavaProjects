
package insertion.sort;

public class Bil implements Comparable<Bil> {    
    private int modell;
    
    public Bil(int modell) {
        this.modell = modell;
    }
    
    @Override
    public int compareTo(Bil t) {
        if (this.modell < t.modell) return -1;
        if (this.modell > t.modell) return 1;
        return 0;
    }
    
    @Override
    public String toString() {
        return Integer.toString(modell);
    }
    
}
