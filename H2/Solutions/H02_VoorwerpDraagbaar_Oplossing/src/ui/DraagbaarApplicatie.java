package ui;

import java.util.List;

import domein.DomeinController;
import dto.DraagbaarDTO;

public class DraagbaarApplicatie
{
    private final DomeinController dc;

    public DraagbaarApplicatie(DomeinController dc)
    {
        this.dc = dc;
    }

    public void start()
    {
        dc.voegWapenToe("Colt", 1.5, 3, 6, false);
        dc.voegSleutelToe("Voordeur", 0.5, 3, 1);
        dc.voegWapenToe("Brown", 0.5, 1, 23, true);
        dc.voegSleutelToe("Achterdeur", 0.5, 1, 2);
        dc.voegGebouwToe("residentie Frankenstein", 4.5);

        List<DraagbaarDTO> lijstDTO = dc.geefDataCollectie();
        
        if (lijstDTO.isEmpty())
        	System.out.println("Collectie is leeg");
        else
        {
        	for (DraagbaarDTO dto : lijstDTO)
        	{
        		char soort = dto.soort();
        		String naamSoort = "";
        		String draagbaar = String.format("is %sdraagbaar", dto.draagbaar() ? "" : "niet ");
        		
        		switch (soort)
        		{
	        		case 'W' ->
	        		{
	        			naamSoort = "Wapen";
	        			String gebruikt = dto.gebruikt() ? "al" : "nog niet";
	        			System.out.printf("%s en met kracht %d %s gebruikt en %s.%n", 
	        					geefVoorwerpString(naamSoort, dto), dto.kracht(), gebruikt, draagbaar);
	        		}
	        		case 'S' ->
	        		{
	        			naamSoort = "Sleutel";
	        			int aantal = dc.geefAantalSleutelsInOmloop();
	        			System.out.printf("%s past op deur %d en %s.%nEr zijn %d sleutel(s) in omloop.%n", 
	        					geefVoorwerpString(naamSoort, dto), dto.deur(), draagbaar, aantal);
	        		}
	        		case 'G' ->
	        		{
	        			naamSoort = "Gebouw";
	        			System.out.printf("%s \"%s\" met hoogte %.1f %s.%n", naamSoort, dto.naam(), dto.hoogte(), draagbaar);
	        		}
        		}
        	}
        }
    }
    
    private String geefVoorwerpString(String naamSoort, DraagbaarDTO dto)
    {
    	String naam = dto.naam();
		double gewicht = dto.gewicht();
		int niveau = dto.niveau();
		return String.format("%s %s met gewicht %.3f uit niveau %d", naamSoort, naam, gewicht, niveau);
    }
}
