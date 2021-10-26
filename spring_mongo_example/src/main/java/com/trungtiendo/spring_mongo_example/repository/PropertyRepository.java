package com.trungtiendo.spring_mongo_example.repository;

import com.trungtiendo.spring_mongo_example.entity.Property;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.stream.Stream;

public interface PropertyRepository extends MongoRepository<Property, String> {

    List<Property> findByName(String name);

    @Query(value="{'city': ?0}", fields = "{'name': 1}")
    Stream<Property> getAllProperyNamesInCity(String city);
}
