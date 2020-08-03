package com.LeagueSocial.Resources;


import com.LeagueSocial.Domain.Associates;
import com.LeagueSocial.Resources.Profile.AssociatesProfileResource;
import com.LeagueSocial.Services.AssociatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

//        return ResponseEntity.ok().body(objs);
        return null;
    }

    @Override
    public ResponseEntity<List<Associates>> AllTrack(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<Associates> Insert(Associates obj) {
        return null;
    }

    @Override
    public ResponseEntity<Associates> Delete(Integer id) {
        return null;
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
