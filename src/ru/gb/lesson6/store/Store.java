package ru.gb.lesson6.store;
import java.util.*;

public class Store {
    private final Set<Notebook> notebooks = new HashSet<>();

    public void addNotebook(Notebook notebook) {
        notebooks.add(notebook);
    }

    public Set<Notebook> filterNotebooks(Map<String, Object> criteria) {
        Set<Notebook> filteredNotebooks = new HashSet<>(notebooks);

        for (Map.Entry<String, Object> entry : criteria.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            filteredNotebooks.removeIf(notebook -> {
                return switch (key) {
                    case "ram" -> notebook.getRam() < (int) value;
                    case "storage" -> notebook.getStorage() < (int) value;
                    case "display" -> notebook.getDisplaySize() < (double) value;
                    case "os" -> !notebook.getOs().equalsIgnoreCase((String) value);
                    case "color" -> !notebook.getColor().equalsIgnoreCase((String) value);
                    default -> false;
                };
            });
        }

        return filteredNotebooks;
    }
    public void generate() {
        addNotebook(new Notebook("Dell", "XPS 13", 16, 512, "Windows", "Silver", 1200, 15.6));
        addNotebook(new Notebook("Apple", "MacBook Air", 8, 256, "MacOS", "Space Gray", 1000,13.3));
        addNotebook(new Notebook("HP", "Pavilion", 8, 1024, "Windows", "Black", 800, 15.6));
        addNotebook(new Notebook("Lenovo", "LEGION", 32, 2048, "Linux", "Black", 1100, 17.3));
        addNotebook(new Notebook("Lenovo", "LEGION", 16, 1024, "Windows", "White", 1000, 15.6));
    }

}
