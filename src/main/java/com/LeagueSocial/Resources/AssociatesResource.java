package com.LeagueSocial.Resources;


import com.LeagueSocial.DTO.AssociatesDTO;
import com.LeagueSocial.Domain.Associates;
import com.LeagueSocial.Resources.Profile.AssociatesProfileResource;
import com.LeagueSocial.Services.AssociatesService;
import com.LeagueSocial.Services.Profile.AssociatesProfileService;
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
    AssociatesProfileService objective;

    @Override
    public ResponseEntity<List<Associates>> AllFallowMe(Integer id) {

        List<Associates> objs = objective.FallowMe(id);
       // List<Associates> objs = service.FallowMe(id);
        return ResponseEntity.ok().body(objs);
       // return null;
    }

    @Override
    public ResponseEntity<List<Associates>> AllTrack(Integer id) {

        List<Associates> objs = objective.Track(id);

        return ResponseEntity.ok().body(objs);
    }

    @Override
    public ResponseEntity<Associates> Insert(AssociatesDTO obj) {

       Associates ass = objective.InsertData(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(ass.getId()).toUri();

        return ResponseEntity.created(uri).build();

    }

    @Override
    public ResponseEntity<Associates> Delete(AssociatesDTO obj) {

        objective.DeleteDate(obj);

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
