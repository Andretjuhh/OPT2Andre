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
    public boolean isGetal (String x){
        if (x.matches("[0-9]+")) {
            return true;
        }
        else {
            return false;
        }
    }
    ///Methodes voor in voegEvenementToe
    public LocalDate vraagDatum() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("De datum van het event:\n welk jaar?");
        int vJaar = scanner.nextInt();
        System.out.println("Maand?");
        int vMaand = scanner.nextInt();
        System.out.println("Dag?");
        int vDag = scanner.nextInt();
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

        System.out.println("Typ het nummer van een evenement om details te bekijken:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (isGetal(input)) {
            int keuze = Integer.parseInt(input) - 1;
            if (keuze >= 0 && keuze < evenementen.size()) {
                menuOpslag = keuze;
                lijstEvent();
            } else {
                System.out.println("Geen geldig evenementnummer.");
            }
        } else {
            System.out.println("Geen nummer ingevoerd.");
        }
    }

    public void lijstEvent() {
        Evenement event = evenementen.get(menuOpslag);
        System.out.println(event.geefOverzicht());

        System.out.println("Deelnemers:");
        ArrayList<Deelnemer> deelnemers = event.getDeelnemers();

        if (deelnemers.isEmpty()) {
            System.out.println("Geen deelnemers in die event");
        } else {
            for (Deelnemer deelnemer : deelnemers) {
                System.out.println("- baam: " + deelnemer.getNaam() + " Email: " + deelnemer.getEmail());
            }
        }
    }

    //evenement toevoegen
    public void voegEvenementToe(){
       Scanner scanner = new Scanner(System.in);
        //vragenlijst wat vraagt naar de gegevens
        System.out.println("Welk type evenement wil je maken? Concert, Workshop, Lezing?");
        String event = scanner.nextLine();

        System.out.println();
        System.out.println("Wat is de naam van het event");
        String naamEvent = scanner.nextLine();

        String mArtiest = "";
        if (event.equals("concert")) {
            System.out.println("Wie is de artiest?");
             mArtiest = scanner.nextLine();
        }
        String mMateriaal = "";
        if (event.equals("workshop")) {
            System.out.println("Wat voor materiaal heb je nodig?");
            mMateriaal = scanner.nextLine();
        }
        String mSpreker = "";
        if (event.equals("lezing")) {
            System.out.println("Wie is de spreker?");
            mSpreker = scanner.nextLine();
        }

        System.out.println("Het maximaal aantal bezoekers/ deelnemers?");
        int mMaxDeelnemers = scanner.nextInt();
        scanner.nextLine();

        LocalDate mDatum = vraagDatum();

        System.out.println("Locatie?");
        String mLocatie = scanner.nextLine();
        while (!locatieDatumCheck(mLocatie, mDatum)) {
            System.out.println("Combinatie van locatie en datum is al in gebruik, kies anders");
            mLocatie = scanner.nextLine();
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

        System.out.println("Typ het nummer van een evenement om een deelnemer toe te voegen.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (isGetal(input)) {
            int keuze = Integer.parseInt(input) - 1;
            if (keuze >= 0 && keuze < evenementen.size()) {
                Evenement event = evenementen.get(keuze);
                System.out.println("Voer de deelnemer in:");
                String naamDeelnemer = scanner.nextLine();
                System.out.println("Voer de Email van de deelnemer in");
                String eMail = scanner.nextLine();
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
        } else {
            System.out.println("Geen nummer ingevoerd.");
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

        System.out.println("Typ het nummer van een evenement om details te bekijken:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (isGetal(input)) {
            int keuze = Integer.parseInt(input) - 1;
            if (keuze >= 0 && keuze < evenementen.size()) {
                menuOpslag = keuze;
                System.out.println("Weet je zeker dat je dit event wilt verwijderen? (typ: JA of NEE)");
                String delete = scanner.nextLine();
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
        } else {
            System.out.println("Geen nummer ingevoerd.");
        }
    }
}
