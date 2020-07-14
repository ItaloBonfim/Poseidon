package com.LeagueSocial.Services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LeagueSocial.Domain.Product;
import com.LeagueSocial.Repositories.ProductRepository;
import com.LeagueSocial.Services.Exceptions.ObjectNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	public Product SelectData(Integer id) {
		
		Optional<Product> obj = repo.findById(id);
		//Lambda Expression
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found, please verify Id:" +id+ ", Tipo:" + Product.class.getName()));
		
	}

	public Product InsertData(Product obj){

		obj.setId(null);// -> to ensure a new register on database without not affect another present register
		return repo.save(obj); // -> return the response with successfully or failed operation
	}

	public Product UpdateData(Product obj){

		SelectData(obj.getId());
		return repo.save(obj);
	}

	public void DeleteData(Integer id){

		SelectData(id);
		repo.deleteById(id);
	}

}
