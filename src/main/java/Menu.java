import java.util.Scanner;

public class Menu {
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
                break;
            case 2:
                System.out.println("Wyświetlanie");
                break;
            case 3:
                System.out.println("Koniec");
                running = false;
                break;


        }
    }
}
