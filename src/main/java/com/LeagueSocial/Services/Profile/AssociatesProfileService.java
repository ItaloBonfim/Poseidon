package com.LeagueSocial.Services.Profile;

import com.LeagueSocial.Domain.Associates;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AssociatesProfileService {

    public List<Associates> FallowMe(Integer id);

    public List<Associates> Track(Integer id);

    public Associates InsertData(Associates obj);

    public void DeleteDate(Integer id);

    public Associates UpdateData(Associates obj);

    public Associates AllAssociatess();

    public Page<Associates> PaginationFilter(Integer page, Integer linesPerPage, String orderBy, String direction);

    public Associates ExtendUpdateData(Associates Obj);
}
