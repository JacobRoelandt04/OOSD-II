package domein;

import java.util.ArrayList;
import java.util.List;

import dto.DraagbaarDTO;

public class DomeinController {

    private final DraagbaarRepository draagbaarRepo;

    public DomeinController() {
        draagbaarRepo = new DraagbaarRepository();
    }

    public void voegWapenToe(String naam, double gewicht, int niveau, int kracht, boolean gebruikt) {
        Wapen wapen = new Wapen(naam, gewicht, niveau, kracht, gebruikt);
        draagbaarRepo.voegDraagbaarItemToe(wapen);
    }

    public void voegSleutelToe(String naam, double gewicht, int niveau, int deur) {
        Sleutel sleutel = new Sleutel(naam, gewicht, niveau, deur);
        draagbaarRepo.voegDraagbaarItemToe(sleutel);
    }

    public void voegGebouwToe(String naam, double hoogte) {
        Gebouw gebouw = new Gebouw(naam, hoogte);
        draagbaarRepo.voegDraagbaarItemToe(gebouw);
    }

    public int geefAantalSleutelsInOmloop()
    {
    	return Sleutel.getAantalInOmloop();
    }
    
    public List<DraagbaarDTO> geefDataCollectie()
    {
    	List<Draagbaar> collectie = draagbaarRepo.getCollectie();
    	List<DraagbaarDTO> data = new ArrayList<>();
    	DraagbaarDTO dto = null;
    	
    	for (Draagbaar d : collectie)
    	{
    		data.add(DraagbaarDTO.maakDraagbaarDTO(d));
    	}
    	
		return data;
    }
}
