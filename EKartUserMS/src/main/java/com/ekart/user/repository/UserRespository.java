package com.ekart.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ekart.user.entity.UserEntity;

@Repository
public interface UserRespository extends JpaRepository<UserEntity, String> {

}
