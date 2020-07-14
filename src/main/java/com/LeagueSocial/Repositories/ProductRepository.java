package com.LeagueSocial.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LeagueSocial.Domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
