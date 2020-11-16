package com.LeagueSocial.Resources;

import com.LeagueSocial.DTO.CommentsDTO;
import com.LeagueSocial.Domain.Comments;
import com.LeagueSocial.Resources.Profile.CommentsProfileResource;
import com.LeagueSocial.Services.Profile.CommentsProfileService;
import com.LeagueSocial.Services.Profile.PublicationServiceProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "publication/comments")
public class CommentsResource implements CommentsProfileResource {

    @Autowired
    private CommentsProfileService service;
    @Autowired
    private PublicationServiceProfile publisher;

    @Override
    public ResponseEntity<Page<CommentsDTO>> Select
            (Integer publicationId, Integer page, Integer linesPerPage, String orderBy, String direction) {

        Page<Comments> pageComments =
         service.PublicationsComments(publicationId,page,linesPerPage,orderBy,direction);

        Page<CommentsDTO> commentsDTOS = pageComments.map(obj -> new CommentsDTO(obj));


        return ResponseEntity.ok().body(commentsDTOS);
    }

    @Override
    public ResponseEntity<Comments> Insert(CommentsDTO obj) {


        Comments publisherComment = service.SendPublisherComment(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(publisherComment.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @Override
    public ResponseEntity<Comments> Delete(CommentsDTO obj) {

        service.DropCommentInPublication(obj);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Comments> Update(Comments obj) {
        return null;
    }
}
