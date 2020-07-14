package com.LeagueSocial.Services;


import java.util.List;
import java.util.Optional;

import com.LeagueSocial.DTO.CategoryDTO;
import com.LeagueSocial.Domain.Account;
import com.LeagueSocial.Services.Exceptions.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.LeagueSocial.Domain.Category;
import com.LeagueSocial.Repositories.CategoryRepository;
import com.LeagueSocial.Services.Exceptions.ObjectNotFoundException;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repo;
	
	public Category SelectData(Integer id) {
		
		Optional<Category> obj = repo.findById(id);
		//Lambda Expression
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found, please verify Id:" +id+ ", Tipo:" + Category.class.getName()));
	}

	public Category InsertData(Category obj){

		obj.setId(null); // -> to ensure a new register on database without not affect another present register
		return repo.save(obj); // -> return the response with successfully or failed operation
	}

	public Category UpdateData(Category obj){

		Category categoryObj = SelectData(obj.getId()); // used to find a specific register on database and then update the same register

		UpdateCategory(categoryObj, obj);
		return repo.save(categoryObj); // Update a specific register
	}

	public void DeleteData(Integer id){
		SelectData(id); // -> to get a specific id on database to delete
		try {
			repo.deleteById(id); // -> to delete the register on database
		}catch (DataIntegrityViolationException e){
			throw new DataIntegrityException("the category has product associated, please verify and try again");
		}
	}

	public List<Category> AllCategories(){
		return repo.findAll();
	}

	public Page<Category> PaginationFilter(Integer page, Integer linesPerPage, String orderBy, String direction){

			PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

			return repo.findAll(pageRequest);
	}

	public Category FromDataTransferObject(CategoryDTO obj){
		return new Category(obj.getId(), obj.getName());
	}

	private void UpdateCategory(Category categoryObj, Category obj){
		categoryObj.setName(obj.getName());
	}


}
