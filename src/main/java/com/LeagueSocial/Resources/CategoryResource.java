package com.LeagueSocial.Resources;

import com.LeagueSocial.DTO.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.LeagueSocial.Domain.Category;
import com.LeagueSocial.Services.CategoryService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/category")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Category> Select(@PathVariable Integer id){
		
		Category obj = service.SelectData(id);
		
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> Insert(@Valid @RequestBody CategoryDTO objDTO){

		Category obj = service.FromDataTransferObject(objDTO);

		obj = service.InsertData(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> Update(@Valid @RequestBody CategoryDTO objDTO, @PathVariable Integer id){

		Category obj = service.FromDataTransferObject(objDTO);

		obj.setId(id); // -> to ensure we update a existing register on database
		obj = service.UpdateData(obj); // -> call the method in class Category on package Service to update a existing register

		return ResponseEntity.noContent().build(); // -> return a null content

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> Delete(@PathVariable Integer id){

		service.DeleteData(id);
		return ResponseEntity.noContent().build();
	}

	//this method is sophisticated, utilizes DTO and convert all categories results in DOMAIN to DTO
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CategoryDTO>> ShowCategories(){

		List<Category> list = service.AllCategories(); //-> return a List with all categories

		List<CategoryDTO> listDTO = list.stream().map(obj -> new CategoryDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(value = "page", method = RequestMethod.GET)
	public ResponseEntity<Page<CategoryDTO>> PageFilter(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction){

		Page<Category> list = service.PaginationFilter(page, linesPerPage, orderBy, direction); //-> return a List with all categories

		Page<CategoryDTO> listDTO = list.map(obj -> new CategoryDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}

}
