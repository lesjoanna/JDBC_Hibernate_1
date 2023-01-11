import java.sql.SQLException;

//Single responsibility - pojedyncza odpowiedzialność
//Open-closed - kod powinien być otwarty na rozszerzanie i
// zamknięty na modyfikacje
//rozruch
public class MovieApp {
    public static void main(String[] args) throws SQLException {
        //Menu.startMenu(); - tak gdyby metoda była statyczna
        Menu menu = new Menu();
        menu.startMenu();
    }
}