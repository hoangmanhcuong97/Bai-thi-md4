package com.example.baithithuchanh.repository;


import com.example.baithithuchanh.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepoCity extends CrudRepository<City, Long> {
}
