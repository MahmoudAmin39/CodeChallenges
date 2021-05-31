import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        int nthNumber = Integer.parseInt(input);

        int recursiveApproachOutput = getFibonacciNumberRecursively(nthNumber);
        System.out.println("Recursively: " + recursiveApproachOutput);

        int iterativeApproachOutput = getFibonacciNumberIteratively(nthNumber);
        System.out.println("Iteratively: " + iterativeApproachOutput);
    }

    private static int getFibonacciNumberRecursively(int index) {
        if (index <= 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        } else {
            return getFibonacciFor(index - 1) + getFibonacciFor(index - 2);
        }
    }

    private static final Map<Integer, Integer> fetchedFibonacci = new HashMap<>();

    private static Integer getFibonacciFor(int number) {
        if (fetchedFibonacci.containsKey(number)) {
            return fetchedFibonacci.get(number);
        }
        int result = getFibonacciNumberRecursively(number);
        fetchedFibonacci.put(number, result);
        return result;
    }

    public static int getFibonacciNumberIteratively(int index) {
        int previousPreviousNumber, previousNumber = 0, currentNumber = 1;
        for (int i = 1; i < index; i++) {
            previousPreviousNumber = previousNumber;
            previousNumber = currentNumber;
            currentNumber = previousPreviousNumber + previousNumber;
        }
        return currentNumber;
    }
}
