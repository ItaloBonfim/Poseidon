package com.LeagueSocial.Resources;

import com.LeagueSocial.DTO.AccountDTO;
import com.LeagueSocial.Domain.Account;
import com.LeagueSocial.Resources.Profile.AccountProfileResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.LeagueSocial.Services.AccountService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/*
 * Classe end-point relacionada a contas cadastradas na base
 * Classe padrão de implementação da interface AccountProfileResource
*/
@RestController
@RequestMapping(value = "/user")
public class AccountResource implements AccountProfileResource {

	//linked on respective class on package Services
	@Autowired
	private AccountService service;


	@Override
	public ResponseEntity<Account> Select(Integer id) {

		Account obj = service.SelectDate(id);
		return ResponseEntity.ok().body(obj);
	}

	@Override
	public ResponseEntity<Account> Insert(Account obj) {

		System.out.println(obj.toString());

		//service.InsertData(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();

	}

	@Override
	public ResponseEntity<Account> Delete(Integer id) {

		service.DeleteDate(id);
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<Account> Update(Account newData, Integer id) {
		newData.setId(id);
		//System.out.println(newData.toString());
		service.UpdateData(newData);


		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<Account> AllAccounts() {
		return null;
	}

	@Override
	public ResponseEntity<Page<Account>> Filter(Integer page, Integer linesPerPage, String orderBy, String direction) {
		return null;
	}
}
