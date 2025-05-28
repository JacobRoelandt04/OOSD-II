package dto;

import domein.Kost;
import domein.Ticket;
import domein.VerplaatsingPerAuto;
import domein.VerplaatsingPerBusTram;

public record KostDTO(char soort, String van, String naar, boolean bus, boolean stadslijn, int lijnnr, String omschrijving, double prijs, double prijsZonderBtw) 
{
	public static KostDTO maakKostDTO(Kost k) {
		if (k instanceof VerplaatsingPerAuto a)
			return new KostDTO('A', a.getVan(), a.getNaar(), false, false, 0, "", a.berekenPrijs(), a.berekenPrijsZonderBtw());
		if (k instanceof VerplaatsingPerBusTram b)
			return new KostDTO('B', b.getVan(), b.getNaar(), b.isBus(), b.isStadslijn(), b.getLijnnr(), "", b.berekenPrijs(), b.berekenPrijsZonderBtw());
		if (k instanceof Ticket t)
			return new KostDTO('T', "", "", false, false, 0, t.getOmschrijving(), t.berekenPrijs(), t.berekenPrijsZonderBtw());
		throw new IllegalArgumentException("Ongeldig kost object");
	}
}
