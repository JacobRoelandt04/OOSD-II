package domein;

public class Cat extends Animal implements Drawable {

	// TODO: Implement required methods
	public Cat(String naam, int leeftijd, double gewicht) {
		super(naam, leeftijd, gewicht);
	}
    // TODO: Cats are not trainable!
	@Override
	public void draw() {
		System.out.println("🐱");
	}

	@Override
	public void makeSound() {
		System.out.print("meow");
	}
}
