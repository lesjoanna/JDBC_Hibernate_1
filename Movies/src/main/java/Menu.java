import javax.swing.JOptionPane;
import java.sql.SQLException;

public class Menu {
    private boolean running = true;
    private Database db;

    public Menu() {
        db = new Database();
    }

    public void startMenu() {
        do {
            int input = showOptions();
            handleOption(input);
        } while (running);
    }

    private int showOptions() {
        Object[] options = {"Dodaj nowy film", "Wyświetl filmy", "Koniec"};
        int input = JOptionPane.showOptionDialog(null, "Wybierz jedną z opcji:",
                "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);
        return input;
    }

    private void handleOption(int input) {
        try {
            executeOption(input);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Błąd zapytania do BD", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void executeOption(int input) throws SQLException {
        switch (input) {
            case 0:
                String title = JOptionPane.showInputDialog("Podaj tytuł:");
                String premiereYearString = JOptionPane.showInputDialog("Podaj rok premiery:");
                int premiereYear = Integer.parseInt(premiereYearString);
                if (premiereYear < 1800 || premiereYear > 2100) {
                    JOptionPane.showMessageDialog(null, "Podano nierealną datę premiery. Powinien być przedział: 1800 - 2100", "Error", JOptionPane.ERROR_MESSAGE);
                    executeOption(input);
                }
                String genre = JOptionPane.showInputDialog("Podaj gatunek:");
                String rateString = JOptionPane.showInputDialog("Podaj ocenę (1-5):");
                int rate = Integer.parseInt(rateString);
                Movie movie = new Movie(title, premiereYear, genre, rate);
                db.save(movie);
                break;
            case 1:
                db.showMovies();
                break;
            case 2:
                end();
                break;
        }
    }
    private void end() {
        running = false;
        db.close();
    }
}
