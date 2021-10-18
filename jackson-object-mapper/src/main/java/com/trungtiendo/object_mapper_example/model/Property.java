package com.trungtiendo.object_mapper_example.model;

import java.util.List;

public class Property {

    private String name;

    private String location;

    private int size;

    private List<Room> rooms;

    public Property() {}

    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", size=" + size +
                ", rooms=" + rooms +
                '}';
    }


    public Property(String name, String location, int size) {
        this.name = name;
        this.location = location;
        this.size = size;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public int getSize() {
        return size;
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
}
