package domein;

import java.util.Comparator;

public class WeightComparator implements Comparator<Animal>{

	@Override
	public int compare(Animal a1, Animal a2) {
		return a1.gewicht == a2.gewicht? 0 : a1.gewicht > a2.gewicht? 1 : -1;
	}

}
