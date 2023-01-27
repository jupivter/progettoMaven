import java.sql.*;
import java.time.LocalDate;

public class Studente {

    private int id;
    private String nome;
    private String cognome;
    private LocalDate date;

    public void creaTabellaStudente() throws SQLException {
        Connection connection = DriverManager.getConnection(DBCredentials.url, DBCredentials.user, DBCredentials.password);
        Statement statement = connection.createStatement();
        String varname1 = ""
                + "CREATE TABLE newdb.Studente ( "
                + "	id INT auto_increment NOT NULL, "
                + "	nome varchar(100) NOT NULL, "
                + "	cognome varchar(100) NOT NULL, "
                + "	`date` DATE NOT NULL, "
                + "	CONSTRAINT Studente_pk PRIMARY KEY (id) "
                + ") "
                + "ENGINE=InnoDB "
                + "DEFAULT CHARSET=utf8mb4 "
                + "COLLATE=utf8mb4_0900_ai_ci;";
        statement.executeUpdate(varname1);
        connection.close();
    }

    public void insertStudente(String nome, String cognome, LocalDate date) throws SQLException {
        Connection connection = DriverManager.getConnection(DBCredentials.url, DBCredentials.user, DBCredentials.password);
        Statement statement = connection.createStatement();
        String varname1 = ""
                + "INSERT INTO newdb.studente "
                + "(nome, cognome, `date`) "
                + "VALUES('"+nome+"', '"+cognome+"', '"+date+"');";
        statement.executeUpdate(varname1);
        connection.close();
    }

    public void selectStudente() throws SQLException {
        Connection connection = DriverManager.getConnection(DBCredentials.url, DBCredentials.user, DBCredentials.password);
        Statement statement = connection.createStatement();
        String varname1 = ""
                + "SELECT id, nome, cognome, `date` "
                + "FROM newdb.studente;";
        ResultSet result = statement.executeQuery(varname1);
        while (result.next()){
            System.out.println(result.getString("id"));
            System.out.println(result.getString("nome"));
            System.out.println(result.getString("cognome"));
            System.out.println(result.getString("date"));
        }
        connection.close();
    }

    public void updateStudente(String nome, String cognome, int id, LocalDate date) throws SQLException {
        Connection connection = DriverManager.getConnection(DBCredentials.url, DBCredentials.user, DBCredentials.password);
        Statement statement = connection.createStatement();
        String varname1 = ""
                + "UPDATE newdb.studente "
                + "SET nome='"+nome+"', cognome='"+cognome+"', `date`='"+date+"' "
                + "WHERE id="+id+";";
        statement.executeUpdate(varname1);
        connection.close();
    }

    public void deleteStudente(int id) throws SQLException {
        Connection connection = DriverManager.getConnection(DBCredentials.url, DBCredentials.user, DBCredentials.password);
        Statement statement = connection.createStatement();
        String varname1 = ""
                + "DELETE FROM newdb.studente "
                + "WHERE id="+id+";";
        statement.executeUpdate(varname1);
        connection.close();
    }

}
