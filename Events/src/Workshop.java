import java.time.LocalDate;

public class Workshop extends Evenement{
    private String materiaal;

    Workshop(String materiaal, String naam, LocalDate datum, int maxDeelnemers) {
        super(naam, datum, maxDeelnemers);
        this.materiaal = materiaal;
    }

    public String getMateriaal() {
        return materiaal;
    }

    @Override
    public String geefOverzicht() {
        return "Workshop: " + getNaam() + " materiaal:" + materiaal + " op: " + getDatum();
    }
}
