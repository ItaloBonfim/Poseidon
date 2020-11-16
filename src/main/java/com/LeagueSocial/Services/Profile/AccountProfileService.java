package com.LeagueSocial.Services.Profile;

/*
 * Interface padrão de implementação
*/

import com.LeagueSocial.DTO.AccountDTO;
import com.LeagueSocial.Domain.Account;
import com.LeagueSocial.Domain.Publication;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.function.Consumer;

public interface AccountClassPerfil {

    public Account SelectDate(Integer id);

    public Account FindUserByEmail(String email);

    public Account InsertData(AccountDTO obj);

    public void DeleteDate(Integer id);

    public Account UpdateData(Account obj, Integer id);

    public Page<Account> PaginationFilter(Integer page, Integer linesPerPage, String orderBy, String direction);

}
