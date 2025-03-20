package com.trungdo.graphql_server.entity;

public class PhysicalBookStore extends BookStore {
    public String getAddress() {
        return address;
    }

    public String getOwnerId() {
        return ownerid;
    }

    private String address;
    private String ownerid;

    public PhysicalBookStore(String id, String name, String address, String ownerId) {
        super(id, name);
        this.address = address;
        this.ownerid = ownerId;
    }
}
