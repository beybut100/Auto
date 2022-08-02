package com.example.Auto2.dao;

import com.example.Auto2.dto.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Users extends MongoRepository<User,String> {

}
