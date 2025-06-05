// TaskProcessor.java
package domein;

@FunctionalInterface
public interface TaskProcessor {
    void process(Task task);
}