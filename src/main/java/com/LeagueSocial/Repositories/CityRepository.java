package com.LeagueSocial.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LeagueSocial.Domain.City;

public interface CityRepository extends JpaRepository<City, Integer> {

}
