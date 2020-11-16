package com.LeagueSocial.Services.Profile;

import com.LeagueSocial.Domain.Account;
import org.springframework.mail.SimpleMailMessage;

public interface EmailProfileService {

    void SendNewCreatedAccountEmail(Account obj);

    void SendEmail(SimpleMailMessage msg);
}
