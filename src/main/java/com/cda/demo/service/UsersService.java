package com.cda.demo.service;

import com.cda.demo.entity.Users;
import com.cda.demo.exception.ResourceAlreadyExistsException;
import com.cda.demo.exception.ResourceNotFoundException;
import com.cda.demo.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersService extends AbstractService<Users> {
    private UsersRepository usersRepository;

    @Override
    public Users findById(Integer id) {
        return this.usersRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Users.class));
    }

    public Users findByEmail(String email) {
        return this.usersRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException(Users.class));
    }

    @Override
    public Iterable<Users> findAll() {
        Iterable<Users> users = this.usersRepository.findAll();
        if (!users.iterator().hasNext()) {
            throw new ResourceNotFoundException(Users.class);
        }
        return users;
    }

    @Override
    public void delete(Integer id) {
        if (this.usersRepository.existsById(id)) {
            this.usersRepository.deleteById(id);
        }  else {
            throw new ResourceNotFoundException(Users.class);
        }
    }

    @Override
    public Users create(Users entity) {
        if (this.usersRepository.existsByEmail(entity.getEmail())) {
            throw new ResourceAlreadyExistsException(Users.class);
        }
        return this.usersRepository.save(entity);
    }

    @Override
    public Users update(Users entity) {
        if (this.usersRepository.existsById(entity.getId())) {
            return this.usersRepository.save(entity);
        }
        throw new ResourceNotFoundException(Users.class);
    }
}
