// TaskTransformer.java
package domein;

@FunctionalInterface
public interface TaskTransformer<R> {
    R transform(Task task);
}