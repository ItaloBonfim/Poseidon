package com.LeagueSocial.Services.utils;

import com.LeagueSocial.DTO.AssociatesDTO;
import com.LeagueSocial.Domain.Account;
import com.LeagueSocial.Domain.Associates;
import com.LeagueSocial.Repositories.AssociatesRepository;
import com.LeagueSocial.Services.Exceptions.DataIntegrityException;
import com.LeagueSocial.Services.Profile.AccountProfileService;
import com.LeagueSocial.Services.Profile.AssociatesProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociatesUtils {

    @Autowired
    private AccountProfileService objectiveAC;

    @Autowired
    private AssociatesRepository repo;

    @Autowired
    private AssociatesProfileService objectiveAS;


    public boolean CheckExistingAssociation(AssociatesDTO obj){
        return repo.CountAssociations(obj.getUser(), obj.getTarget()) != 0;
    }

    public Associates CreateAssociatesWithEntities(AssociatesDTO objdto){

        if(CheckExistingAssociation(objdto)){

            Account user = objectiveAC.SelectDate(objdto.getUser());
            Account target = objectiveAC.SelectDate(objdto.getTarget());

            return new Associates(user, target, objdto.getBlocked());
           // return newAssociation;

        }else{
            throw new DataIntegrityException("Associação já existe em banco");
        }
    }

    public Associates VerifyContextAssociation(AssociatesDTO obj){
        return repo.SelectLine(obj.getUser(), obj.getTarget());
    }

}
