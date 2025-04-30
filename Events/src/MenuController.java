import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuController {
    private ArrayList<Evenement> evenementen;
    private int menuOpslag;

    MenuController (ArrayList<Evenement> evenementen, int menuOpslag) {
        this.evenementen = evenementen;
        this.menuOpslag = menuOpslag;
    }

    public boolean isGetal (String x){
        if (x.matches("[0-9]+")) {
            return true;
        }
        else {
            return false;
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean bezig = true;

        while (bezig) {
            tekenMenu();

            System.out.println("Geef het nummer van het event om dit te bekijken of typ stop om te stoppen");
            String input = scanner.nextLine();

            if(input.equals("stop")) {
                bezig = false;
                System.out.println("Tot ziens");
            } else if (isGetal(input)) {
                int keuze = Integer.parseInt(input);
                int keuzeInt = keuze - 1;

                if (keuzeInt >= 0 && keuzeInt < evenementen.size()) {
                    menuOpslag = keuzeInt;
                    voerActieUit();
                } else {
                    System.out.println("Niet een event");
                }

            } else {
                System.out.println("geen nummer, kies een nummer");
            }

        }

    }
    public void tekenMenu() {
        System.out.println("\n--- Gemeente Evenementenmenu ---");

        for (int i = 0; i < evenementen.size(); i++) {
            Evenement e = evenementen.get(i);
            System.out.println((i + 1) + ". " + e.getNaam());
        }

        System.out.println();
    }

    public void voerActieUit() {
        Evenement e = evenementen.get(menuOpslag);
        System.out.println(e.geefOverzicht());
    }

}
