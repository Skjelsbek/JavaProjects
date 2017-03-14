package string.math.working.incomplete.version;

public class StringMathWorkingIncompleteVersion {

    public static void main(String[] args) {
        System.out.println(algorithm("2(-2+2*2--2)/2")); // Testing the algorithm.                    
    } // End main

    private static String algorithm(String calculation) {
        StringBuilder sb1 = new StringBuilder();  // Instantiate StringBuilder as sb1          
        sb1.append(calculation);    // Stores String parameter in StringBuilder sb1                

        // Checks if the string contains parentheses
        if (sb1.toString().contains("(")) {
            byte parenthesisCounter = 0;  // Creating a counter we're gonna use so that we know how many parentheses we need to dissolve 

            // Countes number of parentheses in sb1
            for (int i = 0; i < sb1.length(); i++) {
                // Checks if the character at index i = '('
                if (sb1.charAt(i) == '(') {
                    parenthesisCounter++;   // Increment parenthesisCounter by 1
                }
            }

            for (int i = 0; i < parenthesisCounter; i++) {
                sb1 = parenthesis(sb1);
            }
        }
        sb1.replace(0, sb1.length(), nestedAlgorithm(sb1.toString()));
        return sb1.toString();
    } // End algorithm method

    private static String nestedAlgorithm(String calculation) {
        StringBuilder sb1 = new StringBuilder();  // Instantiate StringBuilder as sb1  
        sb1.append(calculation);     // Stores String parameter in StringBuilder sb1        

        // Checking if there are any operators in the parameter string at all, and does the following code if it is
        if (sb1.toString().contains("*") || sb1.toString().contains("/") || sb1.toString().contains("+") || sb1.toString().contains("-")) {
            byte operationCounter = 0;  // Creating a counter we're gonna use so that we know how many operations we're gonna do                      

            // Counts number of operations, and stores the number in operationCounter variable
            for (int i = 0; i < sb1.length(); i++) {
                if (sb1.charAt(i) == '*' || sb1.charAt(i) == '/' || sb1.charAt(i) == '+' || sb1.charAt(i) == '-') {
                    if (i != 0 && (!(sb1.charAt(i - 1) == '*' || sb1.charAt(i - 1) == '/' || sb1.charAt(i - 1) == '+' || sb1.charAt(i - 1) == '-'))) {
                        operationCounter++;
                    }
                }
            }

            // Runs as many times as we have operations so that we're able to do all of them separately
            for (int n = 0; n < operationCounter; n++) {
                // Checks if sb1 contains '*' or '/', if it don't it does the operations for '+' and '-'
                if (sb1.toString().contains("*") || sb1.toString().contains("/")) {
                    sb1 = multiplicationAndDivision(sb1); // Replaces what's in sb1 with the outcome from putting sb1 into the multiplication/division algorithm                    
                } else {
                    sb1 = plusAndMinus(sb1);    // Replaces what's in sb1 with the outcome from putting sb1 into the plus/minus algorithm
                } // End if-else
            }   // End outer for-loop            
        } // End outer if
        return sb1.toString(); // Returning what's left in sb1, wich should be the answer. If the parameter string had no operator this is the exact same
    } // End nestedAlgorithm method

