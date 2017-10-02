package Bank;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public abstract class InnholdSjekk {

    public static boolean bokstaver(String tekst) {
        for (int i = 0; i < tekst.length(); i++) {
            if (!((Character.isSpace(tekst.charAt(i))) || (Character.isLetter(tekst.charAt(i))))) {
                return false;
            }
        }
        return true;
    }

    public static boolean tall(String tekst) {
        for (int i = 0; i < tekst.length(); i++) {
            if (!((tekst.charAt(i) == KeyEvent.VK_PERIOD) || (Character.isDigit(tekst.charAt(i))))) {
                return false;
            }
        }
        return true;
    }

    public static boolean antallPunktum(String tekst) {
        int punktumCount = 0;
        for (int i = 0; i < tekst.length(); i++) {
            if (tekst.charAt(i) == KeyEvent.VK_PERIOD) {
                punktumCount++;
            }
        }
        if (punktumCount <= 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean pin(String tekst) {
        for (int i = 0; i < tekst.length(); i++) {
            if (!Character.isDigit(tekst.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    public static int multiplier(){
        int multiplier;
        Double scrSizeWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int collectedWidth = scrSizeWidth.intValue();
        int refrenceWidth = 1920;
        if (collectedWidth/refrenceWidth > 1){
            multiplier = collectedWidth/refrenceWidth;
        } else {
            multiplier = 1;
        }
        return multiplier;
    }
}
