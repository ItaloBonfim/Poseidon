package com.LeagueSocial.Repositories;

import com.LeagueSocial.Domain.Publication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer> {

    @Query("SELECT DISTINCT obj FROM Publication obj INNER JOIN obj.user us where us.id = :id")
    public Page<Publication> UserPublishersHistory(@Param("id") Integer id, Pageable pageable);

    @Query(value = "SELECT DISTINCT obj FROM Publication obj INNER JOIN obj.user")
    public Page<Publication> RandomPublishers (Pageable pageable);
}
