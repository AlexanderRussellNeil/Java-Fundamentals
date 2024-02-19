import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberConversions {
    public static void main(String[] args) {
        
        int decimalNumber = -1;
        int targetBase = -1;
        try
        {        
            decimalNumber = ReadIntValue(1, 100000);
            targetBase = ReadIntValue(2, 16);

            String result = convertDecimalToBaseRecursive(decimalNumber, targetBase);
            System.out.println("Decimal " + decimalNumber + " in base " + targetBase + ": " + result);
        } 
        catch (ValueOutOfRangeException e) 
        {
            System.out.println(e.getMessage());
        }
    }

    private static String convertDecimalToBaseRecursive(int decimal, int base) {
        if (decimal == 0) {
            return "";
        } else {
            int remainder = decimal % base;
            char digit = getBaseDigit(remainder);
            return convertDecimalToBaseRecursive(decimal / base, base) + digit;
        }
    }

    private static char getBaseDigit(int remainder) {
        if (remainder < 10) {
            return (char) ('0' + remainder);
        } else {
            return (char) ('A' + remainder - 10);
        }
    }

    public static int ReadIntValue(int leftBorder, int rightBorder) throws ValueOutOfRangeException
    {
        Scanner scanner = new Scanner(System.in);
        int value;

        try 
        {
            System.out.print("Enter an integer between " + leftBorder + " and " + rightBorder + ": ");
            value = scanner.nextInt();

            if (value < leftBorder || value > rightBorder) 
            {
                throw new ValueOutOfRangeException("Value out of range. Please enter a value within the specified range.");
            }
            return value;
        } catch (InputMismatchException e) 
        {
            throw new InputMismatchException("Invalid input. Please enter a valid integer.");
        } 
        finally 
        {
            scanner.nextLine();
        }
    }

    public static class ValueOutOfRangeException extends Exception 
    {
        public ValueOutOfRangeException(String message) 
        {
            super(message);
        }
    }
}