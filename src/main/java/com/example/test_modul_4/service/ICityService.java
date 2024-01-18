package com.example.test_modul_4.service;

import com.example.test_modul_4.model.City;

import java.util.List;

public interface ICityService extends IGenerateService<City> {
    List<City> findStudentByNameContaining(String name);
}
