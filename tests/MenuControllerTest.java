import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MenuControllerTest {

    @Test
    void testLocatieDatumCheck() {
        ArrayList<Evenement> lijst = new ArrayList<>();
        lijst.add(new Concert("Artiest", "Event1", LocalDate.of(2025, 5, 10), 5, "Rotterdam"));

        MenuController controller = new MenuController(lijst, 0);

        boolean beschikbaar = controller.locatieDatumCheck("Rotterdam", LocalDate.of(2025, 5, 10));

        assertFalse(beschikbaar, "Locatie en datum zijn al bezet, dus check moet false geven.");
    }
}
