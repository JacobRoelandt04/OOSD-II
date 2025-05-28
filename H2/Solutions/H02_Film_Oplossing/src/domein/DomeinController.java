package domein;

import java.util.List;

import dto.VertoonbaarDTO;

public class DomeinController {

	private final VertoonbaarRepository vertoonbaarRepo;
	
	public DomeinController() {
		vertoonbaarRepo = new VertoonbaarRepository();
	}
	
	public void voegVoorstellingToe(String naam, int sterren, int jaar)
	{
		vertoonbaarRepo.voegVoorstellingToe(new Film(naam, sterren, jaar));
	}

	public void voegVoorstellingToe(String artiest, String concertnaam)
	{
		vertoonbaarRepo.voegVoorstellingToe(new ConcertRegistratie(artiest, concertnaam));
	}

	public VertoonbaarDTO[] geefAlleVoorstellingen()
	{
		List<Vertoonbaar> lijst = vertoonbaarRepo.getVoorstellingen();
		VertoonbaarDTO[] dtoArray = new VertoonbaarDTO[lijst.size()];
		
		int i=0;
		for (Vertoonbaar v : lijst)
		{
			dtoArray[i] = VertoonbaarDTO.maakVertoonbaarDTO(v);
			i++;
		}
		return dtoArray;
	}

	public int geefAantalInZaal(int zaalnr)
	{
		return vertoonbaarRepo.geefAantalInZaal(zaalnr);
	}
}