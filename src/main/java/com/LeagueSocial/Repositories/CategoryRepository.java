package com.LeagueSocial.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LeagueSocial.Domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
