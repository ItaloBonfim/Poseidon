package com.LeagueSocial.Services;

import com.LeagueSocial.Domain.Account;
import com.LeagueSocial.Repositories.AccountRepository;
import com.LeagueSocial.Security.UserSpringSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//implementantion of userDetailsService of Spring security tratament (UserDetailsImpl)
@Service
public class UserDetailsImplementation implements UserDetailsService {
    /*this line
    -> @Autowired private AccountProfileService accountProfileService;
    return this exception
    Unsatisfied dependency expressed through field 'service'; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException
    checkout why!
     */
    @Autowired private AccountRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
          Account account = repository.findByEmail(email);

        if(account == null){
            throw new UsernameNotFoundException(email);
        }
        return new UserSpringSecurity(account.getId(), account.getEmail(),account.getPassword(),account.getPerfis());
    }
}
