package com.trungtiendo.object_mapper_example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.trungtiendo.object_mapper_example.model.Property;
import com.trungtiendo.object_mapper_example.model.Room;

import java.util.List;

public class ObjectMapperExample {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        Property property = new Property("Opera", "Sydney", 20);
        property.setRooms(List.of(new Room("Bedroom", 10), new Room("Bathroom", 10)));
        String value = objectMapper.writeValueAsString(property);
        System.out.println("json string: " + value);

        Property returnedProperty = objectMapper.readValue(value, Property.class);
        System.out.println("Returned property: " + returnedProperty);
    }
}
