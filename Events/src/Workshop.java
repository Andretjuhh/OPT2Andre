import java.time.LocalDate;

public class Workshop extends Evenement{
    private String materiaal;

    Workshop(String materiaal, String naam, LocalDate datum, int maxDeelnemers, String locatie) {
        super(naam, datum, maxDeelnemers, locatie);
        this.materiaal = materiaal;
    }
    @Override
    public String geefOverzicht() {
        return "Workshop: " + getNaam() + " materiaal:" + materiaal + " op: " + getDatum();
    }
}
