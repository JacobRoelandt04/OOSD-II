package domein;

import java.util.ArrayList;
import java.util.List;

import dto.BeheerskostDTO;

public class DomeinController {
	private final KostenRepository kostenRepos;

	public DomeinController() {
		kostenRepos = new KostenRepository();
	}
	
	public List<BeheerskostDTO> geefInfoBeheerskosten()
	{
		List<Beheerskost> lijst = kostenRepos.getKosten();
		List<BeheerskostDTO> info = new ArrayList<>();
		for (Beheerskost b : lijst)
		{
			info.add(BeheerskostDTO.maakBeheerskostDTO(b));
		}
		return info;
	}
	
	public double geefAangroeiIntrestSpaarRekening()
	{
		return SpaarRekening.getAangroeiIntrest();
	}
}