package com.LeagueSocial.Services;

import com.LeagueSocial.Domain.Account;
import com.LeagueSocial.Domain.Associates;
import com.LeagueSocial.Repositories.AccountRepository;
import com.LeagueSocial.Repositories.AssociatesRepository;
import com.LeagueSocial.Services.Exceptions.ObjectNotFoundException;
import com.LeagueSocial.Services.Profile.AssociatesProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AssociatesService implements AssociatesProfileService {

    @Autowired
    private AssociatesRepository repo;
    @Autowired
    private AccountRepository repoAcc;

    @Override
    public List<Associates> FallowMe(Integer id) {

        Account obj = IdentifyAccount(id);

        List<Associates> list = repo.AllFollow(obj.getId());

        return null;
    }

    @Override
    public List<Associates> Track(Integer id) {
        return null;
    }

    @Override
    public Associates InsertData(Associates obj) {
        return null;
    }

    @Override
    public void DeleteDate(Integer id) {

    }

    @Override
    public Associates UpdateData(Associates obj) {
        return null;
    }

    @Override
    public Associates AllAssociatess() {
        return null;
    }

    @Override
    public Page<Associates> PaginationFilter(Integer page, Integer linesPerPage, String orderBy, String direction) {
        return null;
    }

    @Override
    public Associates ExtendUpdateData(Associates Obj) {
        return null;
    }

    private Account IdentifyAccount(Integer id){
        Optional<Account> obj = repoAcc.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "User with ID: "+id+" Not found. Type: " + Account.class.getName()));
    }
}
