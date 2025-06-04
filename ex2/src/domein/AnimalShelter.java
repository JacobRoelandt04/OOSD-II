package domein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AnimalShelter {
    private List<Animal> animals;
    
    public AnimalShelter() {
        animals = new ArrayList<>();
    }
    
    // TODO: addAnimal(Animal animal)
    public void addAnimal(Animal animal) {
    	animals.add(animal);
	}
    // TODO: getAllDrawableAnimals() - returns List<Drawable>
    public List<Drawable> getAllDrawableAnimals() {
    	List<Drawable> drawableAnimals = new ArrayList<>();
    	for (Animal animal : animals) {
    		if(animal instanceof Drawable) {
    			drawableAnimals.add((Drawable) animal);
    		}
    	}
    	return drawableAnimals;
	}
    // TODO: getAllTrainableAnimals() - returns List<Trainable>  
    public List<Trainable> getAllTrainableAnimals() {
    	List<Trainable> drawableAnimals = new ArrayList<>();
    	for (Animal animal : animals) {
    		if(animal instanceof Drawable) {
    			drawableAnimals.add((Trainable) animal);
    		}
    	}
    	return drawableAnimals;
	}
    // TODO: sortAnimalsByAge() - use Collections.sort()
    public void sortAnimalsByAge() {
    	animals.sort(null);
	}
    // TODO: sortAnimalsByWeight() - use Comparator
    public void sortAnimalsByWeight() {
    	animals.sort(new WeightComparator());
	}
}