package com.example.Auto2.dao;

import com.example.Auto2.dto.user.Registration.LoginAndPassword;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginPasswords extends MongoRepository<LoginAndPassword,String> {

public Optional<LoginAndPassword> getFirstByLogin(String login);
public Optional<LoginAndPassword> findFirstByLogin(String login);

}
