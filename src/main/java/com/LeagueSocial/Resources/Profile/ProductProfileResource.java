package com.LeagueSocial.Resources.Profile;

/*
 * Perfil padrão de metodos da classe productResource
 * Implementação padrão do end-point de Products
 */

import com.LeagueSocial.DTO.ProductDTO;
import com.LeagueSocial.Domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

public interface ProductProfileResource {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> Select(@PathVariable Integer id);

    @PreAuthorize("hasAnyRole('ADMIN')")//only admin acess
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Product> Insert(@RequestBody Product obj);

    @PreAuthorize("hasAnyRole('ADMIN')")//only admin acess
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Product> Delete(@PathVariable Integer id);

    @PreAuthorize("hasAnyRole('ADMIN')")//only admin acess
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Product> Update(@RequestBody ProductDTO id, @PathVariable Integer obj);

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Product> AllProducts();

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<Product>> Filter(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction);
}
