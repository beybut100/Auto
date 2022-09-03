package com.example.Auto2.dao;

import com.example.Auto2.dto.user.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionPst extends JpaRepository<Session, Integer> {



}
