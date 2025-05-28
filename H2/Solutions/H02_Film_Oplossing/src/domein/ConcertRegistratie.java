package domein;

public class ConcertRegistratie implements Vertoonbaar
{
	private final String artiest;
	private final String concertNaam;
	
	public ConcertRegistratie(String artiest, String concertNaam)
	{
		controleerIngevuld(artiest);
		controleerIngevuld(concertNaam);
		this.artiest = artiest;
		this.concertNaam = concertNaam;
	}

	private void controleerIngevuld(String tekst)
	{
		if (tekst == null || tekst.isBlank())
			throw new IllegalArgumentException("Alle gegevens moeten ingevuld zijn!");
	}
	
	public String getArtiest()
	{
		return artiest;
	}

	public String getConcertNaam()
	{
		return concertNaam;
	}

	@Override
	public int wordtVertoondInZaal()
	{
		return 2;
	}
}
