package domein;

import java.util.ArrayList;
import java.util.List;

import dto.KostDTO;

public class DomeinController
{
    private final KostenRepository kr;
	
    public DomeinController()
    {
    	kr = new KostenRepository();
    }
        
    public String geefOverzichtAantalDocumenten()
    {
    	int[] aantallen = kr.geefAantalDocumentenPerSoort();
        return "Volgende documenten werden ingediend:\n"
                + aantallen[0] + " ticket(s), " + aantallen[1] + " verplaatsing(en) per auto en " 
                + aantallen[2] + " verplaatsing(en) per bus/tram.\n\n";
    }
    
     public List<KostDTO> geefKostenLijst()
     {
    	 List<Kost> kosten = kr.getKosten();
    	 List<KostDTO> dtos = new ArrayList<>();
    	 for (Kost k : kosten)
    	 {
    		 dtos.add(KostDTO.maakKostDTO(k));
    	 }
    	 return dtos;
     }
     
     public double berekenTotaalKosten() 
	 {
    	 double totaal = 0;
		 List<Kost> kosten = kr.getKosten();
		
		 for (Kost k : kosten)
		 {
			 totaal += k instanceof Verplaatsing ? k.berekenPrijsZonderBtw() : k.berekenPrijs(); 
		 }
		 return totaal;
	 }
}