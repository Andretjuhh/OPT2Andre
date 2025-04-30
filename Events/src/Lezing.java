import java.time.LocalDate;

public class Lezing extends Evenement{
    private String spreker;

    Lezing (String spreker,String naam, LocalDate datum, int maxDeelnemers, String locatie) {
        super(naam, datum, maxDeelnemers, locatie);
        this.spreker = spreker;
    }

    public String getSpreker() {
        return spreker;
    }

    @Override
    public String geefOverzicht() {
        return "Lezing: " + getNaam() + " spreker:" + spreker + " op: " + getDatum();
}
}
