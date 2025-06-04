package cui;

import java.util.ArrayList;
import java.util.List;

import domein.*;

public class Main {
	public static void main(String[] args) {
		AnimalShelter shelter = new AnimalShelter();
		
		shelter.addAnimal(new Cat("Olaf", 13, 7));
		shelter.addAnimal(new Cat("Basil", 6, 4));
		shelter.addAnimal(new Dog("Doggo1", 4, 13));
		shelter.addAnimal(new Dog("Doggo2", 14, 16));
		
		for (AnimalShelter animal : shelter) {
			animal.makeSound();
			if (animal instanceof Drawable)
				((Drawable) animal).draw();
			if (animal instanceof Trainable)
				((Trainable) animal).train("Sit");
		}
	}
}
