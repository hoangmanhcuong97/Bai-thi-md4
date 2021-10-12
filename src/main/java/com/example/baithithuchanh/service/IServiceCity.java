package com.example.baithithuchanh.service;


import com.example.baithithuchanh.model.City;

import java.util.Optional;

public interface IServiceCity{
    Iterable<City> showAll();
    void save(City city);
    void delete(long id);
    Optional<City> findById(long id);
}
