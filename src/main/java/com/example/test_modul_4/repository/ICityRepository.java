package com.example.test_modul_4.repository;

import com.example.test_modul_4.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICityRepository extends JpaRepository<City, Long> {
    @Query("select c from City c where c.name like %:name%")
    List<City> findCityByNameContaining(String name);
}
