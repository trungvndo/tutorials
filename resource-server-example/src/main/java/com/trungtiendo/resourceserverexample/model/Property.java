package com.trungtiendo.resourceserverexample.model;

public class Property {

    private long id;

    private String name;

    private String location;

    private Long size;

    public Property(long id, String name, String location, Long size) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.size = size;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public void setPropertyValues(Property property) {
        this.setName(property.getName());
        this.setLocation(property.getLocation());
        this.setSize(property.getSize());
    }
}
