package com.LeagueSocial.Repositories;

import com.LeagueSocial.Domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer>{

}
