package com.api.repository.register;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.entity.UserEntity;

public interface RegisterUserRepository extends JpaRepository<UserEntity, UUID>{

}