    private static StringBuilder plusAndMinus(StringBuilder sb1) {
        StringBuilder sb2 = new StringBuilder(); // Instantiate StringBuilder as sb2
        char operator = '0';  // char for storing mathematical operator, the initialisation is just so that we don't get an error. It will get updated later!
        double[] array = new double[3]; // Array for storing factors and sum
        byte leftCounter = 0;   // byte for storing the size of left factor
        byte rightCounter = 0;  // byte for storing the size of right factor
        byte operatorIndex = 0; // byte for storing the index of the operator

        // Runs through sb1
        for (int i = 0; i < sb1.length(); i++) {
            // Checks if the character in sb1 at index i is equal to either '+' or '-', and runs the following code if thats true
            if (i != 0 && (sb1.charAt(i) == '+' || sb1.charAt(i) == '-')) {
                operator = sb1.charAt(i); // Stores the operator in the variable operator so we know if we're gonna add or subtract the factors later
                operatorIndex = (byte) i; // Stores the index of the operator as a byte in operatorIndex

                // Runs through sb1 from the index before i, to it finds another operator or the index get to 0
                for (int j = i - 1; j >= 0; j--) {
                    // Checks if it runs into another operator; does operation based on conditions
                    if (!(sb1.charAt(j) == '+' || sb1.charAt(j) == '-' || sb1.charAt(j) == '*' || sb1.charAt(j) == '/')) {
                        leftCounter++; // Increment the leftCounter by 1 for each letter in the left factor
                        sb2.append(sb1.charAt(j)); // Adds the character at index j in sb1 to sb2. Since the loop counts down and not up, sb2 will end up backwards
                    } else if ((j == 0 && sb1.charAt(j) == '-') || ((j != 0) && (sb1.charAt(j) == '-') && (sb1.charAt(j - 1) == '*' || sb1.charAt(j - 1) == '/' || sb1.charAt(j - 1) == '+' || sb1.charAt(j - 1) == '-'))) {
                        leftCounter++;
                        sb2.append(sb1.charAt(j));
                    } else {
                        break;  // Breaks out of the inner for-loop when it gets to an operator
                    }   // End if-else            
                }   // End for-loop

                sb2.reverse(); // Since it's backwards we need to reverse it to make the factor back to the original
                array[0] = Double.parseDouble(sb2.toString()); // Now that sb2 contains the first factor, we can place it in the double array to store it as a double
                sb2.delete(0, sb2.length()); // Clearing sb2 now that we've stored the value, so that we can use it for the second factor aswell

                // Runs through sb1 from the index after i to it finds another operator or it gets to the last index
                for (int j = i + 1; j < sb1.length(); j++) {
                    // Checks if it runs into another operator; does operation based on conditions
                    if (!(sb1.charAt(j) == '+' || sb1.charAt(j) == '-' || sb1.charAt(j) == '*' || sb1.charAt(j) == '/')) {
                        rightCounter++; // Increment the rightCounter by 1 for each letter in the right factor
                        sb2.append(sb1.charAt(j));  // Adds the character at index j in sb1 to sb2. Since the loop counts up this time, sb2 will end up just as the original factor
                    } else if (j == i + 1 && sb1.charAt(j) == '-') {
                        rightCounter++;
                        sb2.append(sb1.charAt(j));
                    } else {
                        break;  // Breaks out of the inner for-loop when it gets to an operator
                    }   // End if-else                
                }   // End for-loop

                array[1] = Double.parseDouble(sb2.toString());    // Now that sb2 contains the second factor, we can place it in the double array to store it as a double                                
                break;  // Breaks out of the outer for-loop when it's done storing both factors
            } // End if
        } // End for-loop

        // Checks the collected operator
        if (operator == '+') {
            array[2] = array[0] + array[1]; // Adds array[0] and array[1], and stores the answer in array[2]
        } else if (operator == '-') {
            array[2] = array[0] - array[1]; // Subtract Array[0] by array[1], and stores the answer in array[2]            
        } // End if-else

        // Replaces the original expression with the answer and returns the edited StringBuilder
        sb1.replace(operatorIndex - leftCounter, operatorIndex + rightCounter + 1, Double.toString(array[2]));
        return sb1;
    } // End plusAndMinus method

    private static StringBuilder multiplicationAndDivision(StringBuilder sb1) {
        StringBuilder sb2 = new StringBuilder(); // Instantiate StringBuilder as sb2
        char operator = '0';  // char for storing mathematical operator
        double[] array = new double[3]; // Array for storing factors and sum
        byte leftCounter = 0;   // byte for storing the size of left factor
        byte rightCounter = 0;  // byte for storing the size of right factor
        byte operatorIndex = 0; // byte for storing the index of the operator

        // Runs through sb1
        for (int i = 0; i < sb1.length(); i++) {
            // Checks if the character in sb1 at index i is equal to either '*' or '/', and runs the following code if thats true
            if (sb1.charAt(i) == '*' || sb1.charAt(i) == '/') {
                operator = sb1.charAt(i); // Stores the operator in the variable operator so we know if we're gonna divide or multiply the two gathered number later
                operatorIndex = (byte) i; // Stores the index of the operator as a byte in operatorIndex

                // Runs through sb1 from the index before i, to it finds another operator or the index get to 0
                for (int j = i - 1; j >= 0; j--) {
                    // Checks if it runs into another operator; does operation based on conditions
                    if (!(sb1.charAt(j) == '+' || sb1.charAt(j) == '-' || sb1.charAt(j) == '*' || sb1.charAt(j) == '/')) {
                        leftCounter++; // Increment the leftCounter by 1 for each letter in the left factor
                        sb2.append(sb1.charAt(j)); // Adds the character at index j in sb1 to sb2. Since the loop counts down and not up, sb2 will end up backwards
                    } else if ((j == 0 && sb1.charAt(j) == '-') || ((j != 0) && (sb1.charAt(j) == '-') && (sb1.charAt(j - 1) == '*' || sb1.charAt(j - 1) == '/' || sb1.charAt(j - 1) == '+' || sb1.charAt(j - 1) == '-'))) {
                        leftCounter++;
                        sb2.append(sb1.charAt(j));
                    } else {
                        break;  // Breaks out of the inner for-loop when it gets to an operator
                    } // End if-else                
                } // End for-loop

                sb2.reverse(); // Since it's backwards we need to reverse it to make the factor back to the original                
                array[0] = Double.parseDouble(sb2.toString()); // Now that sb2 contains the first factor, we can place it in the double array to store it as a double                        
                sb2.delete(0, sb2.length()); // Clearing sb2 now that we've stored the value, so that we can use it for the second factor aswell                

                // Runs through sb1 from the index after i to it finds another operator, or it gets to the last index
                for (int j = i + 1; j < sb1.length(); j++) {
                    // Checks if it runs into another operator; does operation based on conditions
                    if (!(sb1.charAt(j) == '+' || sb1.charAt(j) == '-' || sb1.charAt(j) == '*' || sb1.charAt(j) == '/')) {
                        rightCounter++; // Increment the rightCounter by 1 for each letter in the right factor
                        sb2.append(sb1.charAt(j));  // Adds the character at index j in sb1 to sb2. Since the loop counts up this time, sb2 will end up just as the original factor
                    } else if (j == i + 1 && sb1.charAt(j) == '-') {
                        rightCounter++;
                        sb2.append(sb1.charAt(j));
                    } else {
                        break;  // Breaks out of the inner for-loop when it gets to an operator
                    }   // End if-else                  
                }   // End for-loop

                array[1] = Double.parseDouble(sb2.toString());    // Now that sb2 contains the second factor, we can place it in the double array to store it as a double                                                                     
                break;  // Breaks out of the outer for-loop when it's done storing both factors
            }   // End if
        } // End for

        // Checks the collected operator
        if (operator == '*') {
            array[2] = array[0] * array[1]; // Multiplies array[0] and array[1], and stores the answer in array[2]
        } else if (operator == '/') {
            array[2] = array[0] / array[1]; //Divides Array[0] by array[1], and stores the answer in array[2]            
        }   // End if-else

        // Replaces the original expression with the answer and returns the edited StringBuilder
        sb1.replace(operatorIndex - leftCounter, operatorIndex + rightCounter + 1, Double.toString(array[2]));
        return sb1;
    } // End multiplicationAndDivision method

