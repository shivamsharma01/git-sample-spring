package com.ekart.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ekart.user.entity.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
	public List<AddressEntity> findByUserId(String userId);
}
