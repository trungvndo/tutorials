package com.trungdo.graphql_server.controller;

import com.trungdo.graphql_server.entity.Author;
import com.trungdo.graphql_server.entity.Book;
import com.trungdo.graphql_server.entity.BookFilter;
import com.trungdo.graphql_server.entity.BookInput;
import com.trungdo.graphql_server.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @QueryMapping
    public Book bookById(@Argument String id) {
        return bookService.getBookById(id);
    }

    @QueryMapping(name = "books")
    public List<Book> getBooks(@Argument(name = "filter") BookFilter bookFilter) {
        return bookService.getBooksByFilter(bookFilter);
    }

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.authorId());
    }

    @MutationMapping(name = "addBook")
    public Book addBook(@Argument(name = "input") BookInput bookInput) {
        return bookService.createBook(bookInput);
    }

    @MutationMapping(name = "deleteBook")
    public Book deleteBook(@Argument String id) {
        return bookService.deleteBook(id);
    }
}
