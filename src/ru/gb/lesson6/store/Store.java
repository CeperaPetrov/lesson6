package ru.gb.lesson6.store;
import java.util.*;

public class Store {
    private Set<Notebook> notebooks = new HashSet<>();

    public void addNotebook(Notebook notebook) {
        notebooks.add(notebook);
    }

    public Set<Notebook> filterNotebooks(Map<String, Object> criteria) {
        Set<Notebook> filteredNotebooks = new HashSet<>(notebooks);

        for (Map.Entry<String, Object> entry : criteria.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            filteredNotebooks.removeIf(notebook -> {
                switch (key) {
                    case "ram":
                        return notebook.getRam() < (int) value;
                    case "storage":
                        return notebook.getStorage() < (int) value;
                    case "os":
                        return !notebook.getOs().equalsIgnoreCase((String) value);
                    case "color":
                        return !notebook.getColor().equalsIgnoreCase((String) value);
                    default:
                        return false;
                }
            });
        }

        return filteredNotebooks;
    }

}
