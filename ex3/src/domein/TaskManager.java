// TaskManager.java
package domein;

import java.time.LocalDate;
import java.util.*;

public class TaskManager {
    private List<Task> tasks;
    
    public TaskManager() {
        this.tasks = new ArrayList<>();
        initializeSampleTasks();
    }
    
    private void initializeSampleTasks() {
        tasks.add(new Task("Complete Java assignment", "Finish lambda exercises", 5, LocalDate.now().plusDays(2)));
        tasks.add(new Task("Buy groceries", "Milk, bread, eggs", 2, LocalDate.now().plusDays(1)));
        tasks.add(new Task("Call dentist", "Schedule appointment", 3, LocalDate.now().plusDays(7)));
        tasks.add(new Task("Prepare presentation", "Q4 results", 4, LocalDate.now().plusDays(3)));
        tasks.add(new Task("Water plants", "Living room and balcony", 1, LocalDate.now()));
        
        // Mark some as completed
        tasks.get(4).setCompleted(true);
    }
    
    // TODO 1: Implement using lambda expression
    // Filter tasks based on a custom condition
    public List<Task> filterTasks(TaskFilter filter) {
        List<Task> filtered = new ArrayList<>();
        for (Task task : tasks) {
            if (filter.accept(task)) {  // The filter parameter is the lambda expression
                filtered.add(task);
            }
        }
        return filtered;
    }
    
    // TODO 2: Implement using lambda expression
    // Process each task with a custom action
    public void processTasks(TaskProcessor processor) {
        for (Task task : tasks) {
        	processor.process(task);
        }
    }
    
    // TODO 3: Implement using lambda expression
    // Transform tasks to another type (e.g., extract specific information)
    public <R> List<R> transformTasks(TaskTransformer<R> transformer) {
        List<R> results = new ArrayList<>();
        for (Task task : tasks) {
        	R transformed = transformer.transform(task);
        	results.add(transformed);
        }
        return results;
    }
    
    // TODO 4: Implement using Comparator with lambda
    // Sort tasks using a custom comparator
    public void sortTasks(Comparator<Task> comparator) {
        Collections.sort(tasks, comparator);
    }
    
    // Helper method to display all tasks
    public void displayTasks() {
        tasks.forEach(System.out::println);
    }
    
    // Helper method to get tasks copy
    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }
}