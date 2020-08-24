package com.LeagueSocial.Services.Profile;

import com.LeagueSocial.DTO.AssociatesDTO;
import com.LeagueSocial.Domain.Associates;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AssociatesProfileService {

    public List<Associates> FallowMe(Integer id);

    public List<Associates> Track(Integer id);

    public Associates InsertData(AssociatesDTO obj);

    public void DeleteDate(Integer user, Integer target);

    public Associates UpdateData(Associates obj);

    public Page<Associates> PaginationFilter(Integer page, Integer linesPerPage, String orderBy, String direction);

    public Associates ExtendUpdateData(Associates Obj);
}
