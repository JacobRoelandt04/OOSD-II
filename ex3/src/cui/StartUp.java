// StartUp.java
package cui;

import domein.*;
import java.time.LocalDate;
import java.util.*;

public class StartUp {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        
        System.out.println("=== All Tasks ===");
        manager.displayTasks();
        
        // TODO 5: Use lambda expressions to:
        // a) Filter only high-priority tasks (priority >= 4)
        System.out.println("\n=== High Priority Tasks ===");
        System.out.println(manager.filterTasks(task -> task.getPriority() >= 4));
        
        // TODO 6: Use lambda expressions to:
        // b) Filter only incomplete tasks
        System.out.println("\n=== Incomplete Tasks ===");
        System.out.println(manager.filterTasks(task -> task.isCompleted()));
        
        // TODO 7: Use lambda expressions to:
        // c) Filter tasks due within 3 days
        System.out.println("\n=== Tasks Due Soon ===");
        System.out.println(manager.filterTasks(task -> task.getDueDate().minusDays(3).isBefore(LocalDate.now())));
        
        // TODO 8: Use lambda expression to:
        // Mark all high-priority incomplete tasks as urgent (print "URGENT: " before title)
        System.out.println("\n=== Processing Urgent Tasks ===");
        manager.processTasks(task -> {
        	if(task.getPriority() >=4) {
        		System.out.printf("URGENT: %s%n", task.toString());
        	}
        });
        
        // TODO 9: Use lambda expression to:
        // Extract all task titles to a list
        System.out.println("\n=== Task Titles ===");
        manager.processTasks(task -> {
        	List<String> titles = new ArrayList<>();
        	titles.add(task.getTitle());
        	System.out.println(titles);
        });
        
        // TODO 10: Sort tasks by due date using lambda
        System.out.println("\n=== Tasks Sorted by Due Date ===");
        manager.sortTasks((task1, task2) -> task1.getDueDate().compareTo(task2.getDueDate()));
        for(Task task : manager.getTasks())
        	System.out.println(task);
        
        // TODO 11: Sort tasks by priority (highest first), then by due date
        System.out.println("\n=== Tasks Sorted by Priority then Due Date ===");
        manager.sortTasks(
        		Comparator.comparingInt(Task::getPriority).reversed()
        					.thenComparing(Task::getDueDate));
        for(Task task : manager.getTasks())
        	System.out.println(task);
        
        // TODO 12: Create a static method in this class that prints a task
        // Then use method reference instead of lambda
        System.out.println("\n=== Using Method Reference ===");
        manager.getTasks().forEach(StartUp::PrintTask);
    }
    
    // TODO 12: Create static method here for method reference
    private static void PrintTask(Task task) {
    	System.out.println(task);
    }
}
