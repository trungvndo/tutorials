package com.trungdo.graphql_server.entity;

public class DigitalBookStore extends BookStore {
    public String getWebsite() {
        return website;
    }

    private String website;

    public DigitalBookStore(String id, String name, String website) {
        super(id, name);
        this.website = website;
    }
}
