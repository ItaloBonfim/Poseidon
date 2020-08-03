package com.LeagueSocial.Resources.Profile;

import com.LeagueSocial.Domain.Associates;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface AssociatesProfileResource {

    @RequestMapping(value = "/fallow/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Associates>> AllFallowMe(@PathVariable Integer id);

    @RequestMapping(value = "/track/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Associates>> AllTrack(@PathVariable Integer id);

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Associates> Insert(@RequestBody Associates obj);

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Associates> Delete(@PathVariable Integer id);

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Associates> Update(@RequestBody Associates newData, @PathVariable Integer id);

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<Associates>> Filter(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction);
}

