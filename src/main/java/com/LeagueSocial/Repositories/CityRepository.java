package com.LeagueSocial.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LeagueSocial.Domain.City;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}
