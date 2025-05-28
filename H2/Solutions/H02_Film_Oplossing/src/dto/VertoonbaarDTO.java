package dto;

import domein.ConcertRegistratie;
import domein.Film;
import domein.Vertoonbaar;

public record VertoonbaarDTO(char soort, int sterren, String naam, int jaar, String artiest, String concertNaam, int zaal) 
{
	public static VertoonbaarDTO maakVertoonbaarDTO(Vertoonbaar v) {
		if (v instanceof Film f)
			return new VertoonbaarDTO('F', f.getSterren(), f.getNaam(), f.getJaar(), "", "", f.wordtVertoondInZaal());
		if (v instanceof ConcertRegistratie c)
			return new VertoonbaarDTO('C', 0, "", 0, c.getArtiest(), c.getConcertNaam(), c.wordtVertoondInZaal());
		throw new IllegalArgumentException("Ongeldig Vertoonbaar item");
	}
	
}
