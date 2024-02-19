import java.util.Scanner;

public class CalculatorSaQ {
    public static void main(String[] args) {
        Stack stack = new Stack(1);
        try {
            Object value = EvaluatePostfix();
        System.out.println("Value " + value);
        }   
        catch (IllegalArgumentException e) 
        {
            System.out.println("Invalid expression: " + e.getMessage());
        }   
        catch (IllegalStateException e) 
        {
            System.out.println("Caught IllegalStateException: " + e.getMessage());
        }
    }

    private static Object EvaluatePostfix()
    {
        String infix = ReadInfix();

        Stack operators = new Stack(1);
        Queue postfix = new Queue(infix.length());

        for(int i = 0; i < usrInput.length(); i++)
        {
            char currentChar = usrInput.charAt(i);

            if("0-9".indexOf(currentChar) != -1)
            {

            }
        }

        return infix;
    }

    private static String ReadInfix() 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String usrInput = scanner.nextLine().replaceAll("\\s", "");
        int bracketCounter = 0;

        if (!usrInput.matches("[()+\\-*/0-9]+") || usrInput.startsWith(")")) {
            throw new IllegalArgumentException("Invalid characters in the input.");
        }

        for (int i = 0; i < usrInput.length(); i++) {
            char currentChar = usrInput.charAt(i);
            char nextChar = (i < usrInput.length() - 1) ? usrInput.charAt(i + 1) : '\0';

            if (("+-*/".indexOf(currentChar) != -1 && "+-*/)".indexOf(nextChar) != -1) || (nextChar == '+' || nextChar == '*' || nextChar == '/') && currentChar == '(') 
            {
                throw new IllegalArgumentException("Two consecutive operators found: " + currentChar + nextChar);
            }

            if (currentChar == '(') {
                bracketCounter++;
            } else if (nextChar == ')') {
                bracketCounter--;
            }
        }

        if (bracketCounter != 0) {
            throw new IllegalArgumentException("Expected additional operator \"(\" or \")\".");
        }

        return usrInput;
    }
}