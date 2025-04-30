import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuController {
    private ArrayList<Evenement> evenementen;
    private int menuOpslag;

    MenuController (ArrayList<Evenement> evenementen, int menuOpslag) {
        this.evenementen = evenementen;
        this.menuOpslag = menuOpslag;
    }

    //Methode voor in Start
    private int getMenuNumber(String input){
        try {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            return 0;
        }
    }

    private String getInputString(String vraagText){
        Scanner scanner = new Scanner(System.in);

        System.out.println(vraagText);
        String input = scanner.nextLine();
        return input;
    }

    private int getInputInt(String vraagText){
        String input = getInputString(vraagText);
        return getMenuNumber(input);
    }


    ///Methodes voor in voegEvenementToe
    public LocalDate vraagDatum() {
        int vJaar = getInputInt("De datum van het event:\n welk jaar?");
        int vMaand = getInputInt("Maand?");
        int vDag = getInputInt("Dag?");

        return LocalDate.of(vJaar, vMaand, vDag);
    }

    public boolean locatieDatumCheck(String locatie, LocalDate datum) {
        for (Evenement e : evenementen) {
            if (e.getLocatie().equals(locatie) && e.getDatum().equals(datum)) {
                return false;
            }
        }
        return true;
    }
    //----------------------------------------------
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean bezig = true;

        while (bezig) {
            tekenMenu();
            String input = scanner.nextLine();

            if (input.equals("1")) {
                toonEvenementenLijst();
            } else if (input.equals("2")) {
                voegEvenementToe();
            } else if (input.equals("3")) {
                schrijfDeelnemerIn();
            } else if (input.equals("4")) {
                verwijderEvenement();
            } else if (input.equals("5")) {
                bezig = false;
                System.out.println("Tot ziens!");
            } else {
                System.out.println("geen nummer, kies een nummer");
            }
        }

    }
    public void tekenMenu() {
        System.out.println("\n--- Gemeente Evenementenmenu ---");
        System.out.println("1. Bekijk huidige evenementen");
        System.out.println("2. Voeg nieuw evenement toe");
        System.out.println("3. Schrijf deelnemer in");
        System.out.println("4. Verwijder evenement");
        System.out.println("5. Stoppen");
        System.out.print("Typ je keuze (1 t/m 5): ");
    }


    public void toonEvenementenLijst() {
        if (evenementen.isEmpty()) {
            System.out.println("Er zijn momenteel geen events.");
            return;
        }

        System.out.println("\n--- Huidige evenementen ---");
        for (int i = 0; i < evenementen.size(); i++) {
            System.out.println((i + 1) + ". " + evenementen.get(i).getNaam());
        }

        String input = getInputString("Typ het nummer van een evenement om details te bekijken:");
       int keuze = getMenuNumber(input) - 1;
        if (keuze >= 0 && keuze < evenementen.size()) {
            menuOpslag = keuze;
            lijstEvent();
        } else {
            System.out.println("Geen geldig evenementnummer.");
        }

    }

    public void lijstEvent() {
        Evenement event = evenementen.get(menuOpslag);
        System.out.println(event.geefOverzicht());

        System.out.println("Deelnemers:");
        ArrayList<Deelnemer> deelnemers = event.getDeelnemers();

        if (deelnemers.isEmpty()) {
            System.out.println("Geen deelnemers in dit event");
        } else {
            for (Deelnemer deelnemer : deelnemers) {
                System.out.println("- naam: " + deelnemer.getNaam() + " Email: " + deelnemer.getEmail());
            }
        }
    }

    //evenement toevoegen
    public void voegEvenementToe(){

        //vragenlijst wat vraagt naar de gegevens
        String event = getInputString("Welk type evenement wil je maken? Concert, Workshop, Lezing?");
        String naamEvent = getInputString("Wat is de naam van het event");

        String mArtiest = "";
        if (event.equals("concert")) {
            mArtiest = getInputString("Wie is de artiest?");
        }
        String mMateriaal = "";
        if (event.equals("workshop")) {
            mMateriaal = getInputString("Wat voor materiaal heb je nodig?");
        }
        String mSpreker = "";
        if (event.equals("lezing")) {
            mSpreker = getInputString("Wie is de spreker?");
        }

        int mMaxDeelnemers = getInputInt("Het maximaal aantal bezoekers/ deelnemers?");

        LocalDate mDatum = vraagDatum();
        String mLocatie = getInputString("Locatie?");
        while (!locatieDatumCheck(mLocatie, mDatum)) {
            mLocatie = getInputString("Combinatie van locatie en datum is al in gebruik, kies anders");
        }
        //Object aanmaken met gegevens
        if (event.equals("concert")){
            Concert nieuwConcert = new Concert(mArtiest, naamEvent, mDatum, mMaxDeelnemers, mLocatie);
            evenementen.add(nieuwConcert);
            System.out.println("Het concert is succesvol toegevoegd!");
        }
        if (event.equals("workshop")) {
            Workshop nieuwWorkshop = new Workshop(mMateriaal, naamEvent, mDatum, mMaxDeelnemers, mLocatie);
            evenementen.add(nieuwWorkshop);
            System.out.println("de workshop is succesvol toegevoegd!");
        }
        if (event.equals("lezing")) {
            Lezing nieuwLezing = new Lezing(mSpreker, naamEvent, mDatum, mMaxDeelnemers, mLocatie);
            evenementen.add(nieuwLezing);
            System.out.println("De lezing is succesvol toegevoegd!");
        }

    }


    //Deelnemers toevoegen
    public void schrijfDeelnemerIn (){

        if (evenementen.isEmpty()) {
            System.out.println("Er zijn momenteel geen events om deelnemers aan toe te voegen, voeg er een toe!");
            return;
        }

        System.out.println("\n--- Huidige evenementen ---");
        for (int i = 0; i < evenementen.size(); i++) {
            System.out.println((i + 1) + ". " + evenementen.get(i).getNaam());
        }

        String input = getInputString("Typ het nummer van een evenement om een deelnemer toe te voegen.");

        int keuze = getMenuNumber(input) - 1;
        if (keuze >= 0 && keuze < evenementen.size()) {
            Evenement event = evenementen.get(keuze);
            String naamDeelnemer = getInputString("Voer de deelnemer in:");
            String eMail = getInputString("Voer de Email van de deelnemer in");
            Deelnemer nieuwDeelnemer = new Deelnemer(naamDeelnemer, eMail);
            boolean done = event.voegDeelnemerToe(nieuwDeelnemer);

            if (done) {
                System.out.println("Deelnemer is succesvol toegevoegd");

            } else {
                System.out.println("Deelnemer is niet toegevoegd (vol of al ingeschreven).");
            }

        } else {
            System.out.println("Geen geldig evenement nummer.");
        }
    }
    //verwijderen van events
    public void verwijderEvenement () {
        if (evenementen.isEmpty()) {
            System.out.println("Er zijn momenteel geen events om te verwijderen, maak een event aan om deze te verwijderen XD");
            return;
        }
        System.out.println("\n--- Huidige evenementen ---");
        for (int i = 0; i < evenementen.size(); i++) {
            System.out.println((i + 1) + ". " + evenementen.get(i).getNaam());
        }

        String input = getInputString("Typ het nummer van een evenement om details te bekijken:");
        int keuze = getMenuNumber(input) - 1;
        if (keuze >= 0 && keuze < evenementen.size()) {
            menuOpslag = keuze;
            String delete = getInputString("Weet je zeker dat je dit event wilt verwijderen? (typ: JA of NEE)");
            if (delete.equals("JA")) {
                System.out.println("Selectie wordt verwijderd!!");
                evenementen.remove(keuze);
            }
            if (delete.equals("NEE")) {
                System.out.println("Event wordt NIET verwijderd!");
            } else {
                System.out.println("JA of NEE, andere commands werken niet.");
            }

        } else {
            System.out.println("Geen geldig evenement nummer.");
        }
    }
}
