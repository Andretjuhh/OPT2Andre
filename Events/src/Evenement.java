import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Evenement{
    private String naam;
    private LocalDate datum;
    private int maxDeelnemers;
    private String locatie;
    private ArrayList<Deelnemer> deelnemers;

    Evenement (String naam, LocalDate datum, int maxDeelnemers, String locatie ){
        this.naam = naam;
        this.datum = datum;
        this.maxDeelnemers = maxDeelnemers;
        this.locatie = locatie;
        this.deelnemers = new ArrayList<>();
    }

    public String getNaam() {
        return naam;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public String getLocatie() {
        return locatie;
    }

    public ArrayList<Deelnemer> getDeelnemers() {
        return deelnemers;
    }

    public boolean voegDeelnemerToe(Deelnemer deelnemer){
        if (deelnemers.size() >= maxDeelnemers) {
            return false;
        } if (deelnemers.contains(deelnemer)){
            return false;
        } else {
            deelnemers.add(deelnemer);
            return true;
        }
    }

    public String geefOverzicht() {
        return "Print overzicht van het Event (als je dit ziet gaat er iets mis XD";
    }

}