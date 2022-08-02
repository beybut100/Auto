package com.example.Auto2.dao;

import com.example.Auto2.dto.car.Auto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AutosList extends MongoRepository<Auto,String> {
        public Optional<Auto> findFirstByBrandModel(String brandName);
}