    private static StringBuilder parenthesis(StringBuilder sb1) {
        StringBuilder sb2 = new StringBuilder(); // Instantiate StringBuilder as sb2                                
        byte openingParenthesisIndex = 0; // byte for storing the index of the opening parenthesis
        byte closingParenthesisIndex = 0; // byte for storing the index of the closing parenthesis

        // Runs through sb1
        for (int i = 0; i < sb1.length(); i++) {
            // Checks if the char at index i = '(', and does the following code if it is
            if (sb1.charAt(i) == '(') {
                openingParenthesisIndex = (byte) i; // Sets the variable openingParenthesisIndex equal to the index of the opening parenthesis in sb1

                // Runs through the content of the parentheses
                for (int j = i + 1; j < sb1.length(); j++) {
                    // Checks if the char at index j in sb1 is not equal to ')'
                    if (sb1.charAt(j) != ')') {
                        sb2.append(sb1.charAt(j)); // Adds the content of the parentheses to sb2 char by char
                    } else {
                        closingParenthesisIndex = (byte) j; // Sets the variable closingParenthesisIndex equal to the index of the closing parenthesis in sb1
                        break;  // Breaks out of the for-loop when it runs into the closing parenthesis
                    } // End if-else
                } // End for-loop
                break; // Breaks out of the outer for-loop
            }   // End if
        }   // End outer for-loop

        boolean multiplicationOperatorAdded = false;    // boolean for checking if it has been added a miltiplication operator with default false

        // Checks if the parentheses has no operators before or after, adds multiplication operator to the side(s) that don't already have one
        if (Character.isDigit(sb1.charAt(openingParenthesisIndex - 1)) && Character.isDigit(sb1.charAt(closingParenthesisIndex + 1))) {
            // Replaces what's inside the parentheses with the answer to the expression inside with a multiplication operator both at the start and the end
            sb1.replace(openingParenthesisIndex, closingParenthesisIndex + 1, "*" + nestedAlgorithm(sb2.toString()) + "*");
            multiplicationOperatorAdded = true;
        } else if (Character.isDigit(sb1.charAt(openingParenthesisIndex - 1))) {
            // Replaces what's inside the parentheses with the answer to the expression inside with a multiplication operator at the start
            sb1.replace(openingParenthesisIndex, closingParenthesisIndex + 1, "*" + nestedAlgorithm(sb2.toString()));
            multiplicationOperatorAdded = true;
        } else if (Character.isDigit(sb1.charAt(closingParenthesisIndex + 1))) {
            // Replaces what's inside the parentheses with the answer to the expression inside with a multiplication operator at the end
            sb1.replace(openingParenthesisIndex, closingParenthesisIndex + 1, nestedAlgorithm(sb2.toString()) + "*");
            multiplicationOperatorAdded = true;
        } // End if-else

        // Checks if the multiplicationOperatorAdded boolean is true
        if (multiplicationOperatorAdded) {
            return sb1; // If multiplicationOperationAdded is true the parenthesis is already calculated so we just need to return it
        } else {
            // Replaces the parentheses and it's content with the answer to the expression inside if no multiplication operator has been added
            sb1.replace(openingParenthesisIndex, closingParenthesisIndex + 1, nestedAlgorithm(sb2.toString()));
            return sb1;
        } // End if-else
    } // End parenthesis method
}
