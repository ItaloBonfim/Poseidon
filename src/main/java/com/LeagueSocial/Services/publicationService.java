package com.LeagueSocial.Services;

import com.LeagueSocial.DTO.AccountDTO;
import com.LeagueSocial.DTO.PublicationDTO;
import com.LeagueSocial.Domain.Account;
import com.LeagueSocial.Domain.Publication;
import com.LeagueSocial.Repositories.AccountRepository;
import com.LeagueSocial.Repositories.PublicationRepository;
import com.LeagueSocial.Services.Exceptions.ObjectNotFoundException;
import com.LeagueSocial.Services.Profile.AccountProfileService;
import com.LeagueSocial.Services.Profile.PublicationServiceProfile;
import com.LeagueSocial.Services.utils.PublicationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


@Service
public class publicationService implements PublicationServiceProfile {

    @Autowired
    private PublicationRepository repo;
    @Autowired
    private PublicationUtils suported;
    @Autowired
    private AccountProfileService extSuported;


    @Override
    public Page<Publication> SelectAllUserPublishers
            (Integer id, Integer page, Integer linesPerPage, String orderBy, String direction) {

        PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction),orderBy);

        Account user = extSuported.SelectDate(id);

        Page<Publication> publisher = repo.UserPublishersHistory(user.getId(),pageRequest);

        return publisher;
    }

    @Override
    public Void DeletePublications(Integer id) {
        return null;
    }

    @Override
    public Publication EditPublication(Publication original, Integer id) {
        return null;
    }

    @Override
    public Publication NewUserPublication(PublicationDTO obj) {

        try {
         Account user = extSuported.SelectDate(obj.UserIdentity());

            Publication PDC = new Publication(null,obj.getMessage(), suported.getTime());
            PDC.getUser().addAll(Arrays.asList(user));

           return repo.save(PDC);
        }catch (UnknownError e){
            throw new UnsupportedOperationException("DEU ALGUM ERRO DURENTE O SAVE DA PUBLICAÇÃO" + e);
        }
    }

    @Override
    public Page<Publication> SelectAllPublishers
            (Integer page, Integer linesPerPage, String orderBy, String direction) {

        PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction),orderBy);

        Page<Publication> publishersRequest = repo.RandomPublishers(pageRequest);
        return publishersRequest;
    }

}
