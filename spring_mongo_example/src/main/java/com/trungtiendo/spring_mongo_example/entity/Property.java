package com.trungtiendo.spring_mongo_example.entity;

import org.springframework.boot.context.properties.bind.Name;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "properties")
@CompoundIndex(name = "name_city", def = "{'name': 1, 'city': 1}")
public class Property {
    @Id
    private String id;

    public Property() {
    }
    public Property(String name, String location, String city, int size) {
        this.name = name;
        this.location = location;
        this.city = city;
        this.size = size;
    }

    @Indexed(unique = true)
    private String name;

    private String location;

    private String city;

    private int size;

    @Version
    private int version;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
