package domein;

import java.util.ArrayList;
import java.util.List;

public class Dog extends Animal implements Drawable, Trainable {

	// TODO: Keep track of known commands in a List<String>
	private List<String> knownCommands;
	
	public Dog(String naam, int leeftijd, double gewicht) {
		super(naam, leeftijd, gewicht);
		knownCommands = new ArrayList<>();
	}
	
    // TODO: Implement all required methods
	@Override
	public void train(String command) {
		knownCommands.add(command);
	}

	@Override
	public boolean knowsCommand(String command) {
		return knownCommands.contains(command);
	}

	@Override
	public void draw() {
		System.out.println("🐕");
	}

	@Override
	public void makeSound() {
		System.out.println("bark");
	}
}