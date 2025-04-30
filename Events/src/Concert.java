import java.time.LocalDate;

public class Concert extends Evenement{
    private String artiest;

    Concert (String artiest, String naam, LocalDate datum, int maxDeelnemers, String locatie) {
        super(naam, datum, maxDeelnemers, locatie);
        this.artiest = artiest;
    }

    @Override
    public String geefOverzicht() {
        return "Festival: " + getNaam() + " met artiest " + artiest + " op: " + getDatum();
    }
}
