// BankingApp.java
package ui;

import domein.*;
import domein.exceptions.*;
import java.math.BigDecimal;
import java.util.Scanner;

public class BankingApp {
    private BankService bankService;
    private Scanner scanner;
    
    public BankingApp() {
        this.bankService = new BankService();
        this.scanner = new Scanner(System.in);
    }
    
    public void start() {
        initializeSampleAccounts();
        
        boolean running = true;
        while (running) {
            displayMenu();
            
            // TODO 13: Implement robust menu input handling
            // Handle InputMismatchException for invalid menu choices
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                
                switch (choice) {
                    case 1 -> createNewAccount();
                    case 2 -> performWithdrawal();
                    case 3 -> performDeposit();
                    case 4 -> performTransfer();
                    case 5 -> bankService.displayAllAccounts();
                    case 6 -> running = false;
                    default -> System.out.println("Invalid option!");
                }
            } catch (Exception e) {
                // YOUR CODE HERE - handle appropriately
            }
        }
    }
    
    private void displayMenu() {
        System.out.println("\n=== Bank Account Management ===");
        System.out.println("1. Create New Account");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Transfer Money");
        System.out.println("5. Display All Accounts");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }
    
    // TODO 14: Implement createNewAccount with full exception handling
    private void createNewAccount() {
        // YOUR CODE HERE
        // Get input from user and handle all possible exceptions
    }
    
    // TODO 15: Implement other operations with appropriate exception handling
    private void performWithdrawal() {
        // YOUR CODE HERE
    }
    
    private void performDeposit() {
        // YOUR CODE HERE
    }
    
    private void performTransfer() {
        // YOUR CODE HERE
    }
    
    private void initializeSampleAccounts() {
        try {
            bankService.createAccount("1234567890", "John Doe", new BigDecimal("1000.00"));
            bankService.createAccount("0987654321", "Jane Smith", new BigDecimal("2500.00"));
            bankService.createAccount("1111111111", "Test User", new BigDecimal("50.00"));
        } catch (Exception e) {
            System.err.println("Error initializing sample accounts: " + e.getMessage());
        }
    }
}