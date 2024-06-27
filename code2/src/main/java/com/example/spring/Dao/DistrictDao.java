package com.example.spring.Dao;

import com.example.spring.Pojo.District;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictDao extends JpaRepository<District, String> {
}
