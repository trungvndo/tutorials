package com.trungtiendo.spring_mongo_example.controller;

import com.trungtiendo.spring_mongo_example.entity.Property;
import com.trungtiendo.spring_mongo_example.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping(path = "/properties")
    public List<Property> getProperties() {
        return this.propertyService.getProperties();
    }

    @GetMapping(path = "/properties/name/{city}")
    public List<String> getPropertyNamesByCity(@PathVariable String city) {
        return this.propertyService.getPropertyNamesInCity(city);
    }

    @PostMapping(path = "/properties")
    public Property createProperty(@RequestBody Property property) {
        return this.propertyService.createProperty(property);
    }

    @PutMapping(path = "/properties/{id}")
    public Property updateProperty(@RequestBody Property property, @PathVariable String id) {
        return this.propertyService.updateProperty(id, property);
    }

    @DeleteMapping(path = "/properties")
    public void deleteProperties(@RequestParam(name="name") String name) {
        this.propertyService.deteleProperty(name);
    }
}
