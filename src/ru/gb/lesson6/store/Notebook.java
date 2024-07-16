package ru.gb.lesson6.store;

public class Notebook {
    private String brand;
    private String model;
    private int ram;
    private int storage;
    private String os;
    private String color;
    private double price;
    private double displaySize;

    public Notebook(String brand, String model, int ram, int storage, String os, String color, double price, double displaySize) {
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
        this.price = price;
        this.displaySize = displaySize;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public double getDisplaySize() {
        return displaySize;
    }

    @Override
    public String toString() {
        StringBuilder notebook = new StringBuilder();
        notebook.append("Notebook{");
        notebook.append("brand='");
        notebook.append(brand);
        notebook.append('\'');


        notebook.append(", model='");
        notebook.append(model);
        notebook.append('\'');

        notebook.append(", ram=");
        notebook.append(ram);

        notebook.append(", storage=");
        notebook.append(storage);

        notebook.append(", os='");
        notebook.append(os);
        notebook.append('\'');

        notebook.append(", display=");
        notebook.append(displaySize);

        notebook.append(", color='");
        notebook.append(color);
        notebook.append('\'');

        notebook.append(", price=");
        notebook.append(price);
        notebook.append('}');

        
        
        return notebook.toString();
    }
}

