package com.trungdo.graphql_server.entity;

public class BookStore {
    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BookStore(String id, String name) {
        this.id = id;
        this.name = name;
    }

}
