import java.time.LocalDate;
import java.util.ArrayList;

public class EventManagerApp {
    public static void main(String[] args) {

        ArrayList<Evenement> evenementen = new ArrayList<>();
        //objecten
        Concert TaylorTour = new Concert("Taylor Swift", "Eras Tour", LocalDate.of(2025, 5, 6), 5, "Rotterdam");
        Concert DuaLipa = new Concert("Dua Lipa", "Rock Werchter", LocalDate.of(2025, 5, 8), 3, "Rotterdam");
        Concert coldplay = new Concert("Coldplay", "Ziggo Dome", LocalDate.of(2025, 5, 7), 5, "Rotterdam");
        Concert Billie = new Concert("Billie Eilish", "Pinkpop", LocalDate.of(2025, 7, 12), 4, "Rotterdam");
        Concert edSheeran = new Concert("Ed Sheeran", "Johan Cruijff Arena", LocalDate.of(2025, 5, 30), 6, "Rotterdam");

        Workshop Fotografie = new Workshop("Cameras", "Workshop Fotografie", LocalDate.of(2025, 5, 18), 5,"Rotterdam");
        Workshop Houtbewerking = new Workshop("Hamer en slijptool", "Workshop Houtbewerking", LocalDate.of(2025, 5, 5), 10,"Rotterdam");
        Workshop Java = new Workshop("Laptop en Internet", "Workshop Java Programmeren", LocalDate.of(2025, 5, 3), 8,"Rotterdam");

        Lezing Minecraft = new Lezing("markus persson", "De Dev van Minecraft", LocalDate.of(2025, 5, 13), 5, "Rotterdam");
        //toevoegen

        evenementen.add(TaylorTour);
        evenementen.add(DuaLipa);
        evenementen.add(coldplay);
        evenementen.add(Billie);
        evenementen.add(edSheeran);
        evenementen.add(Fotografie);
        evenementen.add(Houtbewerking);
        evenementen.add(Java);
        evenementen.add(Minecraft);

        MenuController Menu = new MenuController(evenementen, 0);

        Menu.start();


    }
}
//To-do versie 2: Data schijven naar data base, na runtime zijn de toegevoegde Objecten verdwenen, bijvoorbeeld Json ofzo.