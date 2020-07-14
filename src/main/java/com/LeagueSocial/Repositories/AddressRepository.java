package com.LeagueSocial.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LeagueSocial.Domain.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
