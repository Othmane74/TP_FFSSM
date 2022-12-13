package FFSSM;

import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class FFSSMUnitTest {
    Club club;
    Licence licence;
    Moniteur moniteur;
    Plongee plongee;
    Plongeur plongeur;
    LocalDate d1, d2;


    @BeforeEach
    public void setUp() {
        plongeur = new Plongeur("CD-544875", "MEKNASSI", "Othmane", "95 Rue Firmin Oules", "075885858", LocalDate.of(2000, 10, 10), 4);
        moniteur = new Moniteur("CD-574875", "Dipon", "Cole", "95 Rue Firmin Oules", "075775858", LocalDate.of(1999, 10, 20), 4, 547);
        club = new Club(moniteur, "Rock", "0655455858");
        licence = new Licence(plongeur, "15445725", LocalDate.of(2022, 2, 14), club);
        d1 = LocalDate.of(2022, 12, 15);
        d2 = LocalDate.of(2023, 1, 15);

    }

    @Test
    public void testDerniereLicence() {
        plongeur.ajouteLicence("1455584", LocalDate.of(2020, 5, 23), club);
        plongeur.ajouteLicence("1555558", LocalDate.of(2021, 6, 10), club);
        plongeur.ajouteLicence("1555558", LocalDate.of(2022, 11, 10), club);
        Licence attendu = new Licence(plongeur, "1555558", LocalDate.of(2022, 11, 10), club);
        boolean result = attendu.equals(plongeur.derniereLicence());
        assertTrue(result, "La dernière licence n'est pas correcte");
    }


    @Test
    public void testLicenceValide() {
        LocalDate aDate = LocalDate.of(2022, 12, 15);
        LocalDate anotherDate = LocalDate.of(2020, 7, 5);
        assertTrue(licence.estValide(aDate));
        assertFalse(licence.estValide(anotherDate));
    }


}
