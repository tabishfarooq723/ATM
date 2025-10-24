import java.util.Scanner;

public class ATM {
    private static final int PREDEFINED_PIN = 1234;   // Correct PIN
    private static int balance = 0;                   // Account balance
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int attempts = 3;

        while (attempts > 0) {
            int pin = readInt("Enter PIN: ");

            if (pin == PREDEFINED_PIN) {
                System.out.println("Login successful!");
                showMenu();
                return; // end program after exit
            } else {
                attempts--;
                System.out.println("Wrong PIN! Attempts left: " + attempts);
            }
        }

        System.out.println("Account locked due to too many failed attempts.");
    }

    // ===== Menu =====
    private static void showMenu() {
        while (true) {
            System.out.println("\n==== ATM Menu ====");
            System.out.println("1) Deposit");
            System.out.println("2) Withdraw");
            System.out.println("3) Check Balance");
            System.out.println("4) Exit");

            int choice = readInt("Choice: ");

            switch (choice) {
                case 1: deposit(); break;
                case 2: withdraw(); break;
                case 3: checkBalance(); break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return; // exit loop & program
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }

    // ===== Operations =====
    private static void deposit() {
        int amount = readInt("Enter amount to deposit: ");
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid amount! Must be greater than 0.");
        }
    }

    private static void withdraw() {
        int amount = readInt("Enter amount to withdraw: ");
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid amount! Must be greater than 0.");
        }
    }

    private static void checkBalance() {
        System.out.println("Your balance is: " + balance);
    }

    // ===== Input Validation Method =====
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // clear wrong input
            }
        }
    }
}
