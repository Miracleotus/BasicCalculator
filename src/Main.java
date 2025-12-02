import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;
            while (!exit) {
                printMenu();
                System.out.print("Choose an option (1-5): ");
                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1":
                    case "2":
                    case "3":
                    case "4":
                        double a = readDouble(scanner, "Enter first number: ");
                        double b = readDouble(scanner, "Enter second number: ");
                        performOperation(choice, a, b);
                        break;

                    case "5":
                        exit = true;
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter 1-5.");
                }
                System.out.println();
            }
        } catch (Exception e) {

            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    private static void printMenu() {
        System.out.println("=== Simple Calculator ===");
        System.out.println("1) Add");
        System.out.println("2) Subtract");
        System.out.println("3) Multiply");
        System.out.println("4) Divide");
        System.out.println("5) Exit");
    }


    private static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("That's not a valid number. Please try again.");
            }
        }
    }

    private static void performOperation(String choice, double a, double b) {
        try {
            double result;
            switch (choice) {
                case "1":
                    result = Calculator.add(a, b);
                    System.out.printf("Result: %.10g%n", result);
                    break;
                case "2":
                    result = Calculator.subtract(a, b);
                    System.out.printf("Result: %.10g%n", result);
                    break;
                case "3":
                    result = Calculator.multiply(a, b);
                    System.out.printf("Result: %.10g%n", result);
                    break;
                case "4":
                    result = Calculator.divide(a, b); // may throw IllegalArgumentException
                    System.out.printf("Result: %.10g%n", result);
                    break;
                default:
                    System.out.println("Unknown operation.");
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
