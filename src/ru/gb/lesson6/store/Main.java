package ru.gb.lesson6.store;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Store store = new Store();

        // Добавим несколько ноутбуков в магазин
        store.generate();


        Scanner scanner = new Scanner(System.in);
        Map<String, Object> criteria = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        System.out.println("5 - Экран");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1 -> {
                System.out.print("Введите минимальный объем ОЗУ (в ГБ): ");
                int ram = scanner.nextInt();
                criteria.put("ram", ram);
            }
            case 2 -> {
                System.out.print("Введите минимальный объем ЖД (в ГБ): ");
                int storage = scanner.nextInt();
                criteria.put("storage", storage);
            }
            case 3 -> {
                System.out.print("Введите операционную систему: ");
                String os = scanner.nextLine();
                criteria.put("os", os);
            }
            case 4 -> {
                System.out.print("Введите цвет: ");
                String color = scanner.nextLine();
                criteria.put("color", color);
            }
            case 5 -> {
                System.out.print("Введите размер экрана: ");
                Double display = scanner.nextDouble();
                criteria.put("display", display);
            }
            default -> System.out.println("Неверный выбор!");
        }

        Set<Notebook> filteredNotebooks = store.filterNotebooks(criteria);

        if (filteredNotebooks.isEmpty()) {
            System.out.println("Нет ноутбуков, соответствующих заданным критериям.");
        } else {
            System.out.println("Найденные ноутбуки:");
            for (Notebook notebook : filteredNotebooks) {
                System.out.println(notebook);
            }
        }

        scanner.close();
    }

}
