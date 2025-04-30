import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Evenement{
    private int id;
    private String naam;
    private LocalDate datum;
    private int maxDeelnemers;
    private ArrayList<Deelnemer> deelnemers;
    private int id_teller;

    Evenement (String naam, LocalDate datum, int maxDeelnemers ){
        this.naam = naam;
        this.datum = datum;
        this.maxDeelnemers = maxDeelnemers;
        this.id = id_teller++;
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

    public String geefOverzicht() {
        return "";
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