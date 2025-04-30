import java.time.LocalDate;
import java.util.ArrayList;

public class EventManagerApp {
    public static void main(String[] args) {

        ArrayList<Evenement> evenementen = new ArrayList<>();

        //toevoegen
        evenementen.add(new Concert("Taylor Swift", "Eras Tour", LocalDate.of(2025, 5, 6), 5, "Rotterdam"));
        evenementen.add(new Concert("Dua Lipa", "Rock Werchter", LocalDate.of(2025, 5, 8), 3, "Rotterdam"));
        evenementen.add(new Concert("Coldplay", "Ziggo Dome", LocalDate.of(2025, 5, 7), 5, "Rotterdam"));
        evenementen.add(new Concert("Billie Eilish", "Pinkpop", LocalDate.of(2025, 7, 12), 4, "Rotterdam"));
        evenementen.add(new Concert("Ed Sheeran", "Johan Cruijff Arena", LocalDate.of(2025, 5, 30), 6, "Rotterdam"));
        evenementen.add(new Workshop("Cameras", "Workshop Fotografie", LocalDate.of(2025, 5, 18), 5,"Rotterdam"));
        evenementen.add(new Workshop("Hamer en slijptool", "Workshop Houtbewerking", LocalDate.of(2025, 5, 5), 10,"Rotterdam"));
        evenementen.add(new Workshop("Laptop en Internet", "Workshop Java Programmeren", LocalDate.of(2025, 5, 3), 8,"Rotterdam"));
        evenementen.add(new Lezing("markus persson", "De Dev van Minecraft", LocalDate.of(2025, 5, 13), 5, "Rotterdam"));

        MenuController Menu = new MenuController(evenementen, 0);

        Menu.start();
    }
}
//To-do versie 2: Data schijven naar data base, na runtime zijn de toegevoegde Objecten verdwenen, bijvoorbeeld Json ofzo.