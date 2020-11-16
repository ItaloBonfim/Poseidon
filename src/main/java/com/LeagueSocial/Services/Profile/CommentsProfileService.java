package com.LeagueSocial.Services.Profile;

import com.LeagueSocial.DTO.CommentsDTO;
import com.LeagueSocial.Domain.Comments;
import com.LeagueSocial.Domain.Publication;
import org.springframework.data.domain.Page;

public interface CommentsProfileService {

    public Page<Comments> PublicationsComments (
            Integer publicationId,Integer page, Integer linesPerPage, String orderBy, String direction);

    public void DropCommentInPublication(CommentsDTO obj);

    public Comments EditComments(Comments obj);

    public Comments SendPublisherComment(CommentsDTO comment);
}
