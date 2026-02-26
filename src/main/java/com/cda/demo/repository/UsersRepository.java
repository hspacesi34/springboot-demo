package com.cda.demo.repository;

import com.cda.demo.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<Users, Integer> {
    boolean existsByEmail(String email);
    Optional<Users> findByEmail(String email);
}
