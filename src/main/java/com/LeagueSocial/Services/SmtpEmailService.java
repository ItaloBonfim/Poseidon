package com.LeagueSocial.Services;

import com.LeagueSocial.Services.utils.AbstractEmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SmtpEmailService extends AbstractEmailService {

    @Autowired private MailSender mailSender;

    private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);

    @Override
    public void SendEmail(SimpleMailMessage msg) {
        LOG.info("Simulando envio de email...");
        mailSender.send(msg);
        LOG.info("Email Encaminhado!");
    }
}