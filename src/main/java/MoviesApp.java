import java.util.ArrayList;
import java.util.Scanner;

public class MoviesApp {

    private static final ArrayList<String> movies = new ArrayList<>();


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        while (true) {

            //Menu to Diplay in Output
            System.out.println("Choose one of 3 options");
            System.out.println("1. Add movie");
            System.out.println("2. Show movies");
            System.out.println("3. End program");

            System.out.println("Enter option: ");

            int option = s.nextInt();

            //Processing of chosen option

            if (option == 1) {
                addMovie();

            } else if (option == 2) {
                showMovies();

            } else if (option == 3) {
                break;

            }

        }
        System.out.println("See you soon!");


        //Method to add movie to the list


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




    //Method that shows movies stored in the list


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
