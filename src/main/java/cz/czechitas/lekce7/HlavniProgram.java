package cz.czechitas.lekce7;

import javax.swing.*;
import java.time.Month;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;

/**
 * Hlaví třída pro lekci 7.
 */
public class HlavniProgram {

    /**
     * Spouštěcí metoda celé aplikace.
     *
     * @param args
     */
    public static void main(String... args) {
        Svatky svatky = new Svatky();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.");

        //    System.out.printf("V seznamu je %d jmen.", svatky.getPocetJmen()).println();
        // svatky.smazSvatek("Monika");
        String jmeno = "Monika";
        System.out.printf("%s má svátek %s.", jmeno, svatky.vratKdyMaSvatek(jmeno)).println();
        jmeno = "Eva";
        System.out.printf("%s má svátek %s.", jmeno, svatky.vratKdyMaSvatek(jmeno)).println();

        System.out.printf("Eva je v seznamu svátků: %b.", svatky.jeVSeznamu("Eva")).println();
        System.out.printf("Eva je v seznamu svátků: %s.", svatky.jeVSeznamuToString("Eva")).println();
        svatky.smazSvatek("Monika");
        svatky.pridejSvatek("Sofie", 15, 5);
        svatky.pridejSvatek("Štěpán", 26, Month.DECEMBER);

        jmeno = "Sofie";
        System.out.printf("%s má svátek %s.", jmeno, svatky.vratKdyMaSvatek(jmeno)).println();

        jmeno = "Štěpán";
        System.out.printf("%s má svátek %s.", jmeno, svatky.vratKdyMaSvatek(jmeno)).println();
        svatky.pridejSvatek("Pinda", 6, 4);
        jmeno = "Pinda";
        System.out.printf("%s má svátek %s.", jmeno, svatky.vratKdyMaSvatek(jmeno).format(formatter)).println();
        svatky.pridejSvatek("Fifinka", 16, 4);
        jmeno = "Fifinka";
        System.out.printf("%s má svátek %s.", jmeno, svatky.vratKdyMaSvatek(jmeno).format(formatter)).println();
        jmeno = "Sofie";
        System.out.printf("%s má svátek %s.", jmeno, svatky.vratKdyMaSvatek(jmeno)).println();


        System.out.println("V seznamu jsou následující jména:");
        svatky.getSeznamJmen().forEach(jmena -> System.out.printf("- %s", jmena).println());


        svatky.smazSvatek("Přemysl");
        System.out.printf("Po smazání Přemysla je v seznamu je %d jmen.", svatky.getPocetJmen()).println();

        svatky.pridejSvatek("Laura", 1, 6);
        svatky.pridejSvatek("Jarmil", 2, Month.JUNE);
        svatky.pridejSvatek("Tamara", MonthDay.of(6, 3));
        svatky.pridejSvatek("Kevin", MonthDay.of(Month.JUNE, 3));
        System.out.printf("Po přidání Laury, Jarmila, Tamary a Kevina je v seznamu je %d jmen.", svatky.getPocetJmen()).println();

    }

}
