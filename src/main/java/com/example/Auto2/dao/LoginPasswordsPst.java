package com.example.Auto2.dao;

import com.example.Auto2.dto.user.Registration.LoginAndPassword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginPasswordsPst extends JpaRepository <LoginAndPassword,String> {


    Optional<LoginAndPassword> getFirstByLogin(String login);
}
