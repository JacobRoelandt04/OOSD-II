package domein;

public abstract class Animal implements Comparable<Animal> {
    protected String naam;
    protected int leeftijd;
    protected double gewicht;
    
    public Animal(String naam, int leeftijd, double gewicht) {
        this.naam = naam;
        this.leeftijd = leeftijd;
        this.gewicht = gewicht;
    }
    
    // TODO: Implement getters
    public String getNaam() {
		return naam;
	}
    
    public int getLeeftijd() {
		return leeftijd;
	}
    
    public double getGewicht() {
		return gewicht;
	}
    // TODO: Implement compareTo (natural ordering by age)
    @Override
    public int compareTo(Animal a) {
    	return this.leeftijd == a.leeftijd? 0 : this.leeftijd > a.leeftijd ? 1 : -1;
    }
    
    // TODO: Abstract method: makeSound()
    abstract public void makeSound();
}
