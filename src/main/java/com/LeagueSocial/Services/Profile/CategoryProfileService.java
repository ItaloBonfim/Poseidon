package com.LeagueSocial.Services.Profile;

/*
 * Interface padrão de implementação
*/

import com.LeagueSocial.DTO.CategoryDTO;
import com.LeagueSocial.Domain.Category;
import org.springframework.data.domain.Page;

public interface CategoryProfileService {

    public Category SelectDate(Integer id);

    public Category InsertData(Category obj);

    public void DeleteDate(Integer id);

    public Category UpdateData(Category obj);

    public Category AllCategories();

    public Page<Category> PaginationFilter(Integer page, Integer linesPerPage, String orderBy, String direction);

    public Category ExtendUpdateData(CategoryDTO obj);
}
