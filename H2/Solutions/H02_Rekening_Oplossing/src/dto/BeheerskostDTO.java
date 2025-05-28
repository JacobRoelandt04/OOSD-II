package dto;

import domein.Beheerskost;
import domein.Kluis;
import domein.SpaarRekening;
import domein.ZichtRekening;

public record BeheerskostDTO (char soort, long rekeningnr, double saldo, String houder, double maxKrediet, int kluisnr, double kost) 
{
	public static BeheerskostDTO maakBeheerskostDTO(Beheerskost b)
	{
		if(b instanceof ZichtRekening z) {
			return new BeheerskostDTO('Z', z.getRekeningNr(), z.getSaldo(), z.getHouder(), z.getMaxKredietOnderNul(), 0, z.geefJaarlijkseKost());
		}
		if(b instanceof SpaarRekening s) {
			return new BeheerskostDTO('S', s.getRekeningNr(), s.getSaldo(), s.getHouder(), 0, 0, s.geefJaarlijkseKost());
		}
		if(b instanceof Kluis k) {
			return new BeheerskostDTO('K', 0, 0, k.getHouder(), 0, k.getKluisnummer(), k.geefJaarlijkseKost());
		}
		throw new IllegalArgumentException("Ongeldige beheerskost");
	}
}
