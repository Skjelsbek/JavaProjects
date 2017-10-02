package Kont2011;

public class JegElskerSommerferie {
    public static void main(String[] args) {
        String jegElskerSommerferie = "Jeg elsker sommerferie"; // String som inneholder teksten.
        char[] sommerferie = new char[22];  // char array med plass til hele setningen.
        
        // Char arrayet verdier fra stringen så jeg slipper å legge inn hver enkelt bokstav manuelt.
        for (int i = 0; i < sommerferie.length; i++) {
            sommerferie[i] = jegElskerSommerferie.charAt(i);
        }
        
        // Skriver ut bokstaver på plass 1, 5, 7, 8, 11, 13 og 21 i arrayet.
        System.out.println("Med array index:");
        for (int i = 0; i < sommerferie.length; i++) {
            if (i == 1 || i == 5 || i == 7 || i == 8 || i == 11 || i == 13 || i ==21) {
                System.out.println(sommerferie[i]);
            }
        }                
        
        // Skriver ut bokstaver på index 1, 5, 7, 8, 11, 13 og 21 i stringen
        System.out.println("");
        System.out.println("Med string.charAt(index):");
        for (int i = 0; i < jegElskerSommerferie.length(); i++) {
            if (i == 1 || i == 5 || i == 7 || i == 8 || i == 11 || i == 13 || i ==21) {
                System.out.println(jegElskerSommerferie.charAt(i));
            }
        }                
    }
}
