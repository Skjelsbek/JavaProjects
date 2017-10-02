package arithmetic_calculator;

import java.awt.Toolkit;

public class DefaultOperations {
    public static int uiSizeDivider() {
        int divider = 1;        
        int originalWidth = 3840;
        Double scrSizeWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int collectedWidth = scrSizeWidth.intValue();        
        if (collectedWidth < originalWidth) {
            divider = originalWidth / collectedWidth;          
        }
        return divider;
    }
}
