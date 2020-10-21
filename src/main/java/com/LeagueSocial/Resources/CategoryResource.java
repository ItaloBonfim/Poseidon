package com.LeagueSocial.Resources;

/*
 * Classe end-point relacionada a Categorias de a tipos de jogos na base
 * Classe padrão de implementação da interface categoryProfileResource
 */

import com.LeagueSocial.DTO.CategoryDTO;
import com.LeagueSocial.Resources.Profile.CategoryProfileResource;
import com.LeagueSocial.Services.Profile.CategoryProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.LeagueSocial.Domain.Category;
import com.LeagueSocial.Services.CategoryService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping(value = "/category")
public class CategoryResource implements CategoryProfileResource {
	

	@Autowired
	private CategoryProfileService objective;


	@Override
	public ResponseEntity<Category> Select(Integer id) {
		Category obj = objective.SelectDate(id);
		return ResponseEntity.ok().body(obj);
	}

	@Override
	public ResponseEntity<Void> Insert(Category obj) {
		obj = objective.InsertData(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@Override
	public ResponseEntity<Void> Delete(Integer id) {
		objective.DeleteDate(id);
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<Category> Update(CategoryDTO objDTO, Integer id) {

		Category obj = objective.ExtendUpdateData(objDTO);
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<Category> AllCategories() {
		return null;
	}

	@Override
	public ResponseEntity<Page<Category>> Filter(Integer page, Integer linesPerPage, String orderBy, String direction) {
		return null;
	}
}
