package domein;

public interface Trainable {
    void train(String command); // Train the animal
    boolean knowsCommand(String command); // Check if trained
}