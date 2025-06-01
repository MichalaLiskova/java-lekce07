package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

    /**
     * Testuje metodu {@link Svatky#vratKdyMaSvatek(String)}
     */
    @Test
    void kdyMaSvatek() { // = je to lepší napsat na vratKdyMaSvatek, aby bylo vidět jako metodu testuji
        Svatky svatky = new Svatky();               //
        assertEquals(MonthDay.of(5, 18), svatky.vratKdyMaSvatek("Nataša"));
        assertNull(svatky.vratKdyMaSvatek("Eva"));
    }

    /**
     * Testuje metodu {@link Svatky#jeVSeznamu(String)}
     */
    @Test
    void jeVSeznamu() {
        Svatky svatky = new Svatky();
        assertTrue(svatky.jeVSeznamu("Zikmund"));
        assertFalse(svatky.jeVSeznamu("Sofie"));
        // Otestovat, že najde v seznamu existující jméno a nenajde neexistující jméno
    }

    /**
     * Testuje metodu {@link Svatky#getPocetJmen()}
     */
    @Test
    void getPocetJmen() {
        Svatky svatky = new Svatky();
        assertEquals(37, svatky.getPocetJmen());
        svatky.pridejSvatek("Sofie", MonthDay.of(5, 29));
        assertEquals(38, svatky.getPocetJmen());
        svatky.smazSvatek("Sofie");
        svatky.smazSvatek("Zikmund");
        assertEquals(36, svatky.getPocetJmen());

        //Otestovat, že vrací počet jmen, která máme v seznamu

    }

    /**
     * Testuje metodu {@link Svatky#getSeznamJmen()}
     */
    @Test
    void getSeznamJmen() {
        Svatky svatky = new Svatky();
        assertEquals(37, svatky.getSeznamJmen().size());
        //Zkontrolovat, že seznam jmen má správný počet položek.
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, int)}
     */
    @Test
    void pridatSvatekDenMesicInt() {
        Svatky svatky = new Svatky();
        assertFalse(svatky.jeVSeznamu("Sofie"));
        svatky.pridejSvatek("Sofie", 15, 05);
        assertEquals(MonthDay.of(5, 15), svatky.vratKdyMaSvatek("Sofie"));
        //Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, Month)}
     */
    @Test
    void pridatSvatekDenMesicMonth() {
        Svatky svatky = new Svatky();
        assertFalse(svatky.jeVSeznamu("Sofie"));
        svatky.pridejSvatek("Sofie", 15, Month.MAY);
        assertEquals(MonthDay.of(5, 15), svatky.vratKdyMaSvatek("Sofie"));
        // Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, MonthDay)}
     */
    @Test
    void prridatSvatekMonthDay() {
        Svatky svatky = new Svatky();
        assertFalse(svatky.jeVSeznamu("Sofie"));
        svatky.pridejSvatek("Sofie", MonthDay.of(5, 15));
        assertEquals(MonthDay.of(5, 15), svatky.vratKdyMaSvatek("Sofie"));
        //Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
    }

    /**
     * Testuje metodu {@link Svatky#smazSvatek(String)}
     */
    @Test
    void smazatSvatek() {
        Svatky svatky = new Svatky();
        assertEquals(37, svatky.getPocetJmen());
        svatky.smazSvatek("Zikmund");
        assertEquals(36, svatky.getPocetJmen());
        //Zkontrolovat, že po smazání bude počet svátků odpovídat novému počtu.
    }
}
