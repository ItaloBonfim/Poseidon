package com.LeagueSocial.Services;


import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.function.Consumer;

import com.LeagueSocial.Domain.Account;
import com.LeagueSocial.Domain.Publication;
import com.LeagueSocial.Services.Exceptions.DataIntegrityException;
import com.LeagueSocial.Services.Exceptions.ObjectNotFoundException;
import com.LeagueSocial.Services.Profile.AccountProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.LeagueSocial.Repositories.AccountRepository;

/*
This class have the responsibility to get data on base and return a response command from respective class
on package Resources
 */
@Service
public class AccountService implements AccountProfileService {

	@Autowired
	private AccountRepository repo;
	SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public Account SelectDate(Integer id) {

        Optional<Account> obj = repo.findById(id);

	    return obj.orElseThrow(() -> new ObjectNotFoundException(
	    		"User with ID: "+id+" Not found. Type: " + Account.class.getName()));
	}

	@Override
	public Account InsertData(Account obj) {
		/* Para esse método, temos que verificar se:
			Algum parametro pode retornar NullPointer e tratar
			Se Username já existe e está em uso
			Se Email existe e já está em uso
			E talvez o mais complicado, o delete deve exlcuir todas as associações também
		 */

		Account toSave = new Account(obj.getName(),obj.getKind(),obj.getEmail(),obj.getPassword());
		toSave.getSexualType();

		return repo.save(toSave);
	}

	@Override
	public void DeleteDate(Integer id) {
		SelectDate(id);
		try {
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e){
			throw new DataIntegrityException("The account has pendent associations, please verify and try again: " + e);
		}
	}

	@Override
	public Account UpdateData(Account obj, Integer id) {

		Account updateInfo = SelectDate(id);

		//METODO PRECECISA SER REFEITO
		
		updateInfo.setName(obj.getName());
		updateInfo.setKind(obj.getKind());
		updateInfo.getSexualType();
		updateInfo.setDescription(obj.getDescription());



		return repo.save(updateInfo);
		//return null;
		//metodo especial para isso
		//updateInfo.setPassword(obj.getPassword());
	}

	@Override
	public Page<Account> PaginationFilter(Integer page, Integer linesPerPage, String orderBy, String direction) {
		return null;
	}



}
