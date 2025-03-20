package com.trungdo.graphql_server.service;

import com.trungdo.graphql_server.entity.Book;
import com.trungdo.graphql_server.entity.BookFilter;
import com.trungdo.graphql_server.entity.BookInput;
import com.trungdo.graphql_server.entity.Category;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {
    private static List<Book> books = new ArrayList<>(List.of(
            new Book("book-1", "Effective Java", 416, Category.NONFICTION, "author-1"),
            new Book("book-2", "Hitchhiker's Guide to the Galaxy", 208, Category.FICTION, "author-2"),
            new Book("book-3", "Down Under", 436, Category.FICTION, "author-3"),
            new Book("book-4", "Thinking Fast and Slow", 234, Category.FICTION, "author-3"),
            new Book("book-5", "Think and Grow Rich", 123, Category.FICTION, "author-3"),
            new Book("book-6", "Happiness Hypothesis", 345, Category.FICTION, "author-3")
    ));

    public Book getBookById(String id) {
            return books.stream()
                    .filter(book -> book.id().equals(id))
                    .findFirst()
                    .orElse(null);
    }

    public List<Book> getBooksByFilter(BookFilter filter) {
        return books.stream()
                .filter(book -> (
                            filter.category() == null ||
                            filter.category() == book.category())
                        && (
                            filter.authorId() == null ||
                            filter.authorId().equals(book.authorId())
                        )
                ).toList();
    }

    public Book createBook(BookInput input) {
        Book newBook = new Book(
                UUID.randomUUID().toString(),
                input.name(),
                input.pageCount(),
                input.category(),
                input.authorId()
        );

        books.add(newBook);
        return newBook;
    }

    public Book deleteBook(String id) {
        Book foundBook = this.getBookById(id);
        books.remove(foundBook);
        return foundBook;
    }
}
