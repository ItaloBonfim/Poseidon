package com.LeagueSocial.Resources;


import com.LeagueSocial.DTO.AssociatesDTO;
import com.LeagueSocial.Domain.Associates;
import com.LeagueSocial.Resources.Profile.AssociatesProfileResource;
import com.LeagueSocial.Services.AssociatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "fallowing/")
public class AssociatesResource implements AssociatesProfileResource {

    @Autowired
    AssociatesService service;


    @Override
    public ResponseEntity<List<Associates>> AllFallowMe(Integer id) {
        //metodo retornando incompatibilidade de tipos, pois o spring que um atributo de tipo Account
        //mas por que ?

        List<Associates> objs = service.FallowMe(id);

        return ResponseEntity.ok().body(objs);
       // return null;
    }

    @Override
    public ResponseEntity<List<Associates>> AllTrack(Integer id) {

        List<Associates> objs = service.Track(id);

        return ResponseEntity.ok().body(objs);
    }

    @Override
    public ResponseEntity<Associates> Insert(AssociatesDTO obj) {
//        System.out.println(obj.getUser());
//        System.out.println(obj.getTarget());
//        System.out.println(obj.getBlocked());

       Associates ass = service.InsertData(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(ass.getId()).toUri();

        return ResponseEntity.created(uri).build();

    }

    @Override
    public ResponseEntity<Associates> Delete(AssociatesDTO obj) {

        service.DeleteDate(obj.getUser(), obj.getTarget());

        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Associates> Update(Associates newData, Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<Page<Associates>> Filter(Integer page, Integer linesPerPage, String orderBy, String direction) {
        return null;
    }
}
