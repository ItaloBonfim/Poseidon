package com.LeagueSocial.Resources.Profile;

/*
    * Perfil padrão de metodos da classe AccountResource
    * Implementação padrão do end-point de contas
*/

import com.LeagueSocial.DTO.AccountDTO;
import com.LeagueSocial.Domain.Account;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface AccountProfileResource {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Account> Select(@PathVariable Integer id);

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Account> Insert(@RequestBody Account obj);

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Account> Delete(@PathVariable Integer id);

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Account> Update(@RequestBody Account newData, @PathVariable Integer id);

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Account> AllAccounts();

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<Account>> Filter(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction);
}
