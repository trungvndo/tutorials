package com.trungtiendo.resourceserverexample.controllers;

import com.trungtiendo.resourceserverexample.model.Property;
import com.trungtiendo.resourceserverexample.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/properties")
    public List<Property> getProperties(@AuthenticationPrincipal OAuth2AuthenticatedPrincipal principal) {
        System.out.println("principal username: " + principal.getAttribute("username"));
        return this.propertyService.getProperties();
    }

    @PostMapping("/properties")
    public void createProperty(@RequestBody Property property) {
        this.propertyService.createProperty(property);
    }

    @GetMapping("/properties/{id}")
    public Property getProperty(@PathVariable long id) {
        return this.propertyService.getPropertyById(id);
    }

    @PutMapping("/properties/{id}")
    public void updateProperty(@PathVariable long id,@RequestBody Property property) {
        this.propertyService.updateProperty(id, property);
    }
}
