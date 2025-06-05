// Task.java
package domein;

import java.time.LocalDate;

public class Task {
    private String title;
    private String description;
    private int priority; // 1-5, where 5 is highest
    private LocalDate dueDate;
    private boolean completed;
    
    public Task(String title, String description, int priority, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        setPriority(priority);
        this.dueDate = dueDate;
        this.completed = false;
    }
    
    // Getters and Setters
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getPriority() { return priority; }
    public LocalDate getDueDate() { return dueDate; }
    public boolean isCompleted() { return completed; }
    
    public void setCompleted(boolean completed) { 
        this.completed = completed; 
    }
    
    private void setPriority(int priority) {
        if (priority < 1 || priority > 5) {
            throw new IllegalArgumentException("Priority must be between 1 and 5");
        }
        this.priority = priority;
    }
    
    @Override
    public String toString() {
        return String.format("Task: %s (Priority: %d, Due: %s, %s)", 
            title, priority, dueDate, completed ? "COMPLETED" : "PENDING");
    }
}