package domein;

public class Motor extends Voertuig{
	private int cilinderinhoud;
	
	public Motor(String merk, int bouwjaar, double prijs, int cilinderinhoud) {
		super(merk, bouwjaar, prijs);
		this.cilinderinhoud = cilinderinhoud;
	}


	@Override
	public double berekenBelasting() {
		return this.cilinderinhoud * 0.15;
	}

	@Override
	String getVoertuigType() {
		return getClass().getSimpleName();
	}
	
}
