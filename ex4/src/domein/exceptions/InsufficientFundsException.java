// InsufficientFundsException.java
package domein.exceptions;

// TODO 1: Create a custom checked exception
// This exception should:
// - Extend Exception
// - Have a constructor that accepts the attempted amount and current balance
// - Override getMessage() to provide a detailed error message
public class InsufficientFundsException extends Exception {

	public InsufficientFundsException() {
		super("You have insufficient Funds");
	}

	public InsufficientFundsException(String message, Throwable cause) {
		super(message, cause);
	}

	public InsufficientFundsException(String message) {
		super(message);
	}

	public InsufficientFundsException(Throwable cause) {
		super(cause);
	}
	
}