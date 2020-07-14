package com.LeagueSocial.Services;

import com.LeagueSocial.Domain.Account;
import com.LeagueSocial.Domain.AssociatedFollowings;
import com.LeagueSocial.Repositories.AccountRepository;
import com.LeagueSocial.Repositories.FallowingRepository;
import com.LeagueSocial.Services.Exceptions.DataIntegrityException;
import com.LeagueSocial.Services.Exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssociatedFallowingsService {

    @Autowired
    private FallowingRepository repo;
    @Autowired
    private AccountRepository repoac;

    public Account SelectData(Integer id){
        Optional<Account> obj = repoac.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found, please verify Id:" +id+ ", Tipo: " +AssociatedFollowings.class.getName()));
    }

    public void DeleteFallowing(Integer id){
        SelectData(id);
        try{
            repo.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("erro aleatorio que não sabemos como resolver");
        }
    }

    public AssociatedFollowings ListaFollowings(Integer id){

        Optional<AssociatedFollowings> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found, please verify id"));
    }

}
