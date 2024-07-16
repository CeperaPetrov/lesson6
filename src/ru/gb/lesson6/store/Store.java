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

}
