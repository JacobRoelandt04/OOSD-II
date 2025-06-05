// BankAccount.java
package domein;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.swing.text.html.MinimalHTMLWriter;

import domein.exceptions.*;

public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private BigDecimal balance;
    private boolean isActive;
    private static final BigDecimal MINIMUM_BALANCE = new BigDecimal("10.00");
    private static final BigDecimal MAXIMUM_WITHDRAWAL = new BigDecimal("5000.00");
    
    public BankAccount(String accountNumber, String accountHolder, BigDecimal initialBalance) throws InsufficientFundsException {
        // TODO 3: Validate inputs and throw appropriate exceptions
        // - accountNumber must be exactly 10 digits
        // - accountHolder must not be null or empty
        // - initialBalance must be at least MINIMUM_BALANCE
        if(accountNumber.length() != 10) {
        	throw new InvalidAccountOperationException("Invalid account number length, must be 10 characters");
        } else {
        	this.accountNumber = accountNumber;        	
        }
        
        if(accountHolder == null || accountHolder.isBlank()) {
        	throw new InvalidAccountOperationException("Please specify an account holder");
        } else {
        	this.accountHolder = accountHolder;
        }
        
        if(initialBalance.compareTo(MINIMUM_BALANCE) == -1) {
        	throw new InsufficientFundsException("Invalid balance");
        } else {        	
        	this.balance = initialBalance;
        }
        
        this.isActive = true;
    }
    
    // TODO 4: Implement withdraw method
    // Should throw:
    // - InsufficientFundsException if balance would go below MINIMUM_BALANCE
    // - InvalidAccountOperationException if account is not active
    // - IllegalArgumentException if amount is negative or exceeds MAXIMUM_WITHDRAWAL
    public void withdraw(BigDecimal amount) throws InsufficientFundsException {
    	if(!isActive()) {
    		throw new InvalidAccountOperationException("Account is inactive");
    	}
    	
    	if(this.balance.subtract(amount).compareTo(BigDecimal.ZERO) == -1) {
    		throw new InsufficientFundsException("Not enough funds");
    	}
    	
    	if(amount.compareTo(MAXIMUM_WITHDRAWAL) == 1 || amount.compareTo(BigDecimal.ZERO) == -1) {
    		throw new IllegalArgumentException("Invalid amount to withdraw");
    	}
    	
    	this.balance.subtract(amount);
    }
    
    // TODO 5: Implement deposit method
    // Should throw:
    // - InvalidAccountOperationException if account is not active
    // - IllegalArgumentException if amount is negative or zero
    public void deposit(BigDecimal amount) {
    	if(!isActive()) {
    		throw new InvalidAccountOperationException("Account is inactive");
    	}
    	
    	if(amount.compareTo(MAXIMUM_WITHDRAWAL) == 1 || amount.compareTo(BigDecimal.ZERO) == -1) {
    		throw new IllegalArgumentException("Invalid amount to withdraw");
    	}
    	
    	this.balance.add(amount);
    }
    
    // TODO 6: Implement transfer method
    // Should handle all exceptions from withdraw and deposit
    // If withdraw succeeds but deposit fails, should reverse the withdrawal
    public void transfer(BigDecimal amount, BankAccount targetAccount) throws InsufficientFundsException {
    	try {
    		this.withdraw(amount);
		} catch (InvalidAccountOperationException|InsufficientFundsException|IllegalArgumentException e) {
			//idk what to do here??
		}
    	
    	try {			
    		targetAccount.deposit(amount);			
		} catch (InvalidAccountOperationException|IllegalArgumentException e) {
			this.deposit(amount);
		}
    }
    
    public void deactivate() {
        this.isActive = false;
    }
    
    public BigDecimal getBalance() {
        return balance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public boolean isActive() {
        return isActive;
    }
    
    @Override
    public String toString() {
        return String.format("Account %s (%s): €%.2f %s", 
            accountNumber, accountHolder, balance, isActive ? "" : "[INACTIVE]");
    }
}