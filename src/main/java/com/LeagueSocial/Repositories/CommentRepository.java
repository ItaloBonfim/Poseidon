package com.LeagueSocial.Repositories;

import com.LeagueSocial.Domain.Comments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Integer> {

    @Query(nativeQuery = true, value = "Select * from comments where publication_id = :publisherId")
    public Page<Comments> getcommentsPagebyId(@Param("publisherId")Integer publisherId, Pageable pageable);
}
