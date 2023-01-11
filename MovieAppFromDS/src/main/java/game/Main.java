package game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {


    public static void main(String[] args) throws SQLException {


        DriverManager.getConnection("jdbc:mysql://localhost:3306/games", "root", "Joanna8673");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games", "root", "Joanna8673");


        String createTableSql = """
                CREATE TABLE games (
                id int,
                title VARCHAR(255) NOT NULL,
                price DOUBLE,
                platform VARCHAR(255) NOT NULL
                               
                               
                               
                );
                               
                               
                """;

       Game game = new Game("GTA", 129.00, "Playstation");
       Statement statement = connection.createStatement();
       String insertGameSql = String.format(" INSERT INTO games VALUES (0, '%s', '%f', '%s');",
                game.getTitle(), game.getPrice(), game.getPlatform());

      System.out.println(insertGameSql);
      statement.execute(insertGameSql);

    }}



