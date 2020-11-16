package com.LeagueSocial.Resources;

import com.LeagueSocial.DTO.PublicationDTO;
import com.LeagueSocial.Domain.Publication;
import com.LeagueSocial.Resources.Profile.PublicationProfileResource;
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
@RequestMapping(value = "publications/")
public class PublicationResources implements PublicationProfileResource {

    @Autowired private PublicationServiceProfile objective;
    @Autowired private CommentsProfileService comments;


    @Override
    public ResponseEntity<Page<PublicationDTO>> SelectAllUserPublishers
            (Integer user, Integer page, Integer linesPerPage, String orderBy, String direction) {

        Page<Publication> publications = objective.SelectAllUserPublishers
                (user,page,linesPerPage,orderBy,direction); //chamada de metodo

        
        //converter um PAGE PUBLICATION para um PAGE PUBLICATION_DTO
        Page<PublicationDTO> publicationDTO = publications.map(obj -> new PublicationDTO(obj));

        //Retorno
        return ResponseEntity.ok().body(publicationDTO);
    }

    @Override
    public ResponseEntity<Publication> DeleteUserPublication(Integer id) {

        objective.DeletePublications(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Publication> UpdatePublication(Publication obj, Integer id) {

        Publication updadatedObj = objective.EditPublication(obj, id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Publication> CreatePublisher(PublicationDTO obj) {

        System.out.println(obj.UserIdentity());

        Publication toInsert = objective.NewUserPublication(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(toInsert.getId()).toUri();

        return ResponseEntity.created(uri).build();
        //return null;
    }

    @Override
    public ResponseEntity<Page<PublicationDTO>> RequestPublishers(Integer page, Integer linesPerPage, String orderBy, String direction) {

        Page<Publication> publications = objective.SelectAllPublishers
                (page,linesPerPage,orderBy,direction);

        Page<PublicationDTO> publishers = publications.map(obj -> new PublicationDTO(obj));

        return ResponseEntity.ok().body(publishers);
    }
}
