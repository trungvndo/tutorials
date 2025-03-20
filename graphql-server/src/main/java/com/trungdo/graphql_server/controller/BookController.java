package com.trungdo.graphql_server.controller;

import com.trungdo.graphql_server.entity.*;
import com.trungdo.graphql_server.service.AuthorService;
import com.trungdo.graphql_server.service.BookService;
import org.dataloader.DataLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.graphql.execution.BatchLoaderRegistry;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Controller
public class BookController {

    private BookService bookService;
    private AuthorService authorService;

    private Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    public BookController(BookService bookService, AuthorService authorService, BatchLoaderRegistry registry) {
        this.bookService = bookService;
        this.authorService = authorService;
        registry.forTypePair(String.class, Author.class).registerMappedBatchLoader((authorIds, env) -> {
            return Mono.just(authorService.getAuthors(authorIds));
        });
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
        log.info("Getting author for book - " + book.id());
        return authorService.getById(book.authorId());
    }

//    @SchemaMapping
//    public CompletableFuture<Author> author(Book book, DataLoader<String, Author> dataLoader) {
//        return dataLoader.load(book.authorId());
//    }
//
//    @BatchMapping
//    public Mono<Map<Book, Author>> author(List<Book> books) {
//        return Mono.just(authorService.getAuthorsForBooks(books));
//    }

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
