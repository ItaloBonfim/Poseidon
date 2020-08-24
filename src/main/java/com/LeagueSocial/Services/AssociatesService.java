package com.LeagueSocial.Services;

import com.LeagueSocial.DTO.AssociatesDTO;
import com.LeagueSocial.Domain.Account;
import com.LeagueSocial.Domain.Associates;
import com.LeagueSocial.Repositories.AccountRepository;
import com.LeagueSocial.Repositories.AssociatesRepository;
import com.LeagueSocial.Services.Exceptions.DataIntegrityException;
import com.LeagueSocial.Services.Exceptions.IllegalArgumentException;
import com.LeagueSocial.Services.Exceptions.NullPointerException;
import com.LeagueSocial.Services.Exceptions.ObjectNotFoundException;
import com.LeagueSocial.Services.Profile.AssociatesProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

        try{
            Associates ass = CreateAssociation(obj);
            return repo.save(ass);
        }
        catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Associação já existe: ");
        }
        catch (ObjectNotFoundException e){
            throw new ObjectNotFoundException("Contas não identificadas");
        }
    }

    @Override
    public void DeleteDate(Integer user, Integer target) {
        /*
        - Para deletar uma associação, é necessario verificar se ela existe
        - Se não existe uma associação, retorna uma mensagem personalizada
        - Caso Existe uma associação, segue o fluxo e então realizar o delete
         */
        Associates obj = SelectAssociation(user, target); // chamada da @Query
        repo.DeleteAssociate(user,target);
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

    @Override
    public Associates ExtendUpdateData(Associates Obj) {
        return null;
    }

    private Account IdentifyAccount(Integer id){
        Optional<Account> obj = repoAcc.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "User with ID: "+id+" Not found. Type: " + Account.class.getName()));
    }

    private Associates CreateAssociation(AssociatesDTO obj){

        Account obj1 = IdentifyAccount(obj.getUser());
        Account obj2 = IdentifyAccount(obj.getTarget());

        try {
            Associates ass = new Associates(obj1, obj2, obj.getBlocked());
            return ass;
        }
        catch (java.lang.NullPointerException e){
            throw new NullPointerException("Arguments can not be null!");
        }
        catch (java.lang.IllegalArgumentException e){
            throw new IllegalArgumentException("Arguments can not be null!");
        }
    }

    private Associates SelectAssociation(Integer user, Integer target){
        try {
           Optional <Associates> obj = repo.SelectLine(user, target);
            return obj.orElseThrow(() -> new ObjectNotFoundException("Não há associações para os ID's informadors em: "+ Associates.class.getName()));
        }
        catch (java.lang.NullPointerException e){
            throw new NullPointerException("Valores não informados ou incorretos");
        }
    }
}
