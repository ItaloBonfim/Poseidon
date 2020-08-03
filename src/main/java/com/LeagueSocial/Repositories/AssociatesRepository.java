package com.LeagueSocial.Repositories;

import com.LeagueSocial.Domain.Associates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AssociatesRepository extends JpaRepository<Associates, Integer> {

    @Query("select obj From Associations obj where obj.user = :id")
    List<Associates> AllFollow(@Param("id")Integer id);
}
