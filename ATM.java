import java.util.Scanner;

public class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int option = getValidInput();

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }

    private void checkBalance() {
        System.out.println("Current balance: $" + bankAccount.getBalance());
    }

    private void deposit() {
        System.out.print("Enter deposit amount: ");
        double amount = getValidAmount();
        bankAccount.deposit(amount);
        System.out.println("Deposited $" + amount);
    }

    private void withdraw() {
        System.out.print("Enter withdrawal amount: ");
        double amount = getValidAmount();
        if (bankAccount.withdraw(amount)) {
            System.out.println("Withdrew $" + amount);
        }
    }

    private double getValidAmount() {
        while (true) {
            try {
                double amount = scanner.nextDouble();
                if (amount <= 0) {
                    System.out.println("Amount must be positive. Please try again.");
                } else {
                    return amount;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private int getValidInput() {
        while (true) {
            try {
                int option = scanner.nextInt();
                return option;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }
}
