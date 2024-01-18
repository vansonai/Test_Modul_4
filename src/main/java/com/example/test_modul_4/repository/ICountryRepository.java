package com.example.test_modul_4.repository;

import com.example.test_modul_4.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICountryRepository extends JpaRepository<Country, Long> {
}
