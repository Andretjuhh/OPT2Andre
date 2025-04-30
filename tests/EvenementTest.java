import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class EvenementTest {

    @Test
    void testVoegDeelnemerToe_succes() {
        Evenement evenement = new Concert("Artiest", "Testconcert", LocalDate.of(2025, 5, 5), 2, "Rotterdam");
        Deelnemer deelnemer = new Deelnemer("Jan", "jan@mail.com");

        boolean toegevoegd = evenement.voegDeelnemerToe(deelnemer);

        assertTrue(toegevoegd, "Deelnemer zou succesvol moeten worden toegevoegd.");
    }

    @Test
    void testVoegDeelnemerToe_geenPlek() {
        Evenement evenement = new Concert("Artiest", "Vol", LocalDate.of(2025, 5, 5), 1, "Rotterdam");
        evenement.voegDeelnemerToe(new Deelnemer("Jan", "jan@mail.com"));
        boolean toegevoegd = evenement.voegDeelnemerToe(new Deelnemer("Piet", "piet@mail.com"));

        assertFalse(toegevoegd, "Er is geen plek meer, deelnemer mag niet worden toegevoegd.");
    }

    @Test
    void testVoegDeelnemerToe_dubbeleDeelnemer() {
        Evenement evenement = new Concert("Artiest", "DubbelTest", LocalDate.of(2025, 5, 5), 2, "Rotterdam");
        Deelnemer deelnemer = new Deelnemer("Sanne", "sanne@mail.com");

        evenement.voegDeelnemerToe(deelnemer);
        boolean tweedeToevoeging = evenement.voegDeelnemerToe(deelnemer);

        assertFalse(tweedeToevoeging, "Deelnemer mag niet twee keer toegevoegd worden.");
    }

}
