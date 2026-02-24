package com.cda.demo.repository;

import com.cda.demo.entity.Manufacturer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManufacturerRepository extends CrudRepository<Manufacturer, Integer> {
    Optional<Manufacturer> findByName(String name);
}
