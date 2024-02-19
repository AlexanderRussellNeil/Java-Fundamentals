import java.util.InputMismatchException;
import java.util.Scanner;

public class FactorialAndFibonacci 
{
    public static void main(String[] args) 
    {
        int value = -1;
        System.out.println("Hello, User! input a number for evaluating Factorial and Fibonacci");
        try 
        {
            value = ReadIntValue(1, 16);
            System.out.println("Factorial of " + value + " is " + recursiveFactorial(value));
            System.out.println("Fibonacci under position " + value + " is " + recursiveFibonacci(value));
        } 
        catch (ValueOutOfRangeException e) 
        {
            System.out.println(e.getMessage());
        }
    }

    public static int recursiveFactorial(int value) {
        if (value == 0 || value == 1) 
        {
            return 1;
        } 
        else 
        {
            return value * recursiveFactorial(value - 1);
        }
    }

    public static int recursiveFibonacci(int value) {
        if (value == 0) 
        {
            return 0;
        } 
        else if (value == 1) 
        {
            return 1;
        } 
        else 
        {
            return recursiveFibonacci(value - 1) + recursiveFibonacci(value - 2);
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