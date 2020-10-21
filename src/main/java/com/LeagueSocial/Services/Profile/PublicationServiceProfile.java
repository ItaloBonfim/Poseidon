package com.LeagueSocial.Services.Profile;

import com.LeagueSocial.DTO.PublicationDTO;
import com.LeagueSocial.Domain.Publication;
import org.springframework.data.domain.Page;

public interface PublicationServiceProfile {

    public Page<Publication> SelectAllUserPublishers
            (Integer id, Integer page, Integer linesPerPage, String orderBy, String direction);

    public Void DeletePublications(Integer id);

    public Publication EditPublication(Publication original, Integer id);

    public Publication NewUserPublication(PublicationDTO obj);

    public Page<Publication> SelectAllPublishers
            (Integer page, Integer linesPerPage, String orderBy, String direction);
}
