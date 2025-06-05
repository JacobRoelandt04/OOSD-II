// InvalidAccountOperationException.java
package domein.exceptions;

// TODO 2: Create a custom unchecked exception
// This exception should:
// - Extend RuntimeException
// - Have multiple constructors (see theory about 4 constructors pattern)

public class InvalidAccountOperationException extends RuntimeException {

	public InvalidAccountOperationException() {
		super("Sometwhing went wrong with the account");
	}


	public InvalidAccountOperationException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidAccountOperationException(String message) {
		super(message);
	}

	public InvalidAccountOperationException(Throwable cause) {
		super(cause);
	}
	
}