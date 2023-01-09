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

    public static void addMovie() {

        Scanner s = new Scanner(System.in);

        System.out.println("Enter movie name: ");
        String movie = s.nextLine();

        movies.add(movie);
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
