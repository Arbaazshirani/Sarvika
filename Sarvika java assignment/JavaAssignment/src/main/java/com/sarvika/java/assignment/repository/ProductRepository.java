package com.sarvika.java.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarvika.java.assignment.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
