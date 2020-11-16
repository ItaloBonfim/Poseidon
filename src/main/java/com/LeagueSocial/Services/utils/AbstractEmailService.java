package com.LeagueSocial.Services.utils;

import com.LeagueSocial.Domain.Account;
import com.LeagueSocial.Services.Profile.EmailProfileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;

public abstract class AbstractEmailService implements EmailProfileService {

    @Value("${default.sender}")
    private String sender;

    @Override
    public void SendNewCreatedAccountEmail(Account obj){
        SimpleMailMessage smm = PrepareSimpleMailMessageFromNewUser(obj);
        SendEmail(smm);
    }

    protected SimpleMailMessage PrepareSimpleMailMessageFromNewUser(Account obj){
        SimpleMailMessage smm = new SimpleMailMessage();
        smm.setTo(obj.getEmail());
        smm.setFrom(sender);
        smm.setSubject("Bem Vindo a League Social " + obj.getName());
        smm.setSentDate(new Date(System.currentTimeMillis()));
        smm.setText(obj.toString());
        return smm;
    }
}
