import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main1 {

    public static void main(String[] args) throws SQLException {


       DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "Joanna8673");

    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "Joanna8673");


    String createTableSql = """
        CREATE TABLE movies (
        title VARCHAR(255) NOT NULL,
        premiereYear int NOT NULL,
        genre VARCHAR(255) NOT NULL,
        rate int NOT NULL
                       
                       
        );
                       
                       
        """;

  // connection.createStatement().execute(createTableSql);
   //Movie movie = new Movie("Ritual", 2018, "Horror", )


}}
