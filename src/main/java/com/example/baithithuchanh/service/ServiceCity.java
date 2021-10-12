package com.example.baithithuchanh.service;


import com.example.baithithuchanh.model.City;
import com.example.baithithuchanh.repository.IRepoCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceCity implements IServiceCity{
    @Autowired
    private IRepoCity repoCity;
    @Override
    public Iterable<City> showAll() {
        return repoCity.findAll();
    }

    @Override
    public void save(City city) {
        repoCity.save(city);
    }

    @Override
    public void delete(long id) {
        repoCity.deleteById(id);
    }

    @Override
    public Optional<City> findById(long id) {
        return repoCity.findById(id);
    }
}
