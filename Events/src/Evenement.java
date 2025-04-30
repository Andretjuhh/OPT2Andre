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

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public int getMaxDeelnemers() {
        return maxDeelnemers;
    }

    public void setMaxDeelnemers(int maxDeelnemers) {
        this.maxDeelnemers = maxDeelnemers;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public String getLocatie() {
        return locatie;
    }

    public ArrayList<Deelnemer> getDeelnemers() {
        return deelnemers;
    }

    public String geefOverzicht() {
        return "Print overzicht van het Event (als je dit ziet gaat er iets mis XD";
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
}