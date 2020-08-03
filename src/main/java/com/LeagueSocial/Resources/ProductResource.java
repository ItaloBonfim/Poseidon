package com.LeagueSocial.Resources;

/*
 * Classe end-point relacionada a Produtos cadastrados na base
 * Classe padrão de implementação da interface ProductProfileResource
 */

import com.LeagueSocial.DTO.ProductDTO;
import com.LeagueSocial.Domain.Account;
import com.LeagueSocial.Resources.Profile.ProductProfileResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.LeagueSocial.Domain.Product;
import com.LeagueSocial.Services.ProductService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/product")
public class ProductResource implements ProductProfileResource {
	
	@Autowired
	private ProductService service;


	@Override
	public ResponseEntity<Product> Select(Integer id) {
		return null;
	}

	@Override
	public ResponseEntity<Product> Insert(Product obj) {
		return null;
	}

	@Override
	public ResponseEntity<Product> Delete(Integer id) {
		return null;
	}

	@Override
	public ResponseEntity<Product> Update(ProductDTO id, Integer obj) {
		return null;
	}

	@Override
	public ResponseEntity<Product> AllProducts() {
		return null;
	}

	@Override
	public ResponseEntity<Page<Product>> Filter(Integer page, Integer linesPerPage, String orderBy, String direction) {
		return null;
	}
}
