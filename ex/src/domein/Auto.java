package domein;

public class Auto extends Voertuig{
	private int aantalDeuren;
	
	public Auto(String merk, int bouwjaar, double prijs, int aantalDeuren) {
		super(merk, bouwjaar, prijs);
		this.aantalDeuren = aantalDeuren;
	}

	@Override
	public double berekenBelasting() {
		return super.getBouwjaar() >= 2020 ? super.prijs * 0.05 : super.prijs * 0.03;
	}

	@Override
	String getVoertuigType() {
		return getClass().getSimpleName();
	}
}
