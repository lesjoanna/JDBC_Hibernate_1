package game;

public class Game {

    private int id;
    private String title;
    private double price;
    private String platform;

    public Game(String title, double price, String platform) {

        this.title = title;
        this.price = price;
        this.platform = platform;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Game(int id, String title, double price, String platform) {
            this.id = id;
            this.title = title;
            this.price = price;
            this.platform = platform;


    }
}
