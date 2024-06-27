package com.example.spring.Dao;

import com.example.spring.Pojo.Elevator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElevatorDao extends JpaRepository<Elevator, String> {
}
