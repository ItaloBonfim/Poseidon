package com.LeagueSocial.Services;

import com.LeagueSocial.DTO.AssociatesDTO;
import com.LeagueSocial.Domain.Account;
import com.LeagueSocial.Domain.Associates;
import com.LeagueSocial.Domain.enums.Perfil;
import com.LeagueSocial.Repositories.AccountRepository;
import com.LeagueSocial.Repositories.AssociatesRepository;
import com.LeagueSocial.Security.UserSpringSecurity;
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

        //Leia-Me
        /*
        - 1° - Para deletar uma associação, é necessario verificar se ela existe
        - 2° - Se não existe uma associação, retorna uma mensagem personalizada
        - 3° - verifique se o usuario quem está tentando deletar a associação e
               ADMIN ou então não é algum outro usuario fora da relação como por exemplo:
               uma relação entre o usuario 1 e o usuario 2 so pode ser rompida por eles
               um 3° usuario não pode deletar, se isso acontecer
               retorne uma mensagem personalizado
        - 4° - Se todos os criterios forem aceitos, segue o fluxo e então realiza a deleção
         */
        if(utils.CheckExistingAssociation(obj)) {

            UserSpringSecurity userProfile = UserService.Authenticated();

            if(userProfile != null || !userProfile.hasRole(Perfil.ADMIN)){
			/*if userProfile different of null OR
			 userProfile don't Have ADMIN profile
			 Or else !id is different of id informed */
                if(!obj.getUser().equals(userProfile.getId()) || !obj.getTarget().equals(userProfile.getId())) {
                    throw new AuthorizationException("Access Denied");
                }
            }

            repo.DeleteAssociate(obj.getUser(), obj.getTarget());
        }else{
            throw new ObjectNotFoundException("no associations!");
        }
    }

    @Override
    public Associates BlockUser(AssociatesDTO obj) {
    /* 1° - Verifique se ja existe uma associação no banco com os id's informados
       2° - Caso exista está associação, traga do banco e então atualize a informação para bloqueado
       3° - Caso não exista uma associação, crie uma nova com o parametro bloqueado definido como true
       4° -
     */
        throw new UnsupportedOperationException("Operação ainda em implementação") ;
    }

    @Override
    public Page<Associates> PaginationFilter(Integer page, Integer linesPerPage, String orderBy, String direction) {
        return null;
    }

}
