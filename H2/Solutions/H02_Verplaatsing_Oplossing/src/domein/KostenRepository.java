package domein;

import java.util.List;
import persistentie.KostenMapper;

public class KostenRepository
{
    private final List<Kost> kosten;
    private final KostenMapper km;
	
    public KostenRepository()
    {
		km = new KostenMapper();
		kosten = km.geefKostenLijst();
    } 

    public int[] geefAantalDocumentenPerSoort()
    {
        int[] aantalPerSoort = new int[3];
        for (Kost k: kosten)
        {
            if (k instanceof Ticket) aantalPerSoort[0]++;
            else if (k instanceof VerplaatsingPerAuto) aantalPerSoort[1]++;
            else if (k instanceof VerplaatsingPerBusTram) aantalPerSoort[2]++;
        }
        return aantalPerSoort;
    }

	public List<Kost> getKosten() 
	{
		return kosten;
	}
}