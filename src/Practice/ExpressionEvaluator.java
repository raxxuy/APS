package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ExpressionEvaluator {

    public static int evaluateExpression(String expression) {
        String[] parts = expression.split("[+]");
        int result = 0;

        for (String part : parts) {
            if (part.contains("*")) result += multiply(part);
            else result += Integer.parseInt(part);
        }

        return result;
    }

    public static int multiply(String expression) {
        String[] numbers = expression.split("[*]");

        int result = Integer.parseInt(numbers[0]);

        for (int i = 1; i < numbers.length; i++) {
            result *= Integer.parseInt(numbers[i]);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }
}