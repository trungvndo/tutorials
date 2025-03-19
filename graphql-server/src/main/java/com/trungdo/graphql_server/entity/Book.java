package com.trungdo.graphql_server.entity;

public record Book (String id, String name, int pageCount, Category category, String authorId) {
}
