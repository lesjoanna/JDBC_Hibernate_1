import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    private boolean running = true;
    private Database db;
    private Scanner scanner = new Scanner(System.in);

    public Menu() {
        db = new Database();
    }

    public void startMenu() {
        do {
            showOptions();
            int input = readDecision();
            handleOption(input);
        } while (running);
    }

    private void showOptions() {
        System.out.println("""
                Wybierz jedną z opcji:
                1. Dodaj nowy film
                2. Wyświetl filmy
                3. Koniec""");
    }

    private int readDecision() {
        return scanner.nextInt();
    }

    private void handleOption(int input) {
        try {
            executeOption(input);
        } catch (SQLException e) {
            System.out.println("Błąd zapytania do BD");
        }

    }

    private void executeOption(int input) throws SQLException {
        switch (input) {
            case 1:
                Movie movie = readMovieData();
                db.save(movie);
                break;
            case 2:
                db.showMovies();
                break;
            case 3:
                end();
                break;
        }
    }

    private Movie readMovieData() {
        System.out.print("Podaj tytuł:");
        String title = scanner.nextLine();
        System.out.print("Podaj rok premiery:");
        int premiereYear = scanner.nextInt();
        if (premiereYear < 1800 || premiereYear > 2100) {
            System.out.println("Podano nierealną datę premiery. " +
                    "Powinien być przedział: 1800 - 2100");
            return readMovieData();
        }
        scanner.nextLine();
        System.out.print("Podaj gatunek:");
        String genre = scanner.nextLine();
        System.out.print("Podaj ocenę (1-5):");
        int rate = scanner.nextInt();
        return new Movie(title, premiereYear, genre, rate);
    }

    private void end() {
        running = false;
        db.close();
    }
}
