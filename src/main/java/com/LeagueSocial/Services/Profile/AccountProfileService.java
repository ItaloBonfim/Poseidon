package com.LeagueSocial.Services.Profile;

/*
 * Interface padrão de implementação
*/

import com.LeagueSocial.Domain.Account;
import org.springframework.data.domain.Page;

public interface AccountProfileService {

    public Account SelectDate(Integer id);

    public Account InsertData(Account obj);

    public void DeleteDate(Integer id);

    public Account UpdateData(Account obj);

    public Account AllAccounts();

    public Page<Account> PaginationFilter(Integer page, Integer linesPerPage, String orderBy, String direction);

    public Account ExtendUpdateData(Account Obj);
}
