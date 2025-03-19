package com.trungdo.graphql_server.entity;

public record BookInput(
        String name,
        Integer pageCount,
        Category category,
        String authorId
) {
}
