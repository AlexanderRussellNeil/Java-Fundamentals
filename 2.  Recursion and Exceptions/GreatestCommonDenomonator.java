import java.util.InputMismatchException;
import java.util.Scanner;

public class GreatestCommonDenomonator 
{
    public static void main(String[] args) 
    {
        int value1 = -1;
        int value2 = -1;

        try 
        {        
            value1 = ReadIntValue(1, 100);
            value2 = ReadIntValue(1, 100);
        } 
        catch (ValueOutOfRangeException e) 
        {
            System.out.println(e.getMessage());
        }

        System.out.println(recursiveGCD(value1,value2));
    }


    public static int recursiveGCD(int a, int b) 
    {
        if (b == 0) 
        {
            return a;
        } 
        else 
        {
            return recursiveGCD(b, a % b);
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