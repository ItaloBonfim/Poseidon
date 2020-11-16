package com.LeagueSocial.Services;


import java.text.SimpleDateFormat;
import java.util.Optional;

import com.LeagueSocial.DTO.AccountDTO;
import com.LeagueSocial.Domain.Account;
import com.LeagueSocial.Domain.enums.KindSex;
import com.LeagueSocial.Domain.enums.Perfil;
import com.LeagueSocial.Security.UserSpringSecurity;
import com.LeagueSocial.Services.Exceptions.AuthorizationException;
import com.LeagueSocial.Services.Exceptions.DataIntegrityException;
import com.LeagueSocial.Services.Exceptions.ObjectNotFoundException;
import com.LeagueSocial.Services.Profile.AccountProfileService;
import com.LeagueSocial.Services.Profile.EmailProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.LeagueSocial.Repositories.AccountRepository;

/*
1° - This class have the responsibility to get data on base and return a response command from respective class
on package Resources.
2° - Verify authentication method has implanted
 */
@Service
public class AccountService implements AccountProfileService {

	@Autowired private AccountRepository repo;
	@Autowired private BCryptPasswordEncoder crypt;
	@Autowired private EmailProfileService eps;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public Account SelectDate(Integer id) {

        Optional<Account> obj = repo.findById(id);

	    return obj.orElseThrow(() -> new ObjectNotFoundException(
	    		"User with ID: "+id+" Not found. Type: " + Account.class.getName()));
	}

	@Override
	public Account InsertData(AccountDTO obj) {
		/* Para esse método, temos que verificar se:
			Algum parametro pode retornar NullPointer e tratar
			Se Username já existe e está em uso
			Se Email existe e já está em uso
		 */

		Account toSave = new Account(obj.getName(),obj.getDescription(),obj.getEmail(),
				crypt.encode(obj.getPassword()), KindSex.toEnum(obj.getGenero()));

		repo.save(toSave);

		eps.SendNewCreatedAccountEmail(toSave);
		return toSave;

	}

	@Override
	public void DeleteDate(Integer id) {

		UserSpringSecurity userProfile = UserService.Authenticated();
		if(userProfile != null || !userProfile.hasRole(Perfil.ADMIN) && !id.equals(userProfile.getId())){
			/*if userProfile different of null OR
			 userProfile don't Have ADMIN profile
			 Or else !id is different of id informed */
			throw new AuthorizationException("Access Denied");
		}

		SelectDate(id);
		try {
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e){
			throw new DataIntegrityException("The account has pendent associations, please verify and try again: " + e);
		}
	}

	@Override
	public Account UpdateData(Account obj, Integer id) {

		UserSpringSecurity userProfile = UserService.Authenticated();
		if(userProfile != null || !userProfile.hasRole(Perfil.ADMIN) && !id.equals(userProfile.getId())){
			/*if userProfile different of null OR
			 userProfile don't Have ADMIN profile
			 Or else !id is different of id informed */
			throw new AuthorizationException("Access Denied");
		}

		Account updateInfo = SelectDate(id);

		//METODO PRECECISA SER REFEITO
		
		updateInfo.setName(obj.getName());
		updateInfo.setKind(obj.getKind());
		updateInfo.getSexualType();
		updateInfo.setDescription(obj.getDescription());

		return repo.save(updateInfo);
	}

	@Override
	public Account FindUserByEmail(String email){
		return repo.findByEmail(email);
	}

	@Override
	public Page<Account> PaginationFilter(Integer page, Integer linesPerPage, String orderBy, String direction) {
		return null;
	}

}
