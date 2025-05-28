package ui;

import domein.DomeinController;
import dto.KostDTO;

public class VerplaatsingApplicatie
{
	private DomeinController dc;

	public VerplaatsingApplicatie(DomeinController dc)
	{
		this.dc = dc;
	}

	public void start()
	{
		String tekst, output = dc.geefOverzichtAantalDocumenten();
		output += "Overzicht gemaakte kosten:\n\n";
		output += String.format("%70s%15s\n", "Kostenpost", "Bedrag");
		for (KostDTO k: dc.geefKostenLijst())
		{ 
			tekst = switch (k.soort())
					{
					case 'A' -> String.format("%s per auto", geefGegevensVerplaatsing(k)); // Auto
					case 'B' -> String.format("%s met %s", geefGegevensVerplaatsing(k), geefInfoBusTram(k)); // Bus/Tram
					default -> String.format("%s", k.omschrijving()); // Ticket
					};

			double prijs = switch (k.soort())
					{
					case 'A', 'B' -> k.prijsZonderBtw();
					default -> k.prijs();
					};
					
			output += String.format("%70s%15.2f\n", tekst, prijs);
		}
		output += String.format("\n\nTotaal gedeclareerde kosten = %7.2f\n", dc.berekenTotaalKosten());
		System.out.printf(output);
	}

	private String geefGegevensVerplaatsing(KostDTO k)
	{	
		return String.format("verplaatsing van %s naar %s", k.van(), k.naar());
	}

	private String geefInfoBusTram(KostDTO k)
	{
		return String.format("%s%s%d", k.stadslijn() ? "stads" : "", k.bus() ? "bus " : "tram ", k.lijnnr());
	}
}