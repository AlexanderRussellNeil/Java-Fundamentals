import java.util.Scanner;

public class CalculatorSaQ {
    public static void main(String[] args) {
        Queue q = EvaluatePostfix();

        int size  = q.size();
        for(int i = 0; i < size; i++)
        {
            System.out.print(q.dequeue());
        }
    }

    private static Queue EvaluatePostfix()
    {
        String infix = ReadInfix();

        Stack operators = new Stack(1);
        Queue postfix = new Queue(infix.length()*2);

        for(int i = 0; i < infix.length(); i++)
        {
            char currentChar = infix.charAt(i);

            //System.out.println(currentChar);

            

            if("0123456789".indexOf(currentChar) != -1)
            {
                postfix.enqueue(currentChar);
            }
            else if("^*/+-".indexOf(currentChar) != -1)
            {
                postfix.enqueue(" ");
                if(operators.isEmpty() || hasPowerOver(currentChar, operators.peek()))
                {
                    operators.push(currentChar);
                }
                else if(!hasPowerOver(currentChar, operators.peek()) && !hasPowerOver(operators.peek(), currentChar))
                {
                    postfix.enqueue(operators.pop());
                    operators.push(currentChar);
                    postfix.enqueue(" ");
                }
                else
                {
                    while(!operators.isEmpty() && hasPowerOver(operators.peek(), currentChar))
                    {
                        postfix.enqueue(operators.pop());
                        postfix.enqueue(" ");
                    }
                    operators.push(currentChar);
                }
            }
            else if("(".indexOf(currentChar) != -1)
            {
                operators.push(currentChar);
            }
            else if(")".indexOf(currentChar) != -1)
            {
                while((char)operators.peek() != '(')
                {
                    postfix.enqueue(" ");
                    postfix.enqueue(operators.pop());
                }
                operators.pop();
            }
        }

        while(!operators.isEmpty())
        {
            postfix.enqueue(" ");
            postfix.enqueue(operators.pop());
        }

        return postfix;
    }

    private static boolean hasPowerOver(Object queueOperator, Object infixOperator)
    {
        if (((char) queueOperator == '^') || (((char) queueOperator == '*' || (char) queueOperator == '/') && ((char)infixOperator == '+' || (char)infixOperator == '-')) || ((char)infixOperator == '(' && ((char)queueOperator == '-' || (char)queueOperator == '+' || (char)queueOperator == '*' || (char)queueOperator == '/')))
            return true;
        return false;
    }

    private static String ReadInfix() 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String usrInput = scanner.nextLine().replaceAll("\\s", "");
        int bracketCounter = 0;

        if (!usrInput.matches("[()+\\-^*/0-9]+") || usrInput.startsWith(")")) {
            throw new IllegalArgumentException("Invalid characters in the input.");
        }

        for (int i = 0; i < usrInput.length(); i++) {
            char currentChar = usrInput.charAt(i);
            char nextChar = (i < usrInput.length() - 1) ? usrInput.charAt(i + 1) : '\0';

            if (("+-*^/".indexOf(currentChar) != -1 && "+^-*/)".indexOf(nextChar) != -1) || (nextChar == '+' || nextChar == '*' || nextChar == '/') && currentChar == '(') 
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