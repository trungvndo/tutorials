package com.trungtiendo.tutorial.springreactiveexample.model;

public class Property {
    private String name;

    private String location;

    private Integer size;

    public Property(String name, String location, Integer size) {
        this.name = name;
        this.location = location;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", size=" + size +
                '}';
    }
}
