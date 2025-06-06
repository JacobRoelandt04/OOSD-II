package domein;

public class VerplaatsingPerBusTram extends Verplaatsing
{
    private int lijnnr;
    private boolean bus;
    private boolean stadslijn;
    private static final double PRIJS_PER_HALTE = 0.32;
	
    public VerplaatsingPerBusTram(String van, String naar, double aantalKm, int lijnnr, boolean bus, boolean stadslijn) 
    {
        super(van, naar, aantalKm);
        setLijnnr(lijnnr);
        setBus(bus);
        setStadslijn(stadslijn);
    }

    public final void setLijnnr(int lijnnr) 
    { 
        if (lijnnr < 0)
            throw new IllegalArgumentException("Lijnnummer moet positief zijn!");
        this.lijnnr = lijnnr;
    }
    public final void setBus(boolean bus) 
    {
        this.bus = bus;
    }
    public final void setStadslijn(boolean stadslijn) 
    { 
        this.stadslijn = stadslijn;
    }
    public int getLijnnr() 
    { 
        return lijnnr; 
    }
    public boolean isBus() 
    { 
        return bus; 
    }
    public boolean isStadslijn() 
    { 
        return stadslijn; 
    }
    public double berekenPrijs() 
    {
        int aantalHaltes = (int) Math.ceil(getAantalKm());
        double prijs = aantalHaltes * PRIJS_PER_HALTE * 2;
        if (isStadslijn()) 
            prijs *= 0.8; 
        return prijs;
    }    
}
