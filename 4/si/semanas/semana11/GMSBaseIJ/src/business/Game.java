/*
 * Game
 * ruicouto in 10/abr/2017
 */
package business;

/**
 *
 * @author ruicouto (IJ project: jfc)
 */
public class Game {
    private int id;
    private String name;
    private int year;
    private double price;
    private String description;
    private String platform;    //  adicionei, pois no tutorial anterior havia

    public Game() {
    }

    public Game(int id, String name, int year, double price, String description, String platform) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.price = price;
        this.description = description;
        this.platform = platform;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", platform='" + platform + '\'' +
                '}';
    }
}
