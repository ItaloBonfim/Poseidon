package com.LeagueSocial.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LeagueSocial.Domain.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
