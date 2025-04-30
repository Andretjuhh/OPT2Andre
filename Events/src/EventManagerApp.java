import java.time.LocalDate;
import java.util.ArrayList;

public class EventManagerApp {
    public static void main(String[] args) {

        ArrayList<Evenement> evenementen = new ArrayList<>();
        //objecten
        Concert TaylorTour = new Concert("Taylor Swift", "Eras Tour", LocalDate.of(2025, 5, 6), 5);
        Concert DuaLipa = new Concert("Dua Lipa", "Rock Werchter", LocalDate.of(2025, 5, 8), 3);
        Concert coldplay = new Concert("Coldplay", "Ziggo Dome", LocalDate.of(2025, 5, 7), 5);
        Concert Billie = new Concert("Billie Eilish", "Pinkpop", LocalDate.of(2025, 7, 12), 4);
        Concert edSheeran = new Concert("Ed Sheeran", "Johan Cruijff Arena", LocalDate.of(2025, 5, 30), 6);

        Workshop Fotografie = new Workshop("Cameras", "Workshop Fotografie", LocalDate.of(2025, 5, 18), 5);
        Workshop Houtbewerking = new Workshop("Hamer en slijptool", "Workshop Houtbewerking", LocalDate.of(2025, 5, 5), 10);
        Workshop Java = new Workshop("Laptop en Internet", "Workshop Java Programmeren", LocalDate.of(2025, 5, 3), 8);

        Lezing Minecraft = new Lezing("markus persson", "De Dev van Minecraft", LocalDate.of(2025, 5, 13), 5);
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
