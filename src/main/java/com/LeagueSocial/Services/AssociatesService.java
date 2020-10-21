package com.LeagueSocial.Services;

import com.LeagueSocial.DTO.AssociatesDTO;
import com.LeagueSocial.Domain.Account;
import com.LeagueSocial.Domain.Associates;
import com.LeagueSocial.Repositories.AccountRepository;
import com.LeagueSocial.Repositories.AssociatesRepository;
import com.LeagueSocial.Services.Exceptions.*;
import com.LeagueSocial.Services.Exceptions.IllegalArgumentException;
import com.LeagueSocial.Services.Exceptions.NullPointerException;
import com.LeagueSocial.Services.Profile.AssociatesProfileService;
import com.LeagueSocial.Services.utils.AssociatesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
    @Autowired
    AssociatesUtils utils;

    @Override
    public List<Associates> FallowMe(Integer id) {
        List<Associates> list = repo.AllFollow(id);
        return list;
    }

    @Override
    public List<Associates> Track(Integer id) {

        List<Associates> list = repo.AllFollowMe(id);
        return list;
    }

    @Override
    public Associates InsertData(AssociatesDTO obj) {
        /*
        - Para inserir, deve-se primeiro verificar se ja não existe a associação
        - Também deve-se verificar se a conta passada existe
        - caso existir, deve-se retornar uma mensagem personalizada
        - caso NÃO existir, criar uma nova associação
         */

        Associates relation = utils.CreateAssociatesWithEntities(obj);
        return repo.save(relation);

    }


    @Override
    public void DeleteDate(AssociatesDTO obj) {
        /*
        - Para deletar uma associação, é necessario verificar se ela existe
        - Se não existe uma associação, retorna uma mensagem personalizada
        - Caso Existe uma associação, segue o fluxo e então realizar o delete
         */
        if(!utils.CheckExistingAssociation(obj)) {
            repo.DeleteAssociate(obj.getUser(), obj.getTarget());
        }else{
            throw new ObjectNotFoundException("no associations!");
        }
    }

    @Override
    public Associates UpdateData(Associates obj) {
        /*
        - Primeiramente, é interessante verificar se existe a associação no banco
        - e então, extrair esse objeto do banco montando uma classe de tipo Associates
        - O unico campo que pode ser alterado aqui é o campo de bloqueado e talvez um campo tipo Date
        - realizar a alteração com o valor novo e então salvar
         */
        return null;
    }

    @Override
    public Page<Associates> PaginationFilter(Integer page, Integer linesPerPage, String orderBy, String direction) {
        return null;
    }

}
