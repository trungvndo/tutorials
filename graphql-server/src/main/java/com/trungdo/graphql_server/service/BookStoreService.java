package com.trungdo.graphql_server.service;

import com.trungdo.graphql_server.entity.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookStoreService {

    private static List<BookStore> bookStores = new ArrayList<>(List.of(
            new DigitalBookStore("store-1", "Store 1", "url1"),
            new DigitalBookStore("store-2", "Store 2", "url2"),
            new PhysicalBookStore("store-3", "Store 3", "My Dinh 2", "user-1"),
            new PhysicalBookStore("store-4", "Store 4", "My Dinh 1", "user-2")
    ));

    public List<BookStore> getBookStores() {
        return bookStores;
    }

    public Person getPersonById(String id) {
        return new Person(id, "name-" + id);
    }
}
