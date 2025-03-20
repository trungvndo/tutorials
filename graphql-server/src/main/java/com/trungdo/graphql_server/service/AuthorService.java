package com.trungdo.graphql_server.service;

import com.trungdo.graphql_server.entity.Author;
import com.trungdo.graphql_server.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    private Logger log = LoggerFactory.getLogger(AuthorService.class);

    private static List<Author> authors = Arrays.asList(
            new Author("author-1", "Joshua", "Bloch"),
            new Author("author-2", "Douglas", "Adams"),
            new Author("author-3", "Bill", "Bryson")
    );

    public Author getById(String id) {
        return authors.stream()
                .filter(author -> author.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Map<String, Author> getAuthors(Set<String> ids) {
        log.info("Get batch - " + ids.size() + " authors");
        var result = new HashMap<String, Author>();
        authors.stream()
                .filter(author -> ids.contains(author.id()))
                .forEach(author -> result.put(author.id(), author));
        return result;
    }

    public Map<Book, Author> getAuthorsForBooks(List<Book> books) {
        log.info("Get batch authors for - " + books.size() + " books");
        var result = new HashMap<Book, Author>();
        books.stream()
                .forEach(book -> result.put(book, getById(book.authorId())));
        return result;
    }
}
