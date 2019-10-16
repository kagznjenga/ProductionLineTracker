package sample;

public abstract class Product implements Item {
    private int id;
    private String type;
    private String manufacturer;
    private String name;

    public Product(String name, String manufacturer, String type) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.type = type;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String toString() {
        String myString = String.format("Name: %s\nManufacturer: %s\nType: %s", name, manufacturer, type);
        return myString;
    }
}
/*
class Widget extends Product {
    Widget(String name, String manufacturer, String type) {
        super(name, manufacturer, type);
    }
}
 */