package com.LeagueSocial.Resources.Profile;

import com.LeagueSocial.DTO.CommentsDTO;
import com.LeagueSocial.Domain.Comments;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface CommentsProfileResource {

    @RequestMapping(value = "/publisherComments",method = RequestMethod.GET)
    public ResponseEntity<Page<CommentsDTO>> Select
            (@RequestParam(value = "publisher", required = true) Integer publisherId,
             @RequestParam(value = "page", defaultValue = "0") Integer page,
             @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
             @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
             @RequestParam(value = "direction", defaultValue = "ASC") String direction);

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Comments> Insert(@RequestBody CommentsDTO obj);

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Comments> Delete(@RequestBody CommentsDTO obj);

    public ResponseEntity<Comments> Update(@RequestBody Comments obj);

}
