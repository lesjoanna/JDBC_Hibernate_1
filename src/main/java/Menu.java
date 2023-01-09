import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private static final ArrayList<String> movies = new ArrayList<>();

    private boolean running = true;

    public void startMenu() {

        do {
            menuAction();
        } while (running);

    }
    public void menuAction() {
        showOptions();
        int input = readDecision();
        executeOption(input);
    }

    private void showOptions() {
        System.out.println("""
                Wybierz jedna z opcji: 
                1. Dodaj nowy film 
                2. Wyswietl film
                3. Koniec""");
    }

    private int readDecision() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void executeOption(int input) {
        switch (input) {

            case 1:
                System.out.println("Dodawanie filmow");
                addMovie();
                break;
            case 2:
                System.out.println("Wyświetlanie");
                showMovies();
                break;
            case 3:
                System.out.println("Koniec");
                running = false;
                break;


        }


    }
    private static void addMovie() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter movie title: ");
        String title = scanner.nextLine();

        String releaseDate = "";
        while (true) {
            System.out.print("Enter movie release date (between 1800 and 2100): ");
            releaseDate = scanner.nextLine();

            // Validate release date
            if (releaseDate.matches("[0-9]{4}") &&
                    Integer.parseInt(releaseDate) >= 1800 &&
                    Integer.parseInt(releaseDate) <= 2100) {
                break;
            } else {
                System.out.println("Invalid release date. Please try again.");
            }
        }

        System.out.print("Enter movie genre: ");
        String genre = scanner.nextLine();

        System.out.print("Enter movie rating: ");
        String rating = scanner.nextLine();

        // Create a movie object
        Movie movie = new Movie(title, releaseDate, genre, rating);

        System.out.println(movie);

        // Add movie to list
        movies.add(String.valueOf(movie)) ;
        System.out.println("Movie added.");
    }

    private static void showMovies() {
        if (movies.isEmpty()) {
            System.out.println("There is no movies on the list.");
        } else {
            System.out.println("Movies: ");

            for (String movie : movies) {
                System.out.println(movie);
            }
        }
    }


}
