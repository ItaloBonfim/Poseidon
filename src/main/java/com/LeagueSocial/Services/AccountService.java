package com.LeagueSocial.Services;


import java.text.SimpleDateFormat;
import java.util.Optional;

import com.LeagueSocial.Domain.Account;
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
		obj.setId(null);
		Account toSave = new Account(obj.getName(),obj.getUsername(),obj.getSexualType().getCod(),obj.getEmail(),obj.getPassword());
		return repo.save(toSave);
	//	return repo.save(obj);

		//return null;
	}

	@Override
	public void DeleteDate(Integer id) {
		SelectDate(id);
		try {
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e){
			throw new DataIntegrityException("The account has pendent associations, please verify and try again");
		}
	}

	@Override
	public Account UpdateData(Account obj) {

		Account up = SelectDate(obj.getId());

		up.setName(obj.getName());
		up.setUsername(obj.getUsername());
		up.setPassword(obj.getPassword());
		up.setSexualType(obj.getSexualType());
		up.setDescription(obj.getDescription());

		System.out.println(up.toString());
		return repo.save(up);
		//return null;
	}

	@Override
	public Account AllAccounts() {
		return null;
	}

	@Override
	public Page<Account> PaginationFilter(Integer page, Integer linesPerPage, String orderBy, String direction) {
		return null;
	}

	@Override
	public Account ExtendUpdateData(Account Obj) {
		return null;
	}
}
