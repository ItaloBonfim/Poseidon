package com.LeagueSocial.Services;


import java.util.Optional;

import com.LeagueSocial.Services.Profile.ProductProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.LeagueSocial.Domain.Product;
import com.LeagueSocial.Repositories.ProductRepository;
import com.LeagueSocial.Services.Exceptions.ObjectNotFoundException;

@Service
public class ProductService implements ProductProfileService {
	
	@Autowired
	private ProductRepository repo;

	@Override
	public Product SelectDate(Integer id) {
		return null;
	}

	@Override
	public Product InsertData(Product obj) {
		return null;
	}

	@Override
	public Product DeleteDate(Integer id) {
		return null;
	}

	@Override
	public Product UpdateData(Product obj) {
		return null;
	}

	@Override
	public Product AllProducts() {
		return null;
	}

	@Override
	public Page<Product> PaginationFilter(Integer page, Integer linesPerPage, String orderBy, String direction) {
		return null;
	}

	@Override
	public Product ExtendUpdateData(Product Obj) {
		return null;
	}
}
