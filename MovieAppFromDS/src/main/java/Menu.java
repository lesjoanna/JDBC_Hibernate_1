
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//menu
public class Menu {
    private boolean running = true;
    private List<Movie> movies = new ArrayList<>();
    private Connection connection;

    public Menu() {
        try {

            String createMoviesTableSql = """
                    
        CREATE TABLE IF NOT EXISTS movies (
        title VARCHAR(255) NOT NULL,
        premiereYear int NOT NULL,
        genre VARCHAR(255) NOT NULL,
        rate int NOT NULL
                       
                       
        );
                    """;
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "Joanna8673");
            Statement statement = connection.createStatement();
            statement.execute(createMoviesTableSql);
        } catch (SQLException e) {System.out.println("Wywwywy");}

    }
    public void startMenu() {
        do {
            menuAction();
        } while (running);
    }

    private void menuAction() {
        showOptions();
        int input = readDecision();
        executeOption(input);
    }

    private void showOptions() {
        System.out.println("""
                Wybierz jedną z opcji:
                1. Dodaj nowy film
                2. Wyświetl filmy
                3. Koniec""");
    }

    private int readDecision() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void executeOption(int input) {
        switch (input) {
            case 1:
                addMovie();
                break;
            case 2:
                showMovies();
                break;
            case 3:
                end();
                break;
        }
    }

    private void addMovie() {
        Movie movie = readMovieData();
        save(movie);
    }

    private Movie readMovieData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj tytuł:");
        String title = scanner.nextLine();
        System.out.print("Podaj rok premiery:");
        int premiereYear = scanner.nextInt();
        if (premiereYear < 1800 || premiereYear > 2100) {
            System.out.println("Podano nierealną datę premiery. " +
                    "Powinien być przedział: 1800 - 2100");
            return readMovieData();
        }
//        scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.print("Podaj gatunek:");
        String genre = scanner.nextLine();
        System.out.print("Podaj ocenę (1-5):");
        int rate = scanner.nextInt();
        return new Movie(title, premiereYear, genre, rate);
    }

    private void showMovies() {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public void save(Movie movie) {
        movies.add(movie);
    }

    private void end() {
        System.out.println("Koniec");
        running = false;
    }


    //każda metoda powinna operować na jednym poziomie abstrakcji
}