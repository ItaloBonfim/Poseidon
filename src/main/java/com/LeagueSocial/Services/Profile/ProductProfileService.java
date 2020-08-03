package com.LeagueSocial.Services.Profile;

/*
 * Interface padrão de implementação
*/

import com.LeagueSocial.Domain.Product;
import org.springframework.data.domain.Page;

public interface ProductProfileService {

    public Product SelectDate(Integer id);

    public Product InsertData(Product obj);

    public Product DeleteDate(Integer id);

    public Product UpdateData(Product obj);

    public Product AllProducts();

    public Page<Product> PaginationFilter(Integer page, Integer linesPerPage, String orderBy, String direction);

    public Product ExtendUpdateData(Product Obj);
}
