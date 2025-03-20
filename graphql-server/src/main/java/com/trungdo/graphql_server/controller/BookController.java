package com.trungdo.graphql_server.controller;

import com.trungdo.graphql_server.entity.*;
import com.trungdo.graphql_server.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.time.Duration;
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

    @SubscriptionMapping
    public Flux<Book> getLatestPurchasedBook() {
        Flux<Integer> interval = Flux.fromIterable(List.of(1,2,3,4,5,6,7,8))
                .delayElements(Duration.ofSeconds(2));
        return interval.map(i -> new Book("book-" + i, "New book here " + i, 20, Category.FICTION, "author-" + i));
    }
}
