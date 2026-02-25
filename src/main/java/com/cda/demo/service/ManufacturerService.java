package com.cda.demo.service;

import com.cda.demo.entity.Manufacturer;
import com.cda.demo.exception.ResourceAlreadyExistsException;
import com.cda.demo.exception.ResourceNotFoundException;
import com.cda.demo.repository.ManufacturerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ManufacturerService extends AbstractService<Manufacturer> {
    private ManufacturerRepository manufacturerRepository;

    @Override
    public Manufacturer findById(Integer id) {
        return this.manufacturerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Manufacturer.class));
    }

    @Override
    public Iterable<Manufacturer> findAll() {
        Iterable<Manufacturer> manufacturers = this.manufacturerRepository.findAll();
        if (!manufacturers.iterator().hasNext()) {
            throw new ResourceNotFoundException(Manufacturer.class);
        }
        return manufacturers;
    }

    @Override
    public void delete(Integer id) {
        if (this.manufacturerRepository.existsById(id)) {
            this.manufacturerRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(Manufacturer.class);
        }
    }

    @Override
    public Manufacturer create(Manufacturer entity) {
        if (this.manufacturerRepository.findByName(entity.getName()).isPresent()) {
            throw new ResourceAlreadyExistsException(Manufacturer.class);
        }
        Manufacturer manufacturer = this.manufacturerRepository.save(entity);
        return manufacturer;
    }

    @Override
    public Manufacturer update(Manufacturer entity) {
        if (this.manufacturerRepository.existsById(entity.getId())) {
            if (this.manufacturerRepository.findByName(entity.getName()).isPresent()) {
                throw new ResourceAlreadyExistsException(Manufacturer.class);
            }
            return this.manufacturerRepository.save(entity);
        }
        throw new ResourceNotFoundException(Manufacturer.class);
    }

    @Override
    public boolean exists(Integer id) {
        boolean exists = this.manufacturerRepository.existsById(id);
        return exists;
    }

}
