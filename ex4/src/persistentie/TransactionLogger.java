// TransactionLogger.java
package persistentie;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionLogger implements AutoCloseable {
    private BufferedWriter writer;
    private static final String LOG_FILE = "transactions.log";
    
    // TODO 7: Implement constructor
    // Should create/open log file for appending
    // Handle IOException appropriately
    public TransactionLogger() {
        // YOUR CODE HERE
    }
    
    // TODO 8: Implement logging method
    // Should write transaction details with timestamp
    // Handle IOException
    public void logTransaction(String accountNumber, String operation, String details) {
        // YOUR CODE HERE
    }
    
    // TODO 9: Implement close method for AutoCloseable
    @Override
    public void close() {
        // YOUR CODE HERE
    }
}