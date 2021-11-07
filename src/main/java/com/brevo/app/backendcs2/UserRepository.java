package com.brevo.app.backendcs2;

import com.brevo.app.backendcs2.entities.UserEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    // public UserEntity findUserByFirstName(String name);
    public UserEntity findUserByEmail(String email);
}
