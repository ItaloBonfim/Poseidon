package com.LeagueSocial.Services;


import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import com.LeagueSocial.DTO.AccountDTO;
import com.LeagueSocial.DTO.NewAccountDTO;
import com.LeagueSocial.Domain.Account;
import com.LeagueSocial.Domain.Account;
import com.LeagueSocial.Domain.Category;
import com.LeagueSocial.Domain.enums.KindSex;
import com.LeagueSocial.Services.Exceptions.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.LeagueSocial.Repositories.AccountRepository;
import com.LeagueSocial.Services.Exceptions.ObjectNotFoundException;

/*
This class have the responsibility to get data on base and return a response command from respective class
on package Resources
 */
@Service
public class AccountService {

	//Auxiliary variables
	@Autowired
	private AccountRepository repo;
	SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy");

	//This method do a select on base an return some data based on parameter id
	public Account SelectData(Integer id) {

		Optional<Account> obj = repo.findById(id);
		//Lambda Expression
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found, please verify Id:" +id+ ", Tipo:" + Account.class.getName()));
	}

	//this method do a insert data on base and return a response with successfully or failed operation
	public Account InsertData(Account obj){

		obj.setId(null); // -> to ensure a new register on database without not affect another present register
		return repo.save(obj); // -> return the response with successfully or failed operation
	}

	//this method do update in some existing data on base
	public Account UpdateData(Account obj){

		Account accountObj = SelectData(obj.getId()); // used to find a specific register on database and then update the same register

		UpdateAccount(accountObj, obj);
		return repo.save(accountObj); // Update a specific register
	}

	//this method do a delete in some existing data on base
	public void DeleteData(Integer id){
		SelectData(id); // -> to get a specific id on database to delete
		try {
			repo.deleteById(id); // -> to delete the register on database
		}catch (DataIntegrityViolationException e){
			throw new DataIntegrityException("the Account has product associated, please verify and try again");
		}
	}

	//this method is have a peculiarity, return a list with all accounts existing on base
	public List<Account> AllAccounts(){
		return repo.findAll();
	}

	//this method utilizes pagination data to filter and response based on parameters received on URI
	public Page<Account> PaginationFilter(Integer page, Integer linesPerPage, String orderBy, String direction){

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

		return repo.findAll(pageRequest);
	}

	//A method based on Data transfer object, a pattern project.
	public Account FromDataTransferObject(AccountDTO obj){
		return new Account(
				obj.getId(), obj.getName(),obj.getUsername(),obj.getKind(), obj.getEmail(), obj.getPassword());
	}

	/*
	Remember: Even thought the name is same, the signature is different, this method is used to insert a new account
	on base
	 */
	public Account FromDataTransferObject(NewAccountDTO obj){
		Account newAccount = new Account(
				null, obj.getName(),obj.getUsername(), KindSex.toEnum(obj.getKind()),obj.getEmail(),obj.getPassword());
		//Address address = new Address(/* inserir o endereço do proprietario da conta*/);
		newAccount.getTelephone().add(obj.getTelephone());

		return newAccount;
	}

	//this method is used to update data on base only and applicable only for class with associated tables
	private void UpdateAccount(Account accountObj, Account obj){
		//caso haja necessidade de incluir mais metodos que podem ser atualizados bastar inseri-los aqui e envia-los na requisição
		accountObj.setName(obj.getName());
		accountObj.setUsername(obj.getUsername());
		accountObj.setPassword(obj.getPassword());
		accountObj.setKind(obj.getKind());

		accountObj.setTelephone(obj.getTelephone());
	}
}
