package ui;

import domein.DomeinController;
import dto.BeheerskostDTO;

public class KostenApplicatie
{
	private final DomeinController dc;
	
	public KostenApplicatie(DomeinController dc)
	{
		this.dc = dc;
	}
	
	public void werkMetKosten()
	{	
		String titel = "", details = "";
		double aangroei = dc.geefAangroeiIntrestSpaarRekening();
		for (BeheerskostDTO dto : dc.geefInfoBeheerskosten())
		{
			String infoHouder = ", houder = " + dto.houder();
			switch (dto.soort())
			{
				case 'K' ->
				{
					titel = "kluisnr = " + dto.kluisnr();
					details = titel + infoHouder;
				}
				case 'S' ->
				{
					titel = "spaarrekening";
					details = String.format("%s. Aangroeiintrest = %.2f%%", geefDetailsRekening(titel, dto), aangroei);
				}
				case 'Z' ->
				{
					titel = "zichtrekening";
					details = String.format("%s. Max krediet onder nul = %.2f", geefDetailsRekening(titel, dto), dto.maxKrediet());
				}
			}
			System.out.println(titel + infoHouder);
			System.out.println("Details: " + details);
			System.out.printf("Kost: %.2f euro%n%n", dto.kost());
		}
	}
	
	private String geefDetailsRekening(String titel, BeheerskostDTO dto)
	{
		long reknr = dto.rekeningnr();
		long eerste = reknr / 1000000000;
		long middenste = reknr % 1000000000 / 100;
		long laatste = reknr % 100;
		return String.format("%s met rekeningnummer %03d-%07d-%02d%nstaat op naam van %s%nen bevat %.2f euro", 
				titel, eerste, middenste, laatste, dto.houder(), dto.saldo()); 
	}
}