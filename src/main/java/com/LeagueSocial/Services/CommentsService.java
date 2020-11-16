package com.LeagueSocial.Services;

import com.LeagueSocial.DTO.CommentsDTO;
import com.LeagueSocial.Domain.Account;
import com.LeagueSocial.Domain.Comments;
import com.LeagueSocial.Domain.Publication;
import com.LeagueSocial.Repositories.CommentRepository;
import com.LeagueSocial.Services.Exceptions.ObjectNotFoundException;
import com.LeagueSocial.Services.Profile.AccountProfileService;
import com.LeagueSocial.Services.Profile.CommentsProfileService;
import com.LeagueSocial.Services.Profile.PublicationServiceProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CommentsService implements CommentsProfileService {

    @Autowired private CommentRepository repo;
    @Autowired private PublicationServiceProfile publisherService;
    @Autowired private AccountProfileService userContent;

    @Override
    public Page<Comments> PublicationsComments(Integer publicationId,Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction),orderBy);

       Page<Comments> comments = repo.getcommentsPagebyId(publicationId, pageRequest);

        return comments;
    }

    @Override
    public void DropCommentInPublication(CommentsDTO obj) {

        try {
            Account account = userContent.SelectDate(obj.UserIdentity());
            repo.deleteById(obj.getPublicationId());
        }catch (ObjectNotFoundException e){
            throw new ObjectNotFoundException("Comment not found");
        }
    }

    @Override
    public Comments EditComments(Comments obj) {
        return null;
    }

    @Override
    public Comments SendPublisherComment(CommentsDTO comment) {

        Publication publication = publisherService.PublicationExist(comment.getPublicationId());
        Account account = userContent.SelectDate(comment.UserIdentity());

        Comments obj = new Comments(comment.getCommentMessage(), account, publication);

        return repo.save(obj);
    }
}
