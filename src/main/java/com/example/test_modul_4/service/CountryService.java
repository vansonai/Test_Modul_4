package com.example.test_modul_4.service;

import com.example.test_modul_4.model.City;
import com.example.test_modul_4.model.Country;
import com.example.test_modul_4.repository.ICountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CountryService implements ICountryService{
    @Autowired
    private ICountryRepository iCountryRepository;

    @Override
    public Iterable<Country> findAll() {
        return iCountryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Country country) {

    }

    @Override
    public void remove(Long id) {

    }
}
