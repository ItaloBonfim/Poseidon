package com.LeagueSocial.Resources.Profile;

/*
 * Perfil padrão de metodos da classe CategoryResource
 * Implementação padrão do end-point de Category
 */

import com.LeagueSocial.DTO.CategoryDTO;
import com.LeagueSocial.Domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

public interface CategoryProfileResource {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> Select(@PathVariable Integer id);

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> Insert(@RequestBody Category obj);

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> Delete(@PathVariable Integer id);

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Category> Update(@RequestBody CategoryDTO objDTO, @PathVariable Integer id);

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Category> AllCategories();

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<Category>> Filter(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction);
}
