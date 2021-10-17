package com.trungtiendo.rulebookexample.model;

public class PropertyBean {

    public PropertyBean(String name, String location, int size, int numberOfBedRooms) {
        this.name = name;
        this.location = location;
        this.size = size;
        this.numberOfBedRooms = numberOfBedRooms;
    }

    /**
     * name of the property, cannot be longer than 10 characters
     */
    private String name;

    /**
     * location of the property, cannot be longer than 50 characters
     */
    private String location;

    /**
     * size of the property, have to be positive and no higher than 1000
     */
    private int size;

    /**
     * number of bedrooms, between 1 and 10
     */
    private int numberOfBedRooms;

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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumberOfBedRooms() {
        return numberOfBedRooms;
    }

    public void setNumberOfBedRooms(int numberOfBedRooms) {
        this.numberOfBedRooms = numberOfBedRooms;
    }

}
