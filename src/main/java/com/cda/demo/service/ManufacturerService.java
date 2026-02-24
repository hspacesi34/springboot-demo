package com.cda.demo.service;

import com.cda.demo.entity.Manufacturer;
import com.cda.demo.repository.ManufacturerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ManufacturerService extends AbstractService<Manufacturer> {
    private ManufacturerRepository manufacturerRepository;

    @Override
    public Manufacturer findById(Integer id) throws Exception {
        try {
            Optional<Manufacturer> manufacturer = this.manufacturerRepository.findById(id);
            if (manufacturer.isPresent()) {
                return manufacturer.get();
            }
            throw new Exception("Manufacturer not found");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Iterable<Manufacturer> findAll() throws Exception {
        try {
            Iterable<Manufacturer> manufacturers = this.manufacturerRepository.findAll();
            if (!manufacturers.iterator().hasNext()) {
                throw new Exception("No manufacturers found");
            }
            return manufacturers;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        try {
            if (this.manufacturerRepository.existsById(id)) {
                this.manufacturerRepository.deleteById(id);
            }
            throw new Exception("Manufacturer not found");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Manufacturer create(Manufacturer entity) throws Exception {
        try {
            if (this.manufacturerRepository.findByName(entity.getName()).isPresent()) {
                throw new Exception("Manufacturer already exists");
            }
            Manufacturer manufacturer = this.manufacturerRepository.save(entity);
            return manufacturer;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Manufacturer update(Manufacturer entity) throws Exception {
        try {
            if (this.manufacturerRepository.existsById(entity.getId())) {
                if (this.manufacturerRepository.findByName(entity.getName()).isPresent()) {
                    throw new Exception("Manufacturer already exists");
                }
                return this.manufacturerRepository.save(entity);
            }
            throw new Exception("Manufacturer not found");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean exists(Integer id) throws Exception {
        try {
            boolean exists = this.manufacturerRepository.existsById(id);
            return exists;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
