package com.example.netflix.repositories;

import com.example.netflix.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByIdentificationNumber(Long identificationNumber);
}
