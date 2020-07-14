package com.LeagueSocial.Resources;

import com.LeagueSocial.DTO.FollowingDTO;
import com.LeagueSocial.Domain.Account;
import com.LeagueSocial.Domain.AssociatedFollowings;
import com.LeagueSocial.Services.AssociatedFallowingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "fallowing/")
public class AssociatedFallowingsResource {

    @Autowired
    private AssociatedFallowingsService service;
    /*
    @RequestMapping(value = "{id}")
    public ResponseEntity<FollowingDTO> Select(@PathVariable Integer id) {
        Account obj = service.SelectData(id);
        FollowingDTO objDTO = new FollowingDTO(obj.getId(), obj.getName(), obj.getUsername(), obj.getListFollowing());

        return ResponseEntity.ok().body(objDTO);
    }

     */

    @RequestMapping(value = "unfollow/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Integer id) {

        service.DeleteFallowing(id);
        return ResponseEntity.noContent().build();

    }

    public ResponseEntity<Void> DeleteBody(@RequestBody AssociatedFollowings obj){





        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "teste/{id}")
    public ResponseEntity<AssociatedFollowings> ListaTudo(@PathVariable Integer id){
        AssociatedFollowings obj = service.ListaFollowings(id);
        return ResponseEntity.ok().body(obj);
    }
}
