import java.util.Scanner;

public class CalculatorSaQ {
    public static void main(String[] args) {
        
        Queue postfixQueue = evaluatePostfix();

        int queueSize = postfixQueue.size();
        System.out.print("Postfix expression: ");
        for (int i = 0; i < queueSize; i++) {
            System.out.print(postfixQueue.dequeue());
        }
    }

    private static Queue evaluatePostfix() {
        String infixExpression = readInfix();

        Stack operatorsStack = new Stack(1);
        Queue postfixQueue = new Queue(infixExpression.length() * 2);

        for (int i = 0; i < infixExpression.length(); i++) {
            char currentChar = infixExpression.charAt(i);

            if ("0123456789".indexOf(currentChar) != -1) {
                postfixQueue.enqueue(currentChar);
            } else if ("^*/+-".indexOf(currentChar) != -1) {
                processOperator(currentChar, operatorsStack, postfixQueue);
            } else if ("(".indexOf(currentChar) != -1) {
                operatorsStack.push(currentChar);
            } else if (")".indexOf(currentChar) != -1) {
                processClosingParenthesis(operatorsStack, postfixQueue);
            }
        }

        while (!operatorsStack.isEmpty()) {
            postfixQueue.enqueue(" ");
            postfixQueue.enqueue(operatorsStack.pop());
        }

        return postfixQueue;
    }

    private static void processOperator(char currentChar, Stack operatorsStack, Queue postfixQueue) {
        postfixQueue.enqueue(" ");
        if (operatorsStack.isEmpty() || hasPowerOver(currentChar, operatorsStack.peek())) {
            operatorsStack.push(currentChar);
        } else if (!hasPowerOver(currentChar, operatorsStack.peek()) && !hasPowerOver(operatorsStack.peek(), currentChar)) {
            postfixQueue.enqueue(operatorsStack.pop());
            operatorsStack.push(currentChar);
            postfixQueue.enqueue(" ");
        } else {
            while (!operatorsStack.isEmpty() && hasPowerOver(operatorsStack.peek(), currentChar)) {
                postfixQueue.enqueue(operatorsStack.pop());
                postfixQueue.enqueue(" ");
            }
            operatorsStack.push(currentChar);
        }
    }

    private static boolean hasPowerOver(Object queueOperator, Object infixOperator) {
        return ((char) queueOperator == '^') || (((char) queueOperator == '*' || (char) queueOperator == '/') && ((char) infixOperator == '+' || (char) infixOperator == '-'))
                || ((char) infixOperator == '(' && ((char) queueOperator == '-' || (char) queueOperator == '+' || (char) queueOperator == '*' || (char) queueOperator == '/'));
    }

    private static void processClosingParenthesis(Stack operatorsStack, Queue postfixQueue) {
        while ((char) operatorsStack.peek() != '(') {
            postfixQueue.enqueue(" ");
            postfixQueue.enqueue(operatorsStack.pop());
        }
        operatorsStack.pop();
    }

    private static String readInfix() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine().replaceAll("\\s", "");
        validateInput(userInput);
        return userInput;
    }

    private static void validateInput(String userInput) {
        int bracketCounter = 0;

        if (!userInput.matches("[()+\\-^*/0-9]+") || userInput.startsWith(")")) {
            throw new IllegalArgumentException("Invalid characters in the input.");
        }

        for (int i = 0; i < userInput.length(); i++) {
            char currentChar = userInput.charAt(i);
            char nextChar = (i < userInput.length() - 1) ? userInput.charAt(i + 1) : '\0';

            if (("+-*^/".indexOf(currentChar) != -1 && "+^-*/)".indexOf(nextChar) != -1) ||
                    (nextChar == '+' || nextChar == '*' || nextChar == '/') && currentChar == '(') {
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
    }
}
