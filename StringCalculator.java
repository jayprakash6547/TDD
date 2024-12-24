import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        String numString = numbers;

        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf('\n');
            delimiter = numbers.substring(2, delimiterIndex);
            numString = numbers.substring(delimiterIndex + 1);
        }

        String[] tokens = numString.split(delimiter);
        List<Integer> negatives = new ArrayList<>();
        int sum = 0;

        for (String token : tokens) {
            int number = Integer.parseInt(token.trim());
            if (number < 0) {
                negatives.add(number);
            }
            sum += number;
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negatives);
        }

        return sum;
    }

    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter input for the String Calculator (leave empty to test empty string):");
        String input = scanner.nextLine();

        try {
            int result = calculator.add(input);
            System.out.println("Output: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        scanner.close();
    }
}
