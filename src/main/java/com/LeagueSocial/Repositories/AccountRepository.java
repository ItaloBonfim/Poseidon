package com.LeagueSocial.Repositories;

import com.LeagueSocial.Domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

    @Transactional(readOnly = true)
    Account findByEmail(@Param("email") String email);
}
