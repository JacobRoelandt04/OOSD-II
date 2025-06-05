// BankService.java
package domein;

import domein.exceptions.*;
import persistentie.TransactionLogger;
import java.math.BigDecimal;
import java.util.*;

public class BankService {
    private Map<String, BankAccount> accounts;
    
    public BankService() {
        this.accounts = new HashMap<>();
    }
    
    // TODO 10: Implement createAccount with proper exception handling
    // Should validate inputs and handle exceptions from BankAccount constructor
    // Log the account creation
    public void createAccount(String accountNumber, String accountHolder, BigDecimal initialBalance) {
    	try {
			accounts.put(accountNumber, new BankAccount(accountNumber, accountHolder, initialBalance));
		} catch (InsufficientFundsException e) {
			e.printStackTrace();
		}
    }
    
    // TODO 11: Implement processTransaction with try-with-resources
    // Use TransactionLogger with try-with-resources
    // Handle all possible exceptions and log transactions
    public void processTransaction(String accountNumber, String operation, BigDecimal amount) {
        // YOUR CODE HERE
    }
    
    // TODO 12: Implement transferMoney with exception chaining
    // Should handle transfer between accounts
    // If anything goes wrong, throw a new exception with the original as cause
    public void transferMoney(String fromAccount, String toAccount, BigDecimal amount) {
        // YOUR CODE HERE
    }
    
    public BankAccount getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
    
    public void displayAllAccounts() {
        accounts.values().forEach(System.out::println);
    }
}