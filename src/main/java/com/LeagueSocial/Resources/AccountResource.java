package com.LeagueSocial.Resources;

import com.LeagueSocial.DTO.AccountDTO;
import com.LeagueSocial.DTO.CategoryDTO;
import com.LeagueSocial.DTO.NewAccountDTO;
import com.LeagueSocial.Domain.Account;
import com.LeagueSocial.Domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.LeagueSocial.Services.AccountService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

/*
that class have the responsibility to get  requests and trigger your respective service on package
br.com.Services and in the end return the answer to server with data.
 */
@RestController
@RequestMapping(value = "/user")
public class AccountResource {

	//linked on respective class on package Services
	@Autowired
	private AccountService service;

	//Select method to get data on base
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Account> Select(@PathVariable Integer id){

		Account obj = service.SelectData(id);
		return ResponseEntity.ok().body(obj);
	}

	//Insert method to insert new data on base
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> Insert(@Valid @RequestBody NewAccountDTO objDTO){

		Account obj = service.FromDataTransferObject(objDTO);

		obj = service.InsertData(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	//Update method to update data on base
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> Update(@Valid @RequestBody AccountDTO objDTO, @PathVariable Integer id){

		Account obj = service.FromDataTransferObject(objDTO);

		obj.setId(id); // -> to ensure we update a existing register on database
		obj = service.UpdateData(obj); // -> call the method in class Account on package Service to update a existing register

		return ResponseEntity.noContent().build(); // -> return a null content

	}

	//Delete method to exclude data on base
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public  ResponseEntity<Void> Delete(@PathVariable Integer id){

		service.DeleteData(id);
		return ResponseEntity.noContent().build();
	}

	/*
	this method utilizes a project pattern to get data on base.
	Data Transfer Object - DTO
	When we want get only registered accounts without others associated data tables, we can used that, but we can used too
	update and another operations described on respective class
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AccountDTO>> ShowAccounts(){

		List<Account> list = service.AllAccounts(); //-> return a List with all accounts, but don't have any endpoint

		List<AccountDTO> listDTO = list.stream().map(obj -> new AccountDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	/*
	This method is responsibility to apply a filter on response request
	Data Pagination
	The parameters have a default value and based that generate a response, for example:
	On Request URL, we cant say something like this
	http://localhost:8080/category/page?linesPerPage=3&page=0&direction=DESC
	and the return is based on that
	 */
	@RequestMapping(value = "page", method = RequestMethod.GET)
	public ResponseEntity<Page<AccountDTO>> PageFilter(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		Page<Account> list = service.PaginationFilter(page, linesPerPage, orderBy, direction); //-> return a List with all categories

		Page<AccountDTO> listDTO = list.map(obj -> new AccountDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}
}
