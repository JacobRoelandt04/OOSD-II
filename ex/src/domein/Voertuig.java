package domein;

import java.util.Objects;

abstract public class Voertuig {
	private String merk;
	private int bouwjaar;
	protected double prijs;
	
	public Voertuig(String merk, int bouwjaar, double prijs) {
		this.merk = merk;
		this.bouwjaar = bouwjaar;
		this.prijs = prijs;
	}
	
	public int getBouwjaar() {
		return this.bouwjaar;
	}
	
	abstract double berekenBelasting();
	
	abstract String getVoertuigType();
	
	@Override
	public String toString() {
		return getVoertuigType() + ": " + this.merk + "(" + getBouwjaar() + ") - €" + this.prijs;
	}
	
	@Override
	public boolean equals(Object obj) {
		Voertuig voertuig = (Voertuig) obj;
		if(this.merk != voertuig.merk)
			return false;
		if(getBouwjaar() != voertuig.getBouwjaar())
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.merk, getBouwjaar());
	}
}

