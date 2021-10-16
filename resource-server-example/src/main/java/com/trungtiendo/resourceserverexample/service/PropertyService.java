package com.trungtiendo.resourceserverexample.service;

import com.trungtiendo.resourceserverexample.model.Property;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    private List<Property> properties = new ArrayList<>();

    public void createProperty(Property property) {
        OAuth2AuthenticatedPrincipal principal = (OAuth2AuthenticatedPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("User " + principal.getAttribute("username") + " is creating new property");
        property.setId(properties.size());
        this.properties.add(property);
    }

    public void updateProperty(long id, Property property) {
        Optional<Property> filterdProperty = properties.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
        if (filterdProperty.isPresent()) {
            Property foundProperty = filterdProperty.get();
            foundProperty.setPropertyValues(property);
        }
    }

    public List<Property> getProperties() {
        return this.properties;
    }

    public Property getPropertyById(long id) {
        Optional<Property> filterdProperty = properties.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
        if (filterdProperty.isPresent()) return filterdProperty.get();
        return null;
    }
}
