import java.time.LocalDateTime;

public class Product {
    private int id;
    private String name;
    private int price;
    LocalDateTime dateOfCreating;
    LocalDateTime dateOfRefreshing;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.dateOfCreating = LocalDateTime.now();
        this.dateOfRefreshing = LocalDateTime.now();
    }

    public Product(int id, String name, int price, LocalDateTime dateOfRefreshing) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.dateOfRefreshing = dateOfRefreshing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getDateOfCreating() {
        return dateOfCreating;
    }

    public void setDateOfCreating(LocalDateTime dateOfCreating) {
        this.dateOfCreating = dateOfCreating;
    }

    public LocalDateTime getDateOfRefreshing() {
        return dateOfRefreshing;
    }

    public void setDateOfRefreshing(LocalDateTime dateOfRefreshing) {
        this.dateOfRefreshing = dateOfRefreshing;
    }

    @Override
    public String toString() {
        return "id товара: " + id + "; Наименование товара: " + name + "; Цена товара: " + price + "; Дата создания: " + dateOfCreating + "; Дата обновления: " + dateOfRefreshing + ";";
    }
}
