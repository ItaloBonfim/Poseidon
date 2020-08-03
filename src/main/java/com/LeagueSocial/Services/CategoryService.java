package com.LeagueSocial.Services;

import com.LeagueSocial.DTO.CategoryDTO;
import com.LeagueSocial.Services.Exceptions.DataIntegrityException;
import com.LeagueSocial.Services.Exceptions.ObjectNotFoundException;
import com.LeagueSocial.Services.Profile.CategoryProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.stereotype.Service;

import com.LeagueSocial.Domain.Category;
import com.LeagueSocial.Repositories.CategoryRepository;

import java.util.Optional;


@Service
public class CategoryService implements CategoryProfileService {
	
	@Autowired
	private CategoryRepository repo;


	@Override
	public Category SelectDate(Integer id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found, please verify Id:" +id+ ", Tipo:" + Category.class.getName()));
	}

	@Override
	public Category InsertData(Category obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	@Override
	public void DeleteDate(Integer id) {
		SelectDate(id); //try get element to delete
		try{
			repo.deleteById(id);
		}catch (DataIntegrityException e){
			throw new DataIntegrityException("Categoria possui produtos associados");
		}
	}

	@Override
	public Category UpdateData(Category obj) {
		return null;
	}

	@Override
	public Category AllCategories() {
		return null;
	}

	@Override
	public Page<Category> PaginationFilter(Integer page, Integer linesPerPage, String orderBy, String direction) {
		return null;
	}

	@Override
	public Category ExtendUpdateData(CategoryDTO obj) {
		return new Category();
	}

	private void UpdateCategoryes (Category setnew, Category obj){
		setnew.setName(obj.getName());
	}
}
