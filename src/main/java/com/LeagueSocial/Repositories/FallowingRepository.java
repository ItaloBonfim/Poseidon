package com.LeagueSocial.Repositories;

import com.LeagueSocial.Domain.AssociatedFollowings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FallowingRepository extends JpaRepository<AssociatedFollowings, Integer> {
}
