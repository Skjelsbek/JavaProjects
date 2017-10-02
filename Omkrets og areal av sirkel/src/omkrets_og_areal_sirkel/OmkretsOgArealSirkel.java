package omkrets_og_areal_sirkel;

public class OmkretsOgArealSirkel {

    public static void main(String[] args) {
        
        for (int r = 1; r <= 10; r++){            
            System.out.println("Areal med radius " + r + " = " + Math.PI*r*r);
            System.out.println("Omkrets med radius " + r + " = " + (2*Math.PI*r) + "\n");            
        }
    }
    
}
