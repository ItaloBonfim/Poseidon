package com.LeagueSocial.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LeagueSocial.Domain.State;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
