package org.example;

import java.util.*;

public class Phone {
    private Map<String, List<String>> book = new HashMap<>();

    public void add(String surname, String phone) {
        if (!book.containsKey(surname)) {
            book.put(surname, new ArrayList<>());
        }
        book.get(surname).add(phone);
    }

    public void get(String surname) {
        List<String> phones = book.get(surname);
        if (phones != null) {
            System.out.println(surname + phones);
        } else {
            System.out.println(surname + " номер телефона не найден");
        }
    }
}