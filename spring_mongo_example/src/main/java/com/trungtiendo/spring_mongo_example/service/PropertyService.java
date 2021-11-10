package com.trungtiendo.spring_mongo_example.service;

import com.trungtiendo.spring_mongo_example.entity.Property;
import com.trungtiendo.spring_mongo_example.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PropertyService {

    private PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public List<Property> getProperties() {
        return this.propertyRepository.findAll();
    }

    public List<String> getPropertyNamesInCity(String city) {
        return this.propertyRepository.getAllProperyNamesInCity(city)
                .map(Property::getName).collect(Collectors.toList());
    }

    public Property createProperty(Property property) {
        int[] copy = new int[5];
        Arrays.sort(copy, Comparator.comparingInt(Integer.).reversed());
        this.propertyRepository.insert(property);
        return property;
    }

    public Property updateProperty(String id, Property property) {
        Optional<Property> optionalProperty = this.propertyRepository.findById(id);
        if (optionalProperty.isPresent()) {
            Property foundProperty = optionalProperty.get();
            foundProperty.setName(property.getName());
            foundProperty.setCity(property.getCity());
            foundProperty.setSize(property.getSize());
            foundProperty.setLocation(property.getLocation());
            return this.propertyRepository.save(foundProperty);
        }
        else {
            throw new RuntimeException("Property not found");
        }
    }

    public void deteleProperty(String name) {
        List<Property> foundProperties = this.propertyRepository.findByName(name);
        this.propertyRepository.deleteAll(foundProperties);
    }
}
