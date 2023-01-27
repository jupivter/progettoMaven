import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws SQLException {

        Studente studente = new Studente();
        //studente.creaTabellaStudente();
        //studente.insertStudente("Luca", "Rossi", LocalDate.of(1999,01,07));
        //studente.selectStudente();
        studente.updateStudente("Marco", "Verdi", 1, LocalDate.of(1988,02,12));
        studente.deleteStudente(1);
        studente.selectStudente();
    }
}
