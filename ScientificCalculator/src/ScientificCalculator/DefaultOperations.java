package ScientificCalculator;

import java.awt.Toolkit;

public class DefaultOperations {
    private static double answer;
    
    // Legger sammen parametrene
    protected static double add(double number1, double number2) {
        answer = number1 + number2;
        return answer;
    }
    
    // Trekker den andre parameteren fra den første
    protected static double subtract(double number1, double number2) {
        answer = number1 - number2;
        return answer;
    }
    
    // Ganger parametrene
    protected static double multiply(double number1, double number2) {
        answer = number1 * number2;
        return answer;
    }
    
    // Deler den første parameteren på den andre
    protected static double devide(double number1, double number2) {
        answer = number1 / number2;
        return answer;
    }
    
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
