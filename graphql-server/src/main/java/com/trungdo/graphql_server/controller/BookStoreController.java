package com.trungdo.graphql_server.controller;

import com.trungdo.graphql_server.entity.BookStore;
import com.trungdo.graphql_server.entity.BookStoreQueries;
import com.trungdo.graphql_server.entity.Person;
import com.trungdo.graphql_server.entity.PhysicalBookStore;
import com.trungdo.graphql_server.service.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookStoreController {

    private BookStoreService service;

    @Autowired
    public BookStoreController(BookStoreService bookStoreService) {
        this.service = bookStoreService;
    }

    @QueryMapping(name = "bookstores")
    public List<BookStore> getAllBookStores() {
        return service.getBookStores();
    }


    @SchemaMapping(field = "owner")
    public Person owner(PhysicalBookStore bookStore) {
        // call only for PhysicalBookStore subtype
        return service.getPersonById(bookStore.getOwnerId());
    }
}
