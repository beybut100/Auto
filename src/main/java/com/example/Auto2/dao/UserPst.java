package com.example.Auto2.dao;

import com.example.Auto2.dto.user.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPst extends JpaRepository<Session, String> {


}
