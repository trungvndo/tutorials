package com.trungtiendo.spring_mongo_example.spring_mongo_example.service;

import com.trungtiendo.spring_mongo_example.entity.Property;
import com.trungtiendo.spring_mongo_example.repository.PropertyRepository;
import com.trungtiendo.spring_mongo_example.service.PropertyService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

@DataMongoTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PropertyServiceTest {

    private PropertyService propertyService;

    @Autowired
    private PropertyRepository propertyRepository;

    @BeforeEach
    void setUp() {
        this.propertyService = new PropertyService(propertyRepository);
        List<Property> properties = new ArrayList<>();
        properties.add(new Property("A", "Melbourne", "Melbourne", 20));
        properties.add(new Property("B", "Melbourne", "Melbourne", 20));
        properties.add(new Property("C", "Sydney", "Sydney", 20));
        properties.add(new Property("D", "Sydney", "Sydney", 20));
        this.propertyRepository.saveAll(properties);
    }

    @AfterEach
    void cleanUp() {
        this.propertyRepository.deleteAll();
    }

    @Test
    public void testGetProperties() {
        List<Property> properties = this.propertyService.getProperties();
        Assertions.assertEquals(properties.size(),4);
    }

    @Test
    public void testGetPropertyNames() {
        List<String> names1 = this.propertyService.getPropertyNamesInCity("Melbourne");
        Assertions.assertEquals(2, names1.size());

        List<String> names2 = this.propertyService.getPropertyNamesInCity("Sydney");
        Assertions.assertEquals(2, names2.size());
    }

    @Test
    public void testCreateNewProperty() {
        Property newProperty = new Property("E", "Brisbane", "Brisbane", 40);
        this.propertyService.createProperty(newProperty);
        List<Property> foundProperty = this.propertyRepository.findByName("E");
        Assertions.assertEquals(1, foundProperty.size());
        Assertions.assertEquals("Brisbane", foundProperty.get(0).getCity());
    }


}
