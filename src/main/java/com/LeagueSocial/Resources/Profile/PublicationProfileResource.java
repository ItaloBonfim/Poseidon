package com.LeagueSocial.Resources.Profile;

import com.LeagueSocial.DTO.PublicationDTO;
import com.LeagueSocial.Domain.Publication;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface PublicationProfileResource {

    @RequestMapping(value = "page", method = RequestMethod.GET)
    public ResponseEntity<Page<PublicationDTO>> SelectAllUserPublishers
            (@RequestParam(value = "user",defaultValue = "0") Integer id,
             @RequestParam(value = "page", defaultValue = "0") Integer page,
             @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
             @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
             @RequestParam(value = "direction", defaultValue = "ASC") String direction);

    @RequestMapping(value = "{/id}", method = RequestMethod.DELETE)
    public ResponseEntity<Publication> DeleteUserPublication(@PathVariable Integer id);

    @RequestMapping(value = "{/?}", method = RequestMethod.PUT)
    public ResponseEntity<Publication> UpdatePublication(@RequestBody Publication obj, @PathVariable Integer id);

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Publication> CreatePublisher(@RequestBody PublicationDTO obj);

    @RequestMapping(value = "/publishers/requestPage", method = RequestMethod.GET)
    public ResponseEntity<Page<PublicationDTO>> RequestPublishers(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                               @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                                                               @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
                                                               @RequestParam(value = "direction", defaultValue = "ASC") String direction);


}
