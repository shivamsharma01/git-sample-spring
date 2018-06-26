package com.ekart.seller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ekart.seller.entity.SellerEntity;
import com.ekart.seller.entity.SellerPK;

@Repository
public interface SellerRepository extends JpaRepository<SellerEntity, SellerPK> {

}
