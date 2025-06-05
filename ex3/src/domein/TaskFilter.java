// TaskFilter.java
package domein;

@FunctionalInterface
public interface TaskFilter {
    boolean accept(Task task);
}