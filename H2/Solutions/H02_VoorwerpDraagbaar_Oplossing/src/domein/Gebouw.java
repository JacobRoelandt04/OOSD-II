package domein;

public class Gebouw implements Draagbaar {

    private final String naam;
    private double hoogte;

    public Gebouw(String naam, double hoogte) {
        super();
        controleerNaam(naam);
        this.naam = naam;
        setHoogte(hoogte);
    }
    
    private void controleerNaam(String naam)
    {
       if (naam == null || naam.isBlank())
            throw new IllegalArgumentException("Naam moet ingevuld worden!");
    }

    public String getNaam() {
        return naam;
    }

    public double getHoogte() {
        return hoogte;
    }

    public final void setHoogte(double hoogte) {
        if (hoogte < 3) 
            throw new IllegalArgumentException("De hoogte moet minstens 3m zijn!");
        this.hoogte = hoogte;
    }

    @Override
    public boolean isDraagbaar() {
        return false;
    }
}
